package com.gdsc.sogongsogong.ui.home

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.data.datasource.PostDataSource
import com.gdsc.sogongsogong.data.entity.TempPost
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val postDataSource: PostDataSource,
    private val hotPostDataSource: HotPostDataSource
): BaseViewModel(dispatcherProvider) {

    private var _posts: StateFlow<List<TempPost>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<TempPost>> = _posts

    private var _hotPosts: StateFlow<Post?> = MutableStateFlow(null)
    val hotPosts: StateFlow<Post?> = _hotPosts

    init {
        onIo {
            _posts = postDataSource.fetchInitAllPost()
                .stateIn(this, SharingStarted.Eagerly, emptyList())

            fetchHotPost()
        }
    }

    fun fetchAllPost(postId: Long) = onIo {
//        _posts = postDataSource.fetchAllPost(postId)
//            .stateIn(this, SharingStarted.Eagerly, emptyList())
    }

    private fun fetchHotPost() = onIo {
        _hotPosts = hotPostDataSource.fetchHotPost()
            .stateIn(this, SharingStarted.Eagerly, null)
    }
}