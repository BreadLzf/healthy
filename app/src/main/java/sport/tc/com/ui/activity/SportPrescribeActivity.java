package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/13.
 * 运动处方
 */

public class SportPrescribeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_precsribe_layout);
        initRightTextToolBar(R.drawable.chronic_disease_back, "运动处方", "专家指导", new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });


    }
}
