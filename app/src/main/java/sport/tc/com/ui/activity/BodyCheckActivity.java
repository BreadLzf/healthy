package sport.tc.com.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.adapter.BodyCheckAdapter;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BodyCheckRequest;
import sport.tc.com.modle.BodyCheckResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/13.
 */

public class BodyCheckActivity extends BaseActivity {
    private TagFlowLayout mTagFlowLayout;
    private List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean> mTagBeanList;
    private List<String> tagLists = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList = new ArrayList<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean>();
    private ListView selfListview;
    private BodyCheckAdapter mBodyCheckAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_check);
        initRightTextToolBar(R.drawable.chronic_disease_back, "体质健康评测", "说明", new OnCustomClickListener() {
            @Override
            public void onItemClick() {
                Intent intent = new Intent(BodyCheckActivity.this, ExplainActivity.class);
                startActivity(intent);
            }
        });
        initView();
        getArticleList();
    }

    private void initView() {
//        selfListview =(ListView)findViewById(R.id.body_check_self_listview);
//        mBodyCheckAdapter =new BodyCheckAdapter(mConfigInfoBeanList,BodyCheckActivity.this);
//        selfListview.setAdapter(mBodyCheckAdapter);
        mLayoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mTagFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        mTagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Toast.makeText(BodyCheckActivity.this, tagLists.get(position), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

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
        novate.call(apiService.bodyCheckApi(validData, executeData), new BaseSubscriber<BodyCheckResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BodyCheckResponse bodyCheckResponse) {
                mTagBeanList = bodyCheckResponse.getData().getAssessInfo().getTag();
                for (int i = 0; i < mTagBeanList.size(); i++) {
                    mTagBeanList.get(i).getTag_title();
                    tagLists.add(mTagBeanList.get(i).getTag_title());
                }
                mTagFlowLayout.setAdapter(new TagAdapter<String>(tagLists) {
                    @Override
                    public View getView(FlowLayout parent, int position, String s) {
                        TextView tv = (TextView) mLayoutInflater.inflate(R.layout.tag_body_check, mTagFlowLayout, false);
                        tv.setText(s);
                        return tv;
                    }
                });


//                mConfigInfoBeanList = bodyCheckResponse.getData().getAssessInfo().getTag().get(0).getConfig_info();
//                mBodyCheckAdapter.setAlbumList(mConfigInfoBeanList);
//                mBodyCheckAdapter.notifyDataSetChanged();
            }
        });
    }
}
