package com.yinhao.viewdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yinhao.viewdemo.R;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment2 extends TabFragment {

    public static Fragment2 instance = null;//单例模式

    public static Fragment2 getInstance() {
        if (instance == null) {
            instance = new Fragment2();
        }
        return instance;
    }

    @Override
    public String[] setTabNames() {
        return new String[0];
    }
}
