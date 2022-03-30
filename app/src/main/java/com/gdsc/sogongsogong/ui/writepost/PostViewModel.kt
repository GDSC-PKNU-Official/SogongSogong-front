package com.gdsc.sogongsogong.ui.writepost

import com.gdsc.sogongsogong.Repository
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val repository: Repository
): BaseViewModel(dispatcherProvider) {

    fun postPost() = onMain {
        repository.pushPost2(1, 1, "sub", "cont")
//        repository.pushPost(userId, postId, subject, content)
    }
}