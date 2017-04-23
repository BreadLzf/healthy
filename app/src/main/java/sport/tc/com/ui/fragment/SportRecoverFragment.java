package sport.tc.com.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.modle.ExpertDetailRequest;
import sport.tc.com.modle.ExpertDetailResponse;
import sport.tc.com.modle.SportWorkRequest;
import sport.tc.com.ui.activity.SportHealthyWorkActivity;
import sport.tc.com.ui.base.BaseFragment;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/3/1.
 * 运动康复
 */

public class SportRecoverFragment extends BaseFragment implements View.OnClickListener {
    private View rootView;
    private RelativeLayout workLayout;

    public static SportRecoverFragment newInstance() {
        return new SportRecoverFragment();
    }

    @Override
    public String getUmengLabel() {
        return "sport_recover";
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initView(inflater, container);

        return rootView;
    }


    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_sport_layout, container, false);
        workLayout = (RelativeLayout) rootView.findViewById(R.id.sport_work_layout);
        workLayout.setOnClickListener(this);
//        initToolBar();
        getWorkList();
        getExpertDetail();

    }


    private void initToolBar() {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.healthy_sport_tool);
        final TextView middle = (TextView) toolbar.findViewById(R.id.healthy_sport_tool_first);
        final TextView right = (TextView) toolbar.findViewById(R.id.healthy_sport_tool_again);
        final LinearLayout middlelayout = (LinearLayout) toolbar.findViewById(R.id.healthy_sport_tool_first_layout);
        final LinearLayout rightlayout = (LinearLayout) toolbar.findViewById(R.id.healthy_sport_tool_again_layout);

        toolbar.setBackgroundColor(Color.parseColor("#1adddf"));
        middle.setText("初诊");
        right.setText("复诊");

        middle.setTextColor(Color.parseColor("#1adddf"));
        right.setTextColor(Color.parseColor("#ffffff"));

        middle.setBackgroundResource(R.drawable.healthy_one_white_shape);
        right.setBackgroundResource(R.drawable.healthy_two_shape);
        middle.setTextColor(Color.parseColor("#1adddf"));
        right.setTextColor(Color.parseColor("#ffffff"));

        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "初诊", Toast.LENGTH_SHORT).show();
                middle.setBackgroundResource(R.drawable.healthy_one_white_shape);
                right.setBackgroundResource(R.drawable.healthy_two_shape);
                middle.setTextColor(Color.parseColor("#1adddf"));
                right.setTextColor(Color.parseColor("#ffffff"));


            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "复诊", Toast.LENGTH_SHORT).show();
                middle.setBackgroundResource(R.drawable.healthy_one_shape);
                right.setBackgroundResource(R.drawable.healthy_two_white_shape);

                middle.setTextColor(Color.parseColor("#ffffff"));
                right.setTextColor(Color.parseColor("#1adddf"));


            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sport_work_layout:
                Intent intent = new Intent(getActivity(), SportHealthyWorkActivity.class);
                startActivity(intent);
                break;
        }
    }


    private void getWorkList() {
        String validData = AppHelper.prouductValidData(getActivity());
        SportWorkRequest sportWorkRequest = new SportWorkRequest();
        sportWorkRequest.setOrder_id("2");

        String executeData = javaBeanToJson(sportWorkRequest);

        Novate novate = new Novate.Builder(getActivity()).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverWorkApi(validData, executeData), new BaseSubscriber<BaseResponse>(getActivity()) {


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse baseResponse) {

            }
        });
    }


    private void getExpertDetail() {
        String validData = AppHelper.prouductValidData(getActivity());
        ExpertDetailRequest expertDeatilRequest = new ExpertDetailRequest();
        expertDeatilRequest.setExpert_id("2");
        String executeData = javaBeanToJson(expertDeatilRequest);

        Novate novate = new Novate.Builder(getActivity()).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverExperDetailtApi(validData, executeData), new BaseSubscriber<ExpertDetailResponse>(getActivity()) {


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ExpertDetailResponse expertDetailResponse) {

            }
        });
    }
}
