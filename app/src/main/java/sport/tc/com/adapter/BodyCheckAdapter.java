package sport.tc.com.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.BodyCheckResponse;
import sport.tc.com.util.AppHelper;

/**
 * Created by lzf on 16/5/5.
 */
public class BodyCheckAdapter extends BaseAdapter {
    private BodyCheckResponse mBodyCheckResponse;
    private List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private Resources mResources;
    private List<String> typeCount;
    /**
     * 1 : "文本框"
     * 2 : "单选框"
     * 3 : "打钩选项框"
     */
    private final String EDIT = "1", RADIO = "2", CHECK = "3";


    public BodyCheckAdapter(List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList, BodyCheckResponse mBodyCheckResponse, Context context, LayoutInflater inflater) {
        mConfigInfoBeanList = mConfigInfoBeanList;
        mContext = context;
        mBodyCheckResponse = mBodyCheckResponse;
        mLayoutInflater = LayoutInflater.from(mContext);
        mResources = inflater.getContext().getResources();


    }


    public List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> getConfigInfoBeanList() {
        return mConfigInfoBeanList;
    }

    public void setAlbumList(List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList) {
        mConfigInfoBeanList = mConfigInfoBeanList;
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
        GroupViewHolder groupViewHolder = null;
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

                case RADIO:
                    radioViewHolder = new RadioViewHolder();
                    convertView = mLayoutInflater.inflate(R.layout.item_body_check_layout, null);
                    radioViewHolder.titleTextView = (TextView) convertView.findViewById(R.id.item_body_check_sex_title);
                    radioViewHolder.contentTextView = (TextView) convertView.findViewById(R.id.item_body_check_sex_tv);
                    radioViewHolder.titleTextView.setText(configInfoBean.getAttr_title());
                    convertView.setTag(radioViewHolder);
                    break;

                case CHECK:
                    groupViewHolder = new GroupViewHolder();
                    convertView = mLayoutInflater.inflate(R.layout.item_body_check_group, null);
                    groupViewHolder.mRadioGroup = (RadioGroup) convertView.findViewById(R.id.item_body_check_radio_group);
                    groupViewHolder.mTextView = (TextView) convertView.findViewById(R.id.item_body_check_group_title);

                    convertView.setTag(groupViewHolder);

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
                    groupViewHolder = (GroupViewHolder) convertView.getTag();

                    break;

            }

        }


        switch (type) {

            case EDIT:
                if (!configInfoBean.getDefault_value().isEmpty()) {
                    editViewHolder.mTextView.setText(configInfoBean.getAttr_title());
                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());
                    switch (configInfoBean.getInput_type()) {
                        case AppContents.BODY_CHECK_INPUT_TYPE_SELF:
                            break;
                        case AppContents.BODY_CHECK_INPUT_TYPE_PROFESS:
                            break;
                        case AppContents.BODY_CHECK_INPUT_TYPE_SELF_AND_PROFESS:
                            break;
                        case AppContents.BODY_CHECK_INPUT_TYPE_SYSTEM:
                            break;
                        case AppContents.BODY_CHECK_INPUT_TYPE_SESTEM_HAND:
                            break;
                    }
                } else {
                    //不是默认值的
                }

                break;

            case RADIO:

                if (!configInfoBean.getDefault_value().isEmpty()){
                    radioViewHolder.titleTextView.setText(configInfoBean.getAttr_title() );
                }else{
                    //不是默认值
                }

                break;

            case CHECK:
                if (!configInfoBean.getDefault_value().isEmpty()){
                    groupViewHolder.mTextView.setText(configInfoBean.getAttr_title() );
                }else{
                  //不是默认值
                }

                break;
        }
        return convertView;
    }


    @Override
    public int getItemViewType(int position) {
        return Integer.valueOf(mConfigInfoBeanList.get(position).getAttr_type());
    }

    @Override
    public int getViewTypeCount() {

        for (int i = 0; i < mConfigInfoBeanList.size(); i++) {
            typeCount.add(mConfigInfoBeanList.get(i).getAttr_type());
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
     * 单选
     */
    static class RadioViewHolder {
        TextView titleTextView;
        TextView contentTextView;
    }


    /**
     * 多选
     */
    static class GroupViewHolder {
        TextView mTextView;
        RadioGroup mRadioGroup;


    }
}
