package com.testtask.myapplication.presentations

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.MaterialToolbar
import com.testtask.myapplication.R
import com.testtask.myapplication.databinding.ActivityMainBinding
import com.testtask.myapplication.presentations.main.MainFragment

class MainActivity : AppCompatActivity() {
    private val viewBinding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initStartView()
    }

    private fun initView() {
        val toolbar: MaterialToolbar = viewBinding.appBarMain.toolbar
        setSupportActionBar(toolbar)
        initDrawer(toolbar)
    }

    private fun initStartView() {
        navigateToFragment(MainFragment.newInstance())
    }

    private fun initDrawer(toolbar: MaterialToolbar) {
        val drawerLayout: DrawerLayout = viewBinding.drawerLayout
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer_layout_description,
            R.string.close_drawer_layout_description
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        initNavigationDrawer(drawerLayout)
    }

    private fun initNavigationDrawer(drawerLayout: DrawerLayout) {
        val navView = viewBinding.navView
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main_frame_menu_drawer -> {
                    navigateToFragment(MainFragment.newInstance())
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_main_frame, fragment)
            .commit()
    }
}