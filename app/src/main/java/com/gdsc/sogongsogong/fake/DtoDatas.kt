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
    data class putPostDto(
        val postId: Long,
        val subject: String,
        val content: String
    )
    data class postHashtag2Dto(
        val postId: Long,
        val hashName: List<String>
    )
    data class putHashtagDto(
        val postId: Long,
        val hashName: String
    )
    data class postHashtagUser2Dto(
        val userId: Long,
        val hashName: String
    )
    data class putHashtagUserDto(
        val userId: Long,
        val hashName: List<String>
    )

    data class getUserBusiness2Dto(
        val num: String,
        val startDate: String,
        val pName:String
    )



}
