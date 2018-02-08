package com.yinhao.viewdemo.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by hp on 2018/2/7.
 */

public class HistogramView extends View {
    //图片大小
    private static final int IMAGE_WIDTH = 400;
    private static final int IMAGE_HEIGHT = 300;
    //开始的x
    private static final int START_X = 30;
    //开始的y
    private static final int START_Y = 10;
    //每一个直方条的间隔
    private static final int INTERVAL = 10;

    private static final String[] TEXTS = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private static final int[] HEIGHTS = {50, 100, 150, 400, 400, 200, 50};

    //每个直方条的宽度
    private static final int COLUMN_WIDTH = (IMAGE_WIDTH - (TEXTS.length + 1) * INTERVAL) / TEXTS.length;

    private Paint paint;

    {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
    }

    public HistogramView(Context context) {
        super(context);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);

        //坐标轴
        canvas.drawLine(START_X, START_Y, START_X, START_Y + IMAGE_HEIGHT, paint);
        canvas.drawLine(START_X, START_Y + IMAGE_HEIGHT, START_X + IMAGE_WIDTH, START_Y + IMAGE_HEIGHT, paint);

        //底部坐标文字
        paint.setTextSize(20);
        for (int i = 0; i < TEXTS.length; i++) {
            canvas.drawText(TEXTS[i],
                    START_X + (i + 1) * INTERVAL + i * COLUMN_WIDTH + COLUMN_WIDTH / 2 - paint.measureText(TEXTS[i]) / 2,
                    START_Y + IMAGE_HEIGHT + 20, paint);
        }

        //柱状图
        paint.setColor(Color.GREEN);
        Path path = new Path();
        path.moveTo(START_X + INTERVAL, START_Y + IMAGE_HEIGHT - HEIGHTS[0]);
        for (int i = 0; i < HEIGHTS.length; i++) {
            path.addRect(START_X + (i + 1) * INTERVAL + i * COLUMN_WIDTH,
                    START_Y + IMAGE_HEIGHT - HEIGHTS[i],
                    START_X + (i + 1) * (INTERVAL + COLUMN_WIDTH),
                    START_Y + IMAGE_HEIGHT, Path.Direction.CW);
        }
        canvas.drawPath(path, paint);
    }
}
