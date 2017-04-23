package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import de.hdodenhof.circleimageview.CircleImageView;
import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.modle.ExpertDetailRequest;
import sport.tc.com.modle.ExpertDetailResponse;
import sport.tc.com.modle.ExpertListResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;
import sport.tc.com.util.ToastUtil;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/23.
 */

public class ExpertDetailActivity extends BaseActivity implements View.OnClickListener {
    String expert_id;
    private CircleImageView mCircleImageView;
    private TextView nameTv;
    private TextView contentTv;
    private Button orderBtn;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.expert_detail_order:
                orderExpert();
                break;
        }

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_detail_layout);
        initRightImgToolBar("专家详情", R.drawable.chronic_disease_back, R.drawable.nape_detail_share, new OnCustomClickListener() {
            @Override
            public void onItemClick() {

            }
        });

        initView();
        getExpertDetail();

    }


    private void initView() {
        expert_id = getIntent().getStringExtra("expert_id");
        mCircleImageView = (CircleImageView) findViewById(R.id.expert_detail_img);
        nameTv = (TextView) findViewById(R.id.expert_detail_user_name);
        contentTv = (TextView) findViewById(R.id.expert_detail_content);
        orderBtn = (Button) findViewById(R.id.expert_detail_order);
        orderBtn.setOnClickListener(this);
    }

    private void getExpertDetail() {
        String validData = AppHelper.prouductValidData(ExpertDetailActivity.this);
        ExpertDetailRequest expertDeatilRequest = new ExpertDetailRequest();
        expertDeatilRequest.setExpert_id(expert_id);
        final String executeData = javaBeanToJson(expertDeatilRequest);

        Novate novate = new Novate.Builder(ExpertDetailActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverExperDetailtApi(validData, executeData), new BaseSubscriber<ExpertDetailResponse>(ExpertDetailActivity.this) {


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ExpertDetailResponse expertDetailResponse) {
                if (expertDetailResponse != null && expertDetailResponse.getCode().equals("000")) {

                    ExpertDetailResponse.DataBean.ExpertDataBean expert_data = expertDetailResponse.getData().getExpert_data();


                    if (expert_data != null) {
                        if (expert_data.getHead_pic() != null) {
                            Glide.with(ExpertDetailActivity.this).load(expert_data.getHead_pic())
                                    .error(R.drawable.expert_head).override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(mCircleImageView);
                        }

                        if (!expert_data.getUser_name().isEmpty()) {
                            nameTv.setText(expert_data.getUser_name());
                        }

                        if (!expert_data.getIntroduce().isEmpty()) {
                            contentTv.setText(expert_data.getIntroduce());
                        }
                    }
                }
            }
        });
    }


    private void orderExpert() {
        String validData = AppHelper.prouductValidData(ExpertDetailActivity.this);

        ExpertListResponse.DataBean.ExpertListBean expertListBean = new ExpertListResponse.DataBean.ExpertListBean();
        expertListBean.setExpert_id(expert_id);
        String executeData = javaBeanToJson(expertListBean);

        Novate novate = new Novate.Builder(ExpertDetailActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.sportRecoverOrderApi(validData, executeData), new BaseSubscriber<BaseResponse>(ExpertDetailActivity.this) {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse response) {
                if (response != null && response.code.equals("000")) {
                    ToastUtil.show(ExpertDetailActivity.this, "预约成功");
                }
            }
        });

    }
}
