package healthy.tichuang.com.modle;

/**
 * Created by punisher on 2017/3/29.
 * 短信验证码
 */

public class Vcode {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? "" : phone;
    }
}
