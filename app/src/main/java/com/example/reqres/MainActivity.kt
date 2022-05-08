package com.example.reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.reqres.databinding.ActivityMainBinding
import com.example.reqres.model.create.ReqUser
import com.example.reqres.model.create.ResUser
import com.example.reqres.model.list_users.UserResponse
import com.example.reqres.model.single_user.SingleUserResponse
import com.example.reqres.model.update.ResUpdateUser
import com.example.reqres.retrofit.RetrofitClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
//        loadUsers()
        loadUsersByDelay()
//        loadSingleUser()
//        createUser()
//        updateUser()
//        deleteUser()

    }

    private fun loadUsersByDelay() {
        RetrofitClient.retrofitService.getUsersByDelay(3).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body()}")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }
        })
    }

    private fun deleteUser() {
        RetrofitClient.retrofitService.deleteUser(1).enqueue(object : Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

            }
        })
    }

    private fun updateUser() {
        val reqUser = ReqUser("Android Developer", "Mansur Mirzayev")
        RetrofitClient.retrofitService.updateUser(1,reqUser).enqueue(object : Callback<ResUpdateUser>{
            override fun onResponse(call: Call<ResUpdateUser>, response: Response<ResUpdateUser>) {
                if(response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body() }")
                }
            }

            override fun onFailure(call: Call<ResUpdateUser>, t: Throwable) {

            }
        })
    }

    private fun createUser(){
        val reqUser = ReqUser("Android Developer", "Mansour Mirza")
        RetrofitClient.retrofitService.createUser(reqUser).enqueue(object : Callback<ResUser>{
            override fun onResponse(call: Call<ResUser>, response: Response<ResUser>) {
                if(response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body() }")
                }
            }

            override fun onFailure(call: Call<ResUser>, t: Throwable) {

            }
        })
    }

    private fun loadSingleUser() {
        RetrofitClient.retrofitService.getSingleUser(2).enqueue(object : Callback<SingleUserResponse>{
            override fun onResponse(
                call: Call<SingleUserResponse>,
                response: Response<SingleUserResponse>
            ) {
                Log.d(TAG, "onResponse: ${response.body()?.data}")
            }

            override fun onFailure(call: Call<SingleUserResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun loadUsers(){
        RetrofitClient.retrofitService.getUsers().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful){
                    Log.d(TAG, "onResponse: ${response.body()}")
                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }
    
}