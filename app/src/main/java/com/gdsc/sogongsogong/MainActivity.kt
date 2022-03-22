package com.gdsc.sogongsogong

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.gdsc.sogongsogong.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.gdsc.sogongsogong.ui.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController by lazy { findNavController(R.id.fragment_navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setNavHostFragment()
    }

    private fun setNavHostFragment() {
        binding.navMainBottomNav.setupWithNavController(navController)
    }
}