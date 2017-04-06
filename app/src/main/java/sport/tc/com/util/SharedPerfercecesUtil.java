package sport.tc.com.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by punisher on 2017/3/1.
 * 共享参数保存类
 */

public class SharedPerfercecesUtil {

    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    // ---------------------------------------------------------------------------------------------

    public static boolean get(Context context, String key) {
        return get(context, key, true);
    }

    public static boolean get(Context context, String key, boolean defValue) {
        if (context == null) {
            return defValue;
        }
        return getSharedPreferences(context).getBoolean(key, defValue);
    }

    public static String get(Context context, String key, String defValue) {
        if (context == null) {
            return defValue;
        }
        return getSharedPreferences(context).getString(key, defValue);
    }

    public static int get(Context context, String key, int defValue) {
        if (context == null) {
            return defValue;
        }
        return getSharedPreferences(context).getInt(key, defValue);
    }

    public static long get(Context context, String key, long defValue) {
        if (context == null) {
            return defValue;
        }
        return getSharedPreferences(context).getLong(key, defValue);
    }

    public static float get(Context context, String key, float defValue) {
        if (context == null) {
            return defValue;
        }
        return getSharedPreferences(context).getFloat(key, defValue);
    }

    public static void put(Context context, String key, boolean value) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, long value) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.putLong(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, String value) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, int value) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.apply();
    }

    public static void put(Context context, String key, float value) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.putFloat(key, value);
        editor.apply();
    }

    public static long getLong(Context context, String key, long defValue) {
        if (context == null) {
            return defValue;
        }
        return getSharedPreferences(context).getLong(key, defValue);
    }

    public static void putLong(Context context, String key, long value) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.putLong(key, value);
        editor.apply();
    }

    public static void clear(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editor = getEditor(context);
        editor.clear();
        editor.apply();
    }

}
