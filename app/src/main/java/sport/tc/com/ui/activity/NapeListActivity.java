package sport.tc.com.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.ArticleRequest;
import sport.tc.com.modle.HealthyCircleResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/3/22.
 */

public class NapeListActivity extends BaseActivity implements View.OnClickListener {

    private static final int COUNT = 20;
    private int CUNRRENT_PAGE = 1;
    private String heealthyCircleAppType = "1";
    private String type = "";
    private String title = "";
    private RelativeLayout napaLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nape_include_layout);
        title = getIntent().getStringExtra("title");
        initToolBar(title, R.drawable.chronic_disease_back);

        type = getIntent().getStringExtra("type");
        initView();
    }


    private void initView() {
        napaLayout = (RelativeLayout) findViewById(R.id.nape_detail_top_layout);
        napaLayout.setOnClickListener(this);
    }

    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.cur_page = CUNRRENT_PAGE;
        articleRequest.page_num = COUNT;
        articleRequest.app_type = heealthyCircleAppType;
        articleRequest.type = type;
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(NapeListActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.artcleListApi(validData, executeData), new BaseSubscriber<HealthyCircleResponse>(this) {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HealthyCircleResponse healthyCircleResponse) {

            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nape_detail_top_layout:
                Intent intent = new Intent(NapeListActivity.this, NapeDetailActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("type", type);
                startActivity(intent);
                break;
        }
    }
}

