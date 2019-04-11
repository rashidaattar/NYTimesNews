package com.demo.nytimesnews.feature.news.presentation.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.nytimesnews.base.presentation.BaseAdapter;
import com.demo.nytimesnews.databinding.ItemNewsListBinding;
import com.demo.nytimesnews.remote.model.Results;


/**
 * Created by Rashida on 4/11/19.
 */
public class NewsListAdapter extends BaseAdapter<Results, NewsListViewHolder> {

    @NonNull
    @Override
    public NewsListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NewsListViewHolder
                (ItemNewsListBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListViewHolder newsListViewHolder, int i) {

    }
}
