package com.gdsc.sogongsogong.ui.home

import com.gdsc.sogongsogong.Repository
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.runCatching

@HiltViewModel
class HomeViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val repository: Repository
): BaseViewModel(dispatcherProvider) {

    // FIXME: 디폴트 값 ?
    suspend fun fetchPost(): Post = runCatching {
        repository.getBestPost().body()!!
    }.onFailure { e ->
        e.printStackTrace()
    }.getOrThrow()
}