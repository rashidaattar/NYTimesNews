package com.demo.nytimesnews.feature.news.list

import android.arch.lifecycle.Observer
import android.content.Intent
import android.view.View
import com.demo.nytimesnews.NYTimesNews
import com.demo.nytimesnews.R
import com.demo.nytimesnews.base.presentation.BaseActivity
import com.demo.nytimesnews.databinding.ActivityNewsListBinding
import com.demo.nytimesnews.di.DaggerMainAppComponent
import com.demo.nytimesnews.di.module.ContextModule
import com.demo.nytimesnews.di.module.NetworkModule
import com.demo.nytimesnews.feature.news.NewsViewModel
import com.demo.nytimesnews.feature.news.detail.NewsDetailFragment
import com.demo.nytimesnews.feature.news.list.adapter.NewsListAdapter
import com.demo.nytimesnews.remote.model.NewsList
import timber.log.Timber
import javax.inject.Inject

class NewsListActivity : BaseActivity<ActivityNewsListBinding?>() {
    @Inject
    lateinit var newsViewModel: NewsViewModel

    @Inject
    lateinit var newsListAdapter: NewsListAdapter


    override fun initViews() {
        DaggerMainAppComponent.builder().contextModule(ContextModule(NYTimesNews.get()))
            .networkModule(NetworkModule()).build().inject(this)
        binding?.newsListView?.adapter = newsListAdapter
        supportActionBar?.title = "NY TIMES NEWS"
        binding?.progressBar?.visibility = View.VISIBLE
        newsViewModel.getNews()
        observeData()
    }

    private fun observeData() {
        newsViewModel.newsData.observe(this, Observer { response: NewsList? ->
            Timber.d("response " + response!!.status)
            if (response.status.equals("OK", ignoreCase = true)) {
                binding!!.progressBar.visibility = View.GONE
                newsListAdapter.setData(response.resultsList)
            }
        })
        newsViewModel.error.observe(this, Observer { integer: Int? ->
            Timber.d("error$integer")
            binding!!.progressBar.visibility = View.GONE
        })
        newsViewModel.goToDetailsLiveData.observe(this, Observer { goToDetails ->
            if (goToDetails!!) {
                newsViewModel.selectedNewsItem?.url?.let {
                    val fragment = NewsDetailFragment.getInstance(it)
                    fragment.show(supportFragmentManager,"bottomsheet")
                }

            }
        })
    }

    override val layout: Int = R.layout.activity_news_list

}