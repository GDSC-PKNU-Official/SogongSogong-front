package com.gdsc.sogongsogong.data.datasource

import com.gdsc.sogongsogong.data.entity.Post
import kotlinx.coroutines.flow.Flow

interface HotPostDataSource {

    suspend fun fetchAllHotPosts(): List<Post>

    suspend fun fetchHotPost(): Post?
}
