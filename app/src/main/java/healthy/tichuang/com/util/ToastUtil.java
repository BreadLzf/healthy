package healthy.tichuang.com.util;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.text.MessageFormat;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;

/**
 * Toast工具类
 */
public class ToastUtil {

    /**
     * Show the given message in a {@link Toast}
     * <p/>
     * This method may be called from any thread
     */
    public static void show(Activity activity, String message) {
        show(activity, message, LENGTH_SHORT);
    }

    /**
     * Show the message with the given resource id in a {@link Toast}
     * <p/>
     * This method may be called from any thread
     */
    public static void show(Activity activity, int resId) {
        if (activity == null) {
            return;
        }
        show(activity, activity.getString(resId));
    }

    /**
     * 在主线程显示(activity或service)
     */
    public static void showAtUI(Context context, String message) {
        showAtUI(context, message, LENGTH_SHORT);
    }

    /**
     * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
     */
    public static void showLong(Activity activity, int resId) {
        show(activity, resId, LENGTH_LONG);
    }

    /**
     * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
     */
    public static void showLong(Activity activity, String message) {
        show(activity, message, LENGTH_LONG);
    }

    /**
     * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
     *
     * @param activity
     * @param message
     * @param args
     */
    public static void showLong(Activity activity, String message, Object... args) {
        String formatted = MessageFormat.format(message, args);
        show(activity, formatted, LENGTH_LONG);
    }

    /**
     * Show message in {@link Toast} with {@link Toast#LENGTH_SHORT} duration
     *
     * @param activity
     * @param message
     * @param args
     */
    public static void showShort(Activity activity, String message, Object... args) {
        String formatted = MessageFormat.format(message, args);
        show(activity, formatted, LENGTH_SHORT);
    }

    /**
     * Show message in {@link Toast} with {@link Toast#LENGTH_LONG} duration
     *
     * @param activity
     * @param resId
     * @param args
     */
    public static void showLong(Activity activity, int resId, Object... args) {
        if (activity == null) {
            return;
        }
        String message = activity.getString(resId);
        showLong(activity, message, args);
    }

    /**
     * Show message in {@link Toast} with {@link Toast#LENGTH_SHORT} duration
     *
     * @param activity
     * @param resId
     * @param args
     */
    public static void showShort(Activity activity, int resId, Object... args) {
        if (activity == null) {
            return;
        }
        String message = activity.getString(resId);
        showShort(activity, message, args);
    }

    private static void show(Activity activity, final int resId, final int duration) {
        if (activity == null) {
            return;
        }
        final Context context = activity.getApplication();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, resId, duration).show();
            }
        });
    }

    private static void show(Activity activity, final String message, final int duration) {
        if (activity == null || message == null) {
            return;
        }
        final Context context = activity.getApplication();
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, duration).show();
            }
        });
    }

    /**
     * 在主线程显示(activity或service)
     */
    private static void showAtUI(Context context, String message, int duration) {
        if (context == null || message == null) {
            return;
        }
        Toast.makeText(context, message, duration).show();
    }

}
