package com.jef.tripgeniusapp.api


import com.jef.tripgeniusapp.model.request.LoginRequest
import com.jef.tripgeniusapp.model.request.RegisterRequest
import com.jef.tripgeniusapp.model.response.DestinasiResponse
import com.jef.tripgeniusapp.model.response.LoginResponse
import com.jef.tripgeniusapp.model.response.RegisterResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("/v1/auth/register")
    fun postRegister(
        @Body request: RegisterRequest,
    ): Call<RegisterResponse>

    @POST("/v1/auth/login")
    fun postLogin(
        @Body request: LoginRequest,
    ): Call<LoginResponse>

    @GET("/v1/data/destination/{id}")
    fun getDestination(
        @Path("id") id:Int,
        @Header("Authorization")token:String
    ):Call<DestinasiResponse>

    @GET("/search/users")
    fun getUsers(
        @Query("age") age: String,
        @Header("Authorization") token: String
    ):  Call<LoginResponse>
}