package com.demo.nytimesnews.feature.news;

import android.app.Application;
import android.support.annotation.NonNull;

import com.demo.nytimesnews.base.model.BaseResponse;
import com.demo.nytimesnews.base.utils.SchedulerProvider;
import com.demo.nytimesnews.base.viewmodel.BaseViewModel;
import com.demo.nytimesnews.base.viewmodel.SingleLiveEvent;
import com.demo.nytimesnews.remote.NewsAPI;


/**
 * Created by Rashida on 4/9/19.
 */
public class NewsViewModel extends BaseViewModel {

    private NewsAPI newsAPI;
    private SchedulerProvider schedulerProvider;

    private SingleLiveEvent<BaseResponse<String>> newsData = new SingleLiveEvent<>();
    private SingleLiveEvent<Integer> error = new SingleLiveEvent<>();

    public SingleLiveEvent<BaseResponse<String>> getNewsData() {
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
        execute(schedulerProvider,newsAPI.getNews(), newsData, error);
    }
}
