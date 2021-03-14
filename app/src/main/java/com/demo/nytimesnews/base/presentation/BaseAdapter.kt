package com.demo.nytimesnews.base.presentation

import android.support.v7.widget.RecyclerView

/**
 * Created by Rashida on 4/8/19.
 */
abstract class BaseAdapter<T, E : RecyclerView.ViewHolder?> : RecyclerView.Adapter<E>() {
    protected var list: List<T>? = null
    fun setData(list: List<T>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}