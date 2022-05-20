package com.gdsc.sogongsogong.data.api

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.fake.DtoDatas
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface ScrapLikeService {

    @GET("/board/one-post/scrapLike")
    suspend fun fetchScrapLikeByUserId(
        @Query("userId") userId: Long,
        @Query("scrap-lik") scrapLike: Boolean,
        @Query("last-scrap") lastScrap: Long
    ): Flow<List<Post>>

    @POST("/board/scraplikes")
    suspend fun postScrapLike(@Body post: Post): Flow<Post>

    // FIXME
    @FormUrlEncoded
    @POST("/board/scraplikes")
    suspend fun postScrapLike(@Body pushScraplike2Dto: DtoDatas.pushScraplike2Dto ): Response<DtoDatas.pushScraplike2Dto>
}