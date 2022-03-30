package com.gdsc.sogongsogong.ui.join

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(dispatcherProvider: DispatcherProvider): BaseViewModel(dispatcherProvider) {

    private val _completeSignUpClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val completeSignUpClickEvent: SharedFlow<Unit> = _completeSignUpClickEvent

    fun emitCompleteSignUpClickEvent() = onMain {
        _completeSignUpClickEvent.emit(Unit)
    }
}