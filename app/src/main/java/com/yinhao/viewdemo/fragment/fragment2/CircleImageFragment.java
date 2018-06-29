package com.yinhao.viewdemo.fragment.fragment2;

import android.view.View;

import com.yinhao.viewdemo.R;
import com.yinhao.viewdemo.fragment.BaseFragment;

public class CircleImageFragment extends BaseFragment {
    @Override
    public void loadData() {

    }

    @Override
    public View initView() {
        return View.inflate(getActivity(), R.layout.fragment_circle, null);
    }
}
