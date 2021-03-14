package com.demo.nytimesnews.di.module;

import android.app.Application;
import android.content.Context;

import com.demo.nytimesnews.di.scope.FeatureScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rashida on 4/9/19.
 */

@Module
public class ContextModule {

    private final Context context;
    private final Application application;

    public ContextModule(Application application) {
        this.application = application;
        this.context = application.getApplicationContext();
    }

    @Provides
    @FeatureScope
    public Context context() {
        return context;
    }


    @Provides
    @FeatureScope
    public Application getApplication() {
        return application;
    }
}
