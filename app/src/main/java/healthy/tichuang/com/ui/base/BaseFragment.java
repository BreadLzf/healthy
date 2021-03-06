package healthy.tichuang.com.ui.base;

import android.support.v4.app.Fragment;

/**
 * Created by punisher on 2017/3/1.
 */

public abstract class BaseFragment extends Fragment {

    public abstract String getUmengLabel();

    //是否可见
    protected boolean isVisble;
    // 标志位，标志Fragment已经初始化完成。
    public boolean isPrepared = false;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisble = true;
            onVisible();
        } else {
            isVisble = false;
            onInVisible();
        }
    }


    protected void onInVisible() {
        loadData();
    }

    protected void onVisible() {
        //加载数据
        loadData();
    }

    protected abstract void loadData();

}
