package com.demo.nytimesnews.base.presentation;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Rashida on 4/8/19.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected List<T> list;

    public void setData(List<T> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        if (list != null && !list.isEmpty())
            return list.size();
        else
            return 0;
    }
}
