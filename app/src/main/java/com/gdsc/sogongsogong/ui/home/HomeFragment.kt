package com.gdsc.sogongsogong.ui.home

import android.os.Bundle
import android.view.View
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.databinding.FragmentHomeBinding
import com.gdsc.sogongsogong.fake.FakeFactory
import com.gdsc.sogongsogong.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val informationAdapter: InformationAdapter by lazy { InformationAdapter() }

    private val boardAdapter: HomeBoardAdapter by lazy { HomeBoardAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinding()
        submitInformationBanner()
        submitHomeBoard(posts = FakeFactory.getFakePosts())
    }

    private fun initBinding() {
        binding.rvHomeInformation.adapter = informationAdapter
        binding.rvHomeBoard.adapter = boardAdapter
    }

    private fun submitInformationBanner() {
        // FIXME: submit real list
        informationAdapter.submitList(listOf(1, 2, 3, 4, 5, 6, 7))
    }

    private fun submitHomeBoard(posts: List<Post>) {
        boardAdapter.submitList(posts)
    }
}