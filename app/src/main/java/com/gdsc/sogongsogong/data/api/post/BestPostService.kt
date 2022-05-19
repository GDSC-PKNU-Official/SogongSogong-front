package com.gdsc.sogongsogong.data.api.post

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface BestPostService {

    @GET("/board/best-post")
    suspend fun fetchBestPost(): Flow<Post>

    @GET("/board/best-post")
    suspend fun fetchBestPostByLastPost(@Query("lastPost") lastPost : Long): Flow<Post>
}