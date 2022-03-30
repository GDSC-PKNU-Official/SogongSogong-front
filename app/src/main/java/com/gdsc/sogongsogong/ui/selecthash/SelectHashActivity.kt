package com.gdsc.sogongsogong.ui.selecthash

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ActivitySelectHashBinding
import com.gdsc.sogongsogong.ui.base.BaseActivity
import com.gdsc.sogongsogong.ui.selecthash.data.CategoryType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SelectHashActivity: BaseActivity<ActivitySelectHashBinding>(R.layout.activity_select_hash) {

    private val selectHashViewModel: SelectHashViewModel by viewModels { defaultViewModelProviderFactory }

    private val selectHashAdapter by lazy { SelectHashAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setRecyclerView() // FIXME: 해시태그 선택에 반응하도록 변경
        setCoroutine()
    }

    private fun setBinding() {
        binding.selectHashViewModel = selectHashViewModel
    }

    private fun setRecyclerView() {
        // TODO: 해시태그 선택에 따라 어댑터 변경
        binding.rvSelectHashContents.adapter = selectHashAdapter
        selectHashAdapter.submitList(listOf("농업 임업 및 어업", "금융 및 보험업", "금융 및 보험업"))
    }

    private fun setCoroutine() {
        lifecycleScope.launch {
            collectCategoryClickEvent()
        }
        lifecycleScope.launch {
            collectCompleteSelectHashEvent()
        }
    }

    private suspend fun collectCategoryClickEvent() {
        selectHashViewModel.categoryClickEvent.collect { categoryType ->
            selectCategory(categoryType)
        }
    }

    private fun selectCategory(categoryType: CategoryType) {
        // TODO: 배경색 입히기, rv어댑터 갈아끼우기
        when (categoryType) {
            CategoryType.Category -> {}
            CategoryType.Etc -> {}
        }
    }

    private suspend fun collectCompleteSelectHashEvent() {
        selectHashViewModel.completeSelectHashEvent.collect {
            finish()
        }
    }
}