package com.demo.nytimesnews.feature.news.presentation.list;

import com.demo.nytimesnews.NYTimesNews;
import com.demo.nytimesnews.R;
import com.demo.nytimesnews.base.presentation.BaseActivity;
import com.demo.nytimesnews.databinding.ActivityNewsListBinding;
import com.demo.nytimesnews.feature.news.NewsViewModel;

import javax.inject.Inject;

import timber.log.Timber;

public class NewsListActivity extends BaseActivity<ActivityNewsListBinding> {

    @Inject
    NewsViewModel newsViewModel;

    @Override
    protected void initViews() {
        //do something

        NYTimesNews.get().getMainAppComponent().inject(this);
        newsViewModel.getNews();
        observeData();
    }

    private void observeData() {

        newsViewModel.getNewsData().observe(this, response -> Timber.d("response " + response.getStatus()));

        newsViewModel.getError().observe(this, integer -> Timber.d("error"+integer));
    }

    @Override
    public int getLayout() {
        return R.layout.activity_news_list;
    }
}
