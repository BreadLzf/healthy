package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.ModifyUser;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.GsonHelper;
import sport.tc.com.util.ToastUtil;

/**
 * Created by punisher on 2017/3/2.
 */

public class ModifyUserActivity extends BaseActivity {


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


    @BindView(R.id.modify_head_img)
    ImageView mModifyHeadImg;
    @BindView(R.id.modify_head_layout)
    FrameLayout mModifyHeadLayout;
    @BindView(R.id.modify_user_nick_name)
    TextView mModifyUserNickName;
    @BindView(R.id.modify_user_sex_man)
    RadioButton mModifyUserSexMan;
    @BindView(R.id.modify_user_sex_woman)
    RadioButton mModifyUserSexWoman;
    @BindView(R.id.modify_user_sex)
    RadioGroup mModifyUserSex;
    @BindView(R.id.modify_user_birth_layout)
    RelativeLayout mModifyUserBirthLayout;
    @BindView(R.id.modify_user_high_layout)
    RelativeLayout mModifyUserHighLayout;
    @BindView(R.id.modify_user_weight_layout)
    RelativeLayout mModifyUserWeightLayout;
    @BindView(R.id.modify_user_bind_phone_layout)
    RelativeLayout mModifyUserBindPhoneLayout;
    @BindView(R.id.modify_user_bind_left)
    RadioButton mModifyUserBindLeft;
    @BindView(R.id.modify_user_bind_right)
    RadioButton mModifyUserBindRight;
    @BindView(R.id.modify_user_bind_group)
    RadioGroup mModifyUserBindGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_user);
        ButterKnife.bind(this);
        initNoBackToolBar("个人信息", "保存", new OnCustomClickListener() {
            @Override
            public void onItemClick() {
                postUserMessage();
            }
        });
        initView();
    }


    private void initView() {
        mModifyUserSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.modify_user_sex_man:
                        sex = "1";
                        break;

                    case R.id.modify_user_sex_woman:
                        sex = "2";
                        break;
                }
            }
        });

        mModifyUserBindGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.modify_user_bind_left:
                        wear_hand = "1";
                        break;
                    case R.id.modify_user_bind_right:
                        wear_hand = "2";
                        break;
                }
            }
        });
    }

    @OnClick({R.id.modify_head_img, R.id.modify_head_layout, R.id.modify_user_nick_name, R.id.modify_user_sex_man, R.id.modify_user_sex_woman,
            R.id.modify_user_birth_layout, R.id.modify_user_high_layout,
            R.id.modify_user_weight_layout, R.id.modify_user_bind_phone_layout,
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modify_head_img:
                ToastUtil.show(this,"头像");
                break;
            case R.id.modify_head_layout:
                break;
            case R.id.modify_user_nick_name:
                ToastUtil.show(this,"昵称");

                break;
            case R.id.modify_user_sex_man:
                break;
            case R.id.modify_user_sex_woman:
                break;

            case R.id.modify_user_birth_layout:
                break;
            case R.id.modify_user_high_layout:
                break;
            case R.id.modify_user_weight_layout:
                break;
            case R.id.modify_user_bind_phone_layout:
                break;

        }
    }

    private void postUserMessage() {

        ModifyUser modifyUser = new ModifyUser();
        modifyUser.setSex(sex);
        modifyUser.setBirth(birth);
        modifyUser.setHeight(height);
        modifyUser.setWeight(weight);
        modifyUser.setBmi(bmi);
        modifyUser.setPhone(phone);
        modifyUser.setWear_hand(wear_hand);
        String modifyJson = GsonHelper.javaBeanToJson(modifyUser);

    }
}
