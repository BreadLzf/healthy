package healthy.tichuang.com.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import healthy.tichuang.com.android_handhoop.R;

/**
 * Created by caixiang on 2017/3/13.
 */
public class CustomView extends View {
    private Paint bgPaint ;
    private Paint arrowPaint ;
    private Paint iconPaint ;

    private String bgCycle = "#FFE1FF";
    private String bgArrow = "#FFE1FF";

    private int radius = 400 ; //px

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStrokeWidth(5);
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setColor(Color.parseColor(bgCycle));
        PathEffect effects1 = new DashPathEffect(new float[]{15,15,15,15},1);
        bgPaint.setPathEffect(effects1);

        arrowPaint = new Paint();
        arrowPaint.setAntiAlias(true);
        arrowPaint.setColor(Color.parseColor(bgCycle));
        PathDashPathEffect effect2 = new PathDashPathEffect(getPath(), 105, 0, PathDashPathEffect.Style.ROTATE);
        arrowPaint.setPathEffect(effect2);

        iconPaint = new Paint();
    }

    private Path getPath(){
        // 画三角形
        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(0, 20f);
        path.lineTo(17.32f, 10f);

        path.close();

        return path ;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawBgCycle(canvas, bgPaint);
        drawBgCycleArrow(canvas, arrowPaint);
        drawCycleIcon(canvas, iconPaint);
        drawCenterIcon(canvas, iconPaint);
    }

    /**
     * 画背景圆
     * @param canvas
     * @param paint
     */
    private void drawBgCycle(Canvas canvas, Paint paint){
        canvas.drawCircle(radius, radius, radius, paint);
    }

    /**
     * 画背景箭头
     * @param canvas
     */
    private void drawBgCycleArrow(Canvas canvas, Paint paint){
        canvas.drawCircle(radius, radius, radius+10, paint);
    }

    /**
     * 画圆上的图标
     * @param canvas
     */
    private void drawCycleIcon(Canvas canvas, Paint paint){
        //圆坐标为（400,400），此处是圆环上随意选取的一点坐标（600，746.41）
        Bitmap mBitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        Rect mSrcRect = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        RectF mDestRect = new RectF(600-mBitmap.getWidth()/2, 746.41f-mBitmap.getHeight()/2f, 600+mBitmap.getWidth()/2, 746.41f+mBitmap.getHeight()/2f);
        canvas.drawBitmap(mBitmap, mSrcRect, mDestRect, paint);

        drawMyText(canvas, "运动风险评估", 600, (int)(746.41f+mBitmap.getHeight()/2f));
    }

    /**
     * 画圆心的图标
     * @param canvas
     */
    private void drawCenterIcon(Canvas canvas, Paint paint){
        Bitmap mBitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        Rect mSrcRect = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        Rect mDestRect = new Rect(radius-mBitmap.getWidth()/2, radius-mBitmap.getHeight()/2, radius+mBitmap.getWidth()/2,radius+mBitmap.getHeight()/2);
        canvas.drawBitmap(mBitmap, mSrcRect, mDestRect, paint);

        drawMyText(canvas, "开启健康之路", radius, radius+mBitmap.getHeight()/2);
    }

    /**
     * 绘制圆底下的文字
     * @param canvas
     * @param text
     * @param offsetX 圆形最底下一点的x值
     * @param offsetY 圆形最底下一点的y值
     */
    private void drawMyText(Canvas canvas, String text, int offsetX, int offsetY){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(20);
        paint.setColor(Color.RED);
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();

        int textHeight = (int)Math.ceil(paint.getFontMetricsInt().descent - paint.getFontMetricsInt().ascent);
        int textWidth = getTextWidth(paint, text) ;

        Rect targetRect = new Rect(offsetX-textWidth/2, offsetY, offsetX+textWidth/2, offsetY+textHeight);

        // 转载请注明出处：http://blog.csdn.net/hursing
        int baseline = (targetRect.bottom + targetRect.top - fontMetrics.bottom - fontMetrics.top) / 2;
        // 下面这行是实现水平居中，drawText对应改为传入targetRect.centerX()
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, targetRect.centerX(), baseline, paint);
    }

    /**
     * 计算文字总长度
     * @param paint
     * @param str
     * @return
     */
    private int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }
}
