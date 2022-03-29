package com.gdsc.sogongsogong

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gdsc.sogongsogong.data.entity.Post
import com.gdsc.sogongsogong.ui.base.BaseViewModel
import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    private val repository: Repository
) : BaseViewModel(dispatcherProvider) {

    /**
     * TODO: liveData -> Flow로 변경하기
     * TODO: 여러 repository로 분할하기
     */
    private val _myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse: LiveData<Response<Post>> = _myResponse

    private val _myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomPosts: LiveData<Response<List<Post>>> = _myCustomPosts

    fun pushPost(post: Post) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.pushPost(post)
    }

    fun pushPost2(userId: Long, postId: Long, subject: String, content: String) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.pushPost2(userId, postId, subject, content)
    }

    fun pushComment() = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.pushComment()

    }
    fun pushComment2(userId: Long, postId: Long, content: String) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.pushComment2(userId, postId, content)
    }

    fun pushScraplike() = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.pushScraplike()
    }

    fun pushScraplike2(userId: Long, postId: Long, category: Boolean) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.pushScraplike2(userId, postId, category)
    }

    fun getPostAuth() = onMain {
        _myResponse.value = repository.getPostAuth()
    }

    fun getPostAuth2(userId: Long, postId: Long) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.getPostAuth2(userId, postId)

    }
    fun getCommentAuth() = onMain {
        _myResponse.value = repository.getCommentAuth()
    }

    fun getCommentAuth2(postId: Long, sort: String, order: String) = onMain {
        // FIXME: 매개변수 불일치
//        _myResponse.value = repository.getCommentAuth2(postId, sort, order)
    }

    fun putPost(postId: Long, sort: String, order: String) = onMain {
        // FIXME: 매개변수 불일치
//        _myResponse.value = repository.putPost(postId, sort, order)
    }

    fun putComment(userId: Long, content: Map<String, String>) = onMain {
        // FIXME: 매개변수 불일치
//        _myResponse.value = repository.putComment(userId, content)
    }

    fun deletePost(postId: Long) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.deletePost(postId)
    }

    fun deleteComment(commentId: Long) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.deleteComment(commentId)

    }
    fun getEntirePost() = onMain {
        // FIXME: 매개변수 불일치
//        _myCustomPosts.value = repository.getEntirePost()
    }

    fun getEntirePost2(lastPost: Long) = onMain {
        // FIXME: 매개변수 불일치
//        _myCustomPosts.value = repository.getEntirePost2(lastPost)
    }

    fun getOnePost() = onMain {
        _myResponse.value = repository.getOnePost()
    }

    fun getOnePost2(postId : Long) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.getOnePost2(postId)
    }

    fun getOnePostComment() = onMain {
        _myResponse.value = repository.getOnePostComment()
    }

    fun getOnePostComment2(postId : Long, lastComment:Long) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value  = repository.getOnePostComment2(postId, lastComment)
    }

    fun getOnePostScarpLike() = onMain {
        _myResponse.value = repository.getOnePostScarpLike()
    }

    fun getOnePostScarpLike2(userId : Long, scrapLike:Boolean, lastScrap:Long) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.getOnePostScarpLike2(userId, scrapLike, lastScrap)
    }

    fun getHotPost() = onMain {
        _myResponse.value = repository.getHotPost()
    }

    fun getHotPost2(lastPost : Long) = onMain {
        _myResponse.value = repository.getHotPost2(lastPost)
    }

    fun getBestPost() = onMain {
        _myResponse.value = repository.getBestPost()
    }

    fun getBestPost2(lastPost : Long) = onMain {
        _myResponse.value = repository.getBestPost2(lastPost)
    }

    fun postHashtag() = onMain {
        // FIXME: 매개변수 불일치
//        _myResponse.value = repository.postHashtag()
    }

    fun postHashtag2(postId: Post, hashName: List<String>) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.postHashtag2(postId, hashName)
    }

    fun putHashtag(postId: Post, hashName: List<String>) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.putHashtag(postId, hashName)
    }

    fun getHashtagPost() = onMain {
        _myResponse.value = repository.getHashtagPost()
    }

    fun getHashtagPost2(postId: Post) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.getHashtagPost2(postId)
    }

    fun postHashtagUser(post: Post) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.postHashtagUser(post)
    }

    fun postHashtagUser2(userId: Long, hashName: List<String>) = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.postHashtagUser2(userId, hashName)
    }

    fun putHashtagUser() = onMain {
        // FIXME: 해당 코드에 오류 없고 repository 쪽이 틀렸고, 오류 안날 때 주석 풀면 됩니다.
//        _myResponse.value = repository.putHashtagUser()
    }

    fun getHashtagUser2(userId : Long) = onMain {
        _myResponse.value = repository.getHashtagUser2(userId)
    }

    fun getHashtagSearchBar() = onMain {
        _myResponse.value = repository.getHashtagSearchBar()
    }

    fun getHashtagSearchBar2(hashtag : List<String>, lastPost : Long) = onMain {
        _myResponse.value = repository.getHashtagSearchBar2(hashtag, lastPost)
    }

    fun getHashtagSearchBoard() = onMain {
        _myResponse.value = repository.getHashtagSearchBoard()
    }

    fun getHashtagSearchBoard2(userId : Long, lastPost : Long) = onMain {
        _myResponse.value = repository.getHashtagSearchBoard2(userId, lastPost)
    }

    fun getUserBusiness() = onMain {
        _myResponse.value = repository.getUserBusiness()
    }

    fun getUserBusiness2(num: String, startDate: String, pName: String) = onMain {
        _myResponse.value = repository.getUserBusiness2(num, startDate, pName)
    }
}