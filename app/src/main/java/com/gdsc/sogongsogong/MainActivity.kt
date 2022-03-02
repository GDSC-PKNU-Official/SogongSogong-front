package com.gdsc.sogongsogong

import android.os.Bundle
import android.os.PersistableBundle
import com.gdsc.sogongsogong.databinding.ActivityMainBinding
import com.gdsc.sogongsogong.ui.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setInitialFragment()
    }

    private fun setInitialFragment() {
        // TODO: set navHostFragment
    }
}