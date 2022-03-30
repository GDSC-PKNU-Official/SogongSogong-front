package com.gdsc.sogongsogong.ui.businessauth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentBusinessNumberAuthBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import com.gdsc.sogongsogong.ui.join.JoinViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BusinessAuthFragment: BaseFragment<FragmentBusinessNumberAuthBinding>(R.layout.fragment_business_number_auth) {

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
            collectAuthButtonClickEvent()
        }
    }

    private suspend fun collectAuthButtonClickEvent() {
        joinViewModel.authorizeClickEvent.collect {
            navigateBusinessType()
        }
    }

    private fun navigateBusinessType() {
        findNavController().navigate(R.id.businessTypeFragment)
    }
}