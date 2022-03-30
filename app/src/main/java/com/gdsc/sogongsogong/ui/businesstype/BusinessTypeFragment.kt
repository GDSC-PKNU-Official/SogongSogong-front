package com.gdsc.sogongsogong.ui.businesstype

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentBusinessTypeBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import com.gdsc.sogongsogong.ui.join.JoinViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BusinessTypeFragment: BaseFragment<FragmentBusinessTypeBinding>(R.layout.fragment_business_type) {

    private val joinViewModel: JoinViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBinding()
        setCoroutine()
    }

    private fun setBinding() {
        binding.joinViewModel = joinViewModel
    }

    private fun setCoroutine() {
        lifecycleScope.launch {
            collectCompleteSignUpClickEvent()

        }
    }

    private suspend fun collectCompleteSignUpClickEvent() {
        joinViewModel.completeSignUpClickEvent.collect {
            // TODO: 가입완료 버튼 클릭 시 화면 전환
        }
    }
}