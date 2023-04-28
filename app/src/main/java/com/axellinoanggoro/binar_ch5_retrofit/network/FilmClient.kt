package com.axellinoanggoro.binar_ch5_retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FilmClient {
    const val  BASE_URL ="https://6254434289f28cf72b5aed04.mockapi.io/"

    val instanceFilm : FilmApi by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(FilmApi::class.java)
    }
}