package com.gdsc.sogongsogong.data.api

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface PostService {

    @GET("/board/entire-post")
    suspend fun fetchInitAllPost(): Flow<List<Post>>

    @GET("/board/entire-post/{last-post}")
    suspend fun fetchAllPost(@Path("lastPost") lastPost: Long): Flow<List<Post>>

    @GET("/board/one-post/{id}")
    suspend fun fetchPost(@Path("id") id: Long): Flow<Post>

    @FormUrlEncoded
    @POST("/board/post")
    suspend fun createPost(@Body post: Post)
}