package com.gdsc.sogongsogong.ui.board

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ItemBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

class BoardAdapter : ListAdapter<Any, BaseViewHolder<ItemBoardBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemBoardBinding> =
        BaseViewHolder(parent, R.layout.item_board)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemBoardBinding>, position: Int) {
//        holder.binding.item = getItem(position)
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

class BoardAdapter : ListAdapter<Any, BaseViewHolder<ItemBoardBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemBoardBinding> =
        BaseViewHolder(parent, R.layout.item_board)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemBoardBinding>, position: Int) {
//        holder.binding.item = getItem(position)
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