package com.yinhao.viewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yinhao.viewdemo.fragment.Fragment1Factory;

/**
 * Created by hp on 2018/2/7.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {

    private final String[] mTabNames;

    public TabLayoutAdapter(FragmentManager fm, String[] tabNames) {
        super(fm);
        mTabNames = tabNames;
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
