package com.gdsc.sogongsogong.ui.setting

import android.os.Bundle
import android.view.View
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.FragmentSettingBinding
import com.gdsc.sogongsogong.ui.base.BaseFragment

class SettingFragment : BaseFragment<FragmentSettingBinding>(R.layout.fragment_setting) {

    private lateinit var adapter: SettingContentsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
    }

    private fun setAdapter() {
        adapter = SettingContentsAdapter()
        binding.rvSettingContents.adapter = adapter
    }
}