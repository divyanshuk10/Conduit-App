package com.divyanshu.newapp.ui.feed

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.divyanshu.api.models.entity.Article
import com.divyanshu.newapp.R
import com.divyanshu.newapp.databinding.ListItemArticlesBinding

class ArticleFeedAdapter : ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
  object : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
      return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
      return oldItem.toString() == newItem.toString()
    }
  }
) {

  inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

  @RequiresApi(Build.VERSION_CODES.M)
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
    return ArticleViewHolder(
      parent.context.getSystemService(LayoutInflater::class.java)
        .inflate(R.layout.list_item_articles, parent, false)
    )
  }

  override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
    ListItemArticlesBinding.bind(holder.itemView).apply {
      val article = getItem(position)
      authorTextView.text = article.author.username
      titleTextView.text = article.title
      descriptionTextView.text = article.body
      dateTextView.text = "January 26, 2022"
      avatarImageView.background = ColorDrawable(Color.MAGENTA)
    }
  }


}