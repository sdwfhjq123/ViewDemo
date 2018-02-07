package com.yinhao.viewdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.yinhao.viewdemo.fragment.Fragment1;
import com.yinhao.viewdemo.fragment.Fragment2;
import com.yinhao.viewdemo.fragment.Fragment4;
import com.yinhao.viewdemo.fragment.Fragment5;
import com.yinhao.viewdemo.fragment.FragmentCenter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2018/2/6.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "HomeFragment";

    private ViewPager mViewPager;
    private RadioButton mClick1, mClick2, mCenterClick, mClick4, mClick5;

    private FragmentPagerAdapter mFragmentPagerAdapter;//将tab页面持久在内存中
    private List<Fragment> mFragmentList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initView(view);

        mFragmentList.add(Fragment1.getInstance());
        mFragmentList.add(Fragment2.getInstance());
        mFragmentList.add(FragmentCenter.getInstance());
        mFragmentList.add(Fragment4.getInstance());
        mFragmentList.add(Fragment5.getInstance());

        //配置ViewPager的适配器
        mFragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        };

        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //判断图标是否选中
                judgeChecked(position);
            }
        });

        return view;
    }

    /**
     * 判断是否显示当前fragment
     *
     * @param position fragment
     */
    private void judgeChecked(int position) {
        switch (position) {
            case 0://1
                judgeBoolean(true, false, false, false, false);
                break;
            case 1://2
                judgeBoolean(false, true, false, false, false);
                break;
            case 2://center
                judgeBoolean(false, false, true, false, false);
                break;
            case 3://4
                judgeBoolean(false, false, false, true, false);
                break;
            case 4://5
                judgeBoolean(false, false, false, false, true);
                break;
        }
    }

    /**
     * boolean 标识
     */
    @SuppressLint("ResourceAsColor")
    private void judgeBoolean(Boolean f1, Boolean f2, Boolean f3, Boolean f4, Boolean f5) {
        mClick1.setChecked(f1);
        mClick2.setChecked(f2);
        mCenterClick.setChecked(f3);
        mClick4.setChecked(f4);
        mClick5.setChecked(f5);
    }

    private void initView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mClick1 = (RadioButton) view.findViewById(R.id.one_click);
        mClick2 = (RadioButton) view.findViewById(R.id.two_click);
        mCenterClick = (RadioButton) view.findViewById(R.id.center_click);
        mClick4 = (RadioButton) view.findViewById(R.id.four_click);
        mClick5 = (RadioButton) view.findViewById(R.id.five_click);

        mClick1.setOnClickListener(this);
        mClick2.setOnClickListener(this);
        mCenterClick.setOnClickListener(this);
        mClick4.setOnClickListener(this);
        mClick5.setOnClickListener(this);

    }

    /**
     * 点击切换页卡
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one_click:
                mViewPager.setCurrentItem(0);
                judgeBoolean(true, false, false, false, false);
                break;
            case R.id.two_click:
                mViewPager.setCurrentItem(1);
                judgeBoolean(false, true, false, false, false);
                break;
            case R.id.center_click:
                mViewPager.setCurrentItem(2);
                judgeBoolean(false, false, true, false, false);
                break;
            case R.id.four_click:
                mViewPager.setCurrentItem(3);
                judgeBoolean(false, false, false, true, false);
                break;
            case R.id.five_click:
                mViewPager.setCurrentItem(4);
                judgeBoolean(false, false, false, false, true);
                break;
        }
    }
}
