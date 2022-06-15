package com.gdsc.sogongsogong.data.remote.post

import com.gdsc.sogongsogong.data.api.post.HotPostService
import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import kotlin.runCatching

class HotPostRemoteDataSource @Inject constructor(
    private val hotPostService: HotPostService
) : HotPostDataSource {

    override suspend fun fetchAllHotPosts() = runCatching {
        hotPostService.fetchAllHotPosts()
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(emptyList())

    override suspend fun fetchHotPost() = runCatching {
        hotPostService.fetchHotPost()
    }.onFailure { throwable ->
        throwable.printStackTrace()
    }.getOrDefault(null)
}
