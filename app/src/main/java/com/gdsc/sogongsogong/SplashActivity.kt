package com.gdsc.sogongsogong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.gdsc.sogongsogong.MainActivity

class SplashActivity : AppCompatActivity() {

    // 2초간 스플래시 화면 보여줌 (ms)
    private val SPLASH_VIEW_TIME: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }
}