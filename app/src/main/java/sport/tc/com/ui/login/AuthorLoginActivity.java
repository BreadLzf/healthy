package sport.tc.com.ui.login;

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
import sport.tc.com.AppContents;
import sport.tc.com.Intents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.Account;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.modle.ExecuteData;
import sport.tc.com.modle.LoginModel;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.ui.home.HomeActivity;
import sport.tc.com.util.AppHelper;
import sport.tc.com.util.GsonHelper;
import sport.tc.com.util.SharedPerfercecesUtil;
import sport.tc.com.util.ToastUtil;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

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

        login_forget_pass_tv.setOnClickListener(this);
        login_confrim_btn.setOnClickListener(this);


        //注册
        regist_phone_ed = (EditText) findViewById(R.id.register_phone_edit);
        regist_code_ed = (EditText) findViewById(R.id.register_code_edit);
        regist_code_tv = (TextView) findViewById(R.id.register_get_code_tv);
        regist_pass_ed = (EditText) findViewById(R.id.register_pass_edit);
        regist_confirm_btn = (Button) findViewById(R.id.register_confirm_btn);


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
            case R.id.register_confirm_btn:
                sendRegister();
                break;

            //获取短信码
            case R.id.register_get_code_tv:
                getCode();
                break;
        }
    }


    private void getCode() {

        String phone = regist_phone_ed.getText().toString().trim();
        if (phone.isEmpty()) {
            ToastUtil.show(AuthorLoginActivity.this, "手机号码不能为空");
            return;
        }

        if (!phone.isEmpty() && !AppHelper.isPhoneNumber(phone)) {
            ToastUtil.show(AuthorLoginActivity.this, "手机号码格式不正确");
            return;
        }

        if(!phone.isEmpty()&&AppHelper.isPhoneNumber(phone)){
            String oneStr = AppHelper.prouductValidData(this);
            ExecuteData executeData = new ExecuteData();
            executeData.phone = regist_phone_ed.getText().toString().trim();
            String twoStr = GsonHelper.javaBeanToJson(executeData);

            Novate novate = new Novate.Builder(AuthorLoginActivity.this).baseUrl(AppContents.API_BASE_URL).build();
            HealthyApiService apiService = novate.create(HealthyApiService.class);

            novate.call(apiService.messageCodeAPI(oneStr, twoStr), new BaseSubscriber<BaseResponse>(this) {
                @Override
                public void onError(Throwable e) {
                    ToastUtil.show(AuthorLoginActivity.this, e.getMessage());

                }

                @Override
                public void onNext(BaseResponse testBean) {
                    ToastUtil.show(AuthorLoginActivity.this, testBean.msg + "");
                }
            });
        }

    }

    /**
     * 发起登录请求
     */
    private void phoneLogin() {
        String phoneStr = login_phone_ed.getText().toString();
        String passStr = login_pass_ed.getText().toString();
        if (phoneStr.isEmpty()) {
            ToastUtil.show(AuthorLoginActivity.this, "手机号码不能为空");
            return;
        }
        if (passStr.isEmpty()) {
            ToastUtil.show(AuthorLoginActivity.this, "密码不能为空");
        }
        if (!phoneStr.isEmpty() && !AppHelper.isPhoneNumber(phoneStr)) {
            ToastUtil.show(AuthorLoginActivity.this, "手机号码格式不正确");
            return;
        }

        if (!phoneStr.isEmpty()&&AppHelper.isPhoneNumber(phoneStr)&&!passStr.isEmpty()){
            String oneStr = AppHelper.prouductValidData(this);
            LoginModel login = new LoginModel();
            login.setLogin_name(phoneStr);
            login.setPassword(passStr);
            String twoStr = javaBeanToJson(login);

            Novate novate = new Novate.Builder(AuthorLoginActivity.this).baseUrl(AppContents.API_BASE_URL).build();
            HealthyApiService apiService = novate.create(HealthyApiService.class);
            novate.call(apiService.loginApi(oneStr, twoStr), new BaseSubscriber<Account>(this) {
                @Override
                public void onError(Throwable e) {
                    ToastUtil.show(AuthorLoginActivity.this, e.getMessage());

                }

                @Override
                public void onNext(Account account) {
                    if (account != null && account.getCode().equals("000")) {
                        Log.e("token","token>>>"+account.getData().getUser_identity());
                        SharedPerfercecesUtil.put(AuthorLoginActivity.this,AppContents.USER_IDENT,account.getData().getUser_identity());
                        Intent intent = new Intent(AuthorLoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                    }
                }
            });
        }
    }


    private void sendRegister() {
        String phoneStr = regist_phone_ed.getText().toString();
        String codeStr = regist_code_ed.getText().toString();
        String passStr = regist_pass_ed.getText().toString();

        if (phoneStr.isEmpty()) {
            ToastUtil.show(AuthorLoginActivity.this, "手机号码不能为空");
            return;
        }
        if (!phoneStr.isEmpty() && !AppHelper.isPhoneNumber(phoneStr)) {
            ToastUtil.show(AuthorLoginActivity.this, "手机号码格式不正确");
            return;
        }

        if (codeStr.isEmpty()) {
            ToastUtil.show(AuthorLoginActivity.this, "验证码不能为空");
            return;
        }

        if (!codeStr.isEmpty() && codeStr.length() < 3) {
            ToastUtil.show(AuthorLoginActivity.this, "验证码格式不正确");
            return;
        }

        if (passStr.isEmpty()) {
            ToastUtil.show(AuthorLoginActivity.this, "密码不能为空");
            return;
        }


        if (!passStr.isEmpty()&&!phoneStr.isEmpty()&&AppHelper.isPhoneNumber(phoneStr)){
            String oneStr = AppHelper.prouductValidData(this);
            ExecuteData login = new ExecuteData();
            login.login_name = phoneStr;
            login.password = passStr;
            login.vcode = codeStr;
            String twoStr = javaBeanToJson(login);

            Novate novate = new Novate.Builder(AuthorLoginActivity.this)
                    .baseUrl(AppContents.API_BASE_URL)
                    .build();
            HealthyApiService apiService = novate.create(HealthyApiService.class);

            novate.call(apiService.registerApi(oneStr, twoStr), new BaseSubscriber<BaseResponse>(this) {
                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(BaseResponse testBean) {

                }
            });
        }
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
        }
    }
}
