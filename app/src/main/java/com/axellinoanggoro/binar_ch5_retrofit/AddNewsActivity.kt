package com.axellinoanggoro.binar_ch5_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ActivityAddNewsBinding
import com.axellinoanggoro.binar_ch5_retrofit.viewmodel.NewsViewModel

class AddNewsActivity : AppCompatActivity() {

    lateinit var binding : ActivityAddNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val title = binding.addTitle.text.toString()
            val gambar = binding.addImage.text.toString()
            val author = binding.addAuthor.text.toString()
            val desc = binding.addDescription.text.toString()
            addNews(title,gambar,author, desc)
        }
    }

    fun addNews(title : String, image : String, author : String, desc : String){
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.addDataNews(title, image, author, desc)
        viewModel.postNews().observe(this) {
            if (it != null) {
                Toast.makeText(this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
            }
        }

    }
}