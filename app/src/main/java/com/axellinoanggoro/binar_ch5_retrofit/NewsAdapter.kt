package com.axellinoanggoro.binar_ch5_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ItemNewsBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataNewsItem
import com.bumptech.glide.Glide

class NewsAdapter(var listNews: List<ResponseDataNewsItem> ) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        var view = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding.titleNews.text = listNews[position].title
        holder.binding.dateNews.text = listNews[position].createdAt
        Glide.with(holder.itemView).load(listNews[position].image).into(holder.binding.imgNews)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}