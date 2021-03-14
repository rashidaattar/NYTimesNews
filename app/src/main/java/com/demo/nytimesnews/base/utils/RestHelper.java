package com.demo.nytimesnews.base.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Rashida on 4/8/19.
 */
public class RestHelper {

    /**
     * @param request
     * @param responseConsumer
     * @param errorConsumer
     * @param <T>
     * @return response or error after executing the network call
     */


    public static <T> Disposable makeRequest(
                                             Observable<T> request,
                                             @NonNull Consumer<T> responseConsumer,
                                             @Nullable Consumer<Integer> errorConsumer) {
        return request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(responseConsumer, throwable -> {

                    errorConsumer.accept(ResponseHelper.getErrorState(throwable));
                    if (throwable.getMessage() != null) {
                        Timber.e("State " + throwable.getMessage());
                    }
                });
    }
}
