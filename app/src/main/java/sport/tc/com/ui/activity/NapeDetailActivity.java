package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import java.util.List;

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

public class NapeDetailActivity extends BaseActivity {

    private static final int COUNT = 20;
    private int CUNRRENT_PAGE = 1;
    private String heealthyCircleAppType = "1";
    private String type = "";
    private String title = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nape_detail_layout);
        title= getIntent().getStringExtra("title");

        initRightImgToolBar(title, R.drawable.chronic_disease_back, R.drawable.nape_detail_share, new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
        getArticleList();
    }


    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.cur_page = CUNRRENT_PAGE;
        articleRequest.page_num = COUNT;
        articleRequest.app_type = heealthyCircleAppType;
        articleRequest.type = type;
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(NapeDetailActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.artcleListApi(validData, executeData), new BaseSubscriber<HealthyCircleResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HealthyCircleResponse healthyCircleResponse) {
                HealthyCircleResponse.DataBean.ArticleListBean articleListBean = healthyCircleResponse.getData().getArticle_list().get(0);
                Log.e("bean", articleListBean.getTitle() + "");
                List<HealthyCircleResponse.DataBean.ArticleListBean.ArticleJsonBean> articleJsonBeanList = articleListBean.getArticle_json();
                Log.e("bean  json size", articleListBean.getArticle_json().size() + "");

                String type ="";
                String paragraphs= "";
                String text ="";
                String src ="";
                String other="";

                for (int i=0;i<articleJsonBeanList.size();i++){
                    Log.e("bean  json type", articleJsonBeanList.get(i).getType() + "");
                    Log.e("bean  json paragraphs", articleJsonBeanList.get(i).getParagraphs() + "");
                    Log.e("bean  json text", articleJsonBeanList.get(i).getText() + "");
                    Log.e("bean  json src", articleJsonBeanList.get(i).getSrc() + "");
                    type =articleJsonBeanList.get(i).getType();
                    paragraphs =articleJsonBeanList.get(i).getParagraphs().toString();
                    other =articleJsonBeanList.get(i).getParagraphs()+"";
                    text=articleJsonBeanList.get(i).getText();
                    src =articleJsonBeanList.get(i).getSrc();
                }


            }
        });

    }

}
