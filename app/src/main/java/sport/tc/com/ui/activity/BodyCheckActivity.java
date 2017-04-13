package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.modle.BodyCheckRequest;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/13.
 */

public class BodyCheckActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_check);
        getArticleList();
    }



    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        BodyCheckRequest bodyCheckRequest = new BodyCheckRequest();
        bodyCheckRequest.setBase_id("1");
        bodyCheckRequest.setPage_num("1");
        bodyCheckRequest.setCur_page("1");
        String executeData = javaBeanToJson(bodyCheckRequest);

        Novate novate = new Novate.Builder(BodyCheckActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.bodyCheckApi(validData, executeData), new BaseSubscriber<BaseResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse baseResponse) {

            }
        });
    }
}
