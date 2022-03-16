package com.gdsc.sogongsogong

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor(dispatcherProvider: DispatcherProvider) : BaseViewModel(dispatcherProvider) {

    fun selectItem(item: Int) {


    }
}