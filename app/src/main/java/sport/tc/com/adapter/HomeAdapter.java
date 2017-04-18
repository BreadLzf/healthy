package sport.tc.com.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.HomeResponse;

/**
 * Created by punisher on 2017/4/12.
 */

public class HomeAdapter extends BaseAdapter {

    public List<HomeResponse.DataBean.ArticleListBean> getListBeanList() {
        return mListBeanList;
    }

    public void setListBeanList(List<HomeResponse.DataBean.ArticleListBean> listBeanList) {
        mListBeanList = listBeanList;
    }

    private List<HomeResponse.DataBean.ArticleListBean>  mListBeanList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;


    public HomeAdapter( Context context) {
        Log.e("data","homeadapter");
        mContext = context;
        mLayoutInflater =  (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        Log.e("data","getCount"+mListBeanList.size()+"");

        return mListBeanList == null ? 0 : mListBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        Log.e("data","getItem"+mListBeanList.get(position));

        return mListBeanList == null ? 0 : mListBeanList.get(position);
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

        HomeResponse.DataBean.ArticleListBean articleListBean      = mListBeanList.get(position);

        Log.e("data","getview"+articleListBean.getPics().get(0));

        Glide.with(mContext).load(articleListBean.getPics().get(0)).into(viewHolder.mImageView);
        viewHolder.titleTv.setText(articleListBean.getTitle());
        viewHolder.contentTv.setText(articleListBean.getArticle_json().get(0).getParagraphs().get(0));
        String type= articleListBean.getApp_type();
        Log.e("data  adapter>>>",type);

        switch (type){
            case  "1":
                viewHolder.tagTv.setText("健康圈");

                break;
            case  "2":
                viewHolder.tagTv.setText("局部知识");

                break;
            case  "3":
                viewHolder.tagTv.setText("营养推荐");

                break;
            case  "4":
                viewHolder.tagTv.setText("运动处方");

                break;
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
