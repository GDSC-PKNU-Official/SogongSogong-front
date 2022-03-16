package com.gdsc.sogongsogong

import android.os.Bundle
import android.os.PersistableBundle
import com.gdsc.sogongsogong.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.gdsc.sogongsogong.ui.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setInitialFragment()
    }

    private fun setInitialFragment() {
        // TODO: set navHostFragment
    }
}