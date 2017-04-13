package sport.tc.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.CommentListResponse;

/**
 * Created by punisher on 2017/4/12.
 */

public class CommentListAdapter extends BaseAdapter {

    private List<CommentListResponse.DataBean.CommentListBean> mCommentList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;




    public CommentListAdapter(List<CommentListResponse.DataBean.CommentListBean> commentList, Context context) {
        mContext = context;
        mCommentList = commentList;
        mLayoutInflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mCommentList == null ? 0 : mCommentList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCommentList == null ? 0 : mCommentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_comment_list, null);
            viewHolder = new ViewHolder();
            viewHolder.mCircleImageView = (CircleImageView) view.findViewById(R.id.comment_list_head);
            viewHolder.phoneTv = (TextView) view.findViewById(R.id.comment_list_phone);
            viewHolder.dateTv = (TextView) view.findViewById(R.id.comment_list_date);
            viewHolder.contentTv = (TextView) view.findViewById(R.id.comment_list_content);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        CommentListResponse.DataBean.CommentListBean comment = mCommentList.get(position);
        Glide.with(mContext).load(comment.getHead_img()).into(viewHolder.mCircleImageView);
        viewHolder.phoneTv.setText(comment.getLogin_name());
        viewHolder.dateTv.setText(comment.getCreate_time());
        viewHolder.contentTv.setText(comment.getUser_msg());
        return view;
    }

    static class ViewHolder {
        CircleImageView mCircleImageView;
        TextView phoneTv;
        TextView dateTv;
        TextView contentTv;
    }

}
