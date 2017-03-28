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
     *
     * @param middleTitle
     * @param leftSource
     */
    public void initToolBar(String middleTitle, int leftSource) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.healthy_normal_toolbar);
        ImageView imageView = (ImageView) toolbar.findViewById(R.id.custom_tool_left_back);
        TextView textView = (TextView) toolbar.findViewById(R.id.custom_tool_middle_title);
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
     *
     * @param middleTitle
     * @param leftSource
     * @param rightSource
     * @param listener
     */
    public void initRightImgToolBar(String middleTitle, int leftSource, int rightSource, final OnCustomClickListener listener) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.healthy_right_tool);

        ImageView back = (ImageView) toolbar.findViewById(R.id.healthy_right_tool_back);
        TextView textView = (TextView) toolbar.findViewById(R.id.healthy_right_tool_title);
        ImageView right = (ImageView) toolbar.findViewById(R.id.healthy_right_tool_img);

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


    /**
     * 左边返回 中间标题 右边文字
     *
     * @param middleTitle
     * @param leftSource
     * @param rightStr
     * @param listener
     */
    public void initRightTextToolBar(String middleTitle, int leftSource, String rightStr, final OnCustomClickListener listener) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.healthy_tool_text);

        ImageView back = (ImageView) toolbar.findViewById(R.id.healthy_tool_text_back);
        TextView textView = (TextView) toolbar.findViewById(R.id.healthy_tool_text_title);
        TextView rightTv = (TextView) toolbar.findViewById(R.id.healthy_tool_text_msg);

        back.setImageResource(leftSource);
        textView.setText(middleTitle);
        rightTv.setText(rightStr);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        rightTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });

    }


    /**
     * 没有返回按钮的toolbar
     *
     * @param middleTitle
     * @param rightStr
     * @param listener
     */
    public void initNoBackToolBar(String middleTitle, String rightStr, final OnCustomClickListener listener) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.healthy_no_back_tool);
        TextView textView = (TextView) toolbar.findViewById(R.id.healthy_no_back_tool_title);
        TextView rightTv = (TextView) toolbar.findViewById(R.id.healthy_no_back_tool_msg);
        textView.setText(middleTitle);
        rightTv.setText(rightStr);
        rightTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });
    }


    /**
     * 没有标题的toolbar
     *
     * @param leftBack
     * @param rightStr
     * @param listener
     */
    public void initNoTitleToolBar(int leftBack, int rightStr, final OnCustomClickListener listener) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.healthy_no_title_toolbar);
        ImageView back = (ImageView) toolbar.findViewById(R.id.healthy_no_title_toolbar_back);
        ImageView rightTv = (ImageView) toolbar.findViewById(R.id.healthy_no_title_toolbar_img);
        back.setImageResource(leftBack);
        rightTv.setImageResource(rightStr);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        rightTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick();
            }
        });

    }


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
