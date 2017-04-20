package sport.tc.com.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by punisher on 2017/4/13.
 */

public class BodyCheckResponse {


    /**
     * code : 000
     * msg : 成功
     * data : {"assessInfo":{"title":"体质健康测评","description":"体质健康测评描述","pic":"hsm.oztechgroup.com/uploads/assess-base_1490412771_1542.jpeg","tag_map_description":{"attr_type_map":{"1":"文本框","2":"单选框","3":"打钩选项框"},"attr_input_map":{"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}},"tag":[{"tag_id":"2","tag_title":"代谢综合征","rank":"1","description":"代谢综合征描述","config_info":[{"attr_title":"身高","tag_id":"2","attr_unit":"cm","attr_type":"1","input_type":"5","rank":"1","grade_json":{"gap_list":[{"min":"0","max":"160","description":"矮子"},{"min":"160","max":"175","description":"正常"},{"min":"175","max":"220","description":"高个"}]},"is_require":"1","config_id":"3","default_value":"189"},{"attr_title":"体重","tag_id":"2","attr_unit":"kg","attr_type":"1","input_type":"4","rank":"2","grade_json":{"gap_list":[{"min":"40","max":"60","description":"瘦子"},{"min":"60","max":"70","description":"正常"},{"min":"70","max":"90","description":"胖子"},{"min":"90","max":"1000","description":"肥胖"}]},"is_require":"1","config_id":"2","default_value":"55"},{"attr_title":"性别","tag_id":"2","attr_unit":"","attr_type":"2","input_type":"4","rank":"3","grade_json":{"gap_list":[{"item_name":"男","description":"是个男人"},{"item_name":"女","description":"是个女人"}]},"is_require":"1","config_id":"4","default_value":"女"},{"attr_title":"糖尿病","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":"糖尿病患者"},"uncheck":{"description":""}}},"is_require":"1","config_id":"5"},{"attr_title":"舒张压","tag_id":"2","attr_unit":"gh","attr_type":"1","input_type":"1","rank":"5","grade_json":{"gap_list":[{"min":"0","max":"100","description":"低"},{"min":"100","max":"500","description":"正常"},{"min":"500","max":"1000","description":"高"}]},"is_require":"0","config_id":"6"},{"attr_title":"高血压","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"6","rank":"6","grade_json":{"relation_attr":["舒张压"],"check_list":{"check":{"description":"高血压"},"uncheck":{"description":""}}},"is_require":"0","config_id":"7"}]},{"tag_id":"5","tag_title":"高血压测试","rank":"2","description":"高血压测试"}]}}
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
         * assessInfo : {"title":"体质健康测评","description":"体质健康测评描述","pic":"hsm.oztechgroup.com/uploads/assess-base_1490412771_1542.jpeg","tag_map_description":{"attr_type_map":{"1":"文本框","2":"单选框","3":"打钩选项框"},"attr_input_map":{"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}},"tag":[{"tag_id":"2","tag_title":"代谢综合征","rank":"1","description":"代谢综合征描述","config_info":[{"attr_title":"身高","tag_id":"2","attr_unit":"cm","attr_type":"1","input_type":"5","rank":"1","grade_json":{"gap_list":[{"min":"0","max":"160","description":"矮子"},{"min":"160","max":"175","description":"正常"},{"min":"175","max":"220","description":"高个"}]},"is_require":"1","config_id":"3","default_value":"189"},{"attr_title":"体重","tag_id":"2","attr_unit":"kg","attr_type":"1","input_type":"4","rank":"2","grade_json":{"gap_list":[{"min":"40","max":"60","description":"瘦子"},{"min":"60","max":"70","description":"正常"},{"min":"70","max":"90","description":"胖子"},{"min":"90","max":"1000","description":"肥胖"}]},"is_require":"1","config_id":"2","default_value":"55"},{"attr_title":"性别","tag_id":"2","attr_unit":"","attr_type":"2","input_type":"4","rank":"3","grade_json":{"gap_list":[{"item_name":"男","description":"是个男人"},{"item_name":"女","description":"是个女人"}]},"is_require":"1","config_id":"4","default_value":"女"},{"attr_title":"糖尿病","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":"糖尿病患者"},"uncheck":{"description":""}}},"is_require":"1","config_id":"5"},{"attr_title":"舒张压","tag_id":"2","attr_unit":"gh","attr_type":"1","input_type":"1","rank":"5","grade_json":{"gap_list":[{"min":"0","max":"100","description":"低"},{"min":"100","max":"500","description":"正常"},{"min":"500","max":"1000","description":"高"}]},"is_require":"0","config_id":"6"},{"attr_title":"高血压","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"6","rank":"6","grade_json":{"relation_attr":["舒张压"],"check_list":{"check":{"description":"高血压"},"uncheck":{"description":""}}},"is_require":"0","config_id":"7"}]},{"tag_id":"5","tag_title":"高血压测试","rank":"2","description":"高血压测试"}]}
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
             * title : 体质健康测评
             * description : 体质健康测评描述
             * pic : hsm.oztechgroup.com/uploads/assess-base_1490412771_1542.jpeg
             * tag_map_description : {"attr_type_map":{"1":"文本框","2":"单选框","3":"打钩选项框"},"attr_input_map":{"1":"自己输入","2":"专业人员输入","3":"自己输入/专业人员输入","4":"系统默认带出","5":"系统默认带出,可手动修改","6":"默认选是，如果否，关联属性"}}
             * tag : [{"tag_id":"2","tag_title":"代谢综合征","rank":"1","description":"代谢综合征描述","config_info":[{"attr_title":"身高","tag_id":"2","attr_unit":"cm","attr_type":"1","input_type":"5","rank":"1","grade_json":{"gap_list":[{"min":"0","max":"160","description":"矮子"},{"min":"160","max":"175","description":"正常"},{"min":"175","max":"220","description":"高个"}]},"is_require":"1","config_id":"3","default_value":"189"},{"attr_title":"体重","tag_id":"2","attr_unit":"kg","attr_type":"1","input_type":"4","rank":"2","grade_json":{"gap_list":[{"min":"40","max":"60","description":"瘦子"},{"min":"60","max":"70","description":"正常"},{"min":"70","max":"90","description":"胖子"},{"min":"90","max":"1000","description":"肥胖"}]},"is_require":"1","config_id":"2","default_value":"55"},{"attr_title":"性别","tag_id":"2","attr_unit":"","attr_type":"2","input_type":"4","rank":"3","grade_json":{"gap_list":[{"item_name":"男","description":"是个男人"},{"item_name":"女","description":"是个女人"}]},"is_require":"1","config_id":"4","default_value":"女"},{"attr_title":"糖尿病","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":"糖尿病患者"},"uncheck":{"description":""}}},"is_require":"1","config_id":"5"},{"attr_title":"舒张压","tag_id":"2","attr_unit":"gh","attr_type":"1","input_type":"1","rank":"5","grade_json":{"gap_list":[{"min":"0","max":"100","description":"低"},{"min":"100","max":"500","description":"正常"},{"min":"500","max":"1000","description":"高"}]},"is_require":"0","config_id":"6"},{"attr_title":"高血压","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"6","rank":"6","grade_json":{"relation_attr":["舒张压"],"check_list":{"check":{"description":"高血压"},"uncheck":{"description":""}}},"is_require":"0","config_id":"7"}]},{"tag_id":"5","tag_title":"高血压测试","rank":"2","description":"高血压测试"}]
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
                 * tag_id : 2
                 * tag_title : 代谢综合征
                 * rank : 1
                 * description : 代谢综合征描述
                 * config_info : [{"attr_title":"身高","tag_id":"2","attr_unit":"cm","attr_type":"1","input_type":"5","rank":"1","grade_json":{"gap_list":[{"min":"0","max":"160","description":"矮子"},{"min":"160","max":"175","description":"正常"},{"min":"175","max":"220","description":"高个"}]},"is_require":"1","config_id":"3","default_value":"189"},{"attr_title":"体重","tag_id":"2","attr_unit":"kg","attr_type":"1","input_type":"4","rank":"2","grade_json":{"gap_list":[{"min":"40","max":"60","description":"瘦子"},{"min":"60","max":"70","description":"正常"},{"min":"70","max":"90","description":"胖子"},{"min":"90","max":"1000","description":"肥胖"}]},"is_require":"1","config_id":"2","default_value":"55"},{"attr_title":"性别","tag_id":"2","attr_unit":"","attr_type":"2","input_type":"4","rank":"3","grade_json":{"gap_list":[{"item_name":"男","description":"是个男人"},{"item_name":"女","description":"是个女人"}]},"is_require":"1","config_id":"4","default_value":"女"},{"attr_title":"糖尿病","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"1","rank":"4","grade_json":{"check_list":{"check":{"description":"糖尿病患者"},"uncheck":{"description":""}}},"is_require":"1","config_id":"5"},{"attr_title":"舒张压","tag_id":"2","attr_unit":"gh","attr_type":"1","input_type":"1","rank":"5","grade_json":{"gap_list":[{"min":"0","max":"100","description":"低"},{"min":"100","max":"500","description":"正常"},{"min":"500","max":"1000","description":"高"}]},"is_require":"0","config_id":"6"},{"attr_title":"高血压","tag_id":"2","attr_unit":"","attr_type":"3","input_type":"6","rank":"6","grade_json":{"relation_attr":["舒张压"],"check_list":{"check":{"description":"高血压"},"uncheck":{"description":""}}},"is_require":"0","config_id":"7"}]
                 */

                private String tag_id;
                private String tag_title;
                private String rank;
                private String description;
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

                public List<ConfigInfoBean> getConfig_info() {
                    return config_info;
                }

                public void setConfig_info(List<ConfigInfoBean> config_info) {
                    this.config_info = config_info;
                }

                public static class ConfigInfoBean {
                    /**
                     * attr_title : 身高
                     * tag_id : 2
                     * attr_unit : cm
                     * attr_type : 1
                     * input_type : 5
                     * rank : 1
                     * grade_json : {"gap_list":[{"min":"0","max":"160","description":"矮子"},{"min":"160","max":"175","description":"正常"},
                     * {"min":"175","max":"220","description":"高个"}]}
                     * is_require : 1
                     * config_id : 3
                     * default_value : 189
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
                    private String default_value;

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

                    public String getDefault_value() {
                        return default_value;
                    }

                    public void setDefault_value(String default_value) {
                        this.default_value = default_value;
                    }

                    public static class GradeJsonBean {
                        private List<GapListBean> gap_list;

                        public List<GapListBean> getGap_list() {
                            return gap_list;
                        }

                        public void setGap_list(List<GapListBean> gap_list) {
                            this.gap_list = gap_list;
                        }

                        public static class GapListBean {
                            /**
                             * min : 0
                             * max : 160
                             * description : 矮子
                             */

                            private String min;
                            private String max;
                            private String description;

                            public String getMin() {
                                return min;
                            }

                            public void setMin(String min) {
                                this.min = min;
                            }

                            public String getMax() {
                                return max;
                            }

                            public void setMax(String max) {
                                this.max = max;
                            }

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
