package healthy.tichuang.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
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
        ButterKnife.bind(this);
        initNoBackToolBar("个人信息", "保存", new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
    }
}
