package com.gdsc.sogongsogong.ui.board

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ActivityBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardActivity: BaseActivity<ActivityBoardBinding>(R.layout.activity_board) {

    private val adapter by lazy { BoardAdapter() }

    private val boardViewModel: BoardViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setAdapter()
        setCoroutine()
    }

    private fun setBinding() {
        binding.viewModel = boardViewModel
    }

    private fun setAdapter() {
        binding.rvBoardPost.adapter = adapter
    }

    private suspend fun collectRecyclerView() {
        boardViewModel.recyclerViewClickEvent.collect {
            navigatePost()
        }
    }

    private fun navigatePost() {
        // TODO: 전달받은 게시글로 이동
    }

    private fun setCoroutine() {
        lifecycleScope.launch {
            collectRecyclerView()
        }
    }
}