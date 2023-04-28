package com.axellinoanggoro.binar_ch5_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ActivityMainBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import com.axellinoanggoro.binar_ch5_retrofit.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataNews()
    }

    fun getDataNews() {
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful) {
                    binding.rvNews.layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        binding.rvNews.adapter = NewsAdapter(response.body()!!)
                } else {
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }

        })
    }
}