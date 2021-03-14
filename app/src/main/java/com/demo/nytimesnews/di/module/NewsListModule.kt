package com.demo.nytimesnews.di.module

import android.app.Application
import com.demo.nytimesnews.di.qualifier.RetrofitQualifier
import com.demo.nytimesnews.di.scope.FeatureScope
import com.demo.nytimesnews.feature.news.NewsViewModel
import com.demo.nytimesnews.feature.news.list.adapter.NewsListAdapter
import com.demo.nytimesnews.remote.api.NewsAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Rashida on 4/10/19.
 */
@Module
class NewsListModule {
    @Provides
    fun newsAPI(@RetrofitQualifier retrofit: Retrofit): NewsAPI {
        return retrofit.create(NewsAPI::class.java)
    }

    @Provides
    @FeatureScope
    fun newsViewModel(application: Application?, newsAPI: NewsAPI?): NewsViewModel {
        return NewsViewModel(application!!, newsAPI!!)
    }

    @Provides
    fun newsListAdapter(newsViewModel: NewsViewModel?): NewsListAdapter {
        return NewsListAdapter(newsViewModel!!)
    }
}