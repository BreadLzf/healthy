package sport.tc.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.modle.HomePageModel;

/**
 * Created by punisher on 2017/3/27.
 */

public class HomePageAdapter extends ItemAdapter<HomePageModel> {

    private List<HomePageModel> mHomePageModelList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private Resources mResources;


    public HomePageAdapter(Activity activity) {
        mContext = activity;
        mLayoutInflater = LayoutInflater.from(mContext);
        mHomePageModelList = new ArrayList<>();
    }

    @Override
    public void setItems(List<HomePageModel> items) {
        super.setItems(items);

    }

    public void setItems(HomePageModel[] items) {
        super.setItems(items);
    }

    @Override
    public void addItems(List<HomePageModel> items) {
        super.addItems(items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HomePageModel model = getItem(position);
        final int type = model.getType();
        View view =buildView(convertView,parent,type);
        switch ( type){
            case  HomePageModel.big:
                inflateBigItem(model, view, position);
                break;

            case  HomePageModel.small:
                inflateSmallItem(model, view, position);
                break;

        }

        return view;
    }


    private View buildView(View convertView, ViewGroup parent, int type) {
        View view = convertView;
        if (view == null) {
            switch (type) {
                case HomePageModel.big:
                    view =mLayoutInflater.inflate(R.layout.home_page_big_item,parent,false);
                    break;

                case HomePageModel.small:
                    view =mLayoutInflater.inflate(R.layout.home_page_small_item,parent,false);
                    break;
            }
        }
        return  view;
    }

    private void  inflateBigItem(HomePageModel  homePageModel,View  view, int  position){
         BigItemHolder bigItemHolder =new BigItemHolder();
    }


    private void  inflateSmallItem(HomePageModel  homePageModel,View  view, int  position){
        SmallItemHolder  smallItemHolder =new SmallItemHolder();
    }


    static   class   BigItemHolder{

    }

    static   class   SmallItemHolder{
    }

}
