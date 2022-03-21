package com.gdsc.sogongsogong.ui.post

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdsc.sogongsogong.R

class PostImagePagerAdapter(
    private val uriPaths: ArrayList<Uri>,
    private val inflater: LayoutInflater
): RecyclerView.Adapter<PostImagePagerAdapter.PostImagePagerViewHolder>() {

    // FIXME: data binding 방식으로 변경
    // FIXME: 매개변수 제거
    // TODO: Base ViewHolder로 migration
    // TODO: list adapter로 migration (diffUtil 적용)
    inner class PostImagePagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        val img: ImageView = itemView.post_img_viewpager_itemView
//
//        fun bind(postUri: Uri) {
//            Glide.with(itemView.context)
//                .load(postUri)
//                .into(img)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostImagePagerViewHolder {
        val view = inflater.inflate(R.layout.post_img_viewpager_item, parent, false)
        return PostImagePagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostImagePagerViewHolder, position: Int) {
//        holder.bind(uriPaths[position])
    }

    override fun getItemCount(): Int = uriPaths.size
}