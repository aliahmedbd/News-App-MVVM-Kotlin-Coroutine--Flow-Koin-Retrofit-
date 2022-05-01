package com.example.androidcleanarchitecture.ui

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidcleanarchitecture.R
import com.example.androidcleanarchitecture.databinding.ActivityMainBinding
import com.example.androidcleanarchitecture.util.PreferenceKeys
import com.example.androidcleanarchitecture.viewmodel.NewsViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val newsViewModel : NewsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)

        setNavigationViewListener()
    }

    private fun setNavigationViewListener() {
        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemAllnews -> {
                transmitCategory("")
            }
            R.id.itemBusiness -> {
                transmitCategory(PreferenceKeys.BUSINESS)
            }
            R.id.itemHealth -> {
                transmitCategory(PreferenceKeys.HEALTH)
            }
            R.id.itemSports -> {
                transmitCategory(PreferenceKeys.SPORTS)
            }
            R.id.itemTechnology -> {
                transmitCategory(PreferenceKeys.TECHNOLOGY)
            }
            R.id.itemEntertainment -> {
                transmitCategory(PreferenceKeys.ENTERTAINMENT)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun transmitCategory(value: String) {
        lifecycleScope.launch {
            newsViewModel.transmitCategory(value)
        }
    }
}