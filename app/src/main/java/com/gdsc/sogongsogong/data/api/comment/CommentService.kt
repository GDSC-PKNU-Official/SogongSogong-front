package com.gdsc.sogongsogong.data.api.comment

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.fake.DtoDatas
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface CommentService {

    @GET("/board/one-post/comment")
    suspend fun fetchCommentByPostId(@Query("postId") postId: Long, @Query("last-comment") lastComment: Long): Flow<List<Post>>

    @POST("/board/comments")
    suspend fun postComments(@Body post: Post): Flow<Post>

    // FIXME
    @FormUrlEncoded
    @POST("/board/comments")
    suspend fun pushComment2(@Body pushComment2Dto: DtoDatas.pushComment2Dto): Response<DtoDatas.pushComment2Dto>

    // FIXME: /board/comment 뒤에 s가 붙는건지 안붙는건지
    @DELETE("/board/comment/{id}")
    suspend fun deleteComment(@Path("commentId") commentId: Long)
}