package com.axellinoanggoro.binar_ch5_retrofit.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axellinoanggoro.binar_ch5_retrofit.UpdateNewsActivity
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ItemNewsBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import com.axellinoanggoro.binar_ch5_retrofit.network.RetrofitClient
import com.bumptech.glide.Glide

class NewsAdapter(var listNews: List<ResponseDataNewsItem> ) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imgNews)

        holder.binding.btnUpdate.setOnClickListener {
            var edit = Intent(it.context, UpdateNewsActivity::class.java)
            edit.putExtra("update", listNews[position].id)
            it.context.startActivity(edit)
        }

//        holder.binding.btnDelete.setOnClickListener {
//            RetrofitClient.instance.deleteNews()
//        }
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}