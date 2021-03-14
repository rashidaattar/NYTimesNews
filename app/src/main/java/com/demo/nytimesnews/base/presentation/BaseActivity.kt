package com.demo.nytimesnews.base.presentation

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Rashida on 4/8/19.
 */
abstract class BaseActivity<B : ViewDataBinding?> : AppCompatActivity() {

    protected var binding: B? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //init data binding
        binding = DataBindingUtil.setContentView<B>(this, layout)
        initViews()
    }

    protected abstract fun initViews()
    abstract val layout: Int
}