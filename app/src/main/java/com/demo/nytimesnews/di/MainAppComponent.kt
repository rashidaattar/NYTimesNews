package com.demo.nytimesnews.di;

import com.demo.nytimesnews.di.module.ContextModule;
import com.demo.nytimesnews.di.module.NetworkModule;
import com.demo.nytimesnews.di.module.NewsListModule;
import com.demo.nytimesnews.di.scope.FeatureScope;
import com.demo.nytimesnews.feature.news.list.NewsListActivity;

import dagger.Component;

/**
 * Created by Rashida on 4/9/19.
 */

@FeatureScope
@Component(modules = {
        ContextModule.class,
        NetworkModule.class,
        NewsListModule.class
})
public interface MainAppComponent {

    void inject(NewsListActivity newsListActivity);

}
