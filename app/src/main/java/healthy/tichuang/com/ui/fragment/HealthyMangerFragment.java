package healthy.tichuang.com.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.customview.HealthyCircleView;
import healthy.tichuang.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 */

public class HealthyMangerFragment extends BaseFragment {
    private View rootView;
    private HealthyCircleView  mHealthyCircleView;
    private  boolean isInit=false;

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
        isPrepared=true;
        loadData();

        return rootView;
    }


    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_healthy_mag_layout, container, false);


    }





    @Override
    protected void loadData() {
        if (!isPrepared||!isVisible()){
            return;
        }else {
            Log.e("HealthyMangerFragment","请求");
        }
    }
}
