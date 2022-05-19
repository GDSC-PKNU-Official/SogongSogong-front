package com.gdsc.sogongsogong

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import com.gdsc.sogongsogong.ui.boardlist.BoardType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(dispatcherProvider: DispatcherProvider) : BaseViewModel(dispatcherProvider) {

    private var _searchBarClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val searchBarClickEvent: SharedFlow<Unit> = _searchBarClickEvent

    private val _boardClickEvent: MutableSharedFlow<BoardType> = MutableSharedFlow()
    val boardClickEvent: SharedFlow<BoardType> = _boardClickEvent

    private val _backButtonEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val backButtonEvent: SharedFlow<Unit> = _backButtonEvent

    private val _addImageClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val addImageClickEvent: SharedFlow<Unit> = _addImageClickEvent

    private val _selectHashTagClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val selectHashTagClickEvent: SharedFlow<Unit> = _selectHashTagClickEvent

    private val _writePostFabClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val writePostFabClickEvent: SharedFlow<Unit> = _writePostFabClickEvent

    private val _writePostCompleteClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val writePostCompleteClickEvent: SharedFlow<Unit> = _writePostCompleteClickEvent

    fun emitSearchBarClickEvent() = onMain {
        _searchBarClickEvent.emit(Unit)
    }

    fun emitBoardClickEvent(boardType: BoardType) = onMain {
        _boardClickEvent.emit(boardType)
    }

    fun emitBackButtonEvent() = onMain {
        _backButtonEvent.emit(Unit)
    }

    fun emitAddImageClickEvent() = onMain {
        _addImageClickEvent.emit(Unit)
    }

    fun emitSelectHashTagClickEvent() = onMain {
        _selectHashTagClickEvent.emit(Unit)
    }

    fun emitWritePostFabClickEvent() = onMain {
        _writePostFabClickEvent.emit(Unit)
    }

    fun emitWritePostCompleteClickEvent() = onMain {
        _writePostCompleteClickEvent.emit(Unit)
    }
}