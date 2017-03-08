package healthy.tichuang.com.customview;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import healthy.tichuang.com.android_handhoop.R;

/**
 * Created by punisher on 2017/3/3.
 */

public class HealthyItem extends FrameLayout {

    private Intent mintent;

    private ImageView iconImage;
    private ImageView arrowImage;
    private TextView titleTv;
    private TextView msgTv;
    private View diverView;

    public HealthyItem(Context context) {
        super(context);
    }

    public HealthyItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HealthyItem(final Context context, final String title, String message, int iconRes, int arrowRes, Intent intent, boolean isShowdiver) {
        super(context);
        mintent = intent;
        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_healthy_item, this);
        iconImage = (ImageView) rootView.findViewById(R.id.healthy_icon_img);
        arrowImage = (ImageView) rootView.findViewById(R.id.healthy_arrow_img);
        titleTv = (TextView) rootView.findViewById(R.id.healthy_title_tv);
        msgTv = (TextView) rootView.findViewById(R.id.healthy_msg_tv);
        diverView = (View) rootView.findViewById(R.id.healthy_diver);

        iconImage.setImageResource(iconRes);
        arrowImage.setImageResource(arrowRes);
        titleTv.setText(title);
        msgTv.setText(message);
        if (isShowdiver){
            diverView.setVisibility(View.VISIBLE);
        }

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
