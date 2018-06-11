package com.yinhao.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by yinhao on 2018/2/26.
 */

public class BeforeOnDrawView extends AppCompatTextView {
    private static final String TAG = "BeforeOnDrawView";

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds = new RectF();

    public BeforeOnDrawView(Context context) {
        super(context);
    }

    public BeforeOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 把下面的绘制代码移到 super.onDraw() 的上面，就可以让原主体内容盖住你的绘制代码了
        // （或者你也可以把 super.onDraw() 移到这段代码的下面）
        Layout layout = getLayout();

        Log.i(TAG, "onDraw: 文本的行数 " + layout.getLineCount());

        bounds.left = layout.getLineLeft(1);
        bounds.right = layout.getLineRight(1);
        bounds.top = layout.getLineTop(1);
        bounds.bottom = layout.getLineBottom(1);
        canvas.drawRect(bounds, paint);

        bounds.left = layout.getLineLeft(layout.getLineCount() - 3);
        bounds.right = layout.getLineRight(layout.getLineCount() - 3);
        bounds.top = layout.getLineTop(layout.getLineCount() - 3);
        bounds.bottom = layout.getLineBottom(layout.getLineCount() - 3);
        canvas.drawRect(bounds, paint);

        super.onDraw(canvas);

    }

}
