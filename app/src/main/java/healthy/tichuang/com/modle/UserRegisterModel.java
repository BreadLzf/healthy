package healthy.tichuang.com.modle;

/**
 * Created by punisher on 2017/3/29.
 * 设置get set模版
 * 用户注册接口
 */

public class UserRegisterModel {

    private  String  login_name;
    private  String  password;
    private  String  vcode;

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? "" : login_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? "" : password;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode == null ? "" : vcode;
    }
}
