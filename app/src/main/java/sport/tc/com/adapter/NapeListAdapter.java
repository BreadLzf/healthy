package sport.tc.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.HealthyCircleResponse;

/**
 * Created by punisher on 2017/4/12.
 */

public class NapeListAdapter extends BaseAdapter {

    public List<HealthyCircleResponse.DataBean.ArticleListBean> getArticleListBeen() {
        return mArticleListBeen;
    }

    public void setArticleListBeen(List<HealthyCircleResponse.DataBean.ArticleListBean> articleListBeen) {
        mArticleListBeen = articleListBeen;
    }

    private List<HealthyCircleResponse.DataBean.ArticleListBean> mArticleListBeen;
    private LayoutInflater mLayoutInflater;
    private Context mContext;


    public NapeListAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArticleListBeen == null ? 0 : mArticleListBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return mArticleListBeen == null ? 0 : mArticleListBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final HomeViewHolder viewHolder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_home_page, null);
            viewHolder = new HomeViewHolder();
            viewHolder.mImageView = (ImageView) view.findViewById(R.id.home_page_big_img);
            viewHolder.titleTv = (TextView) view.findViewById(R.id.home_page_big_title);

            viewHolder.contentTv = (TextView) view.findViewById(R.id.home_page_content_tv);
            viewHolder.tagTv = (TextView) view.findViewById(R.id.home_page_big_tag);
            view.setTag(viewHolder);
        } else {
            viewHolder = (HomeViewHolder) view.getTag();
        }

        HealthyCircleResponse.DataBean.ArticleListBean  articleListBean = mArticleListBeen.get(position);

        if (articleListBean != null) {

            viewHolder.titleTv.setText(articleListBean.getTitle());
            //图片集合
            if (articleListBean.getPics() != null && articleListBean.getPics().size() > 0) {
                Glide.with(mContext).load(articleListBean.getPics().get(0)).into(viewHolder.mImageView);
            }


            //内容集合
            List<HealthyCircleResponse.DataBean.ArticleListBean.ArticleJsonBean> jsonBeanList = articleListBean.getArticle_json();
//            if (jsonBeanList != null && jsonBeanList.size() > 0) {
//
//                for (int i = 0; i < jsonBeanList.size(); i++) {
//                    List<String> paragraphs = jsonBeanList.get(i).getParagraphs();
//                    if (paragraphs != null && paragraphs.size() > 0) {
//                        viewHolder.contentTv.setText(paragraphs.get(i));
//                    }
//                }
//            }

            viewHolder.tagTv.setText(articleListBean.getType_str() + "知识");

        }
        return view;
    }

    static class HomeViewHolder {
        ImageView mImageView;
        TextView titleTv;
        TextView contentTv;
        TextView tagTv;
    }

}
