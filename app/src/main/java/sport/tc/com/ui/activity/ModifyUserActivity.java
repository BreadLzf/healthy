package sport.tc.com.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.api.HealthyApiService;
import sport.tc.com.modle.BaseResponse;
import sport.tc.com.modle.ModifyUser;
import sport.tc.com.ui.base.BaseActivity;
import sport.tc.com.util.AppHelper;
import sport.tc.com.util.ToastUtil;

import static sport.tc.com.util.GsonHelper.javaBeanToJson;

/**
 * Created by punisher on 2017/4/12.
 */

public class ModifyUserActivity extends BaseActivity {


    @BindView(R.id.modify_head_img)
    ImageView mModifyHeadImg;
    @BindView(R.id.modify_head_layout)
    FrameLayout mModifyHeadLayout;
    @BindView(R.id.modify_user_nick_name)
    EditText mModifyUserNickName;
    @BindView(R.id.modify_user_sex_man)
    RadioButton mModifyUserSexMan;
    @BindView(R.id.modify_user_sex_woman)
    RadioButton mModifyUserSexWoman;
    @BindView(R.id.modify_user_sex)
    RadioGroup mModifyUserSex;
    @BindView(R.id.modify_user_birth_layout)
    RelativeLayout mModifyUserBirthLayout;
    @BindView(R.id.modify_user_high_edit)
    EditText mModifyUserHighEdit;
    @BindView(R.id.modify_user_high_layout)
    RelativeLayout mModifyUserHighLayout;
    @BindView(R.id.modify_user_weight_edit)
    EditText mModifyUserWeightEdit;
    @BindView(R.id.modify_user_weight_layout)
    RelativeLayout mModifyUserWeightLayout;
    @BindView(R.id.modify_phone_edit)
    EditText mModifyPhoneEdit;
    @BindView(R.id.modify_user_bind_phone_layout)
    RelativeLayout mModifyUserBindPhoneLayout;
    @BindView(R.id.modify_user_bind_left)
    RadioButton mModifyUserBindLeft;
    @BindView(R.id.modify_user_bind_right)
    RadioButton mModifyUserBindRight;
    @BindView(R.id.modify_user_bind_group)
    RadioGroup mModifyUserBindGroup;
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
    private String nick;
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
        setContentView(R.layout.activity_modify_user);
        ButterKnife.bind(this);
        initNoBackToolBar("个人信息", "保存", new OnCustomClickListener() {
            @Override
            public void onItemClick() {
                modifyUserMessage();

            }
        });
        initView();
    }

    private void modifyUserMessage() {
        nick =mModifyUserNickName.getText().toString();
        birth="19901011";
        height=mModifyUserHighEdit.getText().toString();
        weight =mModifyUserWeightEdit.getText().toString();
        bmi="22";
        phone=mModifyPhoneEdit.getText().toString();

        if (nick.isEmpty()){
            ToastUtil.show(ModifyUserActivity.this,"昵称不能为空");

        }
        if (height.isEmpty()){
            ToastUtil.show(ModifyUserActivity.this,"身高不能为空");

        }
        if (weight.isEmpty()){
            ToastUtil.show(ModifyUserActivity.this,"体重不能为空");

        }
        if (phone.isEmpty()){
            ToastUtil.show(ModifyUserActivity.this,"手机号不能为空");
        }
        if (!phone.isEmpty()&&!AppHelper.isPhoneNumber(phone)){
            ToastUtil.show(ModifyUserActivity.this,"手机号码不正确");
        }

        if (!nick.isEmpty()&&!birth.isEmpty()&&!birth.isEmpty()&&!weight.isEmpty()&&!bmi.isEmpty()&&!phone.isEmpty()){
            postUserMessage();
        }
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


    private void postUserMessage() {
        String validData = AppHelper.prouductValidData(this);
        ModifyUser modifyUser = new ModifyUser();
        modifyUser.setNick_name(nick);
        modifyUser.setSex(sex);
        modifyUser.setBirth("19890313");
        modifyUser.setHeight(height);
        modifyUser.setWeight(weight);
        modifyUser.setBmi("68");
        modifyUser.setPhone(phone);
        modifyUser.setWear_hand(wear_hand);
        String executeData = javaBeanToJson(modifyUser);


        Novate novate = new Novate.Builder(ModifyUserActivity.this).baseUrl(AppContents.API_BASE_URL).build();
        HealthyApiService apiService = novate.create(HealthyApiService.class);
        novate.call(apiService.modifyUserApi(validData, executeData), new BaseSubscriber<BaseResponse>(this) {


            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(BaseResponse baseResponse) {

            }
        });

    }

    @OnClick({R.id.modify_head_img, R.id.modify_head_layout, R.id.modify_user_nick_name, R.id.modify_user_sex_man, R.id.modify_user_sex_woman, R.id.modify_user_sex, R.id.modify_user_birth_layout, R.id.modify_user_high_edit, R.id.modify_user_high_layout, R.id.modify_user_weight_edit, R.id.modify_user_weight_layout, R.id.modify_phone_edit, R.id.modify_user_bind_phone_layout, R.id.modify_user_bind_left, R.id.modify_user_bind_right, R.id.modify_user_bind_group})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.modify_head_img:
                break;
            case R.id.modify_head_layout:
                break;
            case R.id.modify_user_nick_name:

                break;
            case R.id.modify_user_sex_man:
                break;
            case R.id.modify_user_sex_woman:
                break;
            case R.id.modify_user_sex:
                break;
            case R.id.modify_user_birth_layout:
                break;
            case R.id.modify_user_high_edit:
                break;
            case R.id.modify_user_high_layout:
                break;
            case R.id.modify_user_weight_edit:
                break;
            case R.id.modify_user_weight_layout:
                break;
            case R.id.modify_phone_edit:
                break;
            case R.id.modify_user_bind_phone_layout:
                break;
            case R.id.modify_user_bind_left:
                break;
            case R.id.modify_user_bind_right:
                break;
            case R.id.modify_user_bind_group:
                break;
        }
    }
}
