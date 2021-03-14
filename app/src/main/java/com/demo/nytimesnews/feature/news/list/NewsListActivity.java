package com.demo.nytimesnews.feature.news.list;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.demo.nytimesnews.NYTimesNews;
import com.demo.nytimesnews.R;
import com.demo.nytimesnews.base.presentation.BaseActivity;
import com.demo.nytimesnews.databinding.ActivityNewsListBinding;
import com.demo.nytimesnews.feature.news.NewsViewModel;
import com.demo.nytimesnews.feature.news.detail.NewsDetailActivity;
import com.demo.nytimesnews.feature.news.list.adapter.NewsListAdapter;

import javax.inject.Inject;

import timber.log.Timber;

public class NewsListActivity extends BaseActivity<ActivityNewsListBinding> {

    @Inject
    NewsViewModel newsViewModel;

    @Inject
    NewsListAdapter newsListAdapter;

    @Override
    protected void initViews() {
        NYTimesNews.get().getMainAppComponent().inject(this);
        binding.newsListView.setAdapter(newsListAdapter);
        getSupportActionBar().setTitle("NY TIMES NEWS");
        binding.progressBar.setVisibility(View.VISIBLE);
        newsViewModel.getNews();
        observeData();
    }

    private void observeData() {

        newsViewModel.getNewsData().observe(this, response -> {
            Timber.d("response " + response.getStatus());
            if (response.getStatus().equalsIgnoreCase("OK")) {
                binding.progressBar.setVisibility(View.GONE);
                newsListAdapter.setData(response.getResultsList());
            }
        });

        newsViewModel.getError().observe(this, integer -> {
                    Timber.d("error" + integer);
                    binding.progressBar.setVisibility(View.GONE);
                }
        );

        newsViewModel.getGoToDetailsLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean goToDetails) {

                if (goToDetails) {
                    Intent intent = new Intent(NewsListActivity.this,NewsDetailActivity.class);
                    intent.putExtra("URL",newsViewModel.getSelectedNewsItem().getUrl());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_news_list;
    }
}
