package healthy.tichuang.com.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * Created by punisher on 2017/3/1.
 */

public class AppHelper {


    /**
     * 显示信息，如屏幕宽度、高度等
     */
    public static DisplayMetrics displayInfo(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }

}
