package healthy.tichuang.com;

import android.app.Application;

/**
 * Created by punisher on 2017/3/1.
 *
 */

public class MyApplication  extends Application {
    private static MyApplication appInstance = null;
    public  static   boolean  isFirst =false;


    @Override
    public void onCreate() {
        super.onCreate();
        appInstance=this;
    }

    /**
     * 获取单例Application
     * @return
     */
    public static MyApplication getInstance() {
        return appInstance;
    }
}
