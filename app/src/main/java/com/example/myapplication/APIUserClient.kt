package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface APIUserClient{
    @POST("/user/login/")
    fun login(@Body user:User): Call<User>

    @GET("/user/")
    fun getUsers(@Query("name") nombre: String): Call<List<User>>

    @POST("/user/login/")
    fun getMessages(@Body user:User): Call<User>
}
