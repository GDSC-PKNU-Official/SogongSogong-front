package com.gdsc.sogongsogong.data.api.comment

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface CommentAuthService {

    @GET("/board/comment-auth")
    suspend fun fetchCommentAuth(): Flow<Post>

    @GET("/board/comment-auth")
    suspend fun fetchCommentAuthById(@Query("userId") userId: Long, @Query("commentId") commentId: Long): Flow<List<Post>>
}