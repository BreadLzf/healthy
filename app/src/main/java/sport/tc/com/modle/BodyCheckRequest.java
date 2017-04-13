package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/13.
 */

public class BodyCheckRequest {

    private  String base_id;
    private  String cur_page;
    private  String page_num;

    public String getBase_id() {
        return base_id;
    }

    public void setBase_id(String base_id) {
        this.base_id = base_id == null ? "" : base_id;
    }

    public String getCur_page() {
        return cur_page;
    }

    public void setCur_page(String cur_page) {
        this.cur_page = cur_page == null ? "" : cur_page;
    }

    public String getPage_num() {
        return page_num;
    }

    public void setPage_num(String page_num) {
        this.page_num = page_num == null ? "" : page_num;
    }
}
