package com.demo.nytimesnews

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * Created by Rashida on 4/9/19.
 */
class NYTimesNews : Application() {
    override fun onCreate() {
        super.onCreate()
        nyTimesNews = this
        initTimber()
    }

    companion object {
        private var nyTimesNews: NYTimesNews? = null
        fun get(): NYTimesNews {
            return nyTimesNews!!
        }

        fun initTimber() {
            if (BuildConfig.DEBUG) {
                Timber.plant(DebugTree())
            }
        }
    }
}