package com.yinhao.viewdemo.fragment.fragment1;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yinhao.viewdemo.R;

/**
 * Created by hp on 2018/2/6.
 */

public class Fragment12 extends com.yinhao.viewdemo.fragment.BaseFragment {
    @Override
    public void loadData() {
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_12, null);
        ImageView circleView = (ImageView) view.findViewById(R.id.circle_view);
        Glide.with(this).load(R.drawable.batman).into(circleView);
        circleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        return view;
    }
}
