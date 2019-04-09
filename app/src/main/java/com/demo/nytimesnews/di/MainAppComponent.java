package com.demo.nytimesnews.di;

import com.demo.nytimesnews.NYTimesNews;
import com.demo.nytimesnews.di.module.ContextModule;
import com.demo.nytimesnews.di.module.NetworkModule;
import com.demo.nytimesnews.di.scope.ApplicationScope;

import dagger.Component;

/**
 * Created by Rashida on 4/9/19.
 */

@ApplicationScope
@Component(modules = {
        ContextModule.class,
        NetworkModule.class
})
public interface MainAppComponent {
}
