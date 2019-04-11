package com.demo.nytimesnews.feature.news.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.nytimesnews.databinding.ItemNewsListBinding;
import com.demo.nytimesnews.remote.model.Results;


/**
 * Created by Rashida on 4/11/19.
 */
public class NewsListViewHolder extends RecyclerView.ViewHolder {

    public final ItemNewsListBinding itemNewsListBinding;

    public NewsListViewHolder(ItemNewsListBinding itemNewsListBinding) {
        super(itemNewsListBinding.getRoot());
        this.itemNewsListBinding = itemNewsListBinding;
    }

    public void bindData(Results results){

    }
}
