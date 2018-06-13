package com.yinhao.viewdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import com.yinhao.viewdemo.side.Contant;
import com.yinhao.viewdemo.side.OnChooseLetterChangedListener;
import com.yinhao.viewdemo.side.SideRecyclerViewAdapter;
import com.yinhao.viewdemo.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SideActivity extends AppCompatActivity {
    private static final String TAG = "SideActivity";
    private RecyclerView mRecyclerView;
    private TextView mHintTv;
    private SideBar mSideBar;
    private List<Contant> mContantList = new ArrayList<>();
    private ArrayMap<String, Integer> mLetters = new ArrayMap<>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_16);

        initView();
        initData();
    }

    private void initData() {
        setData();
    }

    private void setData() {
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
        for (int i = 0; i < mContantList.size(); i++) {
            String chaR = HanziToPinyin.getInstance().get(mContantList.get(i).getName().trim()
                    .substring(0, 1)).get(0).target.substring(0, 1).toUpperCase().toUpperCase();
            mContantList.get(i).setFirstChar(chaR);
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
        mRecyclerView.setAdapter(new SideRecyclerViewAdapter(mContantList, this, mLetters));
    }

    public void initView() {
        mSideBar = (SideBar) findViewById(R.id.sidebar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mHintTv = (TextView) findViewById(R.id.tv_hint);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

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
