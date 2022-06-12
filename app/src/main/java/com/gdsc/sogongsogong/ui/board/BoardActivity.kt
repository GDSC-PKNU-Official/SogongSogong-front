package com.gdsc.sogongsogong.ui.board

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.gdsc.sogongsogong.NavViewModel
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.databinding.ActivityBoardBinding
import com.gdsc.sogongsogong.fake.FakeFactory
import com.gdsc.sogongsogong.ui.base.BaseActivity
import com.gdsc.sogongsogong.ui.writepost.WritePostActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardActivity: BaseActivity<ActivityBoardBinding>(R.layout.activity_board) {

    private val adapter by lazy { BoardAdapter() }

    private val navViewModel: NavViewModel by viewModels { defaultViewModelProviderFactory }

    private val boardViewModel: BoardViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setAdapter()
        setCoroutine()
        setHotPost()
    }

    private fun setBinding() {
        binding.navViewModel = navViewModel
    }

    private fun setAdapter() {
        binding.rvBoardPost.adapter = adapter
    }

    private fun submitPosts(posts: List<Post>) {
        adapter.submitList(posts)
    }

    private fun setCoroutine() {
        // TODO: 깔끔하게 바꿀 것
        lifecycleScope.launch {
            collectBackButtonClickEvent()
        }
        lifecycleScope.launch {
            collectBoardClickEvent()
        }
        lifecycleScope.launch {
            collectWritePostFabClickEvent()
        }
        lifecycleScope.launch {
            collectPost()
        }
    }

    private fun setHotPost() = with(binding) {
        hotItem = FakeFactory.getFakePost()
        hotCommentCount = (hotItem as Post).commentCount.toString()
        hotGoodCount = (hotItem as Post).goodCount.toString()
    }

    private suspend fun collectBackButtonClickEvent() {
        navViewModel.backButtonEvent.collect {
            finish()
        }
    }

    private suspend fun collectBoardClickEvent() {
        navViewModel.boardClickEvent.collect {
            // TODO: 게시글 확인
        }
    }

    private suspend fun collectWritePostFabClickEvent() {
        navViewModel.writePostFabClickEvent.collect {
            showWritePostActivity()
        }
    }

    private suspend fun collectPost() {
        boardViewModel.posts.collect { posts ->
//            submitPosts(posts)
        }
    }

    private fun showWritePostActivity() {
        startActivity(Intent(this, WritePostActivity::class.java))
    }
}