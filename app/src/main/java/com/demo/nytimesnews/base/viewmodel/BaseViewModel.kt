package com.demo.nytimesnews.base.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.support.annotation.CallSuper
import com.demo.nytimesnews.base.utils.ResponseHelper
import com.demo.nytimesnews.base.utils.RestHelper.makeRequest
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

/**
 * Created by Rashida on 4/8/19.
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    @CallSuper
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    protected fun <T> execute(requestObservable: Observable<T>?,
                              responseLiveData: Consumer<T>,
                              errorLiveData: MutableLiveData<Int?>
    ) {
        compositeDisposable.add(makeRequest(requestObservable!!,
            Consumer<T> { responseEntity: T? ->
                if (responseEntity != null) responseLiveData.accept(responseEntity) else errorLiveData.postValue(
                    ResponseHelper.OTHER
                )
            },
           Consumer { errorEntity: Int? ->
                errorLiveData.postValue(errorEntity)
            })
        )
    }
}