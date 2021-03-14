package com.demo.nytimesnews.feature.news

import android.app.Application
import com.demo.nytimesnews.base.viewmodel.BaseViewModel
import com.demo.nytimesnews.base.viewmodel.SingleLiveEvent
import com.demo.nytimesnews.remote.api.NewsAPI
import com.demo.nytimesnews.remote.model.NewsList
import com.demo.nytimesnews.remote.model.Results
import timber.log.Timber

/**
 * Created by Rashida on 4/9/19.
 */
class NewsViewModel(application: Application,
                    private val newsAPI: NewsAPI
) : BaseViewModel(application) {
    val newsData = SingleLiveEvent<NewsList>()
    val error = SingleLiveEvent<Int>()
    val goToDetailsLiveData = SingleLiveEvent<Boolean>()
    var selectedNewsItem: Results? = null

    fun getNews() {
        execute( newsAPI.getNews1(), { newsList: NewsList ->
            Timber.d("result size :" + newsList.numResults)
            newsData.postValue(newsList)
        }, error)
    }

    fun goToDetails(results: Results?) {
        selectedNewsItem = results
        goToDetailsLiveData.postValue(true)
    }
}