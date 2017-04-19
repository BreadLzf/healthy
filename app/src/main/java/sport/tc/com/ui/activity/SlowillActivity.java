package sport.tc.com.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BodyCheckRequest;
import sport.tc.com.modle.SlowillResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/13.
 */

public class SlowillActivity extends BaseActivity implements View.OnClickListener{
    private ImageView picImage;
    private TextView contentTv;
    private Button searchBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slow_ill);
        initRightTextToolBar(R.drawable.chronic_disease_back, "慢病评估", "历史记录", new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
        getArticleList();
        initView();
    }

    private void initView() {
        picImage = (ImageView) findViewById(R.id.ill_slow_imageView);
        contentTv = (TextView) findViewById(R.id.ill_slow_content);

        searchBtn = (Button) findViewById(R.id.ill_slow_search_btn);
        searchBtn.setOnClickListener(this);

    }

    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        BodyCheckRequest bodyCheckRequest = new BodyCheckRequest();
        bodyCheckRequest.setBase_id("2");
        bodyCheckRequest.setPage_num("1");
        bodyCheckRequest.setCur_page("1");
        String executeData = javaBeanToJson(bodyCheckRequest);

        Novate novate = new Novate.Builder(SlowillActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.slowIllApi(validData, executeData), new BaseSubscriber<SlowillResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SlowillResponse slowillResponse) {
                if (slowillResponse!=null&&slowillResponse.getCode().equals("000")){
                    SlowillResponse.DataBean.AssessInfoBean assessInfoBean =slowillResponse.getData().getAssessInfo();
                    contentTv.setText(assessInfoBean.getDescription());
                    Glide.with(SlowillActivity.this).load(assessInfoBean.getPic()).error(R.drawable.chronic_disease_bg).into(picImage);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.ill_slow_search_btn:
                Intent  intent = new Intent(SlowillActivity.this,SlowillReportActivity.class);
                startActivity(intent);
                break;
        }

    }
}
