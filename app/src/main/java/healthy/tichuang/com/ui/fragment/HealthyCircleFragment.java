package healthy.tichuang.com.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.customview.HealthyItem;
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
        healthyContainer = (ViewGroup) v.findViewById(R.id.healthy_container);
        Activity context = getActivity();
        initView(context);
        return v;
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
        Intent intent = null;
        healthyContainer.addView(new HealthyItem(context, "颈部", "颈部简单描述", R.drawable.healthy_head, intent, true));
        healthyContainer.addView(new HealthyItem(context, "肩部", "肩部简单描述", R.drawable.healthy_jian, intent, true));
        healthyContainer.addView(new HealthyItem(context, "上肢", "上肢简单描述", R.drawable.healthy_hand, intent, true));
        healthyContainer.addView(new HealthyItem(context, "足踝部", "足踝部简单描述", R.drawable.healhthy_foot, intent, true));
        healthyContainer.addView(new HealthyItem(context, "活动", "活动描述", R.drawable.healthy_active, intent, true));
        healthyContainer.addView(new HealthyItem(context, "意见反馈", "我们耐心倾听您的每一个反馈", R.drawable.healthy_feed, intent, true));

    }
}
