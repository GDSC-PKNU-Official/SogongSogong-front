package com.gdsc.sogongsogong.di.module

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.datasource.PostDataSource
import com.gdsc.sogongsogong.data.remote.post.HotPostRemoteDataSource
import com.gdsc.sogongsogong.data.remote.post.PostRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindPostRemoteDataSource(dataSource: PostRemoteDataSource): PostDataSource

    @Binds
    abstract fun bindHotPostRemoteDataSource(dataSource: HotPostRemoteDataSource): HotPostDataSource
}