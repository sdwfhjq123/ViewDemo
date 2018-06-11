package com.yinhao.viewdemo.fragment.fragment1;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yinhao.viewdemo.R;
import com.yinhao.viewdemo.view.WeChatSlideSwitch;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment15 extends com.yinhao.viewdemo.fragment.BaseFragment {
    private static final String TAG = "Fragment15";

    @Override
    public void loadData() {

    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_15, null);
        WeChatSlideSwitch slideSwitch = (WeChatSlideSwitch) view.findViewById(R.id.view);
        slideSwitch.setOnCheckedChangeListener(new WeChatSlideSwitch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(WeChatSlideSwitch buttonView, boolean isChecked) {
                Log.i(TAG, isChecked + "");
            }
        });
        return view;
    }
}
