package sport.tc.com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sport.tc.com.AppContents;
import sport.tc.com.encryptutil.MD5Encrypt;
import sport.tc.com.modle.ValidData;

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
        String time =String.valueOf(System.currentTimeMillis()).substring(0, 10);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.getMd5Value(time));
        stringBuffer.append(AppContents.TCTK);

        String md5Token = MD5Encrypt.getMd5Value(stringBuffer.toString());

        ValidData validData =new  ValidData();
        validData.time=time;
        validData.token=md5Token;

        return  GsonHelper.javaBeanToJson(validData);
    }


    public static boolean isPhoneNumber(String mobiles) {
        Pattern p = Pattern.compile("^1[34578]\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
