package com.demo.nytimesnews.di.module;

import com.demo.nytimesnews.di.qualifier.RetrofitQualifier;
import com.demo.nytimesnews.di.scope.ApplicationScope;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rashida on 4/9/19.
 */
@Module
public class NetworkModule {


    private static final int READ_TIMEOUT = 30;
    private static final int CONNECT_TIMEOUT = 15;


    /**
     * this method will build an okhttp
     *
     * @return
     */
    @Provides
    public OkHttpClient okhttpClientBuilder() {
        return new OkHttpClient.Builder()
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS).build();
    }

    @Provides
    @ApplicationScope
    @RetrofitQualifier
    public Retrofit retrofitNews(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://api.nytimes.com/svc/mostpopular/v2/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
