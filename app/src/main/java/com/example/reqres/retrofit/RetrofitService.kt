package com.example.reqres.retrofit

import com.example.reqres.model.create.ReqUser
import com.example.reqres.model.create.ResUser
import com.example.reqres.model.list_users.UserResponse
import com.example.reqres.model.single_user.SingleUserResponse
import com.example.reqres.model.update.ResUpdateUser
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("users")
    fun getUsers() : Call<UserResponse>

    @GET("users")
    fun getUsersByDelay(@Query("delay") delay : Int) : Call<UserResponse>

    @GET("users/{id}")
    fun getSingleUser(@Path("id") id : Int) : Call<SingleUserResponse>

    @POST("users")
    fun createUser(@Body reqUser: ReqUser) : Call<ResUser>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id : Int, @Body reqUser: ReqUser) : Call<ResUpdateUser>
//    the same with ---@PUT---
//    @PATCH("users/{id}")
//    fun updateUser(@Path("id") id : Int, @Body reqUser: ReqUser) : Call<ResUpdateUser>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id : Int) : Call<ResponseBody>


    @GET("users/{id}")
    fun getUsersByIdAndDelay(@Path("id") id : Int, @Query("delay") delay : Int) : Call<SingleUserResponse>

}