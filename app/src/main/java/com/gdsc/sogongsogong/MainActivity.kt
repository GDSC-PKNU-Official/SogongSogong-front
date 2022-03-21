package com.gdsc.sogongsogong

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.gdsc.sogongsogong.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.gdsc.sogongsogong.ui.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setNavHostFragment()
    }

    private fun setNavHostFragment() {
        val navHost = NavHostFragment.create(R.navigation.nav_graph_bottom_nav)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }
}