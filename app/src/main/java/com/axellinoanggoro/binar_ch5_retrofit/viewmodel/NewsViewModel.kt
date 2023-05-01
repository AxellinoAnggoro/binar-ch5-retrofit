package com.axellinoanggoro.binar_ch5_retrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.axellinoanggoro.binar_ch5_retrofit.model.DataNews
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseAddNews
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import com.axellinoanggoro.binar_ch5_retrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    var liveDataNews : MutableLiveData<List<ResponseDataNewsItem>> = MutableLiveData()
    var postDataNews : MutableLiveData<ResponseAddNews> = MutableLiveData()

    fun postNews() : MutableLiveData<ResponseAddNews>{
        return postDataNews
    }

    fun callApiNews(){
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItem>>{
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful){
                    liveDataNews.postValue(response.body())
                }else{
                    liveDataNews.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                liveDataNews.postValue(null)
            }

        })
    }

    fun addDataNews(title: String, image : String, author : String, desc : String){
        RetrofitClient.instance.postDataNews(DataNews(title, desc, image, author)).enqueue(object : Callback<ResponseAddNews>{
            override fun onResponse(
                call: Call<ResponseAddNews>,
                response: Response<ResponseAddNews>
            ) {
                if (response.isSuccessful){
                    postDataNews.postValue(response.body())
                }else{
                    postDataNews.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseAddNews>, t: Throwable) {
                postDataNews.postValue(null)
            }

        })
    }
}