package com.gdsc.sogongsogong.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gdsc.sogongsogong.NavViewModel
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.databinding.FragmentHomeBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import com.gdsc.sogongsogong.util.throttleFirst
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val informationAdapter: InformationAdapter by lazy { InformationAdapter() }

    private val boardAdapter: HomeBoardAdapter by lazy { HomeBoardAdapter() }

    private val navViewModel: NavViewModel by viewModels { defaultViewModelProviderFactory }

    private val homeViewModel: HomeViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        setCoroutines()
        submitInformationBanner()
    }

    private fun initBinding() = with(binding) {
        rvHomeInformation.adapter = informationAdapter
        rvHomeBoard.adapter = boardAdapter
        navViewModel = navViewModel
    }

    private fun setCoroutines() {
        lifecycleScope.launch {
            collectSearchBarClickEvent()
        }
        lifecycleScope.launch {
            collectHotPost()
        }
        lifecycleScope.launch {
            collectPosts()
        }
        lifecycleScope.launch {
            collectHotPost()
        }
    }

    private suspend fun collectHotPost() {
        homeViewModel.hotPosts.collect() { hotPost ->
            hotPost?.let { setHotPost(it) }
        }
    }

    private fun setHotPost(hotPost: Post) = with(binding) {
        hotItem = hotPost
        hotLikeCount = "${hotPost.countLike}"
        hotCommentCount = "${hotPost.countComment}"
    }

    private suspend fun collectPosts() {
        homeViewModel.posts.collect { posts ->
            boardAdapter.submitList(posts)
        }
    }

    private suspend fun collectSearchBarClickEvent() {
        navViewModel.searchBarClickEvent.throttleFirst().collect {
            findNavController().navigate(R.id.action_home_to_search)
        }
    }

    private fun submitInformationBanner() {
        // FIXME: submit real list
        informationAdapter.submitList(listOf(1, 2, 3, 4, 5, 6, 7))
    }
}