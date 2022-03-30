package com.gdsc.sogongsogong.fake

import com.gdsc.sogongsogong.data.entity.Noti
import com.gdsc.sogongsogong.data.entity.Post

object FakeFactory {

    fun getFakePost(): Post = Post(
        boardId = 0,
        title = "How to apply for COVID-19 subsidy and tips.",
        body = "Contents",
        userId = "Anonymous",
        regdate = "17:50",
        type = "",
        goodCount = 30,
        commentCount = 12,
        scrapCount = 10,
        goodCheck = "",
        scrapCheck = "",
        userCheck = ""
    )

    fun getFakePosts(): List<Post> = listOf(
        Post(
            boardId = 0,
            title = "Notice of Change of Government Corona Policy",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 132,
            commentCount = 64,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "A clever way to start a business",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 32,
            commentCount = 34,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "10 Tips for dealing with rude customers",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 75,
            commentCount = 44,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "Legal consultation promotion",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 36,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),

        Post(
            boardId = 0,
            title = "Notice of Change of Government Corona Policy",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 132,
            commentCount = 64,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "A clever way to start a business",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 32,
            commentCount = 34,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "10 Tips for dealing with rude customers",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 75,
            commentCount = 44,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "Legal consultation promotion",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 36,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),

        Post(
            boardId = 0,
            title = "Notice of Change of Government Corona Policy",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 132,
            commentCount = 64,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "A clever way to start a business",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 32,
            commentCount = 34,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "10 Tips for dealing with rude customers",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 75,
            commentCount = 44,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
        Post(
            boardId = 0,
            title = "Legal consultation promotion",
            body = "컨텐츠내용",
            userId = "Anonymous",
            regdate = "17:50",
            type = "",
            goodCount = 36,
            commentCount = 12,
            scrapCount = 10,
            goodCheck = "",
            scrapCheck = "",
            userCheck = ""
        ),
    )

    fun getFakeNotifs() = listOf(
        Noti(
            title = "Application will take about a month :(",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
        Noti(
            title = "Thank you very much for the great information!",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
        Noti(
            title = "Is there any additional documents you need to apply for?",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
        Noti(
            title = "Wow, I really agree with this post!!!!!",
            body = "내용내용",
            boardId = 0,
            type = "",
            regDate = "2022.03.18 20:46"
        ),
    )
}