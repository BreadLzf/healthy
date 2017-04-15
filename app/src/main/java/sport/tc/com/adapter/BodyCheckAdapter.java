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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import sport.tc.com.AppContents;
import sport.tc.com.modle.BodyCheckResponse;
import sport.tc.com.util.AppHelper;

/**
 * Created by lzf on 16/5/5.
 */
public class BodyCheckAdapter extends BaseAdapter {
    private  BodyCheckResponse mBodyCheckResponse;
    private List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean>    mConfigInfoBeanList;
    private LayoutInflater mLayoutInflater;
    private Context        mContext;
    private Resources      mResources;
    private  List<String>  typeCount;
    /**
     * 1 : "文本框"
     2 : "单选框"
     3 : "打钩选项框"
     */
    private final String  EDIT = "1", RADIO = "2", CHECK = "3";


    public BodyCheckAdapter(List<BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean> mConfigInfoBeanList,  BodyCheckResponse mBodyCheckResponse, Context context, LayoutInflater inflater) {
        mConfigInfoBeanList =mConfigInfoBeanList;
        mContext = context;
        mBodyCheckResponse =mBodyCheckResponse;
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
        TextViewHolder textViewHolder = null;
        BodyCheckResponse.DataBean.AssessInfoBean.TagBean.ConfigInfoBean  configInfoBean  = mConfigInfoBeanList.get(position);
       String  type = configInfoBean.getAttr_type();

        if (convertView == null) {

            switch (type) {
                case EDIT:

                    editViewHolder = new EditViewHolder();
                    editViewHolder.mTextView.setText(configInfoBean.getAttr_title());
                    String  attr_type =configInfoBean.getAttr_type();
                    String inputType =configInfoBean.getInput_type();

                    switch (attr_type){

                        case AppContents.BODY_CHECK_ATTR_TYPE_EDIT:
                            switch (inputType){
                                case AppContents.BODY_CHECK_INPUT_TYPE_SELF:
                                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());

                                    break;

                                case AppContents.BODY_CHECK_INPUT_TYPE_PROFESS:
                                    editViewHolder.mEditText.setClickable(false);
                                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());

                                    break;

                                case AppContents.BODY_CHECK_INPUT_TYPE_SELF_AND_PROFESS:
                                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());

                                    break;

                                case AppContents.BODY_CHECK_INPUT_TYPE_SYSTEM:
                                    editViewHolder.mEditText.setClickable(false);
                                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());

                                    break;

                                case AppContents.BODY_CHECK_INPUT_TYPE_SESTEM_HAND:
                                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());

                                    break;

                                case AppContents.BODY_CHECK_INPUT_TYPE_DEFAULT_CHECK:
                                    editViewHolder.mEditText.setText(configInfoBean.getDefault_value());

                                    break;
                            }
                            break;

                         //单选
                        case AppContents.BODY_CHECK_ATTR_TYPE_DAN:
                            switch (inputType){
                                case AppContents.BODY_CHECK_INPUT_TYPE_DEFAULT_CHECK:

                                    break;
                            }
                            break;
                         //多个选项
                        case AppContents.BODY_CHECK_ATTR_TYPE_GOU:
                            switch (inputType){
                                case AppContents.BODY_CHECK_INPUT_TYPE_DEFAULT_CHECK:

                                    break;
                            }


                            break;


                    }




                    convertView.setTag(editViewHolder);

                    break;

                case RADIO:
                    radioViewHolder = new RadioViewHolder();
                    convertView.setTag(radioViewHolder);
                    break;

                case CHECK:
                    textViewHolder = new TextViewHolder();
                    convertView.setTag(textViewHolder);

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
                    textViewHolder = (TextViewHolder) convertView.getTag();

                    break;

            }

        }


        switch (type) {

            case EDIT:



                break;


            case RADIO:

                break;

            case CHECK:

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

        for (int  i=0;i<mConfigInfoBeanList.size();i++){
            typeCount.add(mConfigInfoBeanList.get(i).getAttr_type());
        }
        List<String>  newTypeCount = AppHelper.removeDuplicate(typeCount);
        return newTypeCount.size();
    }

    /**
     * 可编辑
     */
    static class EditViewHolder {
        TextView  mTextView;
        EditText  mEditText;
    }

    /**
     * 单选
     */
    static class RadioViewHolder {
       TextView mTextView;
        RadioGroup  mRadioGroup;
        RadioButton  oneRadioButton;
        RadioButton  twoRadioButton;
    }


    /**
     * 显示
     */
    static class TextViewHolder {
        TextView titleTextView;
        TextView contentTextView;
    }
}
