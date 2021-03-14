package com.demo.nytimesnews.base.presentation;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Rashida on 4/8/19.
 */
public abstract class BaseAdapter<T,E extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<E> {

    protected List<T> list;

    public void setData(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (list != null && !list.isEmpty())
            return list.size();
        else
            return 0;
    }
}