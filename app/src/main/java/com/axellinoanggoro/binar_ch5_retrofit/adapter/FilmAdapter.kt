package com.axellinoanggoro.binar_ch5_retrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axellinoanggoro.binar_ch5_retrofit.databinding.ItemFilmBinding
import com.axellinoanggoro.binar_ch5_retrofit.model.ResponseDataFilmItem
import com.bumptech.glide.Glide

class FilmAdapter(var listFilm:List<ResponseDataFilmItem>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.titleFilm.text = listFilm[position].name
        holder.binding.dateFilm.text = listFilm[position].date
        Glide.with(holder.itemView).load(listFilm[position].image).into(holder.binding.imgFilm)
    }

    override fun getItemCount(): Int {
        return listFilm.size
    }
}