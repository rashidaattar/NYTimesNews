package com.demo.nytimesnews.feature.news.list.adapter

import android.databinding.BindingAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.demo.nytimesnews.base.presentation.BaseAdapter
import com.demo.nytimesnews.databinding.ItemNewsListBinding
import com.demo.nytimesnews.feature.news.NewsViewModel
import com.demo.nytimesnews.remote.model.Media
import com.demo.nytimesnews.remote.model.Results

/**
 * Created by Rashida on 4/11/19.
 */
class NewsListAdapter(private val newsViewModel: NewsViewModel) :
    BaseAdapter<Results?, NewsListViewHolder?>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): NewsListViewHolder {
        return NewsListViewHolder(
            ItemNewsListBinding.inflate(
                LayoutInflater.from(viewGroup.context), viewGroup, false
            )
        )
    }

    override fun onBindViewHolder(newsListViewHolder: NewsListViewHolder, i: Int) {
        newsListViewHolder.bindData(list?.get(i), newsViewModel)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("thumbnail")
        fun setThumbnail(thumbnail: ImageView, media: Media) {
            media.mediaMetadataList.filter { mediaMetadata -> mediaMetadata.format.equals("Standard Thumbnail", ignoreCase = true) }
                .firstOrNull()?.let {
                    Glide.with(thumbnail.context).load(it.url).into(thumbnail)
                }
        }
    }
}