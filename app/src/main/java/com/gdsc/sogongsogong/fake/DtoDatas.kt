package com.gdsc.sogongsogong.fake

class DtoDatas {

    data class pushPost2Dto (
        val userId: Long,
        val postId: Long,
        val subject: String,
        val content: String
    )
    data class pushComment2Dto(
        val userId: Long,
        val postId: Long,
        val content: String
    )
    data class pushScraplike2Dto(
        val userId: Long,
        val postId: Long,
        val category: Boolean
    )


}