package sport.tc.com.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import butterknife.ButterKnife;
import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.ui.login.AuthorLoginActivity;
import sport.tc.com.util.SharedPerfercecesUtil;

public class SplashActivity extends BaseActivity {

    /**
     * 闪屏页面的事件
     */
    private final long NORMAL_TIME = 3000;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        final boolean isFirstEnter = SharedPerfercecesUtil.get(this, AppContents.FIRST_ENTER, true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
//                if (isFirstEnter){
//                    intent =new Intent(SplashActivity.this, IntroActivity.class);
//                }else{
//                    intent =new Intent(SplashActivity.this, HomeActivity.class);
//                }

                intent = new Intent(SplashActivity.this, AuthorLoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, NORMAL_TIME);
    }
}
