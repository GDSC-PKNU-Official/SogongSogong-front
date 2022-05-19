package com.gdsc.sogongsogong.ui.boardlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gdsc.sogongsogong.NavViewModel
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentBoardListBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import com.gdsc.sogongsogong.ui.boardlist.BoardType.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BoardListFragment: BaseFragment<FragmentBoardListBinding>(R.layout.fragment_board_list) {

    private val navViewModel: NavViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBinding()
        setCoroutine()
    }

    private fun setBinding() {
        binding.navViewModel = navViewModel
    }

    private fun setCoroutine() {
        lifecycleScope.launch {
            collectBoardClickEvent()
        }
    }

    // TODO: 게시판 별 이동
    private suspend fun collectBoardClickEvent() {
        navViewModel.boardClickEvent.collect { boardType ->
            findNavController().navigate(
                when (boardType) {
                    MY_POST -> R.id.action_boardList_to_board
                    MY_COMMENT -> R.id.action_boardList_to_board
                    MY_LIKE -> R.id.action_boardList_to_board
                    MY_SCRAP -> R.id.action_boardList_to_board
                    HOT_BOARD -> R.id.action_boardList_to_board
                    BEST_BOARD -> R.id.action_boardList_to_board
                    SOGONG_BOARD -> R.id.action_boardList_to_board
                    HASH_BOARD -> R.id.action_boardList_to_hashBoard
                    MARKET_BOARD -> R.id.action_boardList_to_board
                }
            )
        }
    }
}