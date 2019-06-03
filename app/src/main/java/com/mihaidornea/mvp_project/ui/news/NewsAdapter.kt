package com.mihaidornea.mvp_project.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mcxiaoke.koi.ext.onClick
import com.mihaidornea.mvp_project.R
import com.mihaidornea.mvp_project.models.article.Article
import kotlinx.android.synthetic.main.news_article_item.view.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    private var news = mutableListOf<Article>()
    var callback: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_article_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount() = news.size


    fun updateData(newNews: List<Article>) {
        news.clear()
        news.addAll(newNews)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bindData(position)
    }


    inner class ArticleViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(position: Int) {
            view.rvi_article_tv_title.text = news[position].title
            Glide.with(view)
                .load(news[position].urlToImage)
                .into(view.rvi_article_iv_image)
            view.onClick {
                callback.invoke(position)
            }
        }
    }

}