package com.axellinoanggoro.binar_ch5_retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val  BASE_URL ="https://6254434289f28cf72b5aed04.mockapi.io/"

    val instance : RestfulApi by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RestfulApi::class.java)
    }
}


//object RetrofitClient {
//    const val BASE_URL = "https://6254434289f28cf72b5aed04.mockapi.io/"
//
//    private val logging : HttpLoggingInterceptor
//    get() {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        return httpLoggingInterceptor.apply {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        }
//    }
//
//    private val client = OkHttpClient.Builder()
//        .addInterceptor(logging)
//        .build()
//
//    val instance : ApiService by lazy {
//        val retrofit = Retrofit.Builder().(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(
//            client).build()
//    }
//
//}