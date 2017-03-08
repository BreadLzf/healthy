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

    private boolean isInit = false;

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
        healthyContainer = (ViewGroup) v.findViewById(R.id.healthy_container);
        initView(context);
        isPrepared = true;
        loadData();
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
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
        healthyContainer.addView(new HealthyItem(context, "测试", "测试", R.mipmap.ic_launcher, R.mipmap.ic_launcher, intent, true));
    }
}
