package com.gdsc.sogongsogong.network

import com.gdsc.sogongsogong.dataclass.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    // 로그인
    @POST("user/login")
    fun login(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, Any>>

    // 회원가입
    @POST ("user/register")
    fun signUp(
        @Body params: HashMap<String, Any>
    ): Call<HashMap<String, String>>

    // 아이디 중복 확인
    @POST("user/confirm/name")
    fun confirmId(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, String>>


    // 로그아웃
    @POST("user/logout")
    fun logout(): Call<HashMap<String, String>>

    // 토큰 검증 (회원 데이터 조회)
    @GET("auth/valid")
    fun authorization():Call<HashMap<String, Any>>

    // 토큰 재발급
    @FormUrlEncoded
    @POST("auth/refresh")
    fun setRefreshToken(
        @Field("token") token: String
    ): Call<HashMap<String, String>>

    // 비밀번호 찾기
    @POST("user/password/find")
    fun findPassword(
        @Body params: HashMap<String, String>
    ):Call<HashMap<String, String>>

    // 비밀번호 확인
    @POST("user/password/check")
    fun checkPassword(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, String>>

    // 비밀번호 변경
    @POST("user/password/change")
    fun changePassword(
        @Body params: HashMap<String, String>
    ): Call<HashMap<String, String>>

    // 회원탈퇴
    @DELETE("user/quit")
    fun deleteUser():Call<HashMap<String, String>>


}