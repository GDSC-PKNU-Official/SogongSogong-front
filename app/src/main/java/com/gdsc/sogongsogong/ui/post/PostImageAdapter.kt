package com.gdsc.sogongsogong.ui.post

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.data.entity.PostDetail
import com.gdsc.sogongsogong.databinding.PostImgItemBinding
import com.gdsc.sogongsogong.ui.base.BaseViewHolder

class PostImageAdapter: ListAdapter<PostDetail, BaseViewHolder<PostImgItemBinding>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<PostImgItemBinding> =
        BaseViewHolder(parent, R.layout.post_img_item)

    override fun onBindViewHolder(holder: BaseViewHolder<PostImgItemBinding>, position: Int) {
        holder.binding.postImgItemView // TODO: data binding
    }

    companion object {

        val diffUtil by lazy {
            object : DiffUtil.ItemCallback<PostDetail>() {
                override fun areContentsTheSame(oldItem: PostDetail, newItem: PostDetail) = oldItem.data == newItem.data
                override fun areItemsTheSame(oldItem: PostDetail, newItem: PostDetail) = oldItem == newItem
            }
        }
    }
}