package com.axellinoanggoro.binar_ch5_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ActivityUpdateNewsBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.DataNews
import com.axellinoanggoro.binar_ch5_retrofit.viewmodel.NewsViewModel

class UpdateNewsActivity : AppCompatActivity() {

    lateinit var binding : ActivityUpdateNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            var id = intent.getStringExtra("update")
            var title = binding.updateTitle.text.toString()
            var image = binding.updateImage.text.toString()
            var author = binding.updateAuthor.text.toString()
            var desc = binding.updateDescription.text.toString()

            updateDataNews(id!!.toInt(), title, image, author, desc)
        }
    }

    fun updateDataNews(id : Int, title: String, image : String, author : String, desc : String){
        val  viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.calUpdDataNews(id, title, image, author, desc )
        viewModel.putNews().observe(this) {
            if (it != null) {
                Toast.makeText(this, "Data berhasil diupdate", Toast.LENGTH_SHORT).show()
            }
        }
    }
}