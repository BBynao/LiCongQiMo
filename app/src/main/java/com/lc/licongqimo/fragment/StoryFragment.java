package com.lc.licongqimo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lc.licongqimo.R;
import com.lc.licongqimo.adapter.StoryAdapter;
import com.lc.licongqimo.bean.StoryBean;
import com.lc.licongqimo.model.ImpStoryModel;
import com.lc.licongqimo.presenter.ImpSroryPresenter;
import com.lc.licongqimo.view.StoryView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoryFragment extends Fragment implements StoryView {


    private View view;
    private Banner mBann;
    private GridView mGv;
    private RecyclerView mRev;
    private ImpSroryPresenter impSroryPresenter;
    private ArrayList<StoryBean.ResultBean.DataBean> mList;
    private StoryAdapter storyAdapter;

    public StoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_story, container, false);
        impSroryPresenter = new ImpSroryPresenter(new ImpStoryModel(), this);
        initView(inflate);
        initStoryRevData();
        return inflate;
    }

    private void initStoryRevData() {
        impSroryPresenter.initData();
    }

    private void initView(View inflate) {
        mBann = (Banner) inflate.findViewById(R.id.bann);


        mGv = (GridView) inflate.findViewById(R.id.gv);

        mRev = (RecyclerView) inflate.findViewById(R.id.rev);
        mRev.setLayoutManager(new GridLayoutManager(getContext(),2));
        mList = new ArrayList<>();
        storyAdapter = new StoryAdapter(getContext(), mList);
        mRev.setAdapter(storyAdapter);
    }

    @Override
    public void OnSuccess(StoryBean bean) {
        List<StoryBean.ResultBean.DataBean> data = bean.getResult().getData();
        mList.addAll(data);
    }

    @Override
    public void OnFail(String error) {
        Log.e("tag", "OnFail: "+error );
    }
}
