package com.gdsc.sogongsogong.network

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Route
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class TokenAuthenticator(
    private val refreshToken: String,
    private val app: MasterApplication
): Authenticator {
    companion object {
        private val TAG = TokenAuthenticator::class.java.simpleName
    }

    override fun authenticate(route: Route?, response: okhttp3.Response): Request? {
        if (response.code() == 401) {
            val getNewDeviceToken = GlobalScope.async(Dispatchers.Default) {
                getNewDeviceToken(refreshToken)
            }

            val token = runBlocking {
                getNewDeviceToken.await()
            }
            if (token != null) {
                return getRequest(response, token)
            }
        }
        return null
    }

    private suspend inline fun getNewDeviceToken(token: String): String? {
        return GlobalScope.async(Dispatchers.Default) {
            callApiNewDeviceToken(token)
        }.await()
    }

    private suspend inline fun callApiNewDeviceToken(token: String): String? = suspendCoroutine { continuation ->
        createWebService<RetrofitService>()
            .setRefreshToken(token)
//            .with(rx)
            .enqueue(object: Callback<HashMap<String, String>> {
                override fun onResponse(call: Call<HashMap<String, String>>, response: Response<HashMap<String, String>>) {
                    if (response.isSuccessful) {
                        val data = response.body()!!["access_token"]!!
                        app.saveUserToken("access_token", data)
                        continuation.resume(data)
                    } else {
                        continuation.resume(null)
                    }
                }

                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    continuation.resume(null)
                }
            })
        return@suspendCoroutine
    }

    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private inline fun <reified T> createWebService(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(app.BASE_URL + "/api/")
            .client(okHttp)
            .addConverterFactory(
                GsonConverterFactory.create(
                GsonBuilder().serializeNulls().create()
            ))
            .build()
        return retrofit.create(T::class.java)
    }

    private fun getRequest(response: okhttp3.Response, token: String): Request {
        return response.request()
            .newBuilder()
            .removeHeader("Authorization")
            .addHeader("Authorization", token)
            .build()
    }
}