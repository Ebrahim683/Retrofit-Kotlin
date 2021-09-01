package com.example.retrofitkotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiController{
    val getInstants:Api
    init {
val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
        getInstants = retrofit.create(Api::class.java)
    }
}

