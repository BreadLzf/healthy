package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.adapter.ExpertListAdapter;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.ExpertListResponse;
import sport.tc.com.modle.ExpertListrequest;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/23.
 */

public class ExpertListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView mListView;
    private ExpertListAdapter mListAdapter;
    private List<ExpertListResponse.DataBean.ExpertListBean>  mExpertListBeen=new ArrayList<>();

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_list_layout);
        initToolBar("专家列表", R.drawable.chronic_disease_back);
        initView();
        getExpertList();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.expert_list_view);
        mListAdapter = new ExpertListAdapter(ExpertListActivity.this);
        mListAdapter.setListBeanList(mExpertListBeen);
        mListView.setAdapter(mListAdapter);

    }


    private void getExpertList() {
        String validData = AppHelper.prouductValidData(this);
        ExpertListrequest expertListrequest = new ExpertListrequest();
        expertListrequest.setStart_time(AppHelper.formatLongTime(System.currentTimeMillis()));
        String executeData = javaBeanToJson(expertListrequest);
        Log.e("executeData>>", executeData);

        Novate novate = new Novate.Builder(ExpertListActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverExpertListApi(validData, executeData), new BaseSubscriber<ExpertListResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ExpertListResponse expertListResponse) {
                if (expertListResponse != null && expertListResponse.getCode().equals("000")) {
                    mExpertListBeen = expertListResponse.getData().getExpert_list();
                    mListAdapter.setListBeanList(mExpertListBeen);
                    mListAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
