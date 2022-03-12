package com.gdsc.sogongsogong.ui.join

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.fragment.NavHostFragment
import com.gdsc.sogongsogong.MainActivity
import com.gdsc.sogongsogong.R
import com.gdsc.sogongsogong.databinding.ActivityJoinBinding
import com.gdsc.sogongsogong.ui.base.BaseActivity

class JoinActivity : BaseActivity<ActivityJoinBinding>(R.layout.activity_join) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setInitPage()
    }

    private fun setInitPage() {
        when(isAutoLogIn()) {
            true -> startMainActivity()
            false -> setInitFragment()
        }
    }

    // TODO: 자동로그인 여부 검사
    // Shared Preference vs db
    private fun isAutoLogIn(): Boolean = false

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    // TODO: set init fragment
    private fun setInitFragment() {
        val navHost = NavHostFragment.create(R.navigation.nav_graph_join)
        supportFragmentManager.beginTransaction()
//            .replace(R.id., navHost) // TODO: set start fragment id
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }
}