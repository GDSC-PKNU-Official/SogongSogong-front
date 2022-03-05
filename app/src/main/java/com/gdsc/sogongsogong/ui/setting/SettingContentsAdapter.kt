package com.gdsc.sogongsogong.ui.setting

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.databinding.ItemSettingContentsBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder


class SettingContentsAdapter: ListAdapter<Any, BaseViewHolder<ItemSettingContentsBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemSettingContentsBinding> {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ItemSettingContentsBinding>, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<Any>() {
                override fun areContentsTheSame(oldItem: Any, newItem: Any) = TODO("Any -> Data")
                override fun areItemsTheSame(oldItem: Any, newItem: Any) = TODO("Any -> Data")
            }
        }
    }
}