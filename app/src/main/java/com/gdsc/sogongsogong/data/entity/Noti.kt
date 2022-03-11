package com.gdsc.sogongsogong.data.entity

import java.io.Serializable

data class NotiList(
    val success: String,
    val data: MutableList<String>
): Serializable

data class NotiPost(
    val title: String,
    val body: String,
    val boardId: Int
): Serializable

data class Noti (
    val title: String,
    val body: String,
    val boardId: Int,
    val type: String,
    val regDate: String
): Serializable