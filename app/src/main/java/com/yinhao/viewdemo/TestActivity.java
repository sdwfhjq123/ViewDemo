package com.yinhao.viewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.yinhao.viewdemo.view.WeChatSlideSwitch;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_15);
        WeChatSlideSwitch slideSwitch = (WeChatSlideSwitch) findViewById(R.id.view);
        slideSwitch.setOnCheckedChangeListener(new WeChatSlideSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(WeChatSlideSwitch buttonView, boolean isChecked) {
                Log.i(TAG, isChecked + "");
            }
        });
    }
}
