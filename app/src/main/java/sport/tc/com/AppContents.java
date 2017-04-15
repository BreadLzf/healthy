package sport.tc.com;

/**
 * Created by punisher on 2017/3/1.
 * 常量类
 */

public class AppContents {
    public static final String API_BASE_URL = "http://hsm.oztechgroup.com/";
    public  static  final  String  TCTK ="5bbfd68e674314de6775c6efb3ee9d02";
    public static  String  FIRST_ENTER ="first_enter";

    /**
     * 用户token
     */
    public static  String USER_IDENT="user_ident";

    public static final int COUNT = 20;
    public static  String HEALTHY_TYPE = "1";

/**
 * 		"1": "文本框",
 "2": "单选框",
 "3": "打钩选项框"
 */

    public  static final  String BODY_CHECK_ATTR_TYPE_EDIT="1";
    public  static final  String BODY_CHECK_ATTR_TYPE_DAN="2";
    public  static final  String BODY_CHECK_ATTR_TYPE_GOU="3";



    /**
     * 		"1": "自己输入",
     "2": "专业人员输入",
     "3": "自己输入/专业人员输入",
     "4": "系统默认带出",
     "5": "系统默认带出,可手动修改",
     "6": "默认选是，如果否，关联属性"
     */
    public static final String BODY_CHECK_INPUT_TYPE_SELF = "1";
    public static final String BODY_CHECK_INPUT_TYPE_PROFESS = "2";
    public static final String BODY_CHECK_INPUT_TYPE_SELF_AND_PROFESS = "3";
    public static final String BODY_CHECK_INPUT_TYPE_SYSTEM = "4";
    public static final String BODY_CHECK_INPUT_TYPE_SESTEM_HAND = "5";
    public static final String BODY_CHECK_INPUT_TYPE_DEFAULT_CHECK = "6";


}
