package com.example.newsapp.adapter

import Articles
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.squareup.picasso.Picasso
import java.util.ArrayList

class NewsListAdapter(
    private val articleList: ArrayList<Articles>,
    val onItemClick: (Articles) -> Unit
) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(articles: Articles) {
            val imgNews = itemView.findViewById(R.id.imgNewsPhoto) as ImageView
            val txtHeader = itemView.findViewById(R.id.txtNewsHeader) as TextView
            val txtSubHeader = itemView.findViewById(R.id.txtSubHeader) as TextView

            txtHeader.text = articles.excerpt
            txtSubHeader.text = articles.summary
            Picasso.get().load(articles.media).into(imgNews)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(articleList[position])
        holder.itemView.setOnClickListener {
            val article: Articles = articleList[position]
            onItemClick(article)
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}