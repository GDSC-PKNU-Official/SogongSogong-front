package com.gdsc.sogongsogong.ui.login

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData


class LoginSignupViewModel {

    val LOGIN_FAIL_STATUS:String = "아이디 또는 비밀번호가 틀렸습니다"
    val LOGIN_SUCCESS_STATUS:String = "로그인 성공" // string 수정 필요

    var input_username_check_count = MutableLiveData<Int>(0)
    var input_password_check_count = MutableLiveData<Int>(0)
    var user_mbti = MutableLiveData<String>("ISTJ")

    companion object {
        @SuppressLint("StaticFieldLeak")
        var instance: LoginSignupViewModel? = null

        @JvmName("fragment_getInstance")
        fun getInstance(): LoginSignupViewModel {
            instance?.let {
                return it
            }
            instance = LoginSignupViewModel()
            return instance!!
        }
    }

    fun login_input_check(): String {
        return if(input_password_check_count.value == 1 && input_username_check_count.value == 1) {
            LOGIN_SUCCESS_STATUS
        } else {
            LOGIN_FAIL_STATUS
        }
    }
}