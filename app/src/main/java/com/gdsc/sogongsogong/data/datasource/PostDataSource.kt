package com.gdsc.sogongsogong.data.datasource

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.data.entity.PostList
import kotlinx.coroutines.flow.Flow

interface PostDataSource {

    suspend fun fetchPost(postId: Long): Post

    suspend fun fetchInitAllPost(): List<Post>

    suspend fun fetchAllPost(lastPost: Long): List<Post>

    suspend fun createPost(post: Post)
}