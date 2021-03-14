package com.demo.nytimesnews;

import android.app.Application;

import com.demo.nytimesnews.di.DaggerMainAppComponent;
import com.demo.nytimesnews.di.MainAppComponent;
import com.demo.nytimesnews.di.module.ContextModule;
import com.demo.nytimesnews.di.module.NetworkModule;

import timber.log.Timber;


/**
 * Created by Rashida on 4/9/19.
 */
public class NYTimesNews extends Application {


    private static NYTimesNews nyTimesNews;

    public static NYTimesNews get() {
        return nyTimesNews;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        nyTimesNews = this;
        initTimber();
    }


    public static void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
