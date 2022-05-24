package com.gdsc.sogongsogong.data.remote.post

import com.gdsc.sogongsogong.data.api.post.PostService
import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val postService: PostService
): PostDataSource {

    override suspend fun fetchPost(postId: Long): Flow<Post> {
        return postService.fetchPost(postId)
    }

    override suspend fun fetchInitAllPost() = postService.fetchInitAllPost()

    override suspend fun fetchAllPost(lastPost: Long) = postService.fetchAllPost(lastPost)

    override suspend fun createPost(post: Post) {
        TODO("Not yet implemented")
    }
}