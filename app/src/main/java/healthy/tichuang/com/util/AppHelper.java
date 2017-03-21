package healthy.tichuang.com.util;

import healthy.tichuang.com.encryptutil.MD5Encrypt;

/**
 * Created by punisher on 2017/3/1.
 */

public class AppHelper {

    public static String formatRequestValidData(String token) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5(String.valueOf(System.currentTimeMillis())));
        stringBuffer.append(token);
        String md5Token = MD5Encrypt.md5(stringBuffer.toString());
        return "{'time'：'"+System.currentTimeMillis() +"'，'token'：'" + md5Token + "'}";
    }
}
