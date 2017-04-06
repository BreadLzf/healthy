package sport.tc.com.customview;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import sport.tc.com.android_handhoop.R;

/**
 * Created by punisher on 2017/3/13.
 */

public class PersonItem extends FrameLayout {
    private Intent mintent;

    private ImageView iconImage;
    private ImageView arrowImage;
    private TextView titleTv;
    private View diverView;



    public PersonItem(Context context) {
        super(context);
    }


    public PersonItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    public PersonItem(final Context context, final String title,  int iconRes, Intent intent, boolean isShowdiver) {
        super(context);
        mintent = intent;
        View rootView = LayoutInflater.from(context).inflate(R.layout.person_item_layout, this);
        iconImage = (ImageView) rootView.findViewById(R.id.person_icon_img);
        titleTv = (TextView) rootView.findViewById(R.id.person_title_tv);
        diverView = (View) rootView.findViewById(R.id.person_diver);
        iconImage.setImageResource(iconRes);
        titleTv.setText(title);
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
