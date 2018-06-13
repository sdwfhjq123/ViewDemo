package com.yinhao.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.yinhao.viewdemo.side.OnChooseLetterChangedListener;

public class SideBar extends View {
    private static final String TAG = "SideBar";
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mChoose = -1;
    private boolean mShowBackground;
    public static String[] mLetters = {"搜", "#", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};
    private OnChooseLetterChangedListener mOnChooseLetterChangedListener;

    public SideBar(Context context) {
        this(context, null);
    }

    public SideBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SideBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //是否展示背景
        if (mShowBackground) {
            setBackgroundColor(Color.LTGRAY);
        } else {
            setBackgroundColor(Color.TRANSPARENT);
        }

        int height = getHeight();
        int width = getWidth();

        //平均每个字母占的高度
        int singleHeight = height / mLetters.length;

        for (int i = 0; i < mLetters.length; i++) {
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(30);
            if (i == mChoose) {
                mPaint.setColor(Color.parseColor("#FF2828"));
                mPaint.setFakeBoldText(true);
            }
            float x = width / 2 - mPaint.measureText(mLetters[i]) / 2;
            float y = singleHeight * i + singleHeight;
            canvas.drawText(mLetters[i], x, y, mPaint);
            mPaint.reset();
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int oldChoose = mChoose;
        int i = (int) (event.getY() / getHeight() * mLetters.length);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mShowBackground = true;
                if (oldChoose != i && mOnChooseLetterChangedListener != null) {
                    if (i > -1 && i < mLetters.length) {
                        //获取触摸位置的字符
                        mOnChooseLetterChangedListener.onChooseLetter(mLetters[i]);
                        Log.i(TAG, "dispatchTouchEvent:------ACTION_DOWN-----获取触摸位置的字符-----" + mLetters[i]);
                        mChoose = i;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                mShowBackground = true;
                if (oldChoose != i && mOnChooseLetterChangedListener != null) {
                    if (i > -1 && i < mLetters.length) {
                        //获取触摸位置的字符
                        mOnChooseLetterChangedListener.onChooseLetter(mLetters[i]);
                        Log.i(TAG, "dispatchTouchEvent:------ACTION_MOVE-----获取触摸位置的字符-----" + mLetters[i]);
                        mChoose = i;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                mShowBackground = false;
                mChoose = -1;
                if (mOnChooseLetterChangedListener != null) {
                    mOnChooseLetterChangedListener.onNoChooseLetter();
                }
                invalidate();
                break;
        }
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOnTouchingLetterChangedListener(OnChooseLetterChangedListener onChooseLetterChangedListener) {
        mOnChooseLetterChangedListener = onChooseLetterChangedListener;
    }
}
