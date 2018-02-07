package com.yinhao.viewdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinhao.viewdemo.R;
import com.yinhao.viewdemo.TabLayoutAdapter;

/**
 * Created by hp on 2018/2/7.
 */

public abstract class TabFragment extends Fragment {

    public Context mContext;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_layout, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        TabLayoutAdapter mTablayoutAdapter = new TabLayoutAdapter(getChildFragmentManager(), setTabNames());
        mViewPager.setAdapter(mTablayoutAdapter);

        //绑定viewpager
        mTabLayout.setupWithViewPager(mViewPager);
        //给viewpager设置点击监听事件,绑定tablayout
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        return view;
    }


    public abstract String[] setTabNames();

}
