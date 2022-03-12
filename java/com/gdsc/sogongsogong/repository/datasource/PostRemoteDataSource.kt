package com.gdsc.sogongsogong.repository.datasource

import com.gdsc.sogongsogong.dataclass.Post

interface PostRemoteDataSource {

    fun fetchPost(postId: Long): Post

    fun fetchPosts(): List<Post>

    fun createPost(post: Post)
}