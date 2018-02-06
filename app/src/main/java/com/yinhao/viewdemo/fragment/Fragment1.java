package com.yinhao.viewdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinhao.viewdemo.R;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment1 extends Fragment {
    public static Fragment1 instance = null;//单例模式

    public static Fragment1 getInstance() {
        if (instance == null) {
            instance = new Fragment1();
        }
        return instance;
    }

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_layout);

        TabLayoutAdapter mTablayoutAdapter = new TabLayoutAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mTablayoutAdapter);

        //绑定viewpager
        mTabLayout.setupWithViewPager(mViewPager);
        //给viewpager设置点击监听事件,绑定tablayout
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        return view;
    }

    class TabLayoutAdapter extends FragmentPagerAdapter {

        private final String[] mTabNames;

        TabLayoutAdapter(FragmentManager fm) {
            super(fm);
            mTabNames = getResources().getStringArray(R.array.tab_f1_names);
        }


        @Override
        public Fragment getItem(int position) {
            return Fragment1Factory.createFragment(position);
        }

        @Override
        public int getCount() {
            return mTabNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabNames[position];
        }

    }
}
