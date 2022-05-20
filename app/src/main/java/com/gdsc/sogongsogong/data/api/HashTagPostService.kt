package com.gdsc.sogongsogong.data.api

import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.fake.DtoDatas
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.*

interface HashTagPostService {

    @GET("/hashtag/post")
    suspend fun fetchHashTagPost(): Flow<Post>

    @GET("/hashtag/post")
    suspend fun fetchHashTagPostById(@Query("postId") postId: Long): Flow<Post>

    // TODO: 무슨 동작인지 모르겠따.
    @GET("/hashtag/user")
    suspend fun fetchHashtagUser(): Flow<Post>

    @GET("/hashtag/user")
    suspend fun fetchHashtagUserById(@Query("userId") userId: Long): Flow<Post>

    // TODO: 몰루
    @GET("/hashtag/search-bar")
    suspend fun fetchHashtagSearchBar(): Flow<Post>

    @GET("/hashtag/search-bar")
    suspend fun fetchHashtagSearchBarByLastPost(@Query("hashtag") hashtag: List<String>, @Query("lastPost") lastPost: Long ): Flow<Post>

    // TODO: 몰루
    @GET("/hashtag/search-board")
    suspend fun fetchHashtagSearchBoard(): Flow<Post>

    @GET("/hashtag/search-board")
    suspend fun getHashtagSearchBoardById(@Query("userId") userId : Long, @Query("lastPost") lastPost: Long ): Flow<Post>

    @POST("/hashtag/post")
    suspend fun postHashTagPost(@Body post: Post): Flow<Post>

    // FIXME
    @FormUrlEncoded
    @POST("/hashtag/post")
    suspend fun postHashtag2(@Body postHashtag2Dto: DtoDatas.postHashtag2Dto): Response<Post>

    // TODO: 무슨 동작인지 모르겠다.
    @POST("/hashtag/user")
    suspend fun postHashtagUser(@Body post: Post): Flow<Post>

    // FIXME
    @FormUrlEncoded
    @POST("/hashtag/user")
    suspend fun postHashtagUser2( @Body postHashtagUser2Dto: DtoDatas.postHashtagUser2Dto ): Response<DtoDatas.postHashtagUser2Dto>

    // FIXME
    @PUT("/hashtag/post")
    fun putHashtag( @Body putHashtagDto: DtoDatas.putHashtagDto ): Response<DtoDatas.putHashtagDto>

    // FIXME
    @PUT("/hashtag/user")
    fun putHashtagUser(@Body putHashtagUserDto: DtoDatas.putHashtagUserDto ): Response<DtoDatas.putHashtagUserDto>
}
