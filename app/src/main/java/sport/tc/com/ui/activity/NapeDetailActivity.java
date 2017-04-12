package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
    //测试控件
    private TextView titleTv;
    private TextView timeTv;
    private TextView tagTv;

    private TextView SubTv;

    private TextView orderOneTv;
    private TextView orderTwoTv;

    private TextView underoneTv;
    private TextView undertwoTv;

    private TextView normalOneTv;
    private TextView normalTwoTv;

    private TextView smallSubTv;

    private ImageView mImageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nape_detail_layout);
        title = getIntent().getStringExtra("title");
        type = getIntent().getStringExtra("type");
        initView();
        initRightImgToolBar(title, R.drawable.chronic_disease_back, R.drawable.nape_detail_share, new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });
        getArticleList();
    }


    private void initView() {
        titleTv = (TextView) findViewById(R.id.nape_test_title);
        timeTv = (TextView) findViewById(R.id.nape_test_time);
        tagTv = (TextView) findViewById(R.id.nape_test_tag);

        SubTv = (TextView) findViewById(R.id.nape_test_sub);


        orderOneTv = (TextView) findViewById(R.id.nape_test_order_one);
        orderTwoTv = (TextView) findViewById(R.id.nape_test_order_two);


        underoneTv = (TextView) findViewById(R.id.nape_test_no_one);
        undertwoTv = (TextView) findViewById(R.id.nape_test_no_two);


        normalOneTv = (TextView) findViewById(R.id.nape_test_normal_one);
        normalTwoTv = (TextView) findViewById(R.id.nape_test_normal_two);

        smallSubTv = (TextView) findViewById(R.id.nape_test_small_title);

        mImageView = (ImageView) findViewById(R.id.nape_test_image);

    }

    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        ArticleRequest articleRequest = new ArticleRequest();
        articleRequest.cur_page = CUNRRENT_PAGE;
        articleRequest.page_num = COUNT;
        articleRequest.app_type = heealthyCircleAppType;
        articleRequest.type = type;
        articleRequest.article_id="1";
        String executeData = javaBeanToJson(articleRequest);

        Novate novate = new Novate.Builder(NapeDetailActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.artcleDetailApi(validData, executeData), new BaseSubscriber<HealthyCircleResponse>(this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HealthyCircleResponse healthyCircleResponse) {
                HealthyCircleResponse.DataBean.ArticleListBean articleListBean = healthyCircleResponse.getData().getArticle_list().get(0);
                Log.e("bean", articleListBean.getTitle() + "");
                List<HealthyCircleResponse.DataBean.ArticleListBean.ArticleJsonBean> articleJsonBeanList = articleListBean.getArticle_json();
                Log.e("bean  json size", articleListBean.getArticle_json().size() + "");
                titleTv.setText(articleListBean.getTitle());
                for (int i = 0; i < articleJsonBeanList.size(); i++) {
                    Log.e("bean  json type", articleJsonBeanList.get(i).getType() + "");
                    Log.e("bean  json paragraphs", articleJsonBeanList.get(i).getParagraphs() + "");
                    Log.e("bean  json text", articleJsonBeanList.get(i).getText() + "");
                    Log.e("bean  json src", articleJsonBeanList.get(i).getSrc() + "");
                    switch (i) {
                        case 0:
                            tagTv.setText(articleJsonBeanList.get(0).getParagraphs().get(0));
                        case 1:
                            SubTv.setText(articleJsonBeanList.get(1).getText());
                        case 2:
                            orderOneTv.setText(articleJsonBeanList.get(2).getParagraphs().get(0));
                            orderTwoTv.setText(articleJsonBeanList.get(2).getParagraphs().get(1));

                        case 3:
                            underoneTv.setText(articleJsonBeanList.get(3).getParagraphs().get(0));
                            undertwoTv.setText(articleJsonBeanList.get(3).getParagraphs().get(1));

                        case 4:
                            normalOneTv.setText(articleJsonBeanList.get(4).getParagraphs().get(0));
                            normalTwoTv.setText(articleJsonBeanList.get(4).getParagraphs().get(1));

                        case 5:

                            smallSubTv.setText(articleJsonBeanList.get(5).getText());

                        case 6:

                        case 7:
                            Glide.with(NapeDetailActivity.this).load(articleJsonBeanList.get(7).getSrc()).into(mImageView);

                    }
                }
            }
        });

    }

}
