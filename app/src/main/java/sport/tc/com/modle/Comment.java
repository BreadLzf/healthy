package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/12.
 */

public class Comment {
    private String url;
    private String phone;
    private String date;
    private String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? "" : url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? "" : phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? "" : date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? "" : content;
    }
}
