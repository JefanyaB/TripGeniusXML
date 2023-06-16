package com.jef.tripgeniusapp.ui.home

import android.content.ContentValues
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jef.tripgeniusapp.adapter.DestinasiAdapter
import com.jef.tripgeniusapp.api.ApiConfig
import com.jef.tripgeniusapp.api.ApiConfigPredict
import com.jef.tripgeniusapp.model.UserPreference
import com.jef.tripgeniusapp.model.request.RegisterRequest
import com.jef.tripgeniusapp.model.response.*
import com.jef.tripgeniusapp.ui.login.LoginViewModel
import com.jef.tripgeniusapp.ui.login.LoginViewModel.Companion.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(private val pref: UserPreference): ViewModel() {

    private val _errorResponse = MutableLiveData<ErrorResponse>()
    val errorResponse: LiveData<ErrorResponse> = _errorResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _listDestinasi = MutableLiveData<DestinasiResponse>()
    val listDestinasi: LiveData<DestinasiResponse> = _listDestinasi

    fun getDestinastion(token : String) {
        _isLoading.value = true
        val client = ApiConfig().getApiService().getDestination( "Bearer $token")
        client.enqueue(object : Callback<DestinasiResponse> {
            override fun onResponse(
                call: Call<DestinasiResponse>,
                response: Response<DestinasiResponse>
            ){
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _listDestinasi.value = response.body()
                    }
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<DestinasiResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(LoginViewModel.TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getUser(): LiveData<Data> {
        return pref.getUser().asLiveData()
    }


}
