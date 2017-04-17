package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/17.
 */

public class SportHealthyWorkActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //do_home_work_item
        setContentView(R.layout.activity_sport_work_layout);
        initToolBar("开始作业",R.drawable.chronic_disease_back);
    }
}
