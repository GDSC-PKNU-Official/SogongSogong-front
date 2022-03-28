package com.gdsc.sogongsogong.ui.selecthash

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class SelectHashViewModel @Inject constructor(dispatcherProvider: DispatcherProvider): BaseViewModel(dispatcherProvider) {

    private var _categoryClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val categoryClickEvent: SharedFlow<Unit> = _categoryClickEvent

    private var _etcCategoryClickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val etcCategoryCLickEvent: SharedFlow<Unit> = _etcCategoryClickEvent

    fun emitCategoryClickEvent() = onMain {
        _categoryClickEvent.emit(Unit)
    }

    fun emitEtcCategoryClickEvent() = onMain {
        _etcCategoryClickEvent.emit(Unit)
    }
}