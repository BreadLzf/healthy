package sport.tc.com.util;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Set;
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
     * 所有请求第一个参数处理
     *
     * @return
     */
    public static String prouductValidData(Context context) {
        String time = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.getMd5Value(time));
        stringBuffer.append(AppContents.TCTK);
        String md5Token = MD5Encrypt.getMd5Value(stringBuffer.toString());
        ValidData validData = new ValidData();
        validData.time = time;
        validData.token = md5Token;
        String userIdentStr = SharedPerfercecesUtil.get(context, AppContents.USER_IDENT, "");
        if (!userIdentStr.isEmpty() && userIdentStr.length() > 0) {
            validData.user_identity = userIdentStr;
        }
        return GsonHelper.javaBeanToJson(validData);
    }


    /**
     * 判断是否是手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isPhoneNumber(String mobiles) {
        Pattern p = Pattern.compile("^1[34578]\\d{9}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }


    /**
     * list  去重复的元素
     * @param list
     * @return
     */
    public static  java.util.List<String> removeDuplicate(java.util.List<String> list){
        Set<String> set = new LinkedHashSet<String>();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }


    public static String formatLongTime(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            String sDateTime = sdf.format(time);
            return sDateTime;
        } catch (Exception e) {
            return null;
        }

    }
}
