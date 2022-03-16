package com.gdsc.sogongsogong.data.remote

import retrofit2.http.GET

interface Api {
    @GET()
    suspend fun fetch(): String
}