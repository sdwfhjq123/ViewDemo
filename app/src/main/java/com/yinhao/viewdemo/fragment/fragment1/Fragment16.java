package com.yinhao.viewdemo.fragment.fragment1;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import com.yinhao.viewdemo.HanziToPinyin;
import com.yinhao.viewdemo.R;
import com.yinhao.viewdemo.side.Contant;
import com.yinhao.viewdemo.side.OnChooseLetterChangedListener;
import com.yinhao.viewdemo.side.SideRecyclerViewAdapter;
import com.yinhao.viewdemo.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hp on 2018/2/6.
 * 字母索引recyclerview
 */

public class Fragment16 extends com.yinhao.viewdemo.fragment.BaseFragment {
    private static final String TAG = "Fragment16";
    private RecyclerView mRecyclerView;
    private TextView mHintTv;
    private SideBar mSideBar;
    private List<Contant> mContantList;
    private ArrayMap<String, Integer> mLetters;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void loadData() {

        setData();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setData() {
        mLetters = new ArrayMap<>();
        mContantList = new ArrayList<>();
        mContantList.add(new Contant("张某"));
        mContantList.add(new Contant("李某"));
        mContantList.add(new Contant("韩某"));
        mContantList.add(new Contant("左某"));
        mContantList.add(new Contant("汉某"));
        mContantList.add(new Contant("顾某"));
        mContantList.add(new Contant("焦某"));
        mContantList.add(new Contant("孔某"));
        mContantList.add(new Contant("商某"));
        mContantList.add(new Contant("沈某"));
        mContantList.add(new Contant("夏某"));
        mContantList.add(new Contant("赵四"));
        mContantList.add(new Contant("钱某"));
        mContantList.add(new Contant("孙丽"));
        mContantList.add(new Contant("李四"));
        mContantList.add(new Contant("吴三桂"));
        mContantList.add(new Contant("王某"));
        mContantList.add(new Contant("冯某"));
        mContantList.add(new Contant("陈某"));
        mContantList.add(new Contant("诸某"));

        //获取名字首字母-大写
        for (Contant contant : mContantList) {
            String chaR = HanziToPinyin.getInstance().get(contant.getName().trim()
                    .substring(0, 1)).get(0).target.substring(0, 1).toUpperCase().toUpperCase();
            contant.setFirstChar(chaR);
        }
        //TODO 根据首字母排序
        Collections.sort(mContantList, new Comparator<Contant>() {
            @Override
            public int compare(Contant c1, Contant c2) {
                return c1.getFirstChar().compareTo(c2.getFirstChar());
            }
        });

        //保存每个字母下的联系人在数据中的位置
        for (int i = 0; i < mContantList.size(); i++) {
            mContantList.get(i).setHeadIndex(i);
            if (!mLetters.containsKey(mContantList.get(i).getFirstChar())) {
                mLetters.put(mContantList.get(i).getFirstChar(), i);
            }
        }

        //加载数据
        mRecyclerView.setAdapter(new SideRecyclerViewAdapter(mContantList, getActivity(), mLetters));
    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_16, null);
        mSideBar = (SideBar) view.findViewById(R.id.sidebar);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mHintTv = (TextView) view.findViewById(R.id.tv_hint);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        mSideBar.setOnTouchingLetterChangedListener(new OnChooseLetterChangedListener() {
            @Override
            public void onChooseLetter(String s) {
                if (mHintTv.getVisibility() == View.GONE) {
                    mHintTv.setVisibility(View.VISIBLE);
                }
                mHintTv.setText(s);
                selectRecyclerView(s);
            }

            @Override
            public void onNoChooseLetter() {
                mHintTv.setVisibility(View.GONE);
            }
        });
        return view;

    }

    private void selectRecyclerView(String s) {
        if (s.equals("搜") || s.equals("#")) {
            mRecyclerView.scrollToPosition(0);
        } else {
            if (mLetters.containsKey(s)) {
                mRecyclerView.scrollToPosition(mLetters.get(s));
            }
        }
    }
}
