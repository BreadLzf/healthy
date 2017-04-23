package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/23.
 */

public class ExpertDetailActivity extends BaseActivity implements View.OnClickListener {
    @Override
    public void onClick(View view) {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_detail_layout);
        initToolBar("专家详情", R.drawable.chronic_disease_back);
        initView();

    }


    private void initView() {

    }
}
