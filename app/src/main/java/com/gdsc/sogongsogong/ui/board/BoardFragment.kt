package com.gdsc.sogongsogong.ui.board

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentBaseBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardFragment: BaseFragment<FragmentBaseBoardBinding>(R.layout.fragment_base_board) {

    private val adapter by lazy { BoardAdapter() }

    private val boardViewModel: BoardViewModel by navGraphViewModels(R.id.nav_graph_bottom_nav) { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setCoroutine()
    }

    private fun setAdapter() {
        binding.rvBaseBoardBoard.adapter = adapter
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
        viewLifecycleOwner.lifecycleScope.launch {
            collectRecyclerView()
        }
    }
}