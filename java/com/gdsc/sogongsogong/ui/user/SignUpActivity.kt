package com.gdsc.sogongsogong.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager

import androidx.core.content.ContextCompat
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.network.MasterApplication

import kotlinx.android.synthetic.main.activity_sign_up.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    // 키보드 InputMethodManager 변수 선언
    private var imm: InputMethodManager? = null
    var idConfirm: Boolean = false
    var stuAuth = false

    inner class IdEditWatcher: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun afterTextChanged(s: Editable?) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            idConfirm = false
            SignUpIdEditTextView.backgroundDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.shape_post_warn_red)
        }
    }

    inner class NameEditWatcher: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun afterTextChanged(s: Editable?) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            stuAuth = false
            SignUpNameEditTextView.backgroundDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.shape_post_warn_red)
        }
    }

    inner class YearEditWatcher: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun afterTextChanged(s: Editable?) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            stuAuth = false
            SignUpYearEditText.backgroundDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.shape_post_warn_red)
        }
    }

    inner class StuNumEditWatcher: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
        override fun afterTextChanged(s: Editable?) { }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            stuAuth = false
            SignUpStuNumEditText.backgroundDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.shape_post_warn_red)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // toolbar 설정
        setSupportActionBar(sign_up_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)       // 기본 뒤로가기 버튼 설정
        supportActionBar?.setDisplayShowTitleEnabled(false)     // 기본 title 제거

        // 키보드 InputMethodManager 세팅
        imm = getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager?

        // 개인 정보 수집 이용 동의서 txt 파일 로드
        val inn = resources.openRawResource(R.raw.personalinfoagreement)
        val b: ByteArray = inn.readBytes()
        val personalInfo = String(b)
        SignUpPersonalInfo.text = personalInfo



        // ID 중복확인 버튼
        SignUpIdButton.setOnClickListener { checkIdDup() }

        // 회원가입 버튼
        SignUpButton.setOnClickListener { signUp()}


    }

    private fun signUp() {
        val id = SignUpIdEditTextView.text.toString()
        val password = SignUpPasswordEditTextView.text.toString()
        val passwordconfirm = SignUpPassWordCheckEditTextView.text.toString()
        val name = SignUpNameEditTextView.text.toString()
        val phoneNum = SignUpPhoneEditText.text.toString()
        val birth = SignUpBirthEditText.text.toString()
        val email = SignUpEmailEditText.text.toString()

        if (!idConfirm) {
            toast("아이디 중복확인을 해 주세요")
            return
        }

        if(password != passwordconfirm || password == "") {
            toast("비밀번호를 확인해 주세요")
            return
        }



        if (SignUpStuNumEditText.text.isNotEmpty()){
            stuNum = SignUpStuNumEditText.text.toString().toInt()
        }
        else {
            toast("번호를 입력해 주세요")
            return
        }


        if(SignUpEmailEditText.text.isEmpty()) {
            toast("이메일을 입력해 주세요")
            return
        }

        // 모든 칸에 빈칸이 없다면
        if (name == "" || phoneNum == "" || birth == "" || email == "") {
            toast("빈칸 없이 입력해 주세요")
            return
        }

        if (!SignUpPersonalInfoCheckbox.isChecked) {
            toast("개인 정보 제3자 제공에 동의해 주세요")
            return
        }

        val regData = HashMap<String, Any>()
        regData["id"] = id
        regData["password"] = password
        regData["name"] = name
        regData["phone"] = phoneNum
        regData["birth"] = birth
        regData["email"] = email

        // 입력받은 회원정보 POST
        (application as MasterApplication).service.signUp(regData)
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful && response.body()!!["success"] == "true") {
                        startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
                        toast("회원가입이 완료되었습니다")
                    } else {
                        toast("회원가입을 할 수 없습니다")
                    }
                }

                // 응답 실패 시
                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    toast("network error")
                    finish()
                }
            })
    }

    // 아이디 중복확인
    private fun checkIdDup() {
        val idMap = HashMap<String, String>()
        val id = SignUpIdEditTextView.text.toString()

        if (id != "") {
            idMap["id"] = id
        } else {
            toast("아이디를 입력해 주세요")
            return
        }

        // ID 중복확인 버튼 기능구현
        (application as MasterApplication).service.confirmId(idMap)
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful) {
                        if(response.body()!!["success"] == "true") {
                            idConfirm = false
                            toast("사용할 수 없는 아이디 입니다")
                            SignUpIdEditTextView.backgroundDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.shape_post_warn_red)
                        } else {
                            idConfirm = true
                            toast("사용할 수 있는 아이디 입니다")
                            SignUpIdEditTextView.backgroundDrawable = ContextCompat.getDrawable(applicationContext, R.drawable.shape_post_main_color)
                            val idWatcher = IdEditWatcher()
                            SignUpIdEditTextView.addTextChangedListener(idWatcher)
                        }
                    } else {
                        toast("중복확인을 할 수 없습니다")
                    }
                }

                // 응답 실패 시
                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    toast("network error")
                    finish()
                }
            })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // toolbar의 뒤로가기 버튼을 눌렀을 때
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // 이벤트 메서드 생성
    // 액티비티 최상위 layout에 onClick 세팅
    // 해당 layout 내 view 클릭 시 함수 실행
    fun hideKeyboard(v: View) {
        if (v != null)
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
    }

    override fun onBackPressed() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}