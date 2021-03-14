package com.demo.nytimesnews.feature.news.detail

import android.view.MenuItem
import com.demo.nytimesnews.R
import com.demo.nytimesnews.base.presentation.BaseActivity
import com.demo.nytimesnews.databinding.ActivityNewsDetailBinding

/**
 * Created by Rashida on 4/14/19.
 */
class NewsDetailActivity : BaseActivity<ActivityNewsDetailBinding?>() {
    override fun initViews() {
        binding?.urlWebview?.loadUrl(intent.getStringExtra("URL"))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override val layout: Int = R.layout.activity_news_detail

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}