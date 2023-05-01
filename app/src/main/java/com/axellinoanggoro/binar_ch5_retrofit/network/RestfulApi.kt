package com.axellinoanggoro.binar_ch5_retrofit.network

import com.axellinoanggoro.binar_ch5_retrofit.model.DataNews
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseAddNews
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulApi {
    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>

    @POST("news")
    fun postDataNews(@Body request : DataNews) : Call<ResponseAddNews>
}