package com.lc.licongqimo.model;

import com.lc.licongqimo.api.StoryService;
import com.lc.licongqimo.bean.StoryBean;
import com.lc.licongqimo.callback.StoryCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpStoryModel implements StroyModel {
    @Override
    public void stroyinitData(final StoryCallBack storyCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StoryService.storyUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StoryService storyService = retrofit.create(StoryService.class);
        Observable<StoryBean> call = storyService.storyinitData();
        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(StoryBean storyBean) {
                        storyCallBack.OnSuccess(storyBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        storyCallBack.OnFail(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
