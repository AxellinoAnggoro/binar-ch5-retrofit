package com.axellinoanggoro.binar_ch5_retrofit.network

import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>
}