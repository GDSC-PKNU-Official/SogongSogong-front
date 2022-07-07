package com.gdsc.sogongsogong.ui.board

import com.gdsc.sogongsogong.data.datasource.HotPostDataSource
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.data.datasource.PostDataSource
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val postDataSource: PostDataSource,
    private val hotPostDataSource: HotPostDataSource
) : BaseViewModel(dispatcherProvider) {

    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    private val _hotPost: MutableStateFlow<Post?> = MutableStateFlow(null)
    val hotPost: StateFlow<Post?> = _hotPost

    private val _recyclerViewClickEvent = MutableSharedFlow<Unit>()
    val recyclerViewClickEvent: SharedFlow<Unit> = _recyclerViewClickEvent

    init {
        fetchInitAllPosts()
        fetchHotPost()
    }

    private fun fetchInitAllPosts() = onIo {
        _posts.emit(postDataSource.fetchInitAllPost())
    }

    private fun fetchHotPost() = onIo {
        _hotPost.emit(hotPostDataSource.fetchHotPost())
    }

    fun fetchAllPost(page: Int) = onIo {
        _posts.emit(postDataSource.fetchAllPost(page.toLong()))
    }

    fun emitRecyclerViewClickEvent() = onMain {
        _recyclerViewClickEvent.emit(Unit)
    }
}
