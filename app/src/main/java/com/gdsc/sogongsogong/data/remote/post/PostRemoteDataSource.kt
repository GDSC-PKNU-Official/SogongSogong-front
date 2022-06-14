package com.gdsc.sogongsogong.data.remote.post

import com.gdsc.sogongsogong.data.api.post.PostService
import com.gdsc.sogongsogong.data.datasource.PostDataSource
import com.gdsc.sogongsogong.data.entity.Post
import kotlin.runCatching
import javax.inject.Inject

class PostRemoteDataSource @Inject constructor(
    private val postService: PostService
): PostDataSource {

    override suspend fun fetchPost(postId: Long): Post {
        return postService.fetchPost(postId)
    }

    override suspend fun fetchInitAllPost(): List<Post> = runCatching {
        postService.fetchInitAllPost()
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(emptyList())

    override suspend fun fetchAllPost(lastPost: Long) = runCatching {
        postService.fetchAllPost(lastPost)
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(emptyList())

    override suspend fun createPost(post: Post) {
        runCatching {
            postService.postPost(post)
        }.onFailure { throwable ->
            throwable.printStackTrace()
        }
    }
}
