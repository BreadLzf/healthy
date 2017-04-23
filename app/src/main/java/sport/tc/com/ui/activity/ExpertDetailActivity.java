package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.ArticleRequest;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.modle.ExpertDetailRequest;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/23.
 */

public class ExpertDetailActivity extends BaseActivity implements View.OnClickListener {
    String expert_id;

    @Override
    public void onClick(View view) {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_detail_layout);
        initToolBar("专家详情", R.drawable.chronic_disease_back);

        initView();
        getExpertDetail();

    }


    private void initView() {
        expert_id = getIntent().getStringExtra("expert_id");

    }

    private void getExpertDetail() {
        String validData = AppHelper.prouductValidData(ExpertDetailActivity.this);
        ExpertDetailRequest expertDeatilRequest = new ExpertDetailRequest();
        expertDeatilRequest.setExpert_id(expert_id);
        String executeData = javaBeanToJson(expertDeatilRequest);

        Novate novate = new Novate.Builder(ExpertDetailActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverExperDetailtApi(validData, executeData), new BaseSubscriber<BaseResponse>(ExpertDetailActivity.this) {


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse baseResponse) {

            }
        });
    }


    private void orderExpert() {
        String validData = AppHelper.prouductValidData(ExpertDetailActivity.this);

        ArticleRequest articleRequest = new ArticleRequest();

        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(ExpertDetailActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverOrderApi(validData, executeData), new BaseSubscriber<BaseResponse>(ExpertDetailActivity.this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse response) {

            }
        });

    }
}
