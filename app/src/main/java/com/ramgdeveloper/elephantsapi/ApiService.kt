package com.ramgdeveloper.elephantsapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("elephants/")
    fun getElephants(): Call<Elephants>
}

object ElephantsApi{
    const val BASE_URL = "https://elephant-api.herokuapp.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

