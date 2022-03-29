package com.gdsc.sogongsogong.di.module

import com.gdsc.sogongsogong.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repository: Repository): Repository
}