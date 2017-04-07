package sport.tc.com.modle;

import java.io.Serializable;

/**
 * Created by punisher on 2017/4/7.
 */

public class Account implements Serializable{


    /**
     * code : 000
     * msg : 成功
     * data : {"user_identity":"iq7Y5i2J4It4b48bOF7fEGZkZTBlNTVkZjkwYzJhNjE4MzAzZjFjYmVkN2QzNzNhNmJhNGE3ODNkNTM3Njk3M2ZhODhkMjEzMmJjNTJiNTcNRAFaBZJU+aHNTtBaiBVQ+UGgfoDXp/fWKOqjnaN0QO2JUl9Rg77MwFIpcsXtosYwaKRPdJUzL98SpOTbHjIcaswyoqKR+S8VU22crjj6Cw==","user_info":{"id":"40","login_name":"18641371890","password_hash":"$2y$13$byM1CxnmfydqJVy0ac3aturlyUFYZpczFsI4ay0MyxrrDiE1z7wJe","real_name":"","nick_name":"","head_img":"","phone":"18641371890","sex":"0","birth":"","height":"0","weight":"0","bmi":"0","wear_hand":"0","parse_id":"0","is_perfect":"0","is_delete":"0"}}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? "" : code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? "" : msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_identity : iq7Y5i2J4It4b48bOF7fEGZkZTBlNTVkZjkwYzJhNjE4MzAzZjFjYmVkN2QzNzNhNmJhNGE3ODNkNTM3Njk3M2ZhODhkMjEzMmJjNTJiNTcNRAFaBZJU+aHNTtBaiBVQ+UGgfoDXp/fWKOqjnaN0QO2JUl9Rg77MwFIpcsXtosYwaKRPdJUzL98SpOTbHjIcaswyoqKR+S8VU22crjj6Cw==
         * user_info : {"id":"40","login_name":"18641371890","password_hash":"$2y$13$byM1CxnmfydqJVy0ac3aturlyUFYZpczFsI4ay0MyxrrDiE1z7wJe","real_name":"","nick_name":"","head_img":"","phone":"18641371890","sex":"0","birth":"","height":"0","weight":"0","bmi":"0","wear_hand":"0","parse_id":"0","is_perfect":"0","is_delete":"0"}
         */

        private String user_identity;
        private UserInfoBean user_info;

        public String getUser_identity() {
            return user_identity;
        }

        public void setUser_identity(String user_identity) {
            this.user_identity = user_identity == null ? "" : user_identity;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class UserInfoBean {
            /**
             * id : 40
             * login_name : 18641371890
             * password_hash : $2y$13$byM1CxnmfydqJVy0ac3aturlyUFYZpczFsI4ay0MyxrrDiE1z7wJe
             * real_name :
             * nick_name :
             * head_img :
             * phone : 18641371890
             * sex : 0
             * birth :
             * height : 0
             * weight : 0
             * bmi : 0
             * wear_hand : 0
             * parse_id : 0
             * is_perfect : 0
             * is_delete : 0
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

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id == null ? "" : id;
            }

            public String getLogin_name() {
                return login_name;
            }

            public void setLogin_name(String login_name) {
                this.login_name = login_name == null ? "" : login_name;
            }

            public String getPassword_hash() {
                return password_hash;
            }

            public void setPassword_hash(String password_hash) {
                this.password_hash = password_hash == null ? "" : password_hash;
            }

            public String getReal_name() {
                return real_name;
            }

            public void setReal_name(String real_name) {
                this.real_name = real_name == null ? "" : real_name;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name == null ? "" : nick_name;
            }

            public String getHead_img() {
                return head_img;
            }

            public void setHead_img(String head_img) {
                this.head_img = head_img == null ? "" : head_img;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone == null ? "" : phone;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex == null ? "" : sex;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth == null ? "" : birth;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height == null ? "" : height;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight == null ? "" : weight;
            }

            public String getBmi() {
                return bmi;
            }

            public void setBmi(String bmi) {
                this.bmi = bmi == null ? "" : bmi;
            }

            public String getWear_hand() {
                return wear_hand;
            }

            public void setWear_hand(String wear_hand) {
                this.wear_hand = wear_hand == null ? "" : wear_hand;
            }

            public String getParse_id() {
                return parse_id;
            }

            public void setParse_id(String parse_id) {
                this.parse_id = parse_id == null ? "" : parse_id;
            }

            public String getIs_perfect() {
                return is_perfect;
            }

            public void setIs_perfect(String is_perfect) {
                this.is_perfect = is_perfect == null ? "" : is_perfect;
            }

            public String getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(String is_delete) {
                this.is_delete = is_delete == null ? "" : is_delete;
            }
        }
    }
}
