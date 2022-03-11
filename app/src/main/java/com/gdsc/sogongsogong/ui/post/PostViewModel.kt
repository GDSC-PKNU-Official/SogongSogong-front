package com.gdsc.sogongsogong.ui.post

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {

    private val _addImageClickEvent = MutableSharedFlow<Unit>()
    val addImageClickEvent: SharedFlow<Unit> = _addImageClickEvent

    fun emitAddImageClickEvent() = onMain {
        _addImageClickEvent.emit(Unit)
    }
}