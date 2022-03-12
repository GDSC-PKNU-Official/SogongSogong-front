package com.gdsc.sogongsogong.ui.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.MainActivity
import com.gdsc.sogongsogong.network.MasterApplication
import com.google.gson.internal.LinkedTreeMap
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private var mBackWait:Long = 0

    // 키보드 InputMethodManager 변수 선언
    private var imm: InputMethodManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 키보드 InputMethodManager 세팅
        imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

        // 회원가입 클릭
        LoginRegisterBtn.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()
        }

        // 아이디, 비밀번호 찾기 클릭
        LoginFindIdPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, FindPasswordActivity::class.java))
            finish()
        }

        // 로그인 버튼   
        LoginButton.setOnClickListener {
            val id = LoginIdEditText.text.toString()
            val password = LoginPasswordEditText.text.toString()
            val post = HashMap<String, String>()

            when {
                id == "" -> toast("아이디를 입력해 주세요")
                password == "" -> toast("비밀번호를 입력해 주세요")
                else -> {
                    post["id"] = id
                    post["password"] = password
                    retrofitLogin(post)
                }
            }
        }
    }

    // 입력받은 id와 password POST 하는 함수
    private fun retrofitLogin(post: HashMap<String, String>) {
        val app = application as MasterApplication
        app.service.login(post)
            .enqueue(object : Callback<HashMap<String, Any>> {
                override fun onResponse(
                    call: Call<HashMap<String, Any>>,
                    response: Response<HashMap<String, Any>>
                ) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        val tokenMap: LinkedTreeMap<String, String>
                        var accessToken: String? = null
                        var refreshToken: String? = null

                        if (result!!["token"] != null) {
                            tokenMap = result["token"] as LinkedTreeMap<String, String>
                            accessToken = tokenMap["access_token"].toString()
                            refreshToken = tokenMap["refresh_token"].toString()
                        }

                        if (accessToken == null || refreshToken == null) {
                            toast("아이디와 비밀번호가 일치하지 않습니다")
                        } else {
                            app.saveUserToken("access_token", accessToken)
                            app.saveUserToken("refresh_token", refreshToken)
                            app.saveUserToken("role", result["role"].toString())

                            app.createRetrofit(refreshToken)
                        }
                    } else {
                        toast("아이디와 비밀번호가 일치하지 않습니다")
                    }
                }
                // 응답 실패 시
                override fun onFailure(call: Call<HashMap<String, Any>>, t: Throwable) {
                    toast("network error")
                    finish()
                }
            })
    }

    // firebase 토큰을 서버로 전송
    fun sendRegistrationToServer() {
        val sp = getSharedPreferences("firebase", Context.MODE_PRIVATE)
        val token = sp.getString("token", null)

        (application as MasterApplication).service.setDeviceToken(token!!)
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful && response.body()!!["success"] == "true") {
                        //
                    } else {
                        toast("알림 설정 오류")
                        finish()
                    }
                }

                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    toast("network error")
                    finish()
                }
            })
    }

    // 이벤트 메서드 생성
    // 액티비티 최상위 layout에 onClick 세팅
    // 해당 layout 내 view 클릭 시 함수 실행
    fun hideKeyboard(v: View) {
        if (v != null)
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - mBackWait >= 2000 ) {
            mBackWait = System.currentTimeMillis()
            toast("뒤로가기 버튼을 한번 더 누르면 종료됩니다")
        } else {
            finish()
        }
    }
}