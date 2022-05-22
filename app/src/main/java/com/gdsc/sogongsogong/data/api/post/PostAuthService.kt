package com.gdsc.sogongsogong.data.api.post

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface PostAuthService {

    @GET("/board/post-auth")
    suspend fun fetchPostAuth(): Flow<Post>

    @GET("/board/post-auth")
    suspend fun fetchPostAuthById(@Query("userId") userId: Long, @Query("postId") postId: Long): Flow<List<Post>>
}