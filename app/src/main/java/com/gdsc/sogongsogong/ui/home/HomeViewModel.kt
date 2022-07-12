package com.gdsc.sogongsogong.ui.home

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.data.datasource.PostDataSource
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
) : BaseViewModel(dispatcherProvider) {

    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    private val _hotPosts: MutableStateFlow<Post?> = MutableStateFlow(null)
    val hotPosts: StateFlow<Post?> = _hotPosts

    init {
        fetchInitAllPost()
        fetchHotPost()
    }

    private fun fetchInitAllPost() = onIo {
        _posts.emit(postDataSource.fetchInitAllPost())
    }

    fun fetchAllPost(postId: Long) = onIo {
        _posts.emit(postDataSource.fetchAllPost(postId))
    }

    fun fetchHotPost() = onIo {
        _hotPosts.emit(hotPostDataSource.fetchHotPost())
    }
}
