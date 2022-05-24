package com.gdsc.sogongsogong.ui.board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.data.remote.post.PostDataSource
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val postDataSource: PostDataSource
) : BaseViewModel(dispatcherProvider) {

    private var _board: MutableLiveData<String> = MutableLiveData() // FIXME: entity로 변경
    val board: LiveData<String> = _board

    private val _recyclerViewClickEvent = MutableSharedFlow<Unit>()
    val recyclerViewClickEvent: SharedFlow<Unit> = _recyclerViewClickEvent

    fun fetchAllPost(page: Int) {
        onIo {
            postDataSource.fetchAllPost(page.toLong())
        }
    }

    fun emitRecyclerViewClickEvent() = onMain {
            _recyclerViewClickEvent.emit(Unit)
    }
}