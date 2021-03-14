package com.demo.nytimesnews.di.module

import com.demo.nytimesnews.di.qualifier.RetrofitQualifier
import com.demo.nytimesnews.di.scope.FeatureScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Rashida on 4/9/19.
 */
@Module
class NetworkModule {
    /**
     * this method will build an okhttp
     *
     * @return
     */
    @Provides
    fun okhttpClientBuilder(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS).build()
    }

    @Provides
    @FeatureScope
    @RetrofitQualifier
    fun retrofitNews(okHttpClient: OkHttpClient?): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    companion object {
        private const val READ_TIMEOUT = 30
        private const val CONNECT_TIMEOUT = 15
    }
}