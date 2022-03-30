package com.gdsc.sogongsogong.ui.notification

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.Noti
import com.gdsc.sogongsogong.databinding.ItemNotificationBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

class NotificationContentsAdapter : ListAdapter<Noti, BaseViewHolder<ItemNotificationBinding>>(diffUtil){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemNotificationBinding> =
        BaseViewHolder(parent, R.layout.item_notification)

    override fun onBindViewHolder(holder: BaseViewHolder<ItemNotificationBinding>, position: Int) {
        holder.binding.item = getItem(position)
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<Noti>() {
                // FIXME: boardId가 중복되는 경우?
                override fun areContentsTheSame(oldItem: Noti, newItem: Noti) = oldItem.boardId == newItem.boardId

                override fun areItemsTheSame(oldItem: Noti, newItem: Noti) = oldItem == newItem
            }
        }
    }
}