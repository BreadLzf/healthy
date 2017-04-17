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

public class SlowillActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slow_ill);
        initToolBar("慢性病评估", R.drawable.chronic_disease_back);
        getArticleList();
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
        novate.call(apiService.slowIllApi(validData, executeData), new BaseSubscriber<BaseResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse BaseResponse) {
//                mTagBeanList=   bodyCheckResponse.getData().getAssessInfo().getTag();
//                for (int i =0;i<mTagBeanList.size();i++){
//                    mTagBeanList.get(i).getTag_title();
//                    tagLists.add(mTagBeanList.get(i).getTag_title());
//                }
//                mTagFlowLayout.setAdapter(new TagAdapter<String>(tagLists)
//                {
//                    @Override
//                    public View getView(FlowLayout parent, int position, String s)
//                    {
//                        TextView tv = (TextView) mLayoutInflater.inflate(R.layout.tag_body_check,mTagFlowLayout, false);
//                        tv.setText(s);
//                        return tv;
//                    }
//                });
//
//
//                mConfigInfoBeanList= bodyCheckResponse.getData().getAssessInfo().getTag().get(0).getConfig_info();
            }
        });
    }
}
