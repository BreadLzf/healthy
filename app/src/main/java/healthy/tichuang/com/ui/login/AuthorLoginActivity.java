package healthy.tichuang.com.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import butterknife.ButterKnife;
import healthy.tichuang.com.AppContents;
import healthy.tichuang.com.Intents;
import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.api.HealthyApiService;
import healthy.tichuang.com.encryptutil.MD5Encrypt;
import healthy.tichuang.com.modle.BaseResponse;
import healthy.tichuang.com.modle.ExecuteData;
import healthy.tichuang.com.modle.LoginModel;
import healthy.tichuang.com.modle.ValidData;
import healthy.tichuang.com.ui.base.BaseActivity;
import healthy.tichuang.com.util.GsonHelper;
import healthy.tichuang.com.util.ToastUtil;

/**
 * Created by punisher on 2017/3/1.
 */

public class AuthorLoginActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout loginLayout;
    private RelativeLayout third_login_layout;
    private TextView loginTv;
    private TextView regiestTv;
    private ImageView loginHeadImg;
    private LinearLayout registertLayout;

    //登录需要用的控件
    private EditText login_phone_ed;
    private EditText login_pass_ed;
    private Button login_confrim_btn;
    private TextView login_forget_pass_tv;


    //注册需要用到的控件
    private EditText regist_phone_ed;
    private EditText regist_code_ed;
    private TextView regist_code_tv;
    private EditText regist_pass_ed;
    private Button regist_confirm_btn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        MyTextWatcher watcher = new MyTextWatcher();
        loginTv = (TextView) findViewById(R.id.login_tv);
        regiestTv = (TextView) findViewById(R.id.register_tv);
        loginTv.setOnClickListener(this);
        regiestTv.setOnClickListener(this);
        loginLayout = (LinearLayout) findViewById(R.id.login_layout);
        registertLayout = (LinearLayout) findViewById(R.id.register_layout);
        third_login_layout = (RelativeLayout) findViewById(R.id.login_third_layout);
        third_login_layout.setVisibility(View.VISIBLE);
        loginHeadImg = (ImageView) findViewById(R.id.login_head_img);


        //登录
        login_phone_ed = (EditText) findViewById(R.id.login_phone_edit);
        login_pass_ed = (EditText) findViewById(R.id.login_pass_edit);
        login_confrim_btn = (Button) findViewById(R.id.login_confirm_btn);
        login_forget_pass_tv = (TextView) findViewById(R.id.login_forget_pass_tv);
        login_phone_ed.addTextChangedListener(watcher);
        login_pass_ed.addTextChangedListener(watcher);
        login_forget_pass_tv.setOnClickListener(this);
        login_confrim_btn.setOnClickListener(this);


        //注册
        regist_phone_ed = (EditText) findViewById(R.id.register_phone_edit);
        regist_code_ed = (EditText) findViewById(R.id.register_code_edit);
        regist_code_tv = (TextView) findViewById(R.id.register_get_code_tv);
        regist_pass_ed = (EditText) findViewById(R.id.register_pass_edit);
        regist_confirm_btn = (Button) findViewById(R.id.register_confirm_btn);

        regist_phone_ed.addTextChangedListener(watcher);
        regist_code_ed.addTextChangedListener(watcher);
        regist_pass_ed.addTextChangedListener(watcher);

        regist_confirm_btn.setOnClickListener(this);
        regist_code_tv.setOnClickListener(this);

    }


    public static Intent createIntent(Context context) {
        return new Intents.Builder().setClass(context, AuthorLoginActivity.class).toIntent();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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


            // 忘记密码
            case R.id.login_forget_pass_tv:

                break;

            //确认登录
            case R.id.login_confirm_btn:
                phoneLogin();
                break;

            //注册
            case   R.id.register_confirm_btn:
                sendRegister();
                break;

            //获取短信码
            case R.id.register_get_code_tv:

                break;
        }
    }

    /**
     * 发起登录请求
     */
    private void phoneLogin() {
        String phoneStr = login_phone_ed.getText().toString();
        String passStr = login_pass_ed.getText().toString();


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5("1486954192"));
        stringBuffer.append("5bbfd68e674314de6775c6efb3ee9d02");
        String token = MD5Encrypt.md5(stringBuffer.toString());

        ValidData validData = new ValidData();
        validData.time = "1486954192";
        validData.token = token;
        String oneStr = GsonHelper.javaBeanToJson(validData);


        LoginModel login = new LoginModel();
        login.setLogin_name("18641371890");
        login.setPassword("123456");
        String twoStr = GsonHelper.javaBeanToJson(login);





        Novate novate = new Novate.Builder(AuthorLoginActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.loginApi(oneStr, twoStr), new BaseSubscriber<BaseResponse>(this) {
            @Override
            public void onError(Throwable e) {
                ToastUtil.show(AuthorLoginActivity.this,e.getMessage());

            }

            @Override
            public void onNext(BaseResponse testBean) {
                ToastUtil.show(AuthorLoginActivity.this,testBean.msg+"");
            }
        });


//        novate.executePost("/api/user-login",map,new  Novate.ResponseCallBack< BaseResponse>(){
//            @Override
//            public void onStart() {
//
//            }
//
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onSuccee(BaseResponse response) {
//
//            }
//        });

    }


    private void sendRegister() {
        String phoneStr = regist_phone_ed.getText().toString();
        String codeStr = regist_code_ed.getText().toString();
        String passStr =regist_pass_ed.getText().toString();


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5("1486954192"));
        stringBuffer.append("23ce786d7846b95e9f14cc3391147e5e");
        String token = MD5Encrypt.md5(stringBuffer.toString());

        ValidData validData = new ValidData();
        validData.time = "1486954192";
        validData.token = token;
        String oneStr = GsonHelper.javaBeanToJson(validData);


        ExecuteData login = new ExecuteData();
        login.login_name="沈洪浪";
        login.password="123456";
        login.vcode="1234";
        String twoStr = GsonHelper.javaBeanToJson(login);

        Novate novate = new Novate.Builder(AuthorLoginActivity.this)
                .baseUrl(AppContents.API_BASE_URL)
                .build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);

        novate.call(apiService.registerApi(oneStr, twoStr), new BaseSubscriber<BaseResponse>(this) {
            @Override
            public void onError(Throwable e) {
                ToastUtil.show(AuthorLoginActivity.this,e.getMessage());

            }

            @Override
            public void onNext(BaseResponse testBean) {
                ToastUtil.show(AuthorLoginActivity.this,testBean.msg+"");

                Log.e("skay 注册db", "db" + testBean.msg + "<code>" + testBean.code);
            }
        });



    }


    class MyTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean login_userName = login_phone_ed.getEditableText().toString().trim().length() > 0;
            boolean login_password = login_pass_ed.getEditableText().toString().trim().length() > 0;
            if (login_userName && login_password) {
                login_confrim_btn.setEnabled(true);
            } else {
                login_confrim_btn.setEnabled(false);
            }

            boolean regist_phone = regist_phone_ed.getEditableText().toString().trim().length() > 0;
            boolean regist_code = regist_code_ed.getEditableText().toString().trim().length() > 0;
            boolean regist_pass = regist_pass_ed.getEditableText().toString().trim().length() > 0;

            if (regist_phone&&regist_code&&regist_pass){
                regist_confirm_btn.setEnabled(true);
            }else{
                regist_confirm_btn.setEnabled(false);
            }
        }
    }


}
