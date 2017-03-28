package healthy.tichuang.com.ui.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import healthy.tichuang.com.android_handhoop.R;

/**
 * Created by punisher on 2017/2/28.
 * 所有Activity的基类
 */

public class BaseActivity extends AppCompatActivity {

    /**
     * 左边返回图
     * 中间文字
     * @param middleTitle
     * @param leftSource
     */
    public  void  initToolBar(String  middleTitle,int leftSource){
        Toolbar  toolbar =(Toolbar) findViewById(R.id.healthy_normal_toolbar);
        ImageView  imageView =(ImageView)toolbar. findViewById(R.id.custom_tool_left_back);
        TextView textView =(TextView) toolbar. findViewById(R.id.custom_tool_middle_title);
        imageView.setImageResource(leftSource);
        textView.setText(middleTitle);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    /**
     * 左边返回图片 中间标题 右边图片 加事件
     * @param middleTitle
     * @param leftSource
     * @param rightSource
     * @param listener
     */
    public  void  initToolBar(String  middleTitle,int leftSource,int rightSource,final  OnCustomClickListener listener){
        Toolbar  toolbar =(Toolbar) findViewById(R.id.healthy_right_tool);

        ImageView  back =(ImageView)toolbar. findViewById(R.id.healthy_right_tool_back);
        TextView textView =(TextView) toolbar. findViewById(R.id.healthy_right_tool_title);
        ImageView  right=(ImageView)toolbar. findViewById(R.id.healthy_right_tool_img);

        back.setImageResource(leftSource);
        textView.setText(middleTitle);
        right.setImageResource(rightSource);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });

    }

    




//    public void setCustomActionBarEnabled() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayShowCustomEnabled(true);
//    }
//
//
//
//    public void initActionBar(int titleResource) {
//        initActionBar(getString(titleResource));
//    }
//
//    public void initActionBar(String title) {
//        setCustomActionBarEnabled();
//    }
//
//
//
//
//
//      public void initActionBar(int backRes, String middleTitle, int rightRes, final OnCustomClickListener listener) {
//        setCustomActionBarEnabled();
//        View customView = LayoutInflater.from(this).inflate(R.layout.custom_actionbar_layout, null);
//        ImageView rightImg = (ImageView) customView.findViewById(R.id.custom_right_img);
//        ((TextView) customView.findViewById(R.id.custom_middle_title)).setText(middleTitle);
//
//        customView.findViewById(R.id.custom_left_back).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        rightImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onItemClick();
//            }
//        });
//        getSupportActionBar().setCustomView(customView);
//    }
//
//    public void initActionBar( String middleTitle,  final OnCustomClickListener listener) {
//        setCustomActionBarEnabled();
//        View customView = LayoutInflater.from(this).inflate(R.layout.custom_tool_back, null);
//        ((TextView) customView.findViewById(R.id.custom_middle_title)).setText(middleTitle);
//
//        customView.findViewById(R.id.custom_left_back).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//
//        getSupportActionBar().setCustomView(customView);
//    }
//
//
//
//
//    public void initActionBar(String middleTitle, String rightTitle, final OnCustomClickListener listener) {
//        setCustomActionBarEnabled();
//
//        View customView = LayoutInflater.from(this).inflate(R.layout.custom_action_title_layout, null);
//        ((TextView) customView.findViewById(R.id.custom_title_right)).setText(rightTitle);
//        ((TextView) customView.findViewById(R.id.custom_title_middle)).setText(middleTitle);
//        TextView right = (TextView) customView.findViewById(R.id.custom_title_right);
//
//
//        right.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.onItemClick();
//            }
//        });
//        getSupportActionBar().setCustomView(customView);
//
//    }








    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 自定义ActionBar样式的Item点击
     */
    public interface OnCustomClickListener {
        void onItemClick();
    }

    public interface OnCustomClickListener2 {
        void onItemClick1();

        void onItemClick2();
    }

}
