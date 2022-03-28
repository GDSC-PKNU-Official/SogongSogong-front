package com.gdsc.sogongsogong

import androidx.lifecycle.MutableLiveData
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import com.gdsc.sogongsogong.Repository
import retrofit2.Response


class MainViewModel : BaseViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData() //push
    //var myResponse2: MutableLiveData<Response<Post>> = MutableLiveData() 
    var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    //var myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    // 이 부분은 검사하 필요합니다... 자료마다 다 달라서 뭘 참고해야 될 지 모르겠어요ㅠㅜ

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
            val response = repository.getPostAuth()
            myResponse.value = response
        }
    }
    fun getPostAuth2(userId: Long, postId: Long){
        onMain {
            val response = repository.getPostAuth2(userId, postId)
            myResponse.value = response
        }
    }

    fun getCommentAuth(){
        onMain {
            val response = repository.getCommentAuth()
            myResponse.value = response
        }
    }

    fun getCommentAuth2(postId: Long, sort: String, order: String){
        onMain {
            val response = repository.getCommentAuth2(postId, sort, order)
            myResponse.value = response
        }
    }

    fun putPost(postId: Long, sort: String, order: String){
        onMain {
            val response = repository.putPost(postId, sort, order)
            myResponse.value = response
        }
    }

    fun putComment(userId: Long, content: Map<String, String>){
        onMain {
            val response = repository.putComment(userId, content)
            myResponse.value = response
        }
    }

    fun deletePost(postId: Long){
        onMain {
            val response = repository.deletePost(postId)
            myResponse.value = response
        }
    }
    fun deleteComment(commentId: Long){
        onMain {
            val response = repository.deleteComment(commentId)
            myResponse.value = response
        }
    }
    fun getEntirePost(){
        onMain {
            val response = repository.getEntirePost()
            myCustomPosts.value = response
        }
    }
    fun getEntirePost2(lastPost: Long){
        onMain {
            val response = repository.getEntirePost2(lastPost)
            myCustomPosts.value = response
        }
    }fun getOnePost(){
        onMain {
            val response = repository.getOnePost()
            myResponse.value = response
        }
    }
    fun getOnePost2(postId : Long){
        onMain {
            val response = repository.getOnePost2(postId)
            myResponse.value = response
        }
    }


    fun getOnePostComment(){
        onMain {
            val response = repository.getOnePostComment()
            myResponse.value = response
        }
    }fun getOnePostComment2(postId : Long, lastComment:Long){
        onMain {
            val response = repository.getOnePostComment2(postId, lastComment)
            myResponse.value = response
        }
    }
    fun getOnePostScarpLike(){
        onMain {
            val response = repository.getOnePostScarpLike()
            myResponse.value = response
        }
    }
    fun getOnePostScarpLike2(userId : Long, scrapLike:Boolean, lastScrap:Long){
        onMain {
            val response = repository.getOnePostScarpLike2(userId, scrapLike, lastScrap)
            myResponse.value = response
        }
    }

    fun getHotPost(){
        onMain {
            val response = repository.getHotPost()
            myResponse.value = response
        }
    }
    fun getHotPost2(lastPost : Long){
        onMain {
            val response = repository.getHotPost2(lastPost)
            myResponse.value = response
        }
    }
    fun getBestPost(){
        onMain {
            val response = repository.getBestPost()
            myResponse.value = response
        }
    }
    fun getBestPost2(lastPost : Long){
        onMain {
            val response = repository.getBestPost2(lastPost)
            myResponse.value = response
        }
    }

    fun postHashtag(){
        onMain {
            val response = repository.postHashtag()
            myResponse.value = response
        }
    }
    fun postHashtag2(postId: Post, hashName: List<String>){
        onMain {
            val response = repository.postHashtag2(postId, hashName)
            myResponse.value = response
        }
    }
    fun putHashtag(postId: Post, hashName: List<String>){
        onMain {
            val response = repository.putHashtag(postId, hashName)
            myResponse.value = response
        }
    }

    fun getHashtagPost(){
        onMain {
            val response = repository.getHashtagPost()
            myResponse.value = response
        }
    }
    fun getHashtagPost2(postId: Post){
        onMain {
            val response = repository.getHashtagPost2(postId)
            myResponse.value = response
        }
    }
    fun postHashtagUser(post: Post){
        onMain {
            val response = repository.postHashtagUser()
            myResponse.value = response
        }
    }
    fun postHashtagUser2(userId: Long, hashName: List<String>){
        onMain {
            val response = repository.postHashtagUser2(userId, hashName)
            myResponse.value = response
        }
    }
    fun putHashtagUser(){
        onMain {
            val response = repository.putHashtagUser()
            myResponse.value = response
        }
    }
    fun getHashtagUser2(userId : Long){
        onMain {
            val response = repository.getHashtagUser2(userId)
            myResponse.value = response
        }
    }
    fun getHashtagSearchBar(){
        onMain {
            val response = repository.getHashtagSearchBar()
            myResponse.value = response
        }
    }


    fun getHashtagSearchBar2(hashtag : List<String>, lastPost : Long){
        onMain {
            val response = repository.getHashtagSearchBar2(hashtag, lastPost)
            myResponse.value = response
        }
    }
    fun getHashtagSearchBoard(){
        onMain {
            val response = repository.getHashtagSearchBoard()
            myResponse.value = response
        }
    }
    fun getHashtagSearchBoard2(userId : Long, lastPost : Long){
        onMain {
            val response = repository.getHashtagSearchBoard2(userId, lastPost)
            myResponse.value = response
        }
    }
    fun getUserBusiness(){
        onMain {
            val response = repository.getUserBusiness()
            myResponse.value = response
        }
    }

    fun getUserBusiness2(num: String, startDate: String, pName: String){
        onMain {
            val response = repository.getUserBusiness2(num, startDate, pName)
            myResponse.value = response
        }
    }



}