package com.gdsc.sogongsogong.di.module

import com.gdsc.sogongsogong.data.api.post.HotPostService
import com.gdsc.sogongsogong.data.api.post.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providePostService(retrofit: Retrofit): PostService = retrofit.create(PostService::class.java)

    @Provides
    @Singleton
    fun provideHotPostService(retrofit: Retrofit): HotPostService = retrofit.create(HotPostService::class.java)
}