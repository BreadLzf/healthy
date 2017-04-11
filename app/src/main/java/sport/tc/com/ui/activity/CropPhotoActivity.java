package sport.tc.com.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import sport.tc.com.android_handhoop.R;
import sport.tc.com.customview.CropView;
import sport.tc.com.ui.base.BaseActivity;

/**
 * 截取图片
 */
public class CropPhotoActivity extends BaseActivity {

    private static final int BITMAP_MAX_SIZE = 2048;
    private CropView mCropView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_photo);
        initNoBackToolBar("截取头像", "使用", new OnCustomClickListener() {
            @Override
            public void onItemClick() {
                onCropImage();
            }
        });

        Uri data = getIntent().getData();
        InputStream is;
        Bitmap bitmap = null;
        try {
            is = getContentResolver().openInputStream(data);
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception | OutOfMemoryError e) {
            e.printStackTrace();
        } finally {
        }

        if (bitmap!=null){
            bitmap = scaleDownIfTooLarge(bitmap);
        }
        mCropView = (CropView) findViewById(R.id.crop);
        mCropView.setImageBitmap(bitmap);
    }

    private Bitmap scaleDownIfTooLarge(Bitmap bitmap) {

        if (bitmap.getHeight() >= BITMAP_MAX_SIZE || bitmap.getWidth() >= BITMAP_MAX_SIZE) {
            float w, h;
            float bw = bitmap.getWidth();
            float bh = bitmap.getHeight();
            if (bw > bh) {
                w = BITMAP_MAX_SIZE;
                h = w * (bh / bw);
            } else {
                h = BITMAP_MAX_SIZE;
                w = h * (bw / bh);
            }
            return Bitmap.createScaledBitmap(bitmap, (int) w, (int) h, false);
        } else {
            return bitmap;
        }
    }

    private void onCropImage() {
        Bitmap bitmap = mCropView.getCroppedBitmap();
        if (bitmap!=null&&bitmap.getHeight()>0){
            if (bitmap.getHeight() > 200 || bitmap.getWidth() > 200) {
                bitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
            }
        }

        Uri uri = getIntent().getParcelableExtra(MediaStore.EXTRA_OUTPUT);
        writeBitmapToFile(bitmap, new File(uri.getPath()));
        setResult(RESULT_OK, getIntent());
        finish();
    }

    private void writeBitmapToFile(Bitmap bitmap, File file) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
