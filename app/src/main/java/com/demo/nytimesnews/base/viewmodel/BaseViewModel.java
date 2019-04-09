package com.demo.nytimesnews.base.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import com.demo.nytimesnews.base.model.BaseResponse;
import com.demo.nytimesnews.base.utils.RestHelper;
import com.demo.nytimesnews.base.utils.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Rashida on 4/8/19.
 */
public class BaseViewModel extends AndroidViewModel {

    @NonNull
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    private SchedulerProvider schedulerProvider;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    @CallSuper
    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }


    protected <T> void execute(Observable<T> requestObservable, MutableLiveData<BaseResponse<T>> responseLiveData,
                               MutableLiveData<Integer> errorLiveData) {

        compositeDisposable.add(RestHelper.makeRequest(schedulerProvider, requestObservable,
                responseEntity -> {
                    if (responseEntity instanceof BaseResponse) {
                        BaseResponse baseResponse = (BaseResponse) responseEntity;

                        responseLiveData.postValue(baseResponse);

                    }

                },
                errorEntity -> errorLiveData.postValue(errorEntity)));
    }
}
