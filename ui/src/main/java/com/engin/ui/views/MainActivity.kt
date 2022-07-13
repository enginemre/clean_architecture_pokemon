package com.engin.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.engin.ui.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navigationController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Setting navigation components with toolbar
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.pokemon_nav_host_fragment) as NavHostFragment
        navigationController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navigationController.graph)
        NavigationUI.setupActionBarWithNavController(
            this,
            navigationController,
            appBarConfiguration
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController, null)
    }

}