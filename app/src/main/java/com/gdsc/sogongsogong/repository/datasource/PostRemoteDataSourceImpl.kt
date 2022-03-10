package com.gdsc.sogongsogong.repository.datasource

import com.gdsc.sogongsogong.dataclass.Post

class PostRemoteDataSourceImpl : PostRemoteDataSource {

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