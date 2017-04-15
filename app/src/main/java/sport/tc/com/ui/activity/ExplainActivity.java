package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/4/15.
 */

public class ExplainActivity  extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain_layout);
        initToolBar("说明",R.drawable.chronic_disease_back);

    }
}
