package com.gdsc.sogongsogong.data.remote.post

import com.gdsc.sogongsogong.data.api.post.HotPostService
import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import javax.inject.Inject

class HotPostRemoteDataSourceImpl @Inject constructor(
    private val hotPostService: HotPostService
) : HotPostDataSource {

    override suspend fun fetchAllHotPosts() = hotPostService.fetchAllHotPosts()
}