package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.ArticleRequest;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/3/22.
 */

public class NapeListActivity extends BaseActivity {

    private static final int COUNT = 10;
    private int CUNRRENT_PAGE = 0;
    private String  heealthyCircleAppType="1";
    private  String  type="";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nape_include_layout);
        String string = getIntent().getStringExtra("title");
        initToolBar(string, R.drawable.chronic_disease_back);
        type =getIntent().getStringExtra("type");
        Log.e("type", getIntent().getStringExtra("type"));
        getArticleList();
    }


    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.cur_page=CUNRRENT_PAGE;
        articleRequest.page_num=COUNT;
        articleRequest.is_index="1";
        articleRequest.app_type=heealthyCircleAppType;
        articleRequest.type=type;
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(NapeListActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.artcleListApi(validData, executeData), new BaseSubscriber<BaseResponse>(this) {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse BaseResponse) {

            }
        });

    }


}

