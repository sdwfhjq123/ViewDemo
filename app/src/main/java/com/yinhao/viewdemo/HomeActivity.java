package com.yinhao.viewdemo;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class HomeActivity extends SingleFragmentActivity {
    private static final String TAG = "HomeActivity";

    @Override
    public Fragment createFragment() {
        return new HomeFragment();
    }

}
