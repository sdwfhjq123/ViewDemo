package com.yinhao.viewdemo.view;


import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hp on 2018/2/7.
 */

public class HistogramView extends View {

    private static final int IMAGE_WIDTH = 600;
    private static final int IMAGE_HEIGHT = 400;
    private static final int START_X = 60;
    private static final int START_Y = 20;
    private static final int INTERVAL = 15;

    private static final String[] TEXTS = {"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};
    private static final int[] HEIGHTS = {50, 100, 150, 400, 400, 200, 50};

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


}
