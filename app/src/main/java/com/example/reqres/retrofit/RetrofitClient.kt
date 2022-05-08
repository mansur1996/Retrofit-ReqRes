package com.example.reqres.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val IS_TESTER = true
    private const val SERVER_DEVELOPMENT = "https://reqres.in/api/"
    private const val SERVER_PRODUCTION = ""

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(server())
            .build()
    }

    private fun server(): String {
        if (IS_TESTER)
            return SERVER_DEVELOPMENT
        return SERVER_PRODUCTION
    }

    val retrofitService : RetrofitService = getRetrofit().create(RetrofitService::class.java)
}