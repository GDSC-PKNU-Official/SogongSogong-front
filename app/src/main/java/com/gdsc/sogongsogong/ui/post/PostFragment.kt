package com.gdsc.sogongsogong.ui.post

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.navGraphViewModels
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentPostBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostFragment : BaseFragment<FragmentPostBinding>(R.layout.fragment_post) {

    private val viewModel: PostViewModel by navGraphViewModels(R.layout.fragment_post) {defaultViewModelProviderFactory}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBinding()
        setCoroutine()
    }

    private fun setBinding() {
        binding.viewModel = viewModel
    }

    private fun setCoroutine() {
        viewLifecycleOwner.lifecycleScope.launch {
            collectAddImageButton()
        }
    }

    private suspend fun collectAddImageButton() {
        viewModel.addImageClickEvent.collect {
            requestGalleryAuthor()
            showGallery()
        }
    }

    private fun requestGalleryAuthor() {
        // TODO: 갤러리 접근권한 요청 // 세팅에서 설정 페이지로 넘어갈지 아님 권한설정알림을 띄울지 결정해야 할 것 같습니다.
    }

    private fun showGallery() {
        if (hasAuthor()) {
            // TODO: 갤러리 화면을 보여준다.
        }
        else {
            // TODO: 갤러리에 접근하지 않는다.
            // TODO: 다이얼로그로 표시
        }
    }

    private fun hasAuthor(): Boolean {
        // TODO: 갤러리 접근 권한을 확인한다.
        return false
    }
}