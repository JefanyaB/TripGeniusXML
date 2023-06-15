package com.jef.tripgeniusapp.api

import com.jef.tripgeniusapp.model.request.RegisterRequest
import com.jef.tripgeniusapp.model.response.DestinasiResponse
import com.jef.tripgeniusapp.model.response.RegisterResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServicePredict {

    @GET("/predict/")
    fun getPredict(
        @Query("user_age")user_age:String
    ):Call<>
}