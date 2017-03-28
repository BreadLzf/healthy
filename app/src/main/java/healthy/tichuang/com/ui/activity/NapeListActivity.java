package healthy.tichuang.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/3/22.
 */

public class NapeListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nape_include_layout);
        String string = getIntent().getStringExtra("title");
        initToolBar(string, R.drawable.chronic_disease_back);
    }
}
