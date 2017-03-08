package healthy.tichuang.com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by punisher on 2017/3/6.
 */

public class HealthyCircleView extends View {

    private Paint mPaint;
    private Context mContext;
    private int radius = 250;

    public HealthyCircleView(Context context) {
        this(context, null);
    }

    public HealthyCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e("ondraw","x>>"+getWidth()/2);
        Log.e("ondraw","y>>"+getHeight()/4);

        canvas.drawCircle(getWidth() / 2, getHeight() / 4, radius, mPaint);
        super.onDraw(canvas);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
