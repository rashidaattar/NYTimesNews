package com.demo.nytimesnews.di;

import android.app.Application;

import com.demo.nytimesnews.base.utils.SchedulerProvider;
import com.demo.nytimesnews.di.module.ContextModule;
import com.demo.nytimesnews.di.module.NetworkModule;
import com.demo.nytimesnews.di.module.NewsListModule;
import com.demo.nytimesnews.di.module.RxModule;
import com.demo.nytimesnews.di.scope.ApplicationScope;
import com.demo.nytimesnews.feature.news.presentation.NewsListActivity;

import dagger.Component;

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

    void inject(NewsListActivity newsListActivity);
}
