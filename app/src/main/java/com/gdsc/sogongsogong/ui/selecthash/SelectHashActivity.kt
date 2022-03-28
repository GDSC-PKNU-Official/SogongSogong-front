package com.gdsc.sogongsogong.ui.selecthash

import androidx.activity.viewModels
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ActivitySelectHashBinding
import com.gdsc.sogongsogong.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectHashActivity: BaseActivity<ActivitySelectHashBinding>(R.layout.activity_select_hash) {

    private val selectHAshViewModel: SelectHashViewModel by viewModels { defaultViewModelProviderFactory }



}