package com.gdsc.sogongsogong.di.module

import com.gdsc.sogongsogong.data.remote.PostRemoteDataSource
import com.gdsc.sogongsogong.data.remote.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindPostDataSource(dataSource: PostRemoteDataSourceImpl): PostRemoteDataSource
}