package sport.tc.com.event;

import sport.tc.com.modle.ModifyUserResponse;

/**
 * Created by punisher on 2017/4/12.
 */

public class ModifyEvent {
    private ModifyUserResponse.DataBean.UserInfoBean  mUserInfoBean ;

    public ModifyEvent(ModifyUserResponse.DataBean.UserInfoBean userInfoBean) {
        mUserInfoBean = userInfoBean;
    }

    public ModifyUserResponse.DataBean.UserInfoBean getUserInfoBean() {
        return mUserInfoBean;
    }

    public void setUserInfoBean(ModifyUserResponse.DataBean.UserInfoBean userInfoBean) {
        mUserInfoBean = userInfoBean;
    }
}
