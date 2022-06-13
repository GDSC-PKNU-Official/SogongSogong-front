package com.gdsc.sogongsogong.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.databinding.ItemHomeBoardBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

class HomeBoardAdapter : ListAdapter<Post, BaseViewHolder<ItemHomeBoardBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemHomeBoardBinding> =
        BaseViewHolder(parent, R.layout.item_home_board)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemHomeBoardBinding>, position: Int) = with(holder.binding) {
        item = getItem(position)
        scrapCount = getItem(position).countLike //FIXME
        commentCount = getItem(position).countComment
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