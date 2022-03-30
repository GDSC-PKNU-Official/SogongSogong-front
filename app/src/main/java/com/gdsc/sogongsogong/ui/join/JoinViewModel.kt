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

    // TODO: 인증하기, 나중에 인증하기 구분
    private val _authorizeClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val authorizeClickEvent: SharedFlow<Unit> = _authorizeClickEvent

    fun emitCompleteSignUpClickEvent() = onMain {
        _completeSignUpClickEvent.emit(Unit)
    }

    fun emitAuthorizeClickEvent() = onDefault {
        _authorizeClickEvent.emit(Unit)
    }
}