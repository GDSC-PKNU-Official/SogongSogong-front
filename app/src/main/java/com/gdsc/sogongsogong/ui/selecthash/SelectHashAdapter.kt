package com.gdsc.sogongsogong.ui.selecthash

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ItemSelectHashContentsBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

// TODO: 자료형 새로 적용
class SelectHashAdapter : ListAdapter<String, BaseViewHolder<ItemSelectHashContentsBinding>>(diffUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemSelectHashContentsBinding> =
        BaseViewHolder(parent, R.layout.item_select_hash_contents)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemSelectHashContentsBinding>, position: Int) {
        holder.binding.item = getItem(position)
    }

    companion object {

        private val diffUtil by lazy {
            object : DiffUtil.ItemCallback<String>() {
                override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
                override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem
            }
        }
    }
}