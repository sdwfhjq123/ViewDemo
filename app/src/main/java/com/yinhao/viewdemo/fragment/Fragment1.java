package com.yinhao.viewdemo.fragment;


import com.yinhao.viewdemo.R;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment1 extends TabFragment {
    public static Fragment1 instance = null;//单例模式

    public static Fragment1 getInstance() {
        if (instance == null) {
            instance = new Fragment1();
        }
        return instance;
    }

    @Override
    public String[] setTabNames() {
        return getResources().getStringArray(R.array.tab_f1_names);
    }

}
