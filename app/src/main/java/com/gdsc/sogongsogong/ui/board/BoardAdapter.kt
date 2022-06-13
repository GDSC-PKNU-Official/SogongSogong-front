package com.gdsc.sogongsogong.ui.board

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.databinding.ItemBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

class BoardAdapter : ListAdapter<Post, BaseViewHolder<ItemBoardBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemBoardBinding> =
        BaseViewHolder(parent, R.layout.item_board)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemBoardBinding>, position: Int) = with(holder.binding) {
        item = getItem(position)
        goodCount = getItem(position).countLike.toString()
        commentCount = getItem(position).countComment.toString()
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<Post>() {
                override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem.postId == newItem.postId
                override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
            }
        }
    }
}