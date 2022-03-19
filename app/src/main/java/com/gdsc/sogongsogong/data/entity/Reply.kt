package com.gdsc.sogongsogong.data.entity

import java.io.Serializable

data class ReplyListList (
    val success: String,
    val data: ArrayList<ReplyList>
): Serializable

data class ReplyList (
    val parent: Reply,
    val child: ArrayList<Reply>
): Serializable

data class ReplyChange (
    val success: String,
    val data: Reply
): Serializable

data class Reply (
    val reply_id: Int,
    val body: String,
    val user_id: String,
    val regdate: String,
    val board_id: Int,
    val parent_id: Int,
    val level: Int,
    val goodCount: Int,
    val goodCheck: String,
    val userCheck: String
): Serializable