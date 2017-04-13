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
import sport.tc.com.adapter.CommentListAdapter;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.CommentListRequest;
import sport.tc.com.modle.CommentListResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/12.
 */

public class CommentListActivity  extends BaseActivity {
    private CommentListAdapter  mCommentListAdapter;
    private ListView  mListView;
    private List<CommentListResponse.DataBean.CommentListBean>  mCommentList=new ArrayList<>();
    private  String art_id="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);
        initToolBar("评论列表",R.drawable.chronic_disease_back);
        art_id=  getIntent().getStringExtra("article_id");
        Log.e("art_id","art_id>>>"+art_id);
        getArticleList();
        initView();

    }

    private void  initView(){
        mListView =(ListView)findViewById(R.id.comment_listview);

    }



    private void getArticleList() {
        String validData = AppHelper.prouductValidData(this);
        final CommentListRequest commentListRequest = new CommentListRequest();
        commentListRequest.article_id =art_id;
        String executeData = javaBeanToJson(commentListRequest);

        Novate novate = new Novate.Builder(CommentListActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.commentListApi(validData, executeData), new BaseSubscriber<CommentListResponse>(this) {


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CommentListResponse commentListResponse) {
                 if (commentListResponse!=null&&commentListResponse.getCode().equals("000")){
                     mCommentList=  commentListResponse.getData().getComment_list();
                     Log.e("list",mCommentList.size()+"");
                     mCommentListAdapter =new CommentListAdapter(mCommentList,CommentListActivity.this);
                     mListView.setAdapter(mCommentListAdapter);

                 }
            }
        });

    }
}
