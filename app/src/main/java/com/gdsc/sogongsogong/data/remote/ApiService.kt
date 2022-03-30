package com.gdsc.sogongsogong.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL = "http://34.82.10.241:8080/"

    val api = clientBuilder(BASE_URL).create(Api::class.java)

    private fun clientBuilder(baseUrl: String) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}