package healthy.tichuang.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/3/2.
 */

public class ModifyUserActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);
        initToolBar("个人信息",R.drawable.chronic_disease_back);

    }
}
