package sport.tc.com.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.adapter.NapeListAdapter;
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

public class NapeListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final int COUNT = 20;
    private int CUNRRENT_PAGE = 1;
    private String type = "";
    private String title = "";
    private RelativeLayout napaLayout;

    private ListView napeListView;
    private NapeListAdapter mNapeListAdapter;
    private List<HealthyCircleResponse.DataBean.ArticleListBean> mArticleListBeen = new ArrayList<>();
    private HealthyCircleResponse.DataBean.ArticleListBean mArticleListBean;


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
        mNapeListAdapter = new NapeListAdapter(NapeListActivity.this);
        mNapeListAdapter.setArticleListBeen(mArticleListBeen);
        napeListView = (ListView) findViewById(R.id.nape_list_view);
        napeListView.setAdapter(mNapeListAdapter);
        napeListView.setOnItemClickListener(this);
        napaLayout = (RelativeLayout) findViewById(R.id.nape_detail_top_layout);
        napaLayout.setOnClickListener(this);
        getArticleList();
    }

    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.cur_page = CUNRRENT_PAGE + "";
        articleRequest.page_num = COUNT + "";
        articleRequest.app_type = type;
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(NapeListActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.artcleListApi(validData, executeData), new BaseSubscriber<HealthyCircleResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HealthyCircleResponse response) {
                if (response != null && response.getCode().equals("000")) {
                    List<HealthyCircleResponse.DataBean.ArticleListBean> article_list = response.getData().getArticle_list();
                    Log.e("article size", "size>>" + article_list.size() + "");
                    if (article_list != null && article_list.size() > 0) {
                        mArticleListBeen = article_list;
                        mNapeListAdapter.setArticleListBeen(mArticleListBeen);
                        mNapeListAdapter.notifyDataSetChanged();
                    }
                }
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mArticleListBean = (HealthyCircleResponse.DataBean.ArticleListBean) mNapeListAdapter.getItem(i);
        String article_id = mArticleListBean.getArticle_id();
        if (article_id!=null&&article_id.length()>0){
            Intent intent =new Intent(NapeListActivity.this,NapeDetailActivity.class);
            intent.putExtra("article_id",article_id);
            startActivity(intent);
        }
    }
}

