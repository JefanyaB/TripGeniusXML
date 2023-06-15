package com.jef.tripgeniusapp.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jef.tripgeniusapp.R
import com.jef.tripgeniusapp.ViewModelFactory
import com.jef.tripgeniusapp.databinding.ActivityMainBinding
import com.jef.tripgeniusapp.model.UserPreference
import com.jef.tripgeniusapp.ui.login.LoginActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_option,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu1 ->{
                finishAffinity()
            }
            R.id.menu2 ->{
                mainViewModel.logout()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[MainViewModel::class.java]
        mainViewModel.getUser().observe(this) { user ->
            if (user.accessToken.isNotEmpty()) {
                mainViewModel.getStory(user.accessToken)
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }
    }



    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}