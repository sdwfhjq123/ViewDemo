package com.yinhao.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.yinhao.viewdemo.R;

/**
 * Created by yinhao on 2018/2/26.
 */

public class AfterOnDrawView extends AppCompatImageView {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public AfterOnDrawView(Context context) {
        super(context);
    }

    public AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mPaint.setColor(Color.parseColor("#FFC107"));
        mPaint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        // 爽吧？

        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
            canvas.concat(getImageMatrix());
            Rect bounds = drawable.getBounds();
            canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20, 40, mPaint);
            canvas.restore();
        }
    }
}
