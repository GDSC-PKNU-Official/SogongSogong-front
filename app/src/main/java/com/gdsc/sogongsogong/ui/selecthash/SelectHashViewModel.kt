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

    private var _categoryClickEvent: MutableSharedFlow<CategoryType> = MutableSharedFlow()
    val categoryClickEvent: SharedFlow<CategoryType> = _categoryClickEvent

    fun emitCategoryClickEvent() = onMain {
        _categoryClickEvent.emit(CategoryType.Category)
    }

    fun emitEtcCategoryClickEvent() = onMain {
        _categoryClickEvent.emit(CategoryType.Etc)
    }
}