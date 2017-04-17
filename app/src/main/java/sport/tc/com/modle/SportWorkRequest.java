package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/17.
 * 运动康复
 */

public class SportWorkRequest {
    private   String  order_id;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id == null ? "" : order_id;
    }
}
