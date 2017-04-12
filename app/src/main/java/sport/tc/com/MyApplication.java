package sport.tc.com;

import android.app.Application;

import sport.tc.com.modle.ModifyUserResponse;

/**
 * Created by punisher on 2017/3/1.
 *
 */

public class MyApplication  extends Application {
    private static MyApplication appInstance = null;
    private ModifyUserResponse.DataBean.UserInfoBean  mUserInfoBean;


    @Override
    public void onCreate() {
        super.onCreate();
        appInstance=this;
    }



    public static MyApplication getAppInstance() {
        return appInstance;
    }

    public static void setAppInstance(MyApplication appInstance) {
        MyApplication.appInstance = appInstance;
    }

    public ModifyUserResponse.DataBean.UserInfoBean getUserInfoBean() {
        return mUserInfoBean;
    }

    public void setUserInfoBean(ModifyUserResponse.DataBean.UserInfoBean userInfoBean) {
        mUserInfoBean = userInfoBean;
    }
}
