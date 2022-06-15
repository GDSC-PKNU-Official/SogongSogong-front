package com.gdsc.sogongsogong.data.entity

import java.io.Serializable

data class PostDetail (
    val success: String,
    val data: MutableList<String>,
    val imagePath: ArrayList<String>
): Serializable

data class Post(
    val postId: Long,
    val subject: String,
    val content: String,
    val date: String,
    val picture: String?,
    val countComment: Int,
    val countLike: Int
): Serializable
