package com.yinhao.viewdemo.fragment;


/**
 * Created by hp on 2018/2/6.
 */

public class Fragment4 extends TabFragment {

    public static Fragment4 instance = null;//单例模式

    public static Fragment4 getInstance() {
        if (instance == null) {
            instance = new Fragment4();
        }
        return instance;
    }

    @Override
    public String[] setTabNames() {
        return new String[0];
    }
}
