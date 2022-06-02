package com.gdsc.sogongsogong.data.entity

import java.io.Serializable

data class PostList (
    val success: String,
    val data: MutableList<String>
): Serializable

data class PostDetail (
    val success: String,
    val data: MutableList<String>,
    val imagePath: ArrayList<String>
): Serializable

data class Post (
    val boardId: Int,
    val title: String,
    val body: String,
    val userId: String,
    val regdate: String,
    val type: String,
    val goodCount: Int,
    val commentCount: Int,
    val scrapCount: Int,
    val goodCheck: String,
    val scrapCheck: String,
    val userCheck: String
): Serializable

data class TempPost(
    val postId: Long,
    val subject: String,
    val content: String,
    val data: Long,
    val picture: String?,
    val countComment: Int,
    val countLike: Int
)
