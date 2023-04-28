package com.axellinoanggoro.binar_ch5_retrofit.network

import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataFilmItem
import retrofit2.Call
import retrofit2.http.GET

interface FilmApi {
    @GET("film")
    fun getAllFilm(): Call<List<ResponseDataFilmItem>>
}