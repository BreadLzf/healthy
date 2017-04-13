package sport.tc.com.modle;

import java.util.List;

/**
 * Created by punisher on 2017/4/13.
 */

public class CommentListResponse {

    /**
     * code : 000
     * msg : 成功
     * data : {"page":{"total_page":4,"total_num":"4","cur_page":1,"page_num":1},"comment_list":[{"user_msg":"Trfggfdghhhgb","create_time":"2017-04-10 20:53:16","login_name":"18641371890","head_img":"http://hsm.oztechgroup.com/images/avatar/avatar_14918996059.jpeg"}]}
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
         * page : {"total_page":4,"total_num":"4","cur_page":1,"page_num":1}
         * comment_list : [{"user_msg":"Trfggfdghhhgb","create_time":"2017-04-10 20:53:16","login_name":"18641371890","head_img":"http://hsm.oztechgroup.com/images/avatar/avatar_14918996059.jpeg"}]
         */

        private PageBean page;
        private List<CommentListBean> comment_list;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<CommentListBean> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<CommentListBean> comment_list) {
            this.comment_list = comment_list;
        }

        public static class PageBean {
            /**
             * total_page : 4
             * total_num : 4
             * cur_page : 1
             * page_num : 1
             */

            private int total_page;
            private String total_num;
            private int cur_page;
            private int page_num;

            public int getTotal_page() {
                return total_page;
            }

            public void setTotal_page(int total_page) {
                this.total_page = total_page;
            }

            public String getTotal_num() {
                return total_num;
            }

            public void setTotal_num(String total_num) {
                this.total_num = total_num;
            }

            public int getCur_page() {
                return cur_page;
            }

            public void setCur_page(int cur_page) {
                this.cur_page = cur_page;
            }

            public int getPage_num() {
                return page_num;
            }

            public void setPage_num(int page_num) {
                this.page_num = page_num;
            }
        }

        public static class CommentListBean {
            /**
             * user_msg : Trfggfdghhhgb
             * create_time : 2017-04-10 20:53:16
             * login_name : 18641371890
             * head_img : http://hsm.oztechgroup.com/images/avatar/avatar_14918996059.jpeg
             */

            private String user_msg;
            private String create_time;
            private String login_name;
            private String head_img;

            public String getUser_msg() {
                return user_msg;
            }

            public void setUser_msg(String user_msg) {
                this.user_msg = user_msg;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getLogin_name() {
                return login_name;
            }

            public void setLogin_name(String login_name) {
                this.login_name = login_name;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img;
            }
        }
    }
}
