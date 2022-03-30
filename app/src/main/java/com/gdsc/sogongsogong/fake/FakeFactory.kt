package com.gdsc.sogongsogong.fake

import com.gdsc.sogongsogong.data.entity.Noti
import com.gdsc.sogongsogong.data.entity.Post

object FakeFactory {
    fun getFakePosts(): List<Post> = listOf(
        Post(
            boardId = 0,
            title = "제목제목",
            body = "컨텐츠내용",
            userId = "1",
            regdate = "17:50",
            type = "",
            goodCount = 30,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "제목제목",
            body = "컨텐츠내용",
            userId = "1",
            regdate = "17:50",
            type = "",
            goodCount = 30,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "제목제목",
            body = "컨텐츠내용",
            userId = "1",
            regdate = "17:50",
            type = "",
            goodCount = 30,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "제목제목",
            body = "컨텐츠내용",
            userId = "1",
            regdate = "17:50",
            type = "",
            goodCount = 30,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        )
    )

    fun getFakeNotifs() = listOf(
        Noti(
            title = "한달쯤 걸린다 하더라구요 ㅜㅜ",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
        Noti(
            title = "한달쯤 걸린다 하더라구요 ㅜㅜ",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
        Noti(
            title = "한달쯤 걸린다 하더라구요 ㅜㅜ",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
        Noti(
            title = "한달쯤 걸린다 하더라구요 ㅜㅜ",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
    )
}