package sport.tc.com.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.customview.HealthyItem;
import sport.tc.com.ui.activity.ActiveActivity;
import sport.tc.com.ui.activity.FeedBackActivity;
import sport.tc.com.ui.activity.NapeListActivity;
import sport.tc.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 */

public class HealthyCircleFragment extends BaseFragment {


    public static HealthyCircleFragment newInstance() {
        return new HealthyCircleFragment();
    }

    @Override
    public String getUmengLabel() {
        return "healthy_circle";
    }


    private ViewGroup healthyContainer;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_healthy_circle, container, false);
        Activity context = getActivity();
        initToolBar(v);
        healthyContainer = (ViewGroup) v.findViewById(R.id.healthy_container);
        initView(context);
        return v;
    }

    private void initToolBar(View v) {
        Toolbar toolbar =(Toolbar) v.findViewById(R.id.healthy_only_title_toolbar);
        TextView middle =(TextView)toolbar.findViewById(R.id.healthy_only_title_toolbar_text);
        toolbar.setBackgroundColor(Color.parseColor("#1adddf"));
        middle.setText("社区");
        middle.setTextColor(Color.parseColor("#e5e5e5"));
    }



    private void initView(Activity context) {

        Intent  shouldIntent =new Intent( context,NapeListActivity.class);


        try {
            healthyContainer.addView(new HealthyItem(context, "颈部", "颈部简单描述", R.drawable.healthy_head, shouldIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            healthyContainer.addView(new HealthyItem(context, "肩部", "肩部简单描述", R.drawable.healthy_jian, shouldIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            healthyContainer.addView(new HealthyItem(context, "上肢", "上肢简单描述", R.drawable.healthy_hand, shouldIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            healthyContainer.addView(new HealthyItem(context, "足踝部", "足踝部简单描述", R.drawable.healhthy_foot, shouldIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Intent  activeIntent =new Intent(context, ActiveActivity.class);
            healthyContainer.addView(new HealthyItem(context, "活动", "活动描述", R.drawable.healthy_active, activeIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Intent  feedIntent =new Intent(context, FeedBackActivity.class);
            healthyContainer.addView(new HealthyItem(context, "意见反馈", "我们耐心倾听您的每一个反馈", R.drawable.healthy_feed, feedIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
