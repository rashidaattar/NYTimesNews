package com.demo.nytimesnews;

import android.app.Application;

import com.demo.nytimesnews.di.DaggerMainAppComponent;
import com.demo.nytimesnews.di.MainAppComponent;
import com.demo.nytimesnews.di.module.ContextModule;
import com.demo.nytimesnews.di.module.NetworkModule;


/**
 * Created by Rashida on 4/9/19.
 */
public class NYTimesNews extends Application {


    MainAppComponent mainAppComponent;
    private static NYTimesNews nyTimesNews;

    public static NYTimesNews get() {
        return nyTimesNews;
    }

    public  MainAppComponent getMainAppComponent() {
        return mainAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nyTimesNews = this;
        mainAppComponent = DaggerMainAppComponent.builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule()).build();
    }
}
