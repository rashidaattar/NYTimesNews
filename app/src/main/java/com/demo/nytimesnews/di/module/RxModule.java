package com.demo.nytimesnews.di.module;

import com.demo.nytimesnews.base.utils.SchedulerProvider;
import com.demo.nytimesnews.di.scope.ApplicationScope;
import com.demo.nytimesnews.remote.AndroidSchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rashida on 4/10/19.
 */

@Module
public class RxModule {
    @Provides
    @ApplicationScope
    SchedulerProvider schedulerProvider() {
        return new AndroidSchedulerProvider();
    }

}

