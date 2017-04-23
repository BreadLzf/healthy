package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/23.
 */

public class ExpertDetailResponse {
    /**
     * code : 000
     * msg : 成功
     * data : {"expert_data":{"expert_id":"19","head_pic":"http://hsm.oztechgroup.com/uploads/1e80bd09f43dc0d22f568c73b7c8c230.jpeg","introduce":"江苏省体育科学研究所&nbsp; 助理研究员美国南加州大学运动学和物理治疗系访问学者，获美国\u201ciHP功能性体能训练机构\u201d高级教练证书。多年从事国家队和省队职业运动员伤后的运动康复和体能训练，涉及足球、篮球、排球、英式橄榄球、乒乓球、举重、赛艇、马拉松、竞走、跳远、铁饼和十项全能等。擅长肩、髋、膝、踝关节运动损伤的物理治疗及后续功能训练方案的设计。&nbsp;","user_name":"顾庆"}}
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
         * expert_data : {"expert_id":"19","head_pic":"http://hsm.oztechgroup.com/uploads/1e80bd09f43dc0d22f568c73b7c8c230.jpeg","introduce":"江苏省体育科学研究所&nbsp; 助理研究员美国南加州大学运动学和物理治疗系访问学者，获美国\u201ciHP功能性体能训练机构\u201d高级教练证书。多年从事国家队和省队职业运动员伤后的运动康复和体能训练，涉及足球、篮球、排球、英式橄榄球、乒乓球、举重、赛艇、马拉松、竞走、跳远、铁饼和十项全能等。擅长肩、髋、膝、踝关节运动损伤的物理治疗及后续功能训练方案的设计。&nbsp;","user_name":"顾庆"}
         */

        private ExpertDataBean expert_data;

        public ExpertDataBean getExpert_data() {
            return expert_data;
        }

        public void setExpert_data(ExpertDataBean expert_data) {
            this.expert_data = expert_data;
        }

        public static class ExpertDataBean {
            /**
             * expert_id : 19
             * head_pic : http://hsm.oztechgroup.com/uploads/1e80bd09f43dc0d22f568c73b7c8c230.jpeg
             * introduce : 江苏省体育科学研究所&nbsp; 助理研究员美国南加州大学运动学和物理治疗系访问学者，获美国“iHP功能性体能训练机构”高级教练证书。多年从事国家队和省队职业运动员伤后的运动康复和体能训练，涉及足球、篮球、排球、英式橄榄球、乒乓球、举重、赛艇、马拉松、竞走、跳远、铁饼和十项全能等。擅长肩、髋、膝、踝关节运动损伤的物理治疗及后续功能训练方案的设计。&nbsp;
             * user_name : 顾庆
             */

            private String expert_id;
            private String head_pic;
            private String introduce;
            private String user_name;

            public String getExpert_id() {
                return expert_id;
            }

            public void setExpert_id(String expert_id) {
                this.expert_id = expert_id;
            }

            public String getHead_pic() {
                return head_pic;
            }

            public void setHead_pic(String head_pic) {
                this.head_pic = head_pic;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }
        }
    }
}
