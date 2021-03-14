package com.demo.nytimesnews.feature.news.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.nytimesnews.R
import com.demo.nytimesnews.base.presentation.BaseBindingBottomSheetFragment
import com.demo.nytimesnews.databinding.LayoutNewsDetailBinding


/**
 * Created by Rashida on 3/14/21.
 *
 */
class NewsDetailFragment() : BaseBindingBottomSheetFragment<LayoutNewsDetailBinding>() {
     fun bindView(inflater: LayoutInflater?, container: ViewGroup?): View? {
        return inflater?.inflate(R.layout.layout_news_detail, container, false)
    }

    override val layout: Int = R.layout.layout_news_detail



    companion object {
        const val BUNDLE_KEY = "url"
        var newsDetailFragment: NewsDetailFragment? = null
         fun getInstance(url: String): NewsDetailFragment {
            val bundle = Bundle()
            bundle.putString(BUNDLE_KEY, url)
            if (newsDetailFragment == null) newsDetailFragment = NewsDetailFragment()
            newsDetailFragment?.arguments = bundle
            return newsDetailFragment!!
        }
    }

    override fun initiView() {
        binding.urlWebview.loadUrl(arguments?.getString(BUNDLE_KEY))
    }

}