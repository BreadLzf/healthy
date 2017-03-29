package healthy.tichuang.com.modle;

/**
 * Created by punisher on 2017/3/29.
 * 用户登录的时候使用的对象
 */

public class LoginModel {

    private  String login_name;
    private  String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? "" : password;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? "" : login_name;
    }
}
