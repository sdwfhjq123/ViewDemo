package com.yinhao.viewdemo.fragment;

import com.yinhao.viewdemo.fragment.fragment2.CircleImageFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment2Factory {
    private static Map<Integer, BaseFragment> mBaseFragments = new HashMap<>();

    public static BaseFragment createFragment(int pos) {

        BaseFragment baseFragment = mBaseFragments.get(pos);

        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    baseFragment = new CircleImageFragment();
                    break;
            }

            mBaseFragments.put(pos, baseFragment);
        }
        return baseFragment;
    }
}
