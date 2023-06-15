package com.jef.tripgeniusapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jef.tripgeniusapp.model.UserPreference
import com.jef.tripgeniusapp.ui.home.MainViewModel
import com.jef.tripgeniusapp.ui.login.LoginViewModel
import com.jef.tripgeniusapp.ui.registrasi.RegisterViewModel

class ViewModelFactory(private val pref: UserPreference) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(pref) as T
            }
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(pref) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}