package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/13.
 * 开启健康之路 ui暂时不做
 */

public class OpenHealthyRoadActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_healthy);
        initRightTextToolBar(R.drawable.chronic_disease_back, "开启健康之路", "说明", new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
    }
}
