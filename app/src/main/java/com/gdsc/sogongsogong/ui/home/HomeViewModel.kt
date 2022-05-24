package com.gdsc.sogongsogong.ui.home

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.data.datasource.PostDataSource
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
    private val postDataSource: PostDataSource,
    private val hotPostDataSource: HotPostDataSource
): BaseViewModel(dispatcherProvider) {

    private var _posts: StateFlow<List<Post>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    private var _hotPosts: StateFlow<List<Post>> = MutableStateFlow(emptyList())
    val hotPosts: StateFlow<List<Post>> = _hotPosts

    init {
        onIo {
            _posts = postDataSource.fetchInitAllPost()
                .stateIn(this, SharingStarted.Eagerly, emptyList())

            fetchAllHotPosts()
        }
    }

    fun fetchAllPost(postId: Long) = onIo {
        _posts = postDataSource.fetchAllPost(postId)
            .stateIn(this, SharingStarted.Eagerly, emptyList())
    }

    private fun fetchAllHotPosts() = onIo {
        _hotPosts = hotPostDataSource.fetchAllHotPosts()
            .stateIn(this, SharingStarted.Eagerly, emptyList())
    }
}