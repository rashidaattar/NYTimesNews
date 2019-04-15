package com.demo.nytimesnews.feature.news.list.adapter;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.nytimesnews.base.presentation.BaseAdapter;
import com.demo.nytimesnews.databinding.ItemNewsListBinding;
import com.demo.nytimesnews.feature.news.NewsViewModel;
import com.demo.nytimesnews.remote.model.Media;
import com.demo.nytimesnews.remote.model.MediaMetadata;
import com.demo.nytimesnews.remote.model.Results;


/**
 * Created by Rashida on 4/11/19.
 */
public class NewsListAdapter extends BaseAdapter<Results, NewsListViewHolder> {

    private NewsViewModel newsViewModel;

    public NewsListAdapter(NewsViewModel newsViewModel){
        this.newsViewModel = newsViewModel;
    }

    @NonNull
    @Override
    public NewsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewsListViewHolder
                (ItemNewsListBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListViewHolder newsListViewHolder, int i) {
        newsListViewHolder.bindData(list.get(i),newsViewModel);
    }

    @BindingAdapter("thumbnail")
    public static void setThumbnail(ImageView thumbnail, Media media) {
        for (MediaMetadata mediaMetadata : media.getMediaMetadataList()) {
            if (mediaMetadata.getFormat().equalsIgnoreCase("Standard Thumbnail")) {
                Glide.with(thumbnail.getContext()).load(mediaMetadata.getUrl()).into(thumbnail);
            }
        }
    }
}
