package sport.tc.com.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.BodyCheckResponse;
import sport.tc.com.util.AppHelper;

/**
 * Created by lzf on 16/5/5.
 */
public class BodyCheckAdapter extends BaseAdapter {
    private List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String> typeCount = new ArrayList<>();

    public void setConfigInfoBeanList(List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> configInfoBeanList) {
        mConfigInfoBeanList = configInfoBeanList;
    }

    /**
     * 1 : "文本框"
     * 2 : "单选框"
     * 3 : "打钩选项框"

     */
    private final String EDIT = "1",  CHECK = "2", RADIO = "3";


    public BodyCheckAdapter( Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }


    public List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> getConfigInfoBeanList() {
        return mConfigInfoBeanList;
    }


    @Override
    public int getCount() {

        return mConfigInfoBeanList == null ? 0 : mConfigInfoBeanList.size();

    }

    @Override
    public Object getItem(int position) {

        return mConfigInfoBeanList == null ? 0 : mConfigInfoBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EditViewHolder editViewHolder = null;
        RadioViewHolder radioViewHolder = null;
        CheckViewHolder checkViewHolder = null;
        BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean configInfoBean = mConfigInfoBeanList.get(position);
        String type = configInfoBean.getAttr_type();

        if (convertView == null) {
            switch (type) {
                case EDIT:
                    editViewHolder = new EditViewHolder();
                    convertView = mLayoutInflater.inflate(R.layout.item_body_edit_layout, null);
                    editViewHolder.mTextView = (TextView) convertView.findViewById(R.id.item_body_check_edit_title);
                    editViewHolder.mEditText = (EditText) convertView.findViewById(R.id.item_body_check_edit);
                    convertView.setTag(editViewHolder);

                    break;

                //单选
                case CHECK:
                    checkViewHolder = new CheckViewHolder();
                    convertView = mLayoutInflater.inflate(R.layout.item_body_check_, null);
                    checkViewHolder.titleTv = (TextView) convertView.findViewById(R.id.item_body_check_title);
                    checkViewHolder.chooseTv = (TextView) convertView.findViewById(R.id.item_body_check_choose);
                    convertView.setTag(checkViewHolder);
                    break;



                case RADIO:
                    radioViewHolder = new RadioViewHolder();
                    convertView = mLayoutInflater.inflate(R.layout.item_body_radio, null);
                    radioViewHolder.titleTextView = (TextView) convertView.findViewById(R.id.item_body_radio_title);
                    radioViewHolder.mRadioGroup = (RadioGroup) convertView.findViewById(R.id.item_body_radio_group);
                    radioViewHolder.yesBtn = (RadioButton) convertView.findViewById(R.id.item_body_radio_group_yes);
                    radioViewHolder.noBtn = (RadioButton) convertView.findViewById(R.id.item_body_radio_group_no);
                    convertView.setTag(radioViewHolder);
                    break;




            }
        } else {
            switch (type) {
                case EDIT:
                    editViewHolder = (EditViewHolder) convertView.getTag();

                    break;

                case RADIO:
                    radioViewHolder = (RadioViewHolder) convertView.getTag();

                    break;

                case CHECK:
                    checkViewHolder = (CheckViewHolder) convertView.getTag();

                    break;

            }

        }


        switch (type) {

            case EDIT:
                if (configInfoBean.getAttr_unit()!=null&&configInfoBean.getAttr_unit().length()>0){
                    editViewHolder.mTextView.setText(configInfoBean.getAttr_title()+"("+configInfoBean.getAttr_unit()+")");
                }
                if (configInfoBean.getDefault_value()!=null){
                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());
                }

                break;

            case CHECK:
                if (configInfoBean.getAttr_unit()!=null&&configInfoBean.getAttr_unit().length()>0){
                    checkViewHolder.titleTv.setText(configInfoBean.getAttr_title()+"("+configInfoBean.getAttr_unit()+")");
                }
                if (configInfoBean.getDefault_value()!=null){
                    checkViewHolder.chooseTv.setText(configInfoBean.getDefault_value());
                }

                break;


            case RADIO:
                if (configInfoBean.getAttr_unit()!=null&&configInfoBean.getAttr_unit().length()>0){
                    radioViewHolder.titleTextView.setText(configInfoBean.getAttr_title()+"("+configInfoBean.getAttr_unit()+")");
                }


                break;


        }
        return convertView;
    }


    @Override
    public int getItemViewType(int position) {
        return Integer.valueOf(mConfigInfoBeanList.get(position).getAttr_type())-1;
    }

    @Override
    public int getViewTypeCount() {

        for (int i = 0; i < mConfigInfoBeanList.size(); i++) {
            if (mConfigInfoBeanList.get(i)!=null&&mConfigInfoBeanList.get(i).getAttr_type()!=null){
                typeCount.add(mConfigInfoBeanList.get(i).getAttr_type());
            }
        }
        List<String> newTypeCount = AppHelper.removeDuplicate(typeCount);
        return newTypeCount.size();
    }

    /**
     * 可编辑
     */
    static class EditViewHolder {
        TextView mTextView;
        EditText mEditText;
    }

    /**
     * 打钩
     */
    static class RadioViewHolder {
        TextView titleTextView;
        RadioGroup mRadioGroup;
        RadioButton yesBtn;
        RadioButton noBtn;
    }


    /**
     * 单选
     */
    static class CheckViewHolder {
        TextView titleTv;
        TextView chooseTv;


    }
}
