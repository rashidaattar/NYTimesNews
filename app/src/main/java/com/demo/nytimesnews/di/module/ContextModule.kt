package com.demo.nytimesnews.di.module

import android.app.Application
import android.content.Context
import com.demo.nytimesnews.di.scope.FeatureScope
import dagger.Module
import dagger.Provides

/**
 * Created by Rashida on 4/9/19.
 */
@Module
class ContextModule(@get:Provides @get:FeatureScope val application: Application) {
    private val context: Context
    @Provides
    @FeatureScope
    fun context(): Context {
        return context
    }

    init {
        context = application.applicationContext
    }
}