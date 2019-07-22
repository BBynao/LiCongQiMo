package com.lc.licongqimo.presenter;

import com.lc.licongqimo.bean.StoryBean;
import com.lc.licongqimo.callback.StoryCallBack;
import com.lc.licongqimo.model.StroyModel;
import com.lc.licongqimo.view.StoryView;

public class ImpSroryPresenter implements StoryPresenter, StoryCallBack {
    private StroyModel model;
    private StoryView view;

    public ImpSroryPresenter(StroyModel model, StoryView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void initData() {
        if (model != null) {
            model.stroyinitData(this);
        }

    }

    @Override
    public void OnSuccess(StoryBean bean) {
        if (view != null) {
            view.OnSuccess(bean);
        }
    }

    @Override
    public void OnFail(String error) {
        if (view != null) {
            view.OnFail(error);
        }

    }
}
