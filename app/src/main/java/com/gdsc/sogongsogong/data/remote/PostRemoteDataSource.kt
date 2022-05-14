package com.gdsc.sogongsogong.data.remote

import com.gdsc.sogongsogong.data.entity.Post

interface PostRemoteDataSource {

    fun fetchPost(postId: Long): Post

    fun fetchPosts(): List<Post>

    fun createPost(post: Post)
}