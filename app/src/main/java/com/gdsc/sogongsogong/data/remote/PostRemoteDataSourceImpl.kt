package com.gdsc.sogongsogong.data.remote

import com.gdsc.sogongsogong.data.entity.Post
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(): PostRemoteDataSource {

    override fun fetchPost(postId: Long): Post {
        TODO("Not yet implemented" )
    }

    override fun fetchPosts(): List<Post> {
        TODO("Not yet implemented")
    }

    override fun createPost(post: Post) {
        TODO("Not yet implemented")
    }
}