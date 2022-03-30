package com.gdsc.sogongsogong.ui.selecthash

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import com.gdsc.sogongsogong.ui.selecthash.data.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class SelectHashViewModel @Inject constructor(dispatcherProvider: DispatcherProvider): BaseViewModel(dispatcherProvider) {

    private val _categoryClickEvent: MutableSharedFlow<CategoryType> = MutableSharedFlow()
    val categoryClickEvent: SharedFlow<CategoryType> = _categoryClickEvent

    private val _completeSelectHashEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val completeSelectHashEvent: SharedFlow<Unit> = _completeSelectHashEvent

    // FIXME: ENUM 사용하기
    // FIXME: 적용 안됨 ㅠㅠ
    private var _isSelectedEtc = true
    val isSelectedEtc get() = _isSelectedEtc

    private var _isSelectedCategory = false
    val isSelectedCategory get() = _isSelectedCategory

    fun emitCategoryClickEvent() = onMain {
        _categoryClickEvent.emit(CategoryType.Category)
        _isSelectedEtc = false
        _isSelectedCategory = !isSelectedCategory
    }

    fun emitEtcCategoryClickEvent() = onMain {
        _categoryClickEvent.emit(CategoryType.Etc)
        _isSelectedCategory = false
        _isSelectedEtc = !isSelectedEtc
    }

    fun emitCompleteSelectHashEvent() = onMain {
        _completeSelectHashEvent.emit(Unit)
    }
}