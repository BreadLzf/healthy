package sport.tc.com.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.customview.CircleMenuLayout;
import sport.tc.com.ui.activity.BodyCheckActivity;
import sport.tc.com.ui.activity.LockHealthyActivity;
import sport.tc.com.ui.activity.OpenHealthyRoadActivity;
import sport.tc.com.ui.activity.SlowillActivity;
import sport.tc.com.ui.activity.SportPrescribeActivity;
import sport.tc.com.ui.activity.SportRiskActivity;
import sport.tc.com.ui.base.BaseFragment;

//import healthy.tichuang.com.customview.HealthyCircleView;

/**
 * Created by punisher on 2017/3/1.
 */

public class HealthyMangerFragment extends BaseFragment {
    private View rootView;


    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[]{"慢性病评估", "运动风险评估", "体质健康评测",
            "锁定健康目标", "运动处方"};
    private int[] mItemImgs = new int[]{
            R.drawable.home_body_chronic, R.drawable.home_body_sport,
            R.drawable.home_body_healthy,
            R.drawable.home_body_lock, R.drawable.home_body_chu};


    public static HealthyMangerFragment newInstance() {
        return new HealthyMangerFragment();
    }

    @Override
    public String getUmengLabel() {
        return "healthy_manger";
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


    private void initView(final LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_healthy_mag_layout, container, false);
        initToolBar();
        mCircleMenuLayout = (CircleMenuLayout) rootView.findViewById(R.id.custom_view);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
        mCircleMenuLayout.setRotateDrawable(getResources().getDrawable(R.drawable.round));
        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                String itemStr = mItemTexts[pos];
                Intent intent;
                switch (itemStr) {
                    case "体质健康评测":
                        intent = new Intent(getActivity(), BodyCheckActivity.class);
                        startActivity(intent);
                        break;

                    case "慢性病评估":
                        intent = new Intent(getActivity(), SlowillActivity.class);
                        startActivity(intent);

                        break;

                    case "运动风险评估":
                        intent = new Intent(getActivity(), SportRiskActivity.class);
                        startActivity(intent);

                        break;

                    case "锁定健康目标":
                        intent = new Intent(getActivity(), LockHealthyActivity.class);
                        startActivity(intent);

                        break;

                    case "运动处方":
                        intent = new Intent(getActivity(), SportPrescribeActivity.class);
                        startActivity(intent);

                        break;
                }
//                Toast.makeText(getActivity(), mItemTexts[pos], Toast.LENGTH_SHORT).show();
            }

            Intent intent;

            @Override
            public void itemCenterClick(View view) {
                intent = new Intent(getActivity(), OpenHealthyRoadActivity.class);
                startActivity(intent);

            }
        });


    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.healthy_no_back_tool);
        TextView middle = (TextView) toolbar.findViewById(R.id.healthy_no_back_tool_title);
        TextView right = (TextView) toolbar.findViewById(R.id.healthy_no_back_tool_msg);
        toolbar.setBackgroundColor(Color.parseColor("#1adddf"));
        middle.setText("社区");
        right.setText("专家库");
        middle.setTextColor(Color.parseColor("#e5e5e5"));
        right.setTextColor(Color.parseColor("#e5e5e5"));
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ceshi", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
