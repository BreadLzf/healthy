package healthy.tichuang.com.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 * 运动康复
 */

public class SportRecoverFragment extends BaseFragment   implements View.OnClickListener{
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
        first_Vist_Doctor =(TextView)rootView.findViewById(R.id.sport_recover_first);
        two_Vist_Doctor=(TextView)rootView.findViewById(R.id.sport_recover_two);
//        first_Vist_Doctor.setTextColor(Color.parseColor("#"));
        first_Vist_Doctor.setOnClickListener(this);
        two_Vist_Doctor.setOnClickListener(this);
    }

//
    @Override
    protected void loadData() {
        if (!isPrepared || !isVisible()) {
            return;
        } else {
            Log.e("SportRecoverFragment", "请求");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.sport_recover_first:

                break;

            case  R.id.sport_recover_two:

                break;
        }

    }
}
