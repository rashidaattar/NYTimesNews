package com.demo.nytimesnews.base.utils

import com.demo.nytimesnews.base.utils.ResponseHelper.getErrorState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by Rashida on 4/8/19.
 */
object RestHelper {
    /**
     * @param request
     * @param responseConsumer
     * @param errorConsumer
     * @param <T>
     * @return response or error after executing the network call
    </T> */
    @JvmStatic
    fun <T> makeRequest(request: Observable<T>,
                        responseConsumer: Consumer<T>,
                        errorConsumer: Consumer<Int?>?
    ): Disposable {
        return request.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
            .subscribe(responseConsumer, Consumer { throwable: Throwable ->
                errorConsumer!!.accept(getErrorState(throwable))
                if (throwable.message != null) {
                    Timber.e("State " + throwable.message)
                }
            })
    }
}