package sport.tc.com.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import sport.tc.com.modle.HealthyCircleResponse;

/**
 */
public final class GsonHelper {

    private static Gson gson = new Gson();

    /**
     * @Title: javaBeanToJson
     * @Description: 生成json字符串
     * @param @param list
     * @param @return 设定文件
     * @return String 返回类型
     * @author fly
     */
    public static <T> String listToJson(List<T> list) {
        try {
            if (null == list || list.isEmpty()) {
                return null;
            }
            return gson.toJson(list);
        } catch (Exception e) {}
        return null;
    }

    /**
     * @Title: javaBeanToJson
     * @Description: java对象转换成json
     * @param @param object
     * @param @return 设定文件
     * @return String 返回类型
     * @author fly
     */
    public static String javaBeanToJson(Object object) {
        try {
            return gson.toJson(object);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @Title: getJsonStr
     * @Description: 取出json字符串中指定内容
     * @param JsonStr
     * @param name
     * @return String 返回类型
     * @author fly
     */
    public static String getJsonStr(String JsonStr, String name) {
        if (TextUtils.isEmpty(JsonStr) || TextUtils.isEmpty(name)) {
            return null;
        }
        try {
            JSONObject jsonObject = new JSONObject(JsonStr);
            if (jsonObject != null && jsonObject.has(name))
                return jsonObject.getString(name);
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    /**
     * @Title: jsonStrToBean
     * @Description: json解析成java bean可用于多层解析
     * @param 设定文件
     * @param jsonStr
     * @param c
     * @return T 返回类型
     * @author fly
     */
    public static <T> T jsonStrToBean(String jsonStr, Class<T> c) {
        try {
            return gson.fromJson(jsonStr, c);
        } catch (Exception e) {}
        return null;
    }

    /**
     * @Title: jsonStrToList
     * @Description: 将json数组解析成list [{},{},{}]
     * @param json
     * @param Type
     * @return List<T> 返回类型
     * @author fly
     */
    public static <T> List<T> jsonStrToList(String jsonStr, Type type) {
        try {
            return gson.fromJson(jsonStr, type);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * @Title: jsonStrToList
     * @Description: 将json数组解析成list [{},{},{}]
     * @param json
     * @param c
     * @return List<T> 返回类型
     * @author fly
     */
    public static <T> List<T> jsonStrToList(String jsonStr, Class<T> c) {
        try {
            Type objectType = new TypeToken<List<T>>() {}.getType();
            return gson.fromJson(jsonStr, objectType);
        } catch (Exception e) {}
        return null;
    }
}
