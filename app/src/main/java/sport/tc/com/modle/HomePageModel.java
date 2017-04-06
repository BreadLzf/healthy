package sport.tc.com.modle;

/**
 * Created by punisher on 2017/3/27.
 */

public class HomePageModel {


    public  static  final  int  big=0;
    public  static  final  int small=1;
    private int type;
    private String title;
    private String bigImg;
    private String[] smallImgs;
    private String bigTag;
    private String smallTag;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public  static  final  int TYPE_COUNT=2;
}
