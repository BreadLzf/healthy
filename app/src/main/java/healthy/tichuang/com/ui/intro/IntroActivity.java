package healthy.tichuang.com.ui.intro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import healthy.tichuang.com.android_handhoop.R;
import healthy.tichuang.com.ui.home.HomeActivity;
import healthy.tichuang.com.ui.login.AuthorLoginActivity;

/**
 * 启动介绍
 */
public class IntroActivity extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener {


    private ViewPager mViewPager;
    private IntroViewPagerAdapter mPagerAdapter;

    private Button btnQuickLogin;
    private Button btnEntryApp;

    private ArrayList<View> mViews;

    private static final int[] mIntroPics = {};

    private ImageView[] mPoints;

    private int mCurrentIndex;

    private boolean isStopped = false;
    /**
     * 快速登录
     */
    private boolean mQuickLogin = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        initView();
        initData();

    }

    private void initView() {
        mViews = new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.vp_intro);
        mPagerAdapter = new IntroViewPagerAdapter();


    }

    private void initData() {

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT
                , LinearLayout.LayoutParams.MATCH_PARENT);

        for (int i = 0; i < mIntroPics.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setImageResource(mIntroPics[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mViews.add(imageView);
        }

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(this);

        initPoint();
    }

    private void initPoint() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_bottom_dots);

        mPoints = new ImageView[mIntroPics.length];

        for (int i = 0; i < mIntroPics.length; i++) {
            mPoints[i] = (ImageView) linearLayout.getChildAt(i);
            setDotEnable(mPoints[i], false);
            mPoints[i].setTag(i);
        }

        mCurrentIndex = 0;
        setDotEnable(mPoints[mCurrentIndex], true);
    }

    private void setDotEnable(ImageView dot, boolean enable) {
        if (enable)
            dot.setImageResource(R.mipmap.ic_launcher);
        else
            dot.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentDot(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        isStopped = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isStopped) {
            entryHome();
        }
    }

    private void entryHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        mQuickLogin = false;
        finish();
    }

    private void quickLogin() {
        startActivity(AuthorLoginActivity.createIntent(this));
    }

    private void setCurrentDot(int index) {
        if (index < 0 || index > mIntroPics.length - 1 || mCurrentIndex == index) {
            return;
        }
        setDotEnable(mPoints[index], true);
        setDotEnable(mPoints[mCurrentIndex], false);

        mCurrentIndex = index;

        changeButtonColor();
    }

    private void changeButtonColor() {
        if (mCurrentIndex == 0) {
            btnEntryApp.setTextColor(getResources().getColor(R.color.intro_blue_color));
            btnQuickLogin.setTextColor(getResources().getColor(R.color.intro_blue_color));
        } else {
            btnEntryApp.setTextColor(getResources().getColor(R.color.intro_red_color));
            btnQuickLogin.setTextColor(getResources().getColor(R.color.intro_red_color));
        }
    }


    class IntroViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViews.get(position), 0);
            return mViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }
    }


}