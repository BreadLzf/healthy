package sport.tc.com.modle;

import java.io.Serializable;

/**
 * Created by punisher on 2017/4/5.
 * 完善用户信息的model
 */

public class ModifyUser implements Serializable {

    private String id;
    private String sex;
    private String birth;
    private String height;
    private String weight;
    private String bmi;
    private String phone;
    private String wear_hand;
    private  String nick_name;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? "" : nick_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? "" : id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? "" : phone;
    }

    public String getWear_hand() {
        return wear_hand;
    }

    public void setWear_hand(String wear_hand) {
        this.wear_hand = wear_hand == null ? "" : wear_hand;
    }
}
