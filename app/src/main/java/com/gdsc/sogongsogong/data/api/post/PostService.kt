package com.gdsc.sogongsogong.data.api.post

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.fake.DtoDatas
import retrofit2.Response
import retrofit2.http.*

interface PostService {

    @GET("/board/entire-post")
    suspend fun fetchInitAllPost(): List<Post>

    @GET("/board/entire-post/{last-post}")
    suspend fun fetchAllPost(@Path("lastPost") lastPost: Long): List<Post>

    @GET("/board/one-post/{id}")
    suspend fun fetchPost(@Path("id") id: Long): Post

    @FormUrlEncoded
    @POST("/board/post")
    suspend fun postPost(@Body post: Post)

    // FIXME
    @FormUrlEncoded
    @POST("/board/post")
    suspend fun pushPost2(@Body pushPost2Dto: DtoDatas.pushPost2Dto): Response<DtoDatas.pushPost2Dto>

    // FIXME
    @PUT("/board/post/{id}")
    suspend fun updatePost(@Body putPostDto: DtoDatas.putPostDto): Response<DtoDatas.putPostDto>

    @DELETE("/board/post/{id}")
    suspend fun deletePost(@Path("postId") postId: Long)
}