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

public class FragmentCenter extends TabFragment {

    public static FragmentCenter instance = null;//单例模式

    public static FragmentCenter getInstance() {
        if (instance == null) {
            instance = new FragmentCenter();
        }
        return instance;
    }

    @Override
    public String[] setTabNames() {
        return new String[0];
    }
}
