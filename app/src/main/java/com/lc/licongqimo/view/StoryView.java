package com.lc.licongqimo.view;

import com.lc.licongqimo.bean.StoryBean;

public interface StoryView {
    void OnSuccess(StoryBean bean);
    void OnFail(String error);
}
