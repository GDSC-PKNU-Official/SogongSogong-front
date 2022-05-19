package com.gdsc.sogongsogong.data.api

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.fake.DtoDatas
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface BusinessService {

    @GET("/user/business")
    suspend fun getUserBusiness(): Response<Post>

    // FIXME
    @GET("/user/business")
    suspend fun getUserBusiness2(@Body getUserBusiness2Dto: DtoDatas.getUserBusiness2Dto) : Response<DtoDatas.getUserBusiness2Dto>
}