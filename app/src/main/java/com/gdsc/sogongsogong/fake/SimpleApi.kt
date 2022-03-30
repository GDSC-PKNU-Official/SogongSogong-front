package com.gdsc.sogongsogong.fake

import com.gdsc.sogongsogong.data.entity.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface SimpleApi {
    //  GET은 서버로부터 정보를 조회하기 위해
    // @POST - CRUD의 Create(생성) 방식, BODY에 전송할 데이터를 담아서 서버에 생성

    /*- Requestbody : Body로 정보 주세요! (data class로 생성해서 넘기면 편함)
    - PathVariable : 그냥 url 뒤에 /붙여서 숫자만 넘겨주세요!
    - RequestParam : url에 ?post-id=1&comment-id=1 이렇게 변수명을 지정해주셔야 해요!*/

    // path, query, queryMap은 수정이 필요할 수 있습니다. 후에 수정 하겠습니다,

    // 사용자가 제목, 내용을 입력한 뒤 게시글을 등록한다.

    @FormUrlEncoded
    @POST("/board/post")

    suspend fun pushPost2(
        @Body pushPost2Dto: DtoDatas.pushPost2Dto
    ): Response<DtoDatas.pushPost2Dto>

    suspend fun pushPost(
        @Field("userId") userId: Long,
        @Field("postId") postId: Long,
        @Field("subject") subject: String,
        @Field("content") content: String
    ): Response<Post>


    // 사용자가 어떤 게시글에 댓글을 등록한다
    @POST("/board/comments")
    suspend fun pushComment(
        @Body post: Post
    ):Response<Post>

    @FormUrlEncoded
    @POST("/board/comments")
    suspend fun pushComment2(
        @Body pushComment2Dto: DtoDatas.pushComment2Dto
    ): Response<DtoDatas.pushComment2Dto>

    // 사용자가 어떤 게시글에 스크랩, 좋아요 버튼을 누른다.
    @POST("/board/scraplikes")
    suspend fun pushScraplike(
        @Body post: Post
    ):Response<Post>

    @FormUrlEncoded
    @POST("/board/scraplikes")
    suspend fun pushScraplike2(
        @Body pushScraplike2Dto: DtoDatas.pushScraplike2Dto
    ): Response<DtoDatas.pushScraplike2Dto>

    //게시글 및 댓글을 수정/삭제
    @GET("/board/post-auth")
    suspend fun getPostAuth() : Response<Post>

    @GET("/board/post-auth")
    suspend fun getPostAuth2(
        @Query("userId") userId : Long,
        @Query("postId") postId: Long
    ): Response<List<Post>>


    @GET("/board/comment-auth")
    suspend fun getCommentAuth() : Response<Post>

    @GET("/board/comment-auth")
    suspend fun getCommentAuth2(
        @Query("userId") userId : Long,
        @Query("commentId") commentId: Long
    ): Response<List<Post>>


    //PUT, DELETE는 코틀린 자료를 못찾아서.. java를 참고했는데 더 알아봐야 할 것 같습니다.

    //수정 버튼을 누르고 글을 수정 재등록
    @PUT("/board/post/{id}")
    fun putPost(
        @Query("postId") postId: Int,
        @Query("subject") subject: String,
        @Query("content") content: String
    ): Call<Post?>?

    @PUT("/board/comment/{id}")
    fun putComment(
        @Query("commentId") commentId: Long,
        @Query("content") content: String
    ): Call<Post?>?

    //삭제 버튼
    @DELETE("/board/post/{id}")
    fun deletePost(
        @Path("postId") postId: Long
    ): Call<Void?>?

    @DELETE("/comment/{id}")
    fun deleteComment(
        @Path("commentId") commentId: Long
    ): Call<Void?>?

    //전체 게시글 리스트를 확인
    @GET("/board/entire-post")
    suspend fun getEntirePost() : Response<Post>

    @GET("/board/entire-post/{last-post}")
    suspend fun getEntirePost2(
        @Path("lastPost") lastPost : Long
    ) : Response<Post>

    // 한 게시글에 대한 페이지
    @GET("/board/one-post/{id}")
    suspend fun getOnePost() : Response<Post>

    @GET("/board/one-post/{id}")
    suspend fun getOnePost2(
        @Query("postId") postId : Long
    ): Response<List<Post>>

    @GET("/board/one-post/comment")
    suspend fun getOnePostComment() : Response<Post>

    @GET("/board/one-post/comment")
    suspend fun getOnePostComment2(
        @Query("postId") postId : Long,
        @Query("last-comment") lastComment:Long
    ): Response<List<Post>>

    // 스크랩, 좋아요
    @GET("/board/one-post/scarpLike")
    suspend fun getOnePostScarpLike() : Response<Post>

    @GET("/board/one-post/scarpLike")
    suspend fun getOnePostScarpLike2(
        @Query("userId") userId : Long,
        @Query("scrap-lik") scrapLike:Boolean,
        @Query("last-scrap") lastScrap:Long,
    ): Response<List<Post>>

    @GET("/board/hot-post")
    suspend fun getHotPost() : Response<Post>

    @GET("/board/hot-post")
    suspend fun getHotPost2(
        @Path("lastPost") lastPost : Long
    ) : Response<Post>


    @GET("/board/best-post")
    suspend fun getBestPost() : Response<Post>

    @GET("/board/best-post")
    suspend fun getBestPost2(
        @Query("lastPost") lastPost : Long
    ) : Response<Post>

    // 해시태그 관련 서비스
    @POST("/hashtag/post")
    suspend fun postHashtag(
        @Body post: Post
    ):Response<Post>

    @FormUrlEncoded
    @POST("/hashtag/post")
    suspend fun postHashtag2(
        @Field("postId") postId: Long,
        @Field("hashName") hashName: List<String>
    ): Response<Post>

    @PUT("/hashtag/post")
    fun putHashtag(
        @Query("postId") postId: Int,
        @Query("hashName") hashName: List<String>
    ): Call<Post?>?

    @GET("/hashtag/post")
    suspend fun getHashtagPost() : Response<Post>

    @GET("/hashtag/post")
    suspend fun getHashtagPost2(
        @Query("postId") postId : Long
    ) : Response<Post>

    @POST("/hashtag/user")
    suspend fun postHashtagUser(
        @Body post: Post
    ):Response<Post>

    @FormUrlEncoded
    @POST("/hashtag/user")
    suspend fun postHashtagUser2(
        @Field("userId") userId: Long,
        @Field("hashName") hashName: List<String>
    ): Response<Post>

    @PUT("/hashtag/user")
    fun putHashtagUser(
        @Query("userId") userId: Int, // long이 아니네..?왜지
        @Query("hashName") hashName: List<String>
    ): Call<Post?>?

    @GET("/hashtag/user")
    suspend fun getHashtagUser() : Response<Post>

    @GET("/hashtag/user")
    suspend fun getHashtagUser2(
        @Query("userId") userId : Long
    ) : Response<Post>


    @GET("/hashtag/search-bar")
    suspend fun getHashtagSearchBar() : Response<Post>

    @GET("/hashtag/search-ba")
    suspend fun getHashtagSearchBar2(
        @Query("hashtag") hashtag : List<String>,
        @Query("lastPost") lastPost : Long
    ) : Response<Post>

    @GET("/hashtag/search-board")
    suspend fun getHashtagSearchBoard() : Response<Post>

    @GET("/hashtag/search-board")
    suspend fun getHashtagSearchBoard2(
        @Query("userId") userId : Long,
        @Query("lastPost") lastPost : Long
    ) : Response<Post>

    @GET("/user/business")
    suspend fun getUserBusiness() : Response<Post>

    @GET("/user/business")
    suspend fun getUserBusiness2(
        @Query("num") num : String,
        @Query("startDate") startDate : String,
        @Query("pName") pName : String
    ) : Response<Post>

}