package com.gdsc.sogongsogong

import android.os.Bundle
import android.os.PersistableBundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gdsc.sogongsogong.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import com.gdsc.sogongsogong.ui.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setInitialFragment()
//        setBottomNav()
    }

    private fun setInitialFragment() {
        val navHost = NavHostFragment.create(R.navigation.nav_graph)
        supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragment, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }

    private fun setBottomNav() {
        val navController = findNavController(R.id.nav_graph_bottom_nav)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.postFragment, R.id.settingFragment))

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navMainBottomNav.setupWithNavController(navController)
    }
}