package com.divyanshu.newapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.divyanshu.api.models.entity.User
import com.divyanshu.newapp.databinding.ActivityMainBinding
import com.divyanshu.newapp.ui.auth.AuthViewModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

  private lateinit var authViewModel: AuthViewModel
  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.appBarLaunch.toolbar)

    val drawerLayout: DrawerLayout = binding.drawerLayout
    val navView: NavigationView = binding.navView
    val navController = findNavController(R.id.nav_host_fragment_content_launch)
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.nav_feed,
        R.id.nav_my_feed,
        R.id.nav_auth
      ), drawerLayout
    )
    setupActionBarWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)

    authViewModel.user.observe({ lifecycle }) {
      updateMenu(it)
      navController.navigateUp()
    }
  }

  private fun updateMenu(user: User?) {
    when (user) {
      is User -> {
        binding.navView.menu.clear()
        binding.navView.inflateMenu(R.menu.menu_main_user_drawer)
      }
      else -> {}
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.main, menu)
    return true
  }

  override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_launch)
    return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
  }
}