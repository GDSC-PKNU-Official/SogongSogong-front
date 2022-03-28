package com.gdsc.sogongsogong

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import com.gdsc.sogongsogong.Repository
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(dispatcherProvider: DispatcherProvider) : BaseViewModel(dispatcherProvider) {

    private var _myResponse: MutableLiveData//<Response<Post>>
    val myResponse: MutableLiveData() = _myResponse
    // var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    private var _myCustomPosts: MutableLiveData//<Response<List<Post>>>
    val myCustomPosts: MutableLiveData() = _myCustomPosts

    fun pushPost(post: Post) {
        onMain {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }

    fun pushPost2(userId: Long, postId: Long, subject: String, content: String) {
        onMain {
            val response = repository.pushPost2(userId, postId, subject, content)
            myResponse.value = response
        }
    }

    fun pushComment(){
        onMain {
            val response = repository.pushComment()
            myResponse.value = response
        }
    }

    fun pushComment2(userId: Long, postId: Long, content: String){
        onMain {
            val response = repository.pushComment2(userId, postId, content)
            myResponse.value = response
        }
    }
    fun pushScraplike(){
        onMain {
            val response = repository.pushScraplike()
            myResponse.value = response
        }
    }
    fun pushScraplike2(userId: Long, postId: Long, category: Boolean){
        onMain {
            val response = repository.pushScraplike2(userId, postId, category)
            myResponse.value = response
        }
    }
    fun getPostAuth(){
        onMain {
            myResponse.value = repository.getPostAuth()
        }
    }
    fun getPostAuth2(userId: Long, postId: Long){
        onMain {
            myResponse.value = repository.getPostAuth2(userId, postId)
        }
    }

    fun getCommentAuth(){
        onMain {
            myResponse.value = repository.getCommentAuth()
        }
    }

    fun getCommentAuth2(postId: Long, sort: String, order: String){
        onMain {
            myResponse.value = repository.getCommentAuth2(postId, sort, order)
        }
    }

    fun putPost(postId: Long, sort: String, order: String){
        onMain {
            myResponse.value = repository.putPost(postId, sort, order)
        }
    }

    fun putComment(userId: Long, content: Map<String, String>){
        onMain {
            myResponse.value = repository.putComment(userId, content)
        }
    }

    fun deletePost(postId: Long){
        onMain {
            myResponse.value = repository.deletePost(postId)
        }
    }
    fun deleteComment(commentId: Long){
        onMain {
            myResponse.value = repository.deleteComment(commentId)
        }
    }
    fun getEntirePost(){
        onMain {
            myCustomPosts.value = repository.getEntirePost()
        }
    }
    fun getEntirePost2(lastPost: Long){
        onMain {
            myCustomPosts.value = repository.getEntirePost2(lastPost)
        }
    }
    fun getOnePost(){
        onMain {
            myResponse.value = repository.getOnePost()
        }
    }
    fun getOnePost2(postId : Long){
        onMain {
            myResponse.value = repository.getOnePost2(postId)
        }
    }


    fun getOnePostComment(){
        onMain {
            myResponse.value = repository.getOnePostComment()
        }
    }fun getOnePostComment2(postId : Long, lastComment:Long){
        onMain {
            myResponse.value  = repository.getOnePostComment2(postId, lastComment)
        }
    }
    fun getOnePostScarpLike(){
        onMain {
            myResponse.value = repository.getOnePostScarpLike()
        }
    }
    fun getOnePostScarpLike2(userId : Long, scrapLike:Boolean, lastScrap:Long){
        onMain {
            myResponse.value =repository.getOnePostScarpLike2(userId, scrapLike, lastScrap)
        }
    }

    fun getHotPost(){
        onMain {
            myResponse.value = repository.getHotPost()
        }
    }
    fun getHotPost2(lastPost : Long){
        onMain {
            myResponse.value = repository.getHotPost2(lastPost)
        }
    }
    fun getBestPost(){
        onMain {
            myResponse.value = repository.getBestPost()
        }
    }
    fun getBestPost2(lastPost : Long){
        onMain {
            myResponse.value = repository.getBestPost2(lastPost)
        }
    }

    fun postHashtag(){
        onMain {
            myResponse.value = repository.postHashtag()
        }
    }
    fun postHashtag2(postId: Post, hashName: List<String>){
        onMain {
            myResponse.value = repository.postHashtag2(postId, hashName)
        }
    }
    fun putHashtag(postId: Post, hashName: List<String>){
        onMain {
            myResponse.value = repository.putHashtag(postId, hashName)
        }
    }

    fun getHashtagPost(){
        onMain {
            myResponse.value = repository.getHashtagPost()
        }
    }
    fun getHashtagPost2(postId: Post){
        onMain {
            myResponse.value = repository.getHashtagPost2(postId)
        }
    }
    fun postHashtagUser(post: Post){
        onMain {
            myResponse.value = repository.postHashtagUser()
        }
    }
    fun postHashtagUser2(userId: Long, hashName: List<String>){
        onMain {
            myResponse.value = repository.postHashtagUser2(userId, hashName)
        }
    }
    fun putHashtagUser(){
        onMain {
            myResponse.value = repository.putHashtagUser()
        }
    }
    fun getHashtagUser2(userId : Long){
        onMain {
            myResponse.value = repository.getHashtagUser2(userId)
        }
    }
    fun getHashtagSearchBar(){
        onMain {
            myResponse.value = repository.getHashtagSearchBar()
        }
    }


    fun getHashtagSearchBar2(hashtag : List<String>, lastPost : Long){
        onMain {
            myResponse.value = repository.getHashtagSearchBar2(hashtag, lastPost)
        }
    }
    fun getHashtagSearchBoard(){
        onMain {
            myResponse.value = repository.getHashtagSearchBoard()
        }
    }
    fun getHashtagSearchBoard2(userId : Long, lastPost : Long){
        onMain {
            myResponse.value = repository.getHashtagSearchBoard2(userId, lastPost)
        }
    }
    fun getUserBusiness(){
        onMain {
            myResponse.value = repository.getUserBusiness()
        }
    }

    fun getUserBusiness2(num: String, startDate: String, pName: String){
        onMain {
            myResponse.value = repository.getUserBusiness2(num, startDate, pName)
        }
    }



}