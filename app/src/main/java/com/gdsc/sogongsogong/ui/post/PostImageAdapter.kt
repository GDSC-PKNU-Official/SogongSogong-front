package com.gdsc.sogongsogong.ui.post

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
<<<<<<< HEAD
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
=======
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gdsc.sogongsogong.R

class PostImageAdapter(
    private val uriPaths: ArrayList<Uri>,
    private val inflater: LayoutInflater,
    private val itemClick: (Int) -> Unit
): RecyclerView.Adapter<PostImageAdapter.PostImageViewHolder>() {
    inner class PostImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val postImage: ImageView = itemView.findViewById(R.id.post_img_itemView)

        fun bind(postUri: Uri, position: Int) {
            Glide.with(itemView.context)
                .load(postUri)
                .override(300)
                .placeholder(R.color.white)
                .into(postImage)

            itemView.setOnClickListener { itemClick(position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostImageViewHolder {
        val view = inflater.inflate(R.layout.post_img_item, parent, false)
        return PostImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostImageViewHolder, position: Int) {
        holder.bind(uriPaths[position], position)
    }

    override fun getItemCount(): Int = uriPaths.size
>>>>>>> origin/hotfix/0320
}