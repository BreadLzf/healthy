package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/17.
 * 专家详情
 */

public class ExpertDetailRequest {
    private  String  expert_id;

    public String getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(String expert_id) {
        this.expert_id = expert_id == null ? "" : expert_id;
    }
}
