package sport.tc.com.modle;

/**
 * 文章点赞返回modle
 * Created by punisher on 2017/4/15.
 */

public class NapeLikeResponse {


    /**
     * code : 000
     * msg : 成功
     * data : {"price_status":"add"}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * price_status : add
         */

        private String price_status;

        public String getPrice_status() {
            return price_status;
        }

        public void setPrice_status(String price_status) {
            this.price_status = price_status;
        }
    }
}
