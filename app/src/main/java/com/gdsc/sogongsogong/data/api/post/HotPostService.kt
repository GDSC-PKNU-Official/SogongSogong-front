package com.gdsc.sogongsogong.data.api.post

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface HotPostService {

    @GET("/board/hot-post")
    suspend fun fetchHotPost(): Post?

    // FIXME: list가 들어오는게 맞겠지?
    @GET("/board/hot-post")
    suspend fun fetchAllHotPosts(): List<Post>

    // FIXME: path 어노테이션이 있는데 url에 변수가 없음
    @GET("/board/hot-post")
    suspend fun fetchHotPostByLastPost(@Path("lastPost") lastPost: Long): Post
}
