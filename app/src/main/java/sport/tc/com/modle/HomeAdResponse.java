package sport.tc.com.modle;

import java.util.List;

/**
 * Created by punisher on 2017/4/23.
 */

public class HomeAdResponse {
    /**
     * code : 000
     * msg : 成功
     * data : [{"id":"1","img_url":"http://hsm.oztechgroup.com/images/avatar/avatar_149258446377.png","sort":"1","status":"1","article":"[{\"type\":\"list\",\"paragraphs\":[\"仁慈的父我已坠入\\n看不见罪的国度\\n请原谅我的自负\\n没人能说没人可说\\n好难承受\\n荣耀的背后刻着一道孤独\"]}]"},{"id":"2","img_url":"http://hsm.oztechgroup.com/images/avatar/avatar_149258162241.jpg","sort":"2","status":"1","article":"[]"},{"id":"3","img_url":"http://hsm.oztechgroup.com/images/avatar/avatar_149258163269.jpg","sort":"3","status":"1","article":"[]"}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * img_url : http://hsm.oztechgroup.com/images/avatar/avatar_149258446377.png
         * sort : 1
         * status : 1
         * article : [{"type":"list","paragraphs":["仁慈的父我已坠入\n看不见罪的国度\n请原谅我的自负\n没人能说没人可说\n好难承受\n荣耀的背后刻着一道孤独"]}]
         */

        private String id;
        private String img_url;
        private String sort;
        private String status;
        private String article;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getArticle() {
            return article;
        }

        public void setArticle(String article) {
            this.article = article;
        }
    }
}
