package com.example.newsapp.adapter

import Article
import android.media.Image
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
    private val articleList: ArrayList<Article>,
    private val resource: Int,
    val onItemClick: ((Article) -> Unit)?,
    val onFavItemClick: ((Article) -> Unit)?
) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgNews = itemView.findViewById(R.id.imgNewsPhoto) as ImageView
        val txtHeader = itemView.findViewById(R.id.txtNewsHeader) as TextView
        val txtSubHeader = itemView.findViewById(R.id.txtSubHeader) as TextView
        val imgFav = itemView.findViewById(R.id.imgFavorite) as ImageView
        fun bindItems(articles: Article) {
            txtHeader.text = articles.title
            txtSubHeader.text = articles.excerpt
            Picasso.get().load(articles.media).into(imgNews)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(resource, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(articleList[position])
        holder.itemView.setOnClickListener {
            val article: Article = articleList[position]
            onItemClick?.let { it1 -> it1(article) }
        }

        holder.imgFav.setOnClickListener {
            val article: Article = articleList[position]
            onFavItemClick?.let { it1 -> it1(article) }
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}