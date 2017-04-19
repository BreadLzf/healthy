package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.adapter.SlowIllSearchAdapter;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BodyCheckRequest;
import sport.tc.com.modle.SlowillResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/19.
 * 慢性病的题目
 */

public class SlowillReportActivity extends BaseActivity {
    private ListView mListView;
    private SlowIllSearchAdapter mSearchAdapter;
    private List<SlowillResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slow_report);
        initToolBar("", R.drawable.chronic_disease_back);
        initView();
        getArticleList();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.slow_report_listview);
        mSearchAdapter = new SlowIllSearchAdapter(SlowillReportActivity.this);


    }


    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        BodyCheckRequest bodyCheckRequest = new BodyCheckRequest();
        bodyCheckRequest.setBase_id("2");
        bodyCheckRequest.setPage_num("1");
        bodyCheckRequest.setCur_page("1");
        String executeData = javaBeanToJson(bodyCheckRequest);

        Novate novate = new Novate.Builder(SlowillReportActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.slowIllApi(validData, executeData), new BaseSubscriber<SlowillResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SlowillResponse slowillResponse) {
                if (slowillResponse != null && slowillResponse.getCode().equals("000")) {
                    List<SlowillResponse.DataBean.AssessInfoBean.TagBean> tagBeanList = slowillResponse.getData().getAssessInfo().getTag();
                    List<SlowillResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> configInfoBeanList = new ArrayList<SlowillResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean>();
                    for (int i = 0; i < tagBeanList.size(); i++) {
                        List<SlowillResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> list = tagBeanList.get(i).getConfig_info();
                        for (int j = 0; j < list.size(); j++) {
                            configInfoBeanList.add(list.get(j));
                        }
                    }
                    mSearchAdapter.setConfigInfoBeanList(configInfoBeanList);
                    mListView.setAdapter(mSearchAdapter);
                    mSearchAdapter.notifyDataSetChanged();
                    Log.e("size", configInfoBeanList.size() + "");
                }
            }
        });
    }
}
