package com.gdsc.sogongsogong.di.module

import com.gdsc.sogongsogong.repository.datasource.PostRemoteDataSource
import com.gdsc.sogongsogong.repository.datasource.PostRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindToDoDataSource(dataSource: PostRemoteDataSourceImpl): PostRemoteDataSource
}