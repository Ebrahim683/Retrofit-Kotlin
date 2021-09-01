package com.example.retrofitkotlin

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("photos")
    fun getData():Call<List<DataModel>>

}