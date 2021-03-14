package com.demo.nytimesnews.di;

import android.app.Application;

import com.demo.nytimesnews.base.utils.SchedulerProvider;
import com.demo.nytimesnews.di.module.ContextModule;
import com.demo.nytimesnews.di.module.NetworkModule;
import com.demo.nytimesnews.di.module.NewsListModule;
import com.demo.nytimesnews.di.module.RxModule;
import com.demo.nytimesnews.di.qualifier.RetrofitQualifier;
import com.demo.nytimesnews.di.scope.ApplicationScope;
import com.demo.nytimesnews.feature.news.detail.NewsDetailActivity;
import com.demo.nytimesnews.feature.news.list.NewsListActivity;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Rashida on 4/9/19.
 */

@ApplicationScope
@Component(modules = {
        ContextModule.class,
        NetworkModule.class,
        RxModule.class,
        NewsListModule.class
})
public interface MainAppComponent {

    Application getApplication();

    SchedulerProvider getSchedulerProvider();

    @RetrofitQualifier
    Retrofit retrofitNews();

    void inject(NewsListActivity newsListActivity);

}
