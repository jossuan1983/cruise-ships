package com.example.myapplication.services

import com.example.myapplication.model.Ship
import retrofit2.Call
import retrofit2.http.GET

interface ServiceAPI {

    @GET("/SKY")
    fun doGetSkyDetails(): Call<Ship>

    @GET("/BLISS")
    fun doGetBlissDetails(): Call<Ship>

    @GET("/ESCAPE")
    fun doGetEscapeDetails(): Call<Ship>

//    @POST("/api/users")
//    fun createUser(@Body user: User): Call<User>
//
//    @GET("/api/users?")
//    fun doGetUserList(@Query("page") page: String): Call<UserList>
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    fun doCreateUserWithField(@Field("name") name: String, @Field("job") job: String): Call<UserList>
}