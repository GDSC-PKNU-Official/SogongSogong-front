package com.gdsc.sogongsogong.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ItemHomeInforamtionBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

class InformationAdapter : ListAdapter<Any, BaseViewHolder<ItemHomeInforamtionBinding>>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemHomeInforamtionBinding>
    = BaseViewHolder(parent, R.layout.item_home_inforamtion)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemHomeInforamtionBinding>, position: Int) {
        // TODO
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<Any>() {
                override fun areContentsTheSame(oldItem: Any, newItem: Any) = oldItem == newItem
                override fun areItemsTheSame(oldItem: Any, newItem: Any) = oldItem == newItem
            }
        }
    }
}