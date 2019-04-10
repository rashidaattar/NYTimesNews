package com.demo.nytimesnews.di.module;

import android.app.Application;

import com.demo.nytimesnews.base.utils.SchedulerProvider;
import com.demo.nytimesnews.di.qualifier.RetrofitQualifier;
import com.demo.nytimesnews.di.scope.ApplicationScope;
import com.demo.nytimesnews.feature.news.NewsViewModel;
import com.demo.nytimesnews.remote.NewsAPI;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Rashida on 4/10/19.
 */

@Module
public class NewsListModule {

    @Provides
    @ApplicationScope
    NewsAPI newsAPI(@RetrofitQualifier Retrofit retrofit) {
        return retrofit.create(NewsAPI.class);
    }

    @Provides
    @ApplicationScope
    NewsViewModel newsViewModel(Application application, SchedulerProvider schedulerProvider, NewsAPI newsAPI) {
        return new NewsViewModel(application, schedulerProvider, newsAPI);
    }

}
