package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/17.
 */

public class LockHealthyDetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_healthy_detail);
        initRightTextToolBar(R.drawable.chronic_disease_back, "锁定健康目标", "说明", new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
    }
}
