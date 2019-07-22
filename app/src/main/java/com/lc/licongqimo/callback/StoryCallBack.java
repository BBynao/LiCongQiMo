package com.lc.licongqimo.callback;

import com.lc.licongqimo.bean.StoryBean;

public interface StoryCallBack {
    void OnSuccess(StoryBean bean);
    void OnFail(String error);
}
