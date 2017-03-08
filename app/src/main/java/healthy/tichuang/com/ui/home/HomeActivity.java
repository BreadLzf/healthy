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

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.api.HealthyApi;
import healthy.tichuang.com.encryptutil.MD5Encrypt;
import healthy.tichuang.com.modle.ExecuteData;
import healthy.tichuang.com.modle.TestBean;
import healthy.tichuang.com.modle.ValidData;
import healthy.tichuang.com.ui.base.BaseActivity;
import healthy.tichuang.com.ui.fragment.HealthyCircleFragment;
import healthy.tichuang.com.ui.fragment.HealthyMangerFragment;
import healthy.tichuang.com.ui.fragment.HomePageFragment;
import healthy.tichuang.com.ui.fragment.SportRecoverFragment;
import healthy.tichuang.com.ui.fragment.UserCenterFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by punisher on 2017/2/28.
 * 所有fragment的管理类 HomeActivity
 */

public class HomeActivity extends BaseActivity implements View.OnClickListener {
    private static String TAG = "HomeActivity";
    private HealthyApi healthyApi =HealthyApi.getInstance();

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
        testUrl();

    }

    private void initClick() {
        home_page_layout.setOnClickListener(this);
        healthy_manger_layout.setOnClickListener(this);
        sport_recover_layout.setOnClickListener(this);
        healthy_circlr_layout.setOnClickListener(this);
        user_center_layout.setOnClickListener(this);
    }


    private void initData() {

        selectColor = getResources().getColor(R.color.grey);
        unSelectColor = getResources().getColor(R.color.read_random_widget_bg);

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
                home_page_image.setImageResource(R.mipmap.ic_launcher);
                home_page_tv.setTextColor(selectColor);
                break;
            case 1:
                healthy_manger_image.setImageResource(R.mipmap.ic_launcher);
                healthy_manger_tv.setTextColor(selectColor);
                break;
            case 2:
                sport_recover_image.setImageResource(R.mipmap.ic_launcher);
                sport_recover_tv.setTextColor(selectColor);
                break;
            case 3:
                healthy_circle_image.setImageResource(R.mipmap.ic_launcher);
                healthy_circle_tv.setTextColor(selectColor);
                break;

            case 4:
                user_center_image.setImageResource(R.mipmap.ic_launcher);
                user_center_tv.setTextColor(selectColor);
                break;
        }
    }


    public void resetColor() {
        home_page_image.setImageResource(R.mipmap.ic_launcher);
        healthy_manger_image.setImageResource(R.mipmap.ic_launcher);
        sport_recover_image.setImageResource(R.mipmap.ic_launcher);
        healthy_circle_image.setImageResource(R.mipmap.ic_launcher);
        user_center_image.setImageResource(R.mipmap.ic_launcher);
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
         Call<TestBean>  call =healthyApi.testApi(validStr, execuStr);
        call.enqueue(new Callback<TestBean>() {
            @Override
            public void onResponse(Call<TestBean> call, Response<TestBean> response) {
                TestBean testBean =response.body();
                Log.e("onResponse","msg"+testBean.msg);
              ;
                Log.e("onResponse","json"+  gson.toJson(response.body()));

            }

            @Override
            public void onFailure(Call<TestBean> call, Throwable t) {

            }
        });

    }

}

