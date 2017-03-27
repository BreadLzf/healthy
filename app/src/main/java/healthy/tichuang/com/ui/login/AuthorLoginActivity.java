package healthy.tichuang.com.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import healthy.tichuang.com.Intents;
import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/3/1.
 */

public class AuthorLoginActivity extends BaseActivity  implements View.OnClickListener {

    private LinearLayout loginLayout;
    private RelativeLayout third_login_layout;
    private TextView  loginTv;
    private TextView  regiestTv;
    private ImageView loginHeadImg;
    private LinearLayout registertLayout;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private  void  initView(){
        loginTv=(TextView)findViewById(R.id.login_tv);
        regiestTv =(TextView)findViewById(R.id.register_tv);
        loginTv.setOnClickListener(this);
        regiestTv.setOnClickListener(this);
        loginLayout =(LinearLayout)findViewById(R.id.login_layout);
        registertLayout =(LinearLayout)findViewById(R.id.register_layout);
        third_login_layout =(RelativeLayout)findViewById(R.id.login_third_layout);
        third_login_layout.setVisibility(View.VISIBLE);
        loginHeadImg =(ImageView)findViewById(R.id.login_head_img);


    }


    public static Intent createIntent(Context context) {
        return new Intents.Builder().setClass(context, AuthorLoginActivity.class).toIntent();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_tv:
                third_login_layout.setVisibility(View.VISIBLE);
                loginLayout.setVisibility(View.VISIBLE);
                registertLayout.setVisibility(View.GONE);
                loginHeadImg.setImageResource(R.drawable.login_person_icon);

                break;

            case R.id.register_tv:
                loginLayout.setVisibility(View.GONE);
                third_login_layout.setVisibility(View.INVISIBLE);
                registertLayout.setVisibility(View.VISIBLE);
                loginHeadImg.setImageResource(R.drawable.login_regist_head);
                break;
        }

    }
}
