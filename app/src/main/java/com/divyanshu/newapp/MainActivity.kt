package com.divyanshu.newapp

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
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

  companion object {
    const val PREFS_AUTH = " prefs_auth"
    const val PREFS__KEY_TOKEN = " prefs_key_token"
  }

  private lateinit var authViewModel: AuthViewModel
  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var binding: ActivityMainBinding
  private lateinit var sharedPreferences: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedPreferences = getSharedPreferences(PREFS_AUTH, MODE_PRIVATE)
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

    sharedPreferences.getString(PREFS__KEY_TOKEN, null)?.let {
      authViewModel.getCurrentUser(it)
    }

    authViewModel.user.observe({ lifecycle }) {
      updateMenu(it)
      it?.token?.let {
        sharedPreferences.edit {
          putString(PREFS__KEY_TOKEN, it)
        }
      }
        ?: run {
          sharedPreferences.edit {
            remove(PREFS_AUTH)
          }
        }
      navController.navigateUp()
    }
  }

  private fun updateMenu(user: User?) {
    when (user) {
      is User -> {
        binding.navView.menu.clear()
        binding.navView.inflateMenu(R.menu.menu_main_user_drawer)
      }
      else -> {
        binding.navView.menu.clear()
        binding.navView.inflateMenu(R.menu.menu_main_guest_drawer)
      }
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.action_logout -> {
        authViewModel.logout()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
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