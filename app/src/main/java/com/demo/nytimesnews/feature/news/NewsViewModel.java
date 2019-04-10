package com.demo.nytimesnews.feature.news;

import android.app.Application;
import android.support.annotation.NonNull;

import com.demo.nytimesnews.base.utils.SchedulerProvider;
import com.demo.nytimesnews.base.viewmodel.BaseViewModel;
import com.demo.nytimesnews.base.viewmodel.SingleLiveEvent;
import com.demo.nytimesnews.remote.api.NewsAPI;
import com.demo.nytimesnews.remote.model.NewsList;

import timber.log.Timber;


/**
 * Created by Rashida on 4/9/19.
 */
public class NewsViewModel extends BaseViewModel {

    private NewsAPI newsAPI;
    private SchedulerProvider schedulerProvider;

    private SingleLiveEvent<NewsList> newsData = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> error = new SingleLiveEvent<>();

    public SingleLiveEvent<NewsList> getNewsData() {
        return newsData;
    }

    public SingleLiveEvent<Integer> getError() {
        return error;
    }

    public NewsViewModel(@NonNull Application application, SchedulerProvider schedulerProvider, NewsAPI newsAPI) {
        super(application);
        this.schedulerProvider = schedulerProvider;
        this.newsAPI = newsAPI;
    }


    public void getNews() {
        execute(schedulerProvider, newsAPI.getNews(), newsList -> {
            Timber.d("result size :" + newsList.getNumResults());
            newsData.postValue(newsList);
        }, error);
    }
}
