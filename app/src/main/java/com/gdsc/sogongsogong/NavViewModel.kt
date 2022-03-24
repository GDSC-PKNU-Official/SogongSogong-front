package com.gdsc.sogongsogong

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(dispatcherProvider: DispatcherProvider) : BaseViewModel(dispatcherProvider) {

    private var _searchBarClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val searchBarClickEvent: SharedFlow<Unit> = _searchBarClickEvent

    // TODO: 어떤 게시판인지 넘겨받기
    private val _boardClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val boardClickEvent: SharedFlow<Unit> = _boardClickEvent

    fun emitSearchBarClickEvent() = onMain {
        _searchBarClickEvent.emit(Unit)
    }

    fun emitBoardClickEvent() = onMain {
        _boardClickEvent.emit(Unit)
    }
}