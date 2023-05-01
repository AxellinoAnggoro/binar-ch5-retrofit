package com.axellinoanggoro.binar_ch5_retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.axellinoanggoro.binar_ch5_retrofit.adapter.NewsAdapter
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ActivityMainBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import com.axellinoanggoro.binar_ch5_retrofit.network.RetrofitClient
import com.axellinoanggoro.binar_ch5_retrofit.viewmodel.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener{
            val move = Intent(this, AddNewsActivity::class.java)
            startActivity(move)
        }
        getDataNews()
    }

    fun getDataNews() {
        RetrofitClient.instance.getAllNews().enqueue(object : Callback<List<ResponseDataNewsItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataNewsItem>>,
                response: Response<List<ResponseDataNewsItem>>
            ) {
                if (response.isSuccessful) {
                    //tanpa viewmodel
//                    binding.rvNews.layoutManager =
//                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
//                        binding.rvNews.adapter = NewsAdapter(response.body()!!)
                    showDataNews()
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

    fun showDataNews(){
        val viewModelNews = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModelNews.callApiNews()
        viewModelNews.liveDataNews.observe(this, Observer {
            if (it != null){
                binding.rvNews.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
                binding.rvNews.adapter = NewsAdapter(it)
            }
        })
    }
}