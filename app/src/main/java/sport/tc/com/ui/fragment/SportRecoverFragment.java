package sport.tc.com.ui.fragment;

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
import sport.tc.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 * 运动康复
 */

public class SportRecoverFragment extends BaseFragment implements View.OnClickListener {
    private View rootView;
    private TextView first_Vist_Doctor;
    private TextView two_Vist_Doctor;

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
        initToolBar();

    }


    private void initToolBar() {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.healthy_sport_tool);
        TextView middle = (TextView) toolbar.findViewById(R.id.healthy_sport_tool_first);
        TextView right = (TextView) toolbar.findViewById(R.id.healthy_sport_tool_again);
        toolbar.setBackgroundColor(Color.parseColor("#1adddf"));
        middle.setText("初诊");
        right.setText("复诊");
        middle.setTextColor(Color.parseColor("#e5e5e5"));
        right.setTextColor(Color.parseColor("#e5e5e5"));
        middle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "初诊", Toast.LENGTH_SHORT).show();

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "复诊", Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onClick(View v) {


    }
}
