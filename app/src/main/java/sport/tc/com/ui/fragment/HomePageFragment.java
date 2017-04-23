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
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.adapter.HomeAdapter;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.customview.HomePageListView;
import sport.tc.com.modle.ArticleRequest;
import sport.tc.com.modle.HomeAdResponse;
import sport.tc.com.modle.HomeResponse;
import sport.tc.com.ui.base.BaseFragment;
import sport.tc.com.util.AppHelper;
import sport.tc.com.util.GlideImageLoader;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/3/1.
 */

public class HomePageFragment extends BaseFragment {
    private boolean isInit = false;
    private View rootView;
    private HomeAdapter mHomeAdapter;
    private HomePageListView mListView;
    private Banner mBanner;
    private TextView workTv;
    private  TextView timeTv;
    private  TextView  typeTv;
    private List<HomeResponse.DataBean.ArticleListBean> mArticleListBeen = new ArrayList<>();




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
        getHomeArticleList();
        getHomeAd();
        return rootView;
    }


    private void initView(LayoutInflater inflater, ViewGroup container) {
        rootView = inflater.inflate(R.layout.fragment_home_page, container, false);
        mListView = (HomePageListView) rootView.findViewById(R.id.home_page_listview);
        mHomeAdapter = new HomeAdapter(getActivity());
        mBanner =(Banner)rootView.findViewById(R.id.banner);
        mBanner.setImageLoader(new GlideImageLoader());
        workTv =(TextView)rootView.findViewById(R.id.home_page_first_work_content);
        timeTv =(TextView)rootView.findViewById(R.id.home_page_cover_time_content);
        typeTv =(TextView)rootView.findViewById(R.id.home_page_sport_type_content);


        initToolbar();

    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.healthy_only_title_toolbar);
        TextView middle = (TextView) toolbar.findViewById(R.id.healthy_only_title_toolbar_text);
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
        articleRequest.is_index = "1";
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(getActivity()).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.homeArtcleListApi(validData, executeData), new BaseSubscriber<HomeResponse>(getActivity()) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HomeResponse response) {
                if (response != null && response.getCode().equals("000")) {
                    mArticleListBeen = response.getData().getArticle_list();
                    mHomeAdapter.setListBeanList(mArticleListBeen);
                    mHomeAdapter.notifyDataSetChanged();
                    mListView.setAdapter(mHomeAdapter);
                    timeTv.setText(mArticleListBeen.get(0).getCreate_time());

                }
            }
        });
    }



    private void getHomeAd() {
        String validData = AppHelper.prouductValidData(getActivity());
        Novate novate = new Novate.Builder(getActivity()).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.homeAdApi(validData), new BaseSubscriber<HomeAdResponse>(getActivity()) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HomeAdResponse homeAdResponse) {
                if (homeAdResponse!=null&&homeAdResponse.getCode().equals("000")){
                       List<HomeAdResponse.DataBean>  dataBeanList=     homeAdResponse.getData();
                    List<String>  images =new ArrayList<String>();
                    if (dataBeanList!=null&&dataBeanList.size()>0){
                        for (int i=0;i<dataBeanList.size();i++){
                            String imageUrl =dataBeanList.get(i).getImg_url();
                            if (!imageUrl.isEmpty()){
                                images.add(dataBeanList.get(i).getImg_url());
                            }
                        }
                    }
                    mBanner.setImages(images);
                    mBanner.start();
                }
            }
        });
    }



}
