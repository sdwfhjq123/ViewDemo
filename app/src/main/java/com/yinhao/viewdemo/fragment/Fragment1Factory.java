package com.yinhao.viewdemo.fragment;

import com.yinhao.viewdemo.fragment.fragment1.Fragment11;
import com.yinhao.viewdemo.fragment.fragment1.Fragment12;
import com.yinhao.viewdemo.fragment.fragment1.Fragment13;
import com.yinhao.viewdemo.fragment.fragment1.Fragment14;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment1Factory {
    private static Map<Integer, BaseFragment> mBaseFragments = new HashMap<>();

    static BaseFragment createFragment(int pos) {

        BaseFragment baseFragment = mBaseFragments.get(pos);

        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    baseFragment = new Fragment11();
                    break;
                case 1:
                    baseFragment = new Fragment12();
                    break;
                case 2:
                    baseFragment = new Fragment13();
                    break;
                case 3:
                    baseFragment = new Fragment14();
                    break;
            }

            mBaseFragments.put(pos, baseFragment);
        }
        return baseFragment;
    }
}
