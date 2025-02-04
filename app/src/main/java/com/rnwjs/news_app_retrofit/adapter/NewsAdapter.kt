package com.rnwjs.news_app_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.rnwjs.news_app_retrofit.R
import com.rnwjs.news_app_retrofit.databinding.NewsItemBinding
import com.rnwjs.news_app_retrofit.models.ArticlesItem

class NewsAdapter(val newsList: List<ArticlesItem?>?) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding: NewsItemBinding = NewsItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsList?.size ?: 0
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.binding.titleId.text = newsList?.get(position)?.title ?: ""
        holder.binding.descId.text = newsList?.get(position)?.description ?: ""

        if(newsList?.get(position)?.urlToImage !=null) {
            Glide.with(holder.itemView.context).load(newsList[position]?.urlToImage)
                .into(holder.binding.image)
        }
    }
}