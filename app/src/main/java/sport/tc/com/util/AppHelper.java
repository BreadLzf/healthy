package sport.tc.com.util;

import android.util.Log;

import sport.tc.com.AppContents;
import sport.tc.com.encryptutil.MD5Encrypt;

/**
 * Created by punisher on 2017/3/1.
 */

public class AppHelper {

    /**
     * 请求的第一个参数
     *
     * @return
     */
    public static String prouductValidData() {
        String time = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5(time));
        stringBuffer.append(AppContents.TCTK);
        String md5Token = MD5Encrypt.md5(stringBuffer.toString());
        Log.e("syso", "time>>" + System.currentTimeMillis());
        Log.e("time", "time>>" + time);

        return "{'time'：'" + time + "'，'token'：'" + md5Token + "'}";
    }
}
