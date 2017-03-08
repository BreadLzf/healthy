package healthy.tichuang.com.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.activity.HealthyFamilyActivity;
import healthy.tichuang.com.ui.activity.ModifyUserActivity;
import healthy.tichuang.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 */

public class UserCenterFragment extends BaseFragment   implements View.OnClickListener{

    private Button  mEditBtn;
    private View  rootView;

    private RelativeLayout  familyLayout;


    public static UserCenterFragment newInstance() {
        return new UserCenterFragment();
    }


    @Override
    public String getUmengLabel() {
        return "user_center";
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initView(inflater,container);
        isPrepared=true;
        loadData();
        return rootView;
    }


    private  void   initView(LayoutInflater inflater, ViewGroup container){
        rootView= inflater.inflate(R.layout.fragment_user_center, container, false);
        mEditBtn = (Button) rootView.findViewById(R.id.user_center_to_edit_btn);
        mEditBtn.setOnClickListener(this);

        familyLayout =(RelativeLayout)rootView.findViewById(R.id.user_center_family_layout);
        familyLayout.setOnClickListener(this);
    }


    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    @Override
    public void onClick(View v) {
        Intent  intent;
        switch(v.getId()){
            case  R.id.user_center_to_edit_btn:
                intent =new Intent(getActivity(), ModifyUserActivity.class);
                startActivity(intent);
                break;

            case R.id.user_center_family_layout:
                intent =new Intent(getActivity(), HealthyFamilyActivity.class);
                startActivity(intent);
                break;

        }
    }



    @Override
    protected void loadData() {
        if (!isPrepared||isVisible()){
            return;
        }else {
            Log.e("UserCenterFragment","请求");
        }
    }
}
