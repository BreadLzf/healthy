package healthy.tichuang.com.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import java.util.HashMap;

import healthy.tichuang.com.AppContents;
import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.encryptutil.MD5Encrypt;
import healthy.tichuang.com.modle.BaseResponse;
import healthy.tichuang.com.modle.ExecuteData;
import healthy.tichuang.com.modle.ValidData;
import healthy.tichuang.com.ui.base.BaseActivity;
import healthy.tichuang.com.ui.fragment.HealthyCircleFragment;
import healthy.tichuang.com.ui.fragment.HealthyMangerFragment;
import healthy.tichuang.com.ui.fragment.HomePageFragment;
import healthy.tichuang.com.ui.fragment.SportRecoverFragment;
import healthy.tichuang.com.ui.fragment.UserCenterFragment;
import healthy.tichuang.com.util.AppHelper;
import healthy.tichuang.com.util.GsonHelper;

/**
 * Created by punisher on 2017/2/28.
 * 所有fragment的管理类 HomeActivity
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private static String TAG = "HomeActivity";

    private RelativeLayout home_page_layout;
    private RelativeLayout healthy_manger_layout;
    private RelativeLayout sport_recover_layout;
    private RelativeLayout healthy_circlr_layout;


    private RelativeLayout user_center_layout;

    private ImageView home_page_image;
    private ImageView healthy_manger_image;
    private ImageView sport_recover_image;
    private ImageView healthy_circle_image;
    private ImageView user_center_image;

    private TextView home_page_tv;
    private TextView healthy_manger_tv;
    private TextView sport_recover_tv;
    private TextView healthy_circle_tv;
    private TextView user_center_tv;


    private Fragment[] fragments;
    private int currentIndex;
    private int index;

    private int selectColor;
    private int unSelectColor;
    private  Gson mGson =new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

    }


    private void initView() {
        home_page_layout = (RelativeLayout) findViewById(R.id.layout_home_page);
        healthy_manger_layout = (RelativeLayout) findViewById(R.id.layout_health_manger);
        sport_recover_layout = (RelativeLayout) findViewById(R.id.layout_sport_recover);
        healthy_circlr_layout = (RelativeLayout) findViewById(R.id.layout_health_circle);
        user_center_layout = (RelativeLayout) findViewById(R.id.layout_user_center);

        home_page_image = (ImageView) findViewById(R.id.img_home_page);
        healthy_manger_image = (ImageView) findViewById(R.id.img_health_manger);
        sport_recover_image = (ImageView) findViewById(R.id.img_sport_recover);
        healthy_circle_image = (ImageView) findViewById(R.id.img_health_circle);
        user_center_image = (ImageView) findViewById(R.id.img_user_center);

        home_page_tv = (TextView) findViewById(R.id.tv_home_page);
        healthy_manger_tv = (TextView) findViewById(R.id.tv_health_manger);
        sport_recover_tv = (TextView) findViewById(R.id.tv_sport_recover);
        healthy_circle_tv = (TextView) findViewById(R.id.tv_health_circle);
        user_center_tv = (TextView) findViewById(R.id.tv_user_center);
        initClick();
        initData();
//        testUrl();
//        getmessagecode();
//        register();

    }

    private void initClick() {
        home_page_layout.setOnClickListener(this);
        healthy_manger_layout.setOnClickListener(this);
        sport_recover_layout.setOnClickListener(this);
        healthy_circlr_layout.setOnClickListener(this);
        user_center_layout.setOnClickListener(this);
    }


    private void initData() {
        selectColor = getResources().getColor(R.color.login_base_color);
        unSelectColor = getResources().getColor(R.color.grey);

        String[] tagString = {"home_page", "healthy_manger", "sport_recover", "healthy_circle", "user_center"};
        fragments = new Fragment[5];
        fragments[0] = getHomePageFragment(tagString[0]);
        fragments[1] = getHealthyMangerFragment(tagString[1]);
        fragments[2] = getSportRecoverFragment(tagString[2]);
        fragments[3] = getHealthyCircleFragment(tagString[3]);
        fragments[4] = getUserCenterFragment(tagString[4]);
        getSupportFragmentManager().beginTransaction().add(R.id.main_content, fragments[0]).commit();

    }


    public HomePageFragment getHomePageFragment(String tag) {
        HomePageFragment fragment = (HomePageFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            Log.e(TAG, "HomePageFragment ");
            fragment = HomePageFragment.newInstance();
        }
        return fragment;
    }

    public HealthyMangerFragment getHealthyMangerFragment(String tag) {
        HealthyMangerFragment fragment = (HealthyMangerFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            Log.e(TAG, "HealthyMangerFragment ");
            fragment = HealthyMangerFragment.newInstance();
        }
        return fragment;
    }


    public SportRecoverFragment getSportRecoverFragment(String tag) {
        SportRecoverFragment fragment = (SportRecoverFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            Log.e(TAG, "SportRecoverFragment ");
            fragment = SportRecoverFragment.newInstance();
        }
        return fragment;
    }


    public HealthyCircleFragment getHealthyCircleFragment(String tag) {
        HealthyCircleFragment fragment = (HealthyCircleFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            Log.e(TAG, "HealthyCircleFragment ");
            fragment = HealthyCircleFragment.newInstance();
        }
        return fragment;
    }


    public UserCenterFragment getUserCenterFragment(String tag) {
        UserCenterFragment fragment = (UserCenterFragment) getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            Log.e(TAG, "UserCenterFragment ");
            fragment = UserCenterFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_home_page:
                index = 0;
                setTabs(index);
                break;
            case R.id.layout_health_manger:
                index = 1;
                setTabs(index);
                break;
            case R.id.layout_sport_recover:
                index = 2;
                setTabs(index);
                break;
            case R.id.layout_health_circle:
                index = 3;
                setTabs(index);
                break;
            case R.id.layout_user_center:
                index = 4;
                setTabs(index);
                break;

        }
        if (currentIndex != index) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.hide(fragments[currentIndex]);
            if (!fragments[index].isAdded()) {
                ft.add(R.id.main_content, fragments[index]);
            }
            ft.show(fragments[index]).commit();
        }
        currentIndex = index;
    }


    public void setTabs(int pos) {
        resetColor();
        switch (pos) {
            case 0:
                home_page_image.setImageResource(R.drawable.home_first_light);
                home_page_tv.setTextColor(selectColor);
                break;
            case 1:
                healthy_manger_image.setImageResource(R.drawable.home_manger_light);
                healthy_manger_tv.setTextColor(selectColor);
                break;
            case 2:
                sport_recover_image.setImageResource(R.drawable.home_sport_light);
                sport_recover_tv.setTextColor(selectColor);
                break;
            case 3:
                healthy_circle_image.setImageResource(R.drawable.home_circle_light);
                healthy_circle_tv.setTextColor(selectColor);
                break;

            case 4:
                user_center_image.setImageResource(R.drawable.home_person_light);
                user_center_tv.setTextColor(selectColor);
                break;
        }
    }


    public void resetColor() {
        home_page_image.setImageResource(R.drawable.home_first_normal);
        healthy_manger_image.setImageResource(R.drawable.home_manger_normal);
        sport_recover_image.setImageResource(R.drawable.home_sport_normal);
        healthy_circle_image.setImageResource(R.drawable.home_circle_normal);
        user_center_image.setImageResource(R.drawable.home_person_normal);
        home_page_tv.setTextColor(unSelectColor);
        healthy_manger_tv.setTextColor(unSelectColor);
        sport_recover_tv.setTextColor(unSelectColor);
        healthy_circle_tv.setTextColor(unSelectColor);
        user_center_tv.setTextColor(unSelectColor);

    }

    private void testUrl() {
        final Gson gson = new Gson();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5("1486954192"));
        stringBuffer.append("5bbfd68e674314de6775c6efb3ee9d02");
        String token = MD5Encrypt.md5(stringBuffer.toString());

        ValidData validData = new ValidData();
        validData.time = "1486954192";
        validData.token = token;


        ExecuteData executeData = new ExecuteData();
        executeData.user_name = "沉洪浪";
        executeData.password = "123456";

        String validStr = gson.toJson(validData);
        String execuStr = gson.toJson(executeData);


    }


    private void getmessagecode() {
       String  validData =AppHelper.formatRequestValidData("");

        ExecuteData executeData = new ExecuteData();
        executeData.phone = "1383838438";

        String validStr = GsonHelper.javaBeanToJson(validData);
        String execuStr = GsonHelper.javaBeanToJson(executeData);



    }


    private void register() {
        final Gson gson = new Gson();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MD5Encrypt.md5("1486954192"));
        stringBuffer.append("23ce786d7846b95e9f14cc3391147e5e");
        String token = MD5Encrypt.md5(stringBuffer.toString());

        ValidData validData = new ValidData();
        validData.time = "1486954192";
        validData.token = token;


        ExecuteData executeData = new ExecuteData();
        executeData.login_name = "18951623490";
        executeData.password = "123456";
        executeData.vcode = "1234";

        String validStr = gson.toJson(validData);
        String execuStr = gson.toJson(executeData);




        Novate novate = new Novate.Builder(this)
                .baseUrl(AppContents.API_BASE_URL)
                .build();
        HashMap  m  = new HashMap();
        novate.executePost("",  m ,new Novate.ResponseCallBack<BaseResponse>(){


            @Override
            public void onStart() {

            }

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.getCode();

            }

            @Override
            public void onSuccee(BaseResponse response) {

            }
        });












//        Call<BaseResponse> call = healthyApi.register(validStr, execuStr);
//        call.enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//                BaseResponse testBean = response.body();
//                Log.e("onResponse", "json" + gson.toJson(response.body()));
//                Toast.makeText(HomeActivity.this, "json", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//
//            }
//        });
    }



   private   void testSkay(){

   }

}

