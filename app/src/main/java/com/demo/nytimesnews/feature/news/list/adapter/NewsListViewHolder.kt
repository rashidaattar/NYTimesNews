package com.demo.nytimesnews.feature.news.list.adapter

import android.support.v7.widget.RecyclerView
import com.demo.nytimesnews.databinding.ItemNewsListBinding
import com.demo.nytimesnews.feature.news.NewsViewModel
import com.demo.nytimesnews.remote.model.Results

/**
 * Created by Rashida on 4/11/19.
 */
class NewsListViewHolder(private val itemNewsListBinding: ItemNewsListBinding) : RecyclerView.ViewHolder(
    itemNewsListBinding.root
) {
    fun bindData(results: Results?, newsViewModel: NewsViewModel?) {
        itemNewsListBinding.viewModel = newsViewModel
        itemNewsListBinding.model = results
        itemNewsListBinding.executePendingBindings()
    }
}