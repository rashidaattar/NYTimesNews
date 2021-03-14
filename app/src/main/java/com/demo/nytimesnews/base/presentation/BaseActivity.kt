package com.demo.nytimesnews.base.presentation;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rashida on 4/8/19.
 */
public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B binding;
    public String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        //init data binding
        binding = DataBindingUtil.setContentView(this, getLayout());
        initViews();
    }

    protected abstract void initViews();

    public abstract int getLayout();
}
