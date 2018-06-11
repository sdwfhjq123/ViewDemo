package com.yinhao.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SlideSwitch extends View {
    private static final String TAG = "SlideSwitch";
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG); //抗锯齿

    private boolean isOn;//是否开启
    private float curX;
    private float centerY;//y固定
    private float viewWidth;
    private float radius;
    private float lineStart;//直线段开始的位置（横坐标，即
    private float lineEnd; //直线段结束的位置（纵坐标
    private float lineWidth;
    private final int SCALE = 4; // 控件长度与滑动的圆的半径的倍数
    private OnStateChangedListener onStateChangedListener;

    public SlideSwitch(Context context) {
        super(context);
    }

    public SlideSwitch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SlideSwitch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //保持宽是高的scale/2倍，即圆形按钮的半径
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() * 2 / SCALE);
        viewWidth = getMeasuredWidth();//视图的宽度
        radius = viewWidth / SCALE;//半径等于 宽度/倍数
        lineWidth = radius * 2f;//直线宽度等于滑块直径
        curX = radius;
        centerY = getMeasuredWidth() / SCALE;//centerY为高度的一半
        lineStart = radius;
        lineEnd = (SCALE - 1) * radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //限制滑动范围
        curX = curX > lineEnd ? lineEnd : curX;
        curX = curX < lineStart ? lineStart : curX;
        //划线
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(lineWidth);//竖着画一个rect
        /*左边部分的线，蓝色*/
        mPaint.setColor(Color.parseColor("#78d371"));
        canvas.drawLine(lineStart, centerY, curX, centerY, mPaint);
        /*右边部分的线，灰色*/
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(curX, centerY, lineEnd, centerY, mPaint);
        /*画圆*/
        /*画最左和最右的圆，直径为直线段宽度， 即在直线段两边分别再加上一个半圆*/
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(lineEnd, centerY, lineWidth / 2, mPaint);
        mPaint.setColor(Color.parseColor("#78d371"));
        canvas.drawCircle(lineStart, centerY, lineWidth / 2, mPaint);
        /*圆形滑块*/
        mPaint.setColor(Color.parseColor("#cccccc"));
        canvas.drawCircle(curX, centerY, radius, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        curX = event.getX();
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (curX > viewWidth / 2) {
                curX = lineEnd;
                if (!isOn) {
                    //只有状态发生改变才调用回调函数， 下同
                    if (null != onStateChangedListener) {
                        onStateChangedListener.onStateChanged(true);
                    }
                    isOn = true;
                    invalidate();
                }
            } else {
                curX = lineStart;
                if (isOn) {
                    if (null != onStateChangedListener) {
                        onStateChangedListener.onStateChanged(false);
                    }
                    isOn = false;
                    invalidate();
                }
            }
        }
        /*通过刷新调用onDraw*/
        postInvalidate();
        return true;

    }

    /*设置开关状态改变监听器*/
    public void setOnStateChangedListener(OnStateChangedListener o) {
        this.onStateChangedListener = o;
    }

    /*内部接口，开关状态改变监听器*/
    public interface OnStateChangedListener {
        void onStateChanged(boolean state);
    }
}
