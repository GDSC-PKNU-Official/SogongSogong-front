package com.gdsc.sogongsogong.di.module

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.datasource.PostDataSource
import com.gdsc.sogongsogong.data.remote.post.HotPostRemoteDataSourceImpl
import com.gdsc.sogongsogong.data.remote.post.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindPostRemoteDataSource(dataSource: PostRemoteDataSourceImpl): PostDataSource

    @Binds
    abstract fun bindHotPostRemoteDataSource(dataSource: HotPostRemoteDataSourceImpl): HotPostDataSource
}