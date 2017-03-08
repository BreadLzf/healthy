package healthy.tichuang.com.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import healthy.tichuang.com.AppContents;
import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseActivity;
import healthy.tichuang.com.ui.home.HomeActivity;
import healthy.tichuang.com.util.SharedPerfercecesUtil;

public class SplashActivity extends BaseActivity {
    /**
     * 闪屏页面的事件
     */
    private final long  NORMAL_TIME = 3000;
    private Handler  handler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final boolean isFirstEnter = SharedPerfercecesUtil.get(this, AppContents.FIRST_ENTER, true);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent  intent;
//                if (isFirstEnter){
//                    intent =new Intent(SplashActivity.this, IntroActivity.class);
//                }else{
//                    intent =new Intent(SplashActivity.this, HomeActivity.class);
//                }

                intent =new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },NORMAL_TIME);
    }
}
