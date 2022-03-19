package com.gdsc.sogongsogong.ui.post

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.ui.post.PostImagePagerAdapter
import kotlinx.android.synthetic.main.activity_post_image_pager.*

class PostImagePagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_image_pager)

        if (intent.hasExtra("uriPaths")) {
            val uriPaths = intent.getSerializableExtra("uriPaths") as ArrayList<Uri>
            val position = intent.getIntExtra("position", 0)
            val adapter = PostImagePagerAdapter(uriPaths, LayoutInflater.from(this@PostImagePagerActivity))
            post_img_viewpager.adapter = adapter
            post_img_viewpager.currentItem = position
//            post_img_viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//                override fun onPageSelected(position: Int) {
//                    super.onPageSelected(position)
//                }
//            })
        } else {
            finish()
        }
    }
}