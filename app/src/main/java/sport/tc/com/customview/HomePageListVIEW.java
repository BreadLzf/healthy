package sport.tc.com.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by punisher on 2017/4/19.
 */

public class HomePageListView  extends ListView{
    public HomePageListView(Context context) {
        super(context);
    }

    public HomePageListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HomePageListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
