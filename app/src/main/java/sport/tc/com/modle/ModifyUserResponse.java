package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/12.
 */

public class ModifyUserResponse  {


    /**
     * code : 000
     * msg : 成功
     * data : {"user_info":{"id":"42","login_name":"18576759600","password_hash":"$2y$13$Pq0wIeAm0VuKgskB80hfBuCHiQZnwh8NH33H6IinOT6cobo6FgXH6","real_name":"","nick_name":"","head_img":"","phone":"18576759999","sex":"2","birth":"19890313","height":"199","weight":"55","bmi":"68","wear_hand":"2","parse_id":"0","is_perfect":"0","is_delete":"0","create_time":null}}
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
         * user_info : {"id":"42","login_name":"18576759600","password_hash":"$2y$13$Pq0wIeAm0VuKgskB80hfBuCHiQZnwh8NH33H6IinOT6cobo6FgXH6","real_name":"","nick_name":"","head_img":"","phone":"18576759999","sex":"2","birth":"19890313","height":"199","weight":"55","bmi":"68","wear_hand":"2","parse_id":"0","is_perfect":"0","is_delete":"0","create_time":null}
         */

        private UserInfoBean user_info;

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class UserInfoBean {
            /**
             * id : 42
             * login_name : 18576759600
             * password_hash : $2y$13$Pq0wIeAm0VuKgskB80hfBuCHiQZnwh8NH33H6IinOT6cobo6FgXH6
             * real_name :
             * nick_name :
             * head_img :
             * phone : 18576759999
             * sex : 2
             * birth : 19890313
             * height : 199
             * weight : 55
             * bmi : 68
             * wear_hand : 2
             * parse_id : 0
             * is_perfect : 0
             * is_delete : 0
             * create_time : null
             */

            private String id;
            private String login_name;
            private String password_hash;
            private String real_name;
            private String nick_name;
            private String head_img;
            private String phone;
            private String sex;
            private String birth;
            private String height;
            private String weight;
            private String bmi;
            private String wear_hand;
            private String parse_id;
            private String is_perfect;
            private String is_delete;
            private Object create_time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLogin_name() {
                return login_name;
            }

            public void setLogin_name(String login_name) {
                this.login_name = login_name;
            }

            public String getPassword_hash() {
                return password_hash;
            }

            public void setPassword_hash(String password_hash) {
                this.password_hash = password_hash;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getBmi() {
                return bmi;
            }

            public void setBmi(String bmi) {
                this.bmi = bmi;
            }

            public String getWear_hand() {
                return wear_hand;
            }

            public void setWear_hand(String wear_hand) {
                this.wear_hand = wear_hand;
            }

            public String getParse_id() {
                return parse_id;
            }

            public void setParse_id(String parse_id) {
                this.parse_id = parse_id;
            }

            public String getIs_perfect() {
                return is_perfect;
            }

            public void setIs_perfect(String is_perfect) {
                this.is_perfect = is_perfect;
            }

            public String getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(String is_delete) {
                this.is_delete = is_delete;
            }

            public Object getCreate_time() {
                return create_time;
            }

            public void setCreate_time(Object create_time) {
                this.create_time = create_time;
            }
        }
    }
}
