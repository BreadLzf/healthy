package sport.tc.com.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.ui.activity.ModifyUserActivity;
import sport.tc.com.ui.activity.MyCollectActivity;
import sport.tc.com.ui.activity.MyExpertActivity;
import sport.tc.com.ui.activity.MyHealthyFamilyActivity;
import sport.tc.com.ui.activity.MyHealthyMangerActivity;
import sport.tc.com.ui.activity.MyNewsActivity;
import sport.tc.com.ui.activity.MyReserveActivity;
import sport.tc.com.ui.activity.MySettingActivity;
import sport.tc.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 */

public class UserCenterFragment extends BaseFragment implements View.OnClickListener {

    private ImageView mEditBtn;
    private View rootView;
    private RelativeLayout healthyFamilyLayout;
    private RelativeLayout healthyMangerLayout;
    private RelativeLayout healthyCollectLayout;
    private RelativeLayout healthyExpertLayout;
    private RelativeLayout healthyReservationLayout;//预约
    private RelativeLayout healthyNewsLayout;
    private RelativeLayout healthySettingLayout;

    private Activity mActivity;


    public static UserCenterFragment newInstance() {
        return new UserCenterFragment();
    }


    @Override
    public String getUmengLabel() {
        return "user_center";
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mActivity = getActivity();
        initView(inflater, container);
        initClick();
        loadData();
        return rootView;
    }


    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_user_center, container, false);
        mEditBtn = (ImageView) rootView.findViewById(R.id.user_center_to_edit_btn);
        mEditBtn.setOnClickListener(this);

        healthyFamilyLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_family_layout);
        healthyMangerLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_manger_layout);
        healthyCollectLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_collect_layout);
        healthyExpertLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_expert_layout);
        healthyReservationLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_reserve_layout);
        healthyNewsLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_news_layout);
        healthySettingLayout = (RelativeLayout) rootView.findViewById(R.id.user_center_setting_layout);


    }


    private void initClick() {
        healthyFamilyLayout.setOnClickListener(this);
        healthyMangerLayout.setOnClickListener(this);
        healthyCollectLayout.setOnClickListener(this);
        healthyExpertLayout.setOnClickListener(this);
        healthyReservationLayout.setOnClickListener(this);
        healthyNewsLayout.setOnClickListener(this);
        healthySettingLayout.setOnClickListener(this);
    }


    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.user_center_to_edit_btn:
                intent = new Intent(mActivity, ModifyUserActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_family_layout:
                intent = new Intent(mActivity, MyHealthyFamilyActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_manger_layout:
                intent = new Intent(mActivity, MyHealthyMangerActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_collect_layout:
                intent = new Intent(mActivity, MyCollectActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_expert_layout:
                intent = new Intent(mActivity,MyExpertActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_reserve_layout:
                intent = new Intent(mActivity, MyReserveActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_news_layout:
                intent = new Intent(mActivity, MyNewsActivity.class);
                startActivity(intent);
                break;


            case R.id.user_center_setting_layout:
                intent = new Intent(mActivity, MySettingActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void loadData() {
        if (!isPrepared || isVisible()) {
            return;
        } else {
            Log.e("UserCenterFragment", "请求");
        }
    }
}
