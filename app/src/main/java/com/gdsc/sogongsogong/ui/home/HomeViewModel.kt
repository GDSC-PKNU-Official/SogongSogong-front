package com.gdsc.sogongsogong.ui.home

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.data.remote.PostRemoteDataSource
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val postRemoteDataSource: PostRemoteDataSource,
): BaseViewModel(dispatcherProvider) {

    private var _posts: StateFlow<List<Post>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    init {
        onIo {
            _posts = postRemoteDataSource.fetchInitAllPost()
                .stateIn(this, SharingStarted.Eagerly, emptyList())
        }
    }

    fun fetchAllPost(postId: Long) = onIo {
        _posts = postRemoteDataSource.fetchAllPost(postId)
            .stateIn(this, SharingStarted.Eagerly, emptyList())
    }
}