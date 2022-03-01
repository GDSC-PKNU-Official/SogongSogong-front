package com.gdsc.sogongsogong.dataclass

import java.io.Serializable

data class PostList (
    val success: String,
    val data: ArrayList<Post>
): Serializable

data class PostDetail (
    val success: String,
    val data: ArrayList<Post>,
    val imagepath: ArrayList<String>
): Serializable

data class Post (
    val board_id: Int,
    val title: String,
    val body: String,
    val user_id: String,
    val regdate: String,
    val type: String,
    val goodCount: Int,
    val CommentCount: Int,
    val scrapCount: Int,
    val goodCheck: String,
    val scrapCheck: String,
    val userCheck: String
): Serializable

