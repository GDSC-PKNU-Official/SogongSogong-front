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

        setInitialFragment()
    }

    private fun setInitialFragment() {
        val navHost = NavHostFragment.create(R.navigation.nav_graph_bottom_nav)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_main, navHost)
            .setPrimaryNavigationFragment(navHost)
            .commit()

        // TODO: 홈버튼, 글작성버튼, 마이페이지 버튼 when 분기
        binding.navMainBottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.menu.bottom_nav_menu -> {true}
                else -> {true}
            }
        }
    }
}