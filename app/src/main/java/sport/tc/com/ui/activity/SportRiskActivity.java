package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/13.
 * 运动风险评估  (暂时没有ui)
 */

public class SportRiskActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_risk);
        initRightTextToolBar(R.drawable.chronic_disease_back, "运动风险评估", "专家指导", new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
    }
}
