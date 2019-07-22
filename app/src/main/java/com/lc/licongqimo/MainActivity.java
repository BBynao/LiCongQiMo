package com.lc.licongqimo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lc.licongqimo.fragment.ParentFragment;
import com.lc.licongqimo.fragment.StoryFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * 故事
     */
    private RadioButton mRbStory;
    /**
     * 亲子
     */
    private RadioButton mRbParent;
    private RadioGroup mRg;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRbStory = (RadioButton) findViewById(R.id.rb_story);
        mRbParent = (RadioButton) findViewById(R.id.rb_parent);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mVp = (ViewPager) findViewById(R.id.vp);

        //绑定Fragment
        fragments = new ArrayList<>();
        fragments.add(new StoryFragment());
        fragments.add(new ParentFragment());

        //创建Viewpager适配器
        mVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });


        //绑定联动
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRg.check(R.id.rb_story);
                        break;
                    case 1:
                        mRg.check(R.id.rb_parent);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_story:
                        mVp.setCurrentItem(0);
                        break;
                    case R.id.rb_parent:
                        mVp.setCurrentItem(1);
                        break;
                }

            }
        });





    }
}
