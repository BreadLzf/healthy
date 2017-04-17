package sport.tc.com.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.ArticleRequest;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.ui.base.BaseFragment;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

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
        getHomeArticleList();

    }



    private void initToolbar() {
        Toolbar toolbar =(Toolbar) rootView.findViewById(R.id.healthy_only_title_toolbar);
        TextView middle =(TextView)toolbar.findViewById(R.id.healthy_only_title_toolbar_text);
        toolbar.setBackgroundColor(Color.parseColor("#1adddf"));
        middle.setText("运动健康康复");
//        //toolbar 设置图片
//        Drawable drawable =getResources().getDrawable(R.drawable.login_regist_head); //图片需要更换
//        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
//        middle.setCompoundDrawables(drawable,null,null,null);
        middle.setTextColor(Color.parseColor("#e5e5e5"));
    }




    private void getHomeArticleList() {
        String validData = AppHelper.prouductValidData(getActivity());
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.is_index ="1";
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(getActivity()).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.homeArtcleListApi(validData, executeData), new BaseSubscriber<BaseResponse>(getActivity()) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse response) {

            }
        });

    }



}
