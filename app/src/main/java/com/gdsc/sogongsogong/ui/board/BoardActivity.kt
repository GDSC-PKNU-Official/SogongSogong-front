package com.gdsc.sogongsogong.ui.board

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.gdsc.sogongsogong.NavViewModel
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ActivityBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseActivity
import com.gdsc.sogongsogong.ui.writepost.WritePostActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardActivity: BaseActivity<ActivityBoardBinding>(R.layout.activity_board) {

    private val adapter by lazy { BoardAdapter() }

    private val navViewModel: NavViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setAdapter()
        setCoroutine()
    }

    private fun setBinding() {
        binding.navViewModel = navViewModel
    }

    private fun setAdapter() {
        binding.rvBoardPost.adapter = adapter
    }

    private fun setCoroutine() {
        lifecycleScope.launch {
            collectBackButtonClickEvent()
            collectBoardClickEvent()
        }
    }

    private suspend fun collectBackButtonClickEvent() {
        navViewModel.backButtonEvent.collect {
            finish()
        }
    }

    private suspend fun collectBoardClickEvent() {
        navViewModel.boardClickEvent.collect {
            showWritePostActivity()
        }
    }

    private fun showWritePostActivity() {
        startActivity(Intent(this, WritePostActivity::class.java))
    }
}