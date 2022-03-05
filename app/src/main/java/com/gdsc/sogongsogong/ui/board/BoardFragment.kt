package com.gdsc.sogongsogong.ui.board

import android.os.Bundle
import android.view.View
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentBaseBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment: BaseFragment<FragmentBaseBoardBinding>(R.layout.fragment_base_board) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        // TODO: set adapter
    }
}