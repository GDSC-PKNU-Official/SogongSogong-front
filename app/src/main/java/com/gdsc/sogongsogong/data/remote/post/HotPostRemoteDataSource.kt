package com.gdsc.sogongsogong.data.remote.post

import com.gdsc.sogongsogong.data.api.post.HotPostService
import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotPostRemoteDataSource @Inject constructor(
    private val hotPostService: HotPostService
) : HotPostDataSource {

    override suspend fun fetchAllHotPosts() = hotPostService.fetchAllHotPosts()

    override suspend fun fetchHotPost() = hotPostService.fetchHotPost()
}