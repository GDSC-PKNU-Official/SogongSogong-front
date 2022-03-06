package com.gdsc.sogongsogong.ui.board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class BoardViewModel : ViewModel() {

    private val fakeRepository: String = "" // FIXME: repository interface로 변경, 주입받을 것

    private var _board: MutableLiveData<String> = MutableLiveData() // FIXME: entity로 변경
    val board: LiveData<String> = _board

    private val _recyclerViewClickEvent = MutableSharedFlow<Unit>()
    val recyclerViewClickEvent: SharedFlow<Unit> = _recyclerViewClickEvent

    fun fetchBoard(page: Int) {
        // TODO: return repository.fetchBoard(page)
    }

    fun fetchBoard() {
        // TODO: return repository.fetchBoard()
    }

    fun emitRecyclerViewClickEvent() {
        viewModelScope.launch {
            _recyclerViewClickEvent.emit(Unit)
        }
    }
}