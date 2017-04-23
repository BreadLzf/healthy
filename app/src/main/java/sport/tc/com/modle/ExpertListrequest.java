package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/23.
 */

public class ExpertListrequest {
    private String start_time;

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time == null ? "" : start_time;
    }
}
