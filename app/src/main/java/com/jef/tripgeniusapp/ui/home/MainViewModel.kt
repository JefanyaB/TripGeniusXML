package com.jef.tripgeniusapp.ui.home

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.*
import com.jef.tripgeniusapp.api.ApiConfig
import com.jef.tripgeniusapp.model.UserPreference
import com.jef.tripgeniusapp.model.response.Data
import com.jef.tripgeniusapp.model.response.DestinasiResponse
import com.jef.tripgeniusapp.model.response.ErrorResponse
import com.jef.tripgeniusapp.ui.login.LoginViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val pref: UserPreference): ViewModel() {

    private val _errorResponse = MutableLiveData<ErrorResponse>()
    val errorResponse: LiveData<ErrorResponse> = _errorResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun getUser(): LiveData<Data> {
        return pref.getUser().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }
}