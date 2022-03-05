package com.gdsc.sogongsogong.ui.board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoardViewModel : ViewModel() {

    private val fakeRepository: String = "" // FIXME: repository interface로 변경, 주입받을 것

    private var _board: MutableLiveData<String> = MutableLiveData() // FIXME: entity로 변경
    val board: LiveData<String> = _board

    fun fetchBoard(page: Int) {
        // TODO: return repository.fetchBoard(page)
    }

    fun fetchBoard() {
        // TODO: return repository.fetchBoard()
    }
}