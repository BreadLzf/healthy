package sport.tc.com.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;

import java.io.File;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.customview.Crop;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.ToastUtil;

/**
 * Created by punisher on 2017/3/2.
 */

public class UserActivity extends BaseActivity {


    /**
     * id：用户的主键编号
     * 电话：接受短信验证码的手机号码
     * 性别：性别（1男2女）
     * 生日：生日，传字符串即可
     * 身高：身高，单位厘米
     * 体重：体重，单位kg
     * bmi：体质指数，由身高体重计算出来的浮点型数据
     * 电话：绑定的手机号，新增时间默认为账号
     * 佩戴手（1左手2右手）
     */

    private String sex;
    private String birth;
    private String height;
    private String weight;
    private String bmi;
    private String phone;
    private String wear_hand;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initNoBackToolBar("个人信息", "修改", new OnCustomClickListener() {
            @Override
            public void onItemClick() {
                Intent  intent =new Intent(UserActivity.this,ModifyUserActivity.class);
                startActivity(intent);
            }
        });
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

}
