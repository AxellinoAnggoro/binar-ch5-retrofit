package com.axellinoanggoro.binar_ch5_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.axellinoanggoro.binar_ch5_retrofit.adapter.FilmAdapter
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ActivityFilmBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataFilmItem
import com.axellinoanggoro.binar_ch5_retrofit.network.FilmClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmActivity : AppCompatActivity() {

    lateinit var binding: ActivityFilmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilmBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getDataFilm()
    }

    fun getDataFilm() {
        FilmClient.instanceFilm.getAllFilm().enqueue(object : Callback<List<ResponseDataFilmItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataFilmItem>>,
                response: Response<List<ResponseDataFilmItem>>
            ) {
                if (response.isSuccessful) {
                    binding.rvFilms.layoutManager =
                        LinearLayoutManager(this@FilmActivity, LinearLayoutManager.VERTICAL, false)
                    binding.rvFilms.adapter = FilmAdapter(response.body()!!)
                }else{
                    Toast.makeText(this@FilmActivity, "fail to load data", Toast.LENGTH_SHORT).show()
                }
            }


            override fun onFailure(call: Call<List<ResponseDataFilmItem>>, t: Throwable) {
                Toast.makeText(this@FilmActivity, "fail", Toast.LENGTH_SHORT).show()
            }

        })
    }
}