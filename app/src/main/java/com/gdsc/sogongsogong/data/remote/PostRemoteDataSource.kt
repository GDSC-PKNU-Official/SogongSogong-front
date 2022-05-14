package com.gdsc.sogongsogong.data.remote

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow

interface PostRemoteDataSource {

    suspend fun fetchPost(postId: Long): Flow<Post>

    suspend fun fetchInitAllPost(): Flow<List<Post>>

    suspend fun fetchAllPost(lastPost: Long): Flow<List<Post>>

    suspend fun createPost(post: Post)
}