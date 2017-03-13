package healthy.tichuang.com.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.base.BaseFragment;

/**
 * Created by punisher on 2017/3/1.
 */

public class UserCenterFragment extends BaseFragment   implements View.OnClickListener{

    private Button  mEditBtn;
    private View  rootView;
    private ViewGroup personContainer;



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
//        initItem(getActivity());
        loadData();
        return rootView;
    }


    private  void   initView(LayoutInflater inflater, ViewGroup container){
        rootView= inflater.inflate(R.layout.fragment_user_center, container, false);

        mEditBtn = (Button) rootView.findViewById(R.id.user_center_to_edit_btn);
        mEditBtn.setOnClickListener(this);

    }



//    private  void  initItem(Activity context){
//        Intent  intent =null;
//        personContainer .addView(new PersonItem(context, "我的健康家庭",R.drawable.person_family, intent, true));
//        personContainer .addView(new PersonItem(context, "我的健康管理",R.drawable.person_manger, intent, true));
//        personContainer .addView(new PersonItem(context, "我的收藏",R.drawable.person_collection, intent, true));
//        personContainer .addView(new PersonItem(context, "我的专家",R.drawable.person_expert, intent, true));
//        personContainer .addView(new PersonItem(context, "我的预约",R.drawable.person_reservation, intent, true));
//        personContainer .addView(new PersonItem(context, "消息",R.drawable.person_news, intent, true));
//        personContainer .addView(new PersonItem(context, "设置",R.drawable.person_setting, intent, true));
//
//    }


    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    @Override
    public void onClick(View v) {

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
