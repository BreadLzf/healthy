package sport.tc.com.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import sport.tc.com.MyApplication;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.customview.Crop;
import sport.tc.com.event.BusProvider;
import sport.tc.com.event.ModifyEvent;
import sport.tc.com.modle.ModifyUserResponse;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.ToastUtil;

/**
 * Created by punisher on 2017/3/2.
 */

public class UserActivity extends BaseActivity {


    @BindView(R.id.user_head_img)
    CircleImageView mUserHeadImg;
    @BindView(R.id.user_nick_name)
    TextView mUserNickName;
    @BindView(R.id.user_sex_tv)
    TextView mUserSexTv;
    @BindView(R.id.user_brith_tv)
    TextView mUserBrithTv;
    @BindView(R.id.user_high_tv)
    TextView mUserHighTv;
    @BindView(R.id.user_weight_tv)
    TextView mUserWeightTv;
    @BindView(R.id.user_bind_phone)
    TextView mUserBindPhone;
    @BindView(R.id.user_bind_hand)
    TextView mUserBindHand;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        BusProvider.getInstance().register(this);
        initNoBackToolBar("个人信息", "修改", new OnCustomClickListener() {
            @Override
            public void onItemClick() {
                Intent intent = new Intent(UserActivity.this, ModifyUserActivity.class);
                startActivity(intent);
            }
        });

        if (MyApplication.getAppInstance().getUserInfoBean()!=null){
            upUserView(MyApplication.getAppInstance().getUserInfoBean());
        }
    }


    @Subscribe
    public void updateUserInfo(ModifyEvent event) {
        Log.e("user", "succ");
        ModifyUserResponse.DataBean.UserInfoBean userInfoBean = event.getUserInfoBean();
        upUserView(userInfoBean);

    }

    private void upUserView(ModifyUserResponse.DataBean.UserInfoBean userInfoBean) {
        if (!userInfoBean.getSex().isEmpty()) {
            switch (userInfoBean.getSex()) {
                case "1":
                    mUserSexTv.setText("男");
                    break;
                case "2":
                    mUserSexTv.setText("女");
                    break;
            }
        }
        mUserNickName.setText(userInfoBean.getNick_name());
        mUserBrithTv.setText(userInfoBean.getBirth());
        mUserHighTv.setText(userInfoBean.getHeight());
        mUserWeightTv.setText(userInfoBean.getWeight());
        mUserBindPhone.setText(userInfoBean.getPhone());
        if (!userInfoBean.getWear_hand().isEmpty()) {
            switch (userInfoBean.getWear_hand()) {
                case "1":
                    mUserBindHand.setText("左手");
                    break;
                case "2":
                    mUserBindHand.setText("右手");

                    break;
            }
        }
    }


    private void beginCrop(Uri source) {
        Uri outputUri = Uri.fromFile(new File(getCacheDir(), "cropped"));
        Intent intent = new Intent(this, CropPhotoActivity.class);
        intent.setData(source);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        startActivityForResult(intent, Crop.REQUEST_CROP);
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            Uri output = Crop.getOutput(result);
//            new UploadAvatarTask(this, "正在上传图片...", output).start();
        } else if (resultCode == Crop.RESULT_ERROR) {
            ToastUtil.show(this, Crop.getError(result).getMessage());
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }
}
