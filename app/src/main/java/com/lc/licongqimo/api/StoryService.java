package com.lc.licongqimo.api;

import com.lc.licongqimo.bean.StoryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface StoryService {
    String storyUrl = "http://172.16.56.85:8080/";
    @GET("android/children.json")
    Observable<StoryBean> storyinitData();
}
