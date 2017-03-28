package healthy.tichuang.com.ui.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 */

public class HomePageFragment extends BaseFragment {
    private boolean isInit = false;
    private View rootView;


    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public String getUmengLabel() {
        return "home_page";
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initView(inflater, container);
        isPrepared = true;

        return rootView;
    }


    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_home_page, container, false);

        initToolbar();
    }



    private void initToolbar() {
        Toolbar toolbar =(Toolbar) rootView.findViewById(R.id.healthy_only_title_toolbar);
        TextView middle =(TextView)toolbar.findViewById(R.id.healthy_only_title_toolbar_text);
        toolbar.setBackgroundColor(Color.parseColor("#1adddf"));
        middle.setText("运动健康康复");
        //toolbar 设置图片
        Drawable drawable =getResources().getDrawable(R.drawable.login_regist_head); //图片需要更换
        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
        middle.setCompoundDrawables(drawable,null,null,null);
        middle.setTextColor(Color.parseColor("#e5e5e5"));
    }


    @Override
    protected void loadData() {
        if (!isPrepared || !isVisible()) {
            return;
        } else {
            Log.e("HomePageFragment", "请求");
        }
    }
}
