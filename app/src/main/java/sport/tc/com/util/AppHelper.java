package sport.tc.com.util;

import sport.tc.com.AppContents;
import sport.tc.com.encryptutil.MD5Encrypt;

/**
 * Created by punisher on 2017/3/1.
 */

public class AppHelper {

    /**
     * 请求的第一个参数
     * @return
     */
    public static String prouductValidData() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5(String.valueOf(System.currentTimeMillis())));
        stringBuffer.append(AppContents.TCTK);
        String md5Token = MD5Encrypt.md5(stringBuffer.toString());
        return "{'time'：'"+System.currentTimeMillis() +"'，'token'：'" + md5Token + "'}";
    }
}
