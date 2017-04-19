package sport.tc.com.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by punisher on 2017/4/19.
 */

public class SlowillResponse {

    /**
     * code : 000
     * msg : 成功
     * data : {"assessInfo":{"title":"慢性病测评","description":"健康测评是宜康网专业开发的一系列的在线健康评估模型应用,主要涉及体质与身体状况、基本性格、生活方式与习惯、颈椎病、心脑血管系统疾病、糖尿病、呼吸系统疾病","pic":"hsm.oztechgroup.com/uploads/assess-base_1492485227_9427.jpg","tag_map_description":{"attr_type_map":{"1":"文本框","2":"单选框","3":"打钩选项框"},"attr_input_map":{"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}},"tag":[{"tag_id":"6","tag_title":"已知的疾病","rank":"1","description":"心脏、外周动脉或脑血管疾病","type":"0","config_info":[{"attr_title":"心脏、外周动脉或脑血管疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":"心脑血管"},"uncheck":{"description":""}}},"is_require":"1","config_id":"8"},{"attr_title":"肺脏疾病：慢性阻塞性肺病、哮喘、其他肺病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"2","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"B"}}},"is_require":"1","config_id":"9"},{"attr_title":"代谢疾病：糖尿病、甲状腺异常和肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"3","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"BBB"}}},"is_require":"1","config_id":"10"},{"attr_title":"运动会导致加重的骨关节炎、运动系统疾病。","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"11"},{"attr_title":"肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"5","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"12"}]},{"tag_id":"8","tag_title":"体征或症状","rank":"2","description":"体征或症状","type":"0","config_info":[{"attr_title":"疼痛：胸部、颈部、臂部或其他部位的 疼痛、不舒服，劳力后加重。（注意：由局部缺血引起的或其他类似于心绞痛的疼痛，其他原因疼痛不算）","tag_id":"8","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"13"}]}]}}
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
         * assessInfo : {"title":"慢性病测评","description":"健康测评是宜康网专业开发的一系列的在线健康评估模型应用,主要涉及体质与身体状况、基本性格、生活方式与习惯、颈椎病、心脑血管系统疾病、糖尿病、呼吸系统疾病","pic":"hsm.oztechgroup.com/uploads/assess-base_1492485227_9427.jpg","tag_map_description":{"attr_type_map":{"1":"文本框","2":"单选框","3":"打钩选项框"},"attr_input_map":{"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}},"tag":[{"tag_id":"6","tag_title":"已知的疾病","rank":"1","description":"心脏、外周动脉或脑血管疾病","type":"0","config_info":[{"attr_title":"心脏、外周动脉或脑血管疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":"心脑血管"},"uncheck":{"description":""}}},"is_require":"1","config_id":"8"},{"attr_title":"肺脏疾病：慢性阻塞性肺病、哮喘、其他肺病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"2","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"B"}}},"is_require":"1","config_id":"9"},{"attr_title":"代谢疾病：糖尿病、甲状腺异常和肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"3","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"BBB"}}},"is_require":"1","config_id":"10"},{"attr_title":"运动会导致加重的骨关节炎、运动系统疾病。","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"11"},{"attr_title":"肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"5","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"12"}]},{"tag_id":"8","tag_title":"体征或症状","rank":"2","description":"体征或症状","type":"0","config_info":[{"attr_title":"疼痛：胸部、颈部、臂部或其他部位的 疼痛、不舒服，劳力后加重。（注意：由局部缺血引起的或其他类似于心绞痛的疼痛，其他原因疼痛不算）","tag_id":"8","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"13"}]}]}
         */

        private AssessInfoBean assessInfo;

        public AssessInfoBean getAssessInfo() {
            return assessInfo;
        }

        public void setAssessInfo(AssessInfoBean assessInfo) {
            this.assessInfo = assessInfo;
        }

        public static class AssessInfoBean {
            /**
             * title : 慢性病测评
             * description : 健康测评是宜康网专业开发的一系列的在线健康评估模型应用,主要涉及体质与身体状况、基本性格、生活方式与习惯、颈椎病、心脑血管系统疾病、糖尿病、呼吸系统疾病
             * pic : hsm.oztechgroup.com/uploads/assess-base_1492485227_9427.jpg
             * tag_map_description : {"attr_type_map":{"1":"文本框","2":"单选框","3":"打钩选项框"},"attr_input_map":{"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}}
             * tag : [{"tag_id":"6","tag_title":"已知的疾病","rank":"1","description":"心脏、外周动脉或脑血管疾病","type":"0","config_info":[{"attr_title":"心脏、外周动脉或脑血管疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":"心脑血管"},"uncheck":{"description":""}}},"is_require":"1","config_id":"8"},{"attr_title":"肺脏疾病：慢性阻塞性肺病、哮喘、其他肺病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"2","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"B"}}},"is_require":"1","config_id":"9"},{"attr_title":"代谢疾病：糖尿病、甲状腺异常和肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"3","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"BBB"}}},"is_require":"1","config_id":"10"},{"attr_title":"运动会导致加重的骨关节炎、运动系统疾病。","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"11"},{"attr_title":"肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"5","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"12"}]},{"tag_id":"8","tag_title":"体征或症状","rank":"2","description":"体征或症状","type":"0","config_info":[{"attr_title":"疼痛：胸部、颈部、臂部或其他部位的 疼痛、不舒服，劳力后加重。（注意：由局部缺血引起的或其他类似于心绞痛的疼痛，其他原因疼痛不算）","tag_id":"8","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"13"}]}]
             */

            private String title;
            private String description;
            private String pic;
            private TagMapDescriptionBean tag_map_description;
            private List<TagBean> tag;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public TagMapDescriptionBean getTag_map_description() {
                return tag_map_description;
            }

            public void setTag_map_description(TagMapDescriptionBean tag_map_description) {
                this.tag_map_description = tag_map_description;
            }

            public List<TagBean> getTag() {
                return tag;
            }

            public void setTag(List<TagBean> tag) {
                this.tag = tag;
            }

            public static class TagMapDescriptionBean {
                /**
                 * attr_type_map : {"1":"文本框","2":"单选框","3":"打钩选项框"}
                 * attr_input_map : {"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}
                 */

                private AttrTypeMapBean attr_type_map;
                private AttrInputMapBean attr_input_map;

                public AttrTypeMapBean getAttr_type_map() {
                    return attr_type_map;
                }

                public void setAttr_type_map(AttrTypeMapBean attr_type_map) {
                    this.attr_type_map = attr_type_map;
                }

                public AttrInputMapBean getAttr_input_map() {
                    return attr_input_map;
                }

                public void setAttr_input_map(AttrInputMapBean attr_input_map) {
                    this.attr_input_map = attr_input_map;
                }

                public static class AttrTypeMapBean {
                    /**
                     * 1 : 文本框
                     * 2 : 单选框
                     * 3 : 打钩选项框
                     */

                    @SerializedName("1")
                    private String _$1;
                    @SerializedName("2")
                    private String _$2;
                    @SerializedName("3")
                    private String _$3;

                    public String get_$1() {
                        return _$1;
                    }

                    public void set_$1(String _$1) {
                        this._$1 = _$1;
                    }

                    public String get_$2() {
                        return _$2;
                    }

                    public void set_$2(String _$2) {
                        this._$2 = _$2;
                    }

                    public String get_$3() {
                        return _$3;
                    }

                    public void set_$3(String _$3) {
                        this._$3 = _$3;
                    }
                }

                public static class AttrInputMapBean {
                    /**
                     * 1 : 自己输入
                     * 2 : 专业人员输入
                     * 3 : 自己输入/专业人员输入
                     * 4 : 系统默认带出
                     * 5 : 系统默认带出,可手动修改
                     * 6 : 默认选是，如果否，关联属性
                     */

                    @SerializedName("1")
                    private String _$1;
                    @SerializedName("2")
                    private String _$2;
                    @SerializedName("3")
                    private String _$3;
                    @SerializedName("4")
                    private String _$4;
                    @SerializedName("5")
                    private String _$5;
                    @SerializedName("6")
                    private String _$6;

                    public String get_$1() {
                        return _$1;
                    }

                    public void set_$1(String _$1) {
                        this._$1 = _$1;
                    }

                    public String get_$2() {
                        return _$2;
                    }

                    public void set_$2(String _$2) {
                        this._$2 = _$2;
                    }

                    public String get_$3() {
                        return _$3;
                    }

                    public void set_$3(String _$3) {
                        this._$3 = _$3;
                    }

                    public String get_$4() {
                        return _$4;
                    }

                    public void set_$4(String _$4) {
                        this._$4 = _$4;
                    }

                    public String get_$5() {
                        return _$5;
                    }

                    public void set_$5(String _$5) {
                        this._$5 = _$5;
                    }

                    public String get_$6() {
                        return _$6;
                    }

                    public void set_$6(String _$6) {
                        this._$6 = _$6;
                    }
                }
            }

            public static class TagBean {
                /**
                 * tag_id : 6
                 * tag_title : 已知的疾病
                 * rank : 1
                 * description : 心脏、外周动脉或脑血管疾病
                 * type : 0
                 * config_info : [{"attr_title":"心脏、外周动脉或脑血管疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"1","grade_json":{"check_list":{"check":{"description":"心脑血管"},"uncheck":{"description":""}}},"is_require":"1","config_id":"8"},{"attr_title":"肺脏疾病：慢性阻塞性肺病、哮喘、其他肺病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"2","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"B"}}},"is_require":"1","config_id":"9"},{"attr_title":"代谢疾病：糖尿病、甲状腺异常和肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"3","grade_json":{"check_list":{"check":{"description":"A"},"uncheck":{"description":"BBB"}}},"is_require":"1","config_id":"10"},{"attr_title":"运动会导致加重的骨关节炎、运动系统疾病。","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"11"},{"attr_title":"肾脏或肝脏疾病","tag_id":"6","attr_unit":"","attr_type":"3","input_type":"1","rank":"5","grade_json":{"check_list":{"check":{"description":""},"uncheck":{"description":""}}},"is_require":"1","config_id":"12"}]
                 */

                private String tag_id;
                private String tag_title;
                private String rank;
                private String description;
                private String type;
                private List<ConfigInfoBean> config_info;

                public String getTag_id() {
                    return tag_id;
                }

                public void setTag_id(String tag_id) {
                    this.tag_id = tag_id;
                }

                public String getTag_title() {
                    return tag_title;
                }

                public void setTag_title(String tag_title) {
                    this.tag_title = tag_title;
                }

                public String getRank() {
                    return rank;
                }

                public void setRank(String rank) {
                    this.rank = rank;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public List<ConfigInfoBean> getConfig_info() {
                    return config_info;
                }

                public void setConfig_info(List<ConfigInfoBean> config_info) {
                    this.config_info = config_info;
                }

                public static class ConfigInfoBean {
                    /**
                     * attr_title : 心脏、外周动脉或脑血管疾病
                     * tag_id : 6
                     * attr_unit :
                     * attr_type : 3
                     * input_type : 1
                     * rank : 1
                     * grade_json : {"check_list":{"check":{"description":"心脑血管"},"uncheck":{"description":""}}}
                     * is_require : 1
                     * config_id : 8
                     */

                    private String attr_title;
                    private String tag_id;
                    private String attr_unit;
                    private String attr_type;
                    private String input_type;
                    private String rank;
                    private GradeJsonBean grade_json;
                    private String is_require;
                    private String config_id;

                    public String getAttr_title() {
                        return attr_title;
                    }

                    public void setAttr_title(String attr_title) {
                        this.attr_title = attr_title;
                    }

                    public String getTag_id() {
                        return tag_id;
                    }

                    public void setTag_id(String tag_id) {
                        this.tag_id = tag_id;
                    }

                    public String getAttr_unit() {
                        return attr_unit;
                    }

                    public void setAttr_unit(String attr_unit) {
                        this.attr_unit = attr_unit;
                    }

                    public String getAttr_type() {
                        return attr_type;
                    }

                    public void setAttr_type(String attr_type) {
                        this.attr_type = attr_type;
                    }

                    public String getInput_type() {
                        return input_type;
                    }

                    public void setInput_type(String input_type) {
                        this.input_type = input_type;
                    }

                    public String getRank() {
                        return rank;
                    }

                    public void setRank(String rank) {
                        this.rank = rank;
                    }

                    public GradeJsonBean getGrade_json() {
                        return grade_json;
                    }

                    public void setGrade_json(GradeJsonBean grade_json) {
                        this.grade_json = grade_json;
                    }

                    public String getIs_require() {
                        return is_require;
                    }

                    public void setIs_require(String is_require) {
                        this.is_require = is_require;
                    }

                    public String getConfig_id() {
                        return config_id;
                    }

                    public void setConfig_id(String config_id) {
                        this.config_id = config_id;
                    }

                    public static class GradeJsonBean {
                        /**
                         * check_list : {"check":{"description":"心脑血管"},"uncheck":{"description":""}}
                         */

                        private CheckListBean check_list;

                        public CheckListBean getCheck_list() {
                            return check_list;
                        }

                        public void setCheck_list(CheckListBean check_list) {
                            this.check_list = check_list;
                        }

                        public static class CheckListBean {
                            /**
                             * check : {"description":"心脑血管"}
                             * uncheck : {"description":""}
                             */

                            private CheckBean check;
                            private UncheckBean uncheck;

                            public CheckBean getCheck() {
                                return check;
                            }

                            public void setCheck(CheckBean check) {
                                this.check = check;
                            }

                            public UncheckBean getUncheck() {
                                return uncheck;
                            }

                            public void setUncheck(UncheckBean uncheck) {
                                this.uncheck = uncheck;
                            }

                            public static class CheckBean {
                                /**
                                 * description : 心脑血管
                                 */

                                private String description;

                                public String getDescription() {
                                    return description;
                                }

                                public void setDescription(String description) {
                                    this.description = description;
                                }
                            }

                            public static class UncheckBean {
                                /**
                                 * description :
                                 */

                                private String description;

                                public String getDescription() {
                                    return description;
                                }

                                public void setDescription(String description) {
                                    this.description = description;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
