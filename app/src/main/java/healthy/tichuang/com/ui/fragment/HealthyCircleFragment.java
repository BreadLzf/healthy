package healthy.tichuang.com.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.customview.HealthyItem;
import healthy.tichuang.com.ui.activity.NapeListActivity;
import healthy.tichuang.com.ui.base.BaseFragment;

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


    @Override
    protected void loadData() {
        if (!isPrepared || !isVisible()) {
            return;
        } else {
            Log.e("HealthyCircleFragment", "请求");
        }
    }


    private void initView(Activity context) {

        try {
            Intent napeIntent =new Intent(context, NapeListActivity.class);
            healthyContainer.addView(new HealthyItem(context, "颈部", "颈部简单描述", R.drawable.healthy_head, napeIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Intent  shouldIntent =new Intent( context,NapeListActivity.class);
            healthyContainer.addView(new HealthyItem(context, "肩部", "肩部简单描述", R.drawable.healthy_jian, shouldIntent, true));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        healthyContainer.addView(new HealthyItem(context, "上肢", "上肢简单描述", R.drawable.healthy_hand, intent, true));
//        healthyContainer.addView(new HealthyItem(context, "足踝部", "足踝部简单描述", R.drawable.healhthy_foot, intent, true));
//        healthyContainer.addView(new HealthyItem(context, "活动", "活动描述", R.drawable.healthy_active, intent, true));
//        healthyContainer.addView(new HealthyItem(context, "意见反馈", "我们耐心倾听您的每一个反馈", R.drawable.healthy_feed, intent, true));

    }
}
