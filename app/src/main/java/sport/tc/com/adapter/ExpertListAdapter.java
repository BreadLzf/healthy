package sport.tc.com.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.ExpertListResponse;
import sport.tc.com.ui.activity.ExpertDetailActivity;

/**
 * Created by punisher on 2017/4/12.
 */

public class ExpertListAdapter extends BaseAdapter {


    private List<ExpertListResponse.DataBean.ExpertListBean> mListBeanList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public List<ExpertListResponse.DataBean.ExpertListBean> getListBeanList() {
        return mListBeanList;
    }

    public void setListBeanList(List<ExpertListResponse.DataBean.ExpertListBean> listBeanList) {
        mListBeanList = listBeanList;
    }

    public ExpertListAdapter(Context context) {
        Log.e("data", "homeadapter");
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListBeanList == null ? 0 : mListBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return mListBeanList == null ? 0 : mListBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ExpertViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_expert_list_layout, null);
            viewHolder = new ExpertViewHolder();
            viewHolder.mImageView = (CircleImageView) view.findViewById(R.id.expert_list_head_view);
            viewHolder.titleTv = (TextView) view.findViewById(R.id.expert_list_title_tv);
            viewHolder.contentTv = (TextView) view.findViewById(R.id.expert_list_content_tv);
            viewHolder.oderTv = (TextView) view.findViewById(R.id.expert_list_order_expert);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ExpertViewHolder) view.getTag();
        }

        ExpertListResponse.DataBean.ExpertListBean expertListBean = mListBeanList.get(position);


        if (expertListBean != null) {
            if (expertListBean.getHead_pic() != null) {
                Glide.with(mContext).load(expertListBean.getHead_pic()).into(viewHolder.mImageView);
            }

            if (!expertListBean.getUser_name().isEmpty()) {
                viewHolder.titleTv.setText(expertListBean.getUser_name());
            }

            if (!expertListBean.getIntroduce().isEmpty()) {
                viewHolder.contentTv.setText(expertListBean.getIntroduce());
            }


        }




        viewHolder.oderTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ExpertDetailActivity.class);
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    static class ExpertViewHolder {
        CircleImageView mImageView;
        TextView titleTv;
        TextView contentTv;
        TextView oderTv;
    }

}
