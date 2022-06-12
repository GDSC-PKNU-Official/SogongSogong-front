package com.gdsc.sogongsogong.data.datasource

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.data.entity.TempPost
import kotlinx.coroutines.flow.Flow

interface PostDataSource {

    suspend fun fetchPost(postId: Long): Flow<Post>

    suspend fun fetchInitAllPost(): Flow<List<TempPost>>

    suspend fun fetchAllPost(lastPost: Long): Flow<List<Post>>

    suspend fun createPost(post: Post)
}