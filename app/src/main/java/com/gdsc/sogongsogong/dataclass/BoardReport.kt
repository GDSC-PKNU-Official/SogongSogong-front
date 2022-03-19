package com.gdsc.sogongsogong.dataclass

data class BoardReport (
    val boardId: Int,
    val sendId: String,
    val recvId: String,
    val body: String,
    val regDate: String
)