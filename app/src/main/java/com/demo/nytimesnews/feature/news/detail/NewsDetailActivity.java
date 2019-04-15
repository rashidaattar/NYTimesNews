package com.demo.nytimesnews.feature.news.detail;

import android.view.MenuItem;

import com.demo.nytimesnews.NYTimesNews;
import com.demo.nytimesnews.R;
import com.demo.nytimesnews.base.presentation.BaseActivity;
import com.demo.nytimesnews.databinding.ActivityNewsDetailBinding;
import com.demo.nytimesnews.feature.news.NewsViewModel;

import javax.inject.Inject;


/**
 * Created by Rashida on 4/14/19.
 */
public class NewsDetailActivity extends BaseActivity<ActivityNewsDetailBinding> {

    @Inject
    NewsViewModel newsViewModel;

    @Override
    protected void initViews() {
        NYTimesNews.get().getMainAppComponent().inject(this);
        binding.setModel(newsViewModel.getSelectedNewsItem());
        binding.urlWebview.loadUrl(newsViewModel.getSelectedNewsItem().getUrl());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_news_detail;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
