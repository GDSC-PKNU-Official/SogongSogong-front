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

    private val selectHAshViewModel: SelectHashViewModel by viewModels { defaultViewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBinding()
        setCoroutine()
    }

    private fun setBinding() {
        binding.selectHashViewModel = selectHAshViewModel
    }

    private fun setRecyclerView() {
        // TODO: 해시태그 선택에 따라 어댑터 변경
    }

    private fun setCoroutine() = lifecycleScope.launch {
        collectCategoryClickEvent()
    }

    private suspend fun collectCategoryClickEvent() {
        selectHAshViewModel.categoryClickEvent.collect { categoryType ->
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
}