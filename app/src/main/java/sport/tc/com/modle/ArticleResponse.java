package sport.tc.com.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by punisher on 2017/4/10.
 */

public class ArticleResponse {


    /**
     * code : 000
     * msg : 成功
     * data : {"cn_map":{"type":
     * {"1":"颈部","2":"肩部","3":"上肢","4":"足裸部","5":"活动","6":"意见反馈"},
     * "app_type":{"1":"健康圈","2":"局部知识","3":"营养推荐","4":"运动处方"},
     * "is_top":{"1":"置顶","2":"不置顶"},
     * "is_index":{"1":"首推","2":"非首推"}},
     * "page":{"total_page":0,"total_num":"0","cur_page":0,"page_num":10},
     * "article_list":[]}
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
         * cn_map : {"type":{"1":"颈部","2":"肩部","3":"上肢","4":"足裸部","5":"活动","6":"意见反馈"},"app_type":{"1":"健康圈","2":"局部知识","3":"营养推荐","4":"运动处方"},"is_top":{"1":"置顶","2":"不置顶"},"is_index":{"1":"首推","2":"非首推"}}
         * page : {"total_page":0,"total_num":"0","cur_page":0,"page_num":10}
         * article_list : []
         */

        private CnMapBean cn_map;
        private PageBean page;
        private List<?> article_list;

        public CnMapBean getCn_map() {
            return cn_map;
        }

        public void setCn_map(CnMapBean cn_map) {
            this.cn_map = cn_map;
        }

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<?> getArticle_list() {
            return article_list;
        }

        public void setArticle_list(List<?> article_list) {
            this.article_list = article_list;
        }

        public static class CnMapBean {
            /**
             * type : {"1":"颈部","2":"肩部","3":"上肢","4":"足裸部","5":"活动","6":"意见反馈"}
             * app_type : {"1":"健康圈","2":"局部知识","3":"营养推荐","4":"运动处方"}
             * is_top : {"1":"置顶","2":"不置顶"}
             * is_index : {"1":"首推","2":"非首推"}
             */

            private TypeBean type;
            private AppTypeBean app_type;
            private IsTopBean is_top;
            private IsIndexBean is_index;

            public TypeBean getType() {
                return type;
            }

            public void setType(TypeBean type) {
                this.type = type;
            }

            public AppTypeBean getApp_type() {
                return app_type;
            }

            public void setApp_type(AppTypeBean app_type) {
                this.app_type = app_type;
            }

            public IsTopBean getIs_top() {
                return is_top;
            }

            public void setIs_top(IsTopBean is_top) {
                this.is_top = is_top;
            }

            public IsIndexBean getIs_index() {
                return is_index;
            }

            public void setIs_index(IsIndexBean is_index) {
                this.is_index = is_index;
            }

            public static class TypeBean {
                /**
                 * 1 : 颈部
                 * 2 : 肩部
                 * 3 : 上肢
                 * 4 : 足裸部
                 * 5 : 活动
                 * 6 : 意见反馈
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

            public static class AppTypeBean {
                /**
                 * 1 : 健康圈
                 * 2 : 局部知识
                 * 3 : 营养推荐
                 * 4 : 运动处方
                 */

                @SerializedName("1")
                private String _$1;
                @SerializedName("2")
                private String _$2;
                @SerializedName("3")
                private String _$3;
                @SerializedName("4")
                private String _$4;

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
            }

            public static class IsTopBean {
                /**
                 * 1 : 置顶
                 * 2 : 不置顶
                 */

                @SerializedName("1")
                private String _$1;
                @SerializedName("2")
                private String _$2;

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
            }

            public static class IsIndexBean {
                /**
                 * 1 : 首推
                 * 2 : 非首推
                 */

                @SerializedName("1")
                private String _$1;
                @SerializedName("2")
                private String _$2;

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
            }
        }

        public static class PageBean {
            /**
             * total_page : 0
             * total_num : 0
             * cur_page : 0
             * page_num : 10
             */

            private int total_page;
            private String total_num;
            private int cur_page;
            private int page_num;

            public int getTotal_page() {
                return total_page;
            }

            public void setTotal_page(int total_page) {
                this.total_page = total_page;
            }

            public String getTotal_num() {
                return total_num;
            }

            public void setTotal_num(String total_num) {
                this.total_num = total_num;
            }

            public int getCur_page() {
                return cur_page;
            }

            public void setCur_page(int cur_page) {
                this.cur_page = cur_page;
            }

            public int getPage_num() {
                return page_num;
            }

            public void setPage_num(int page_num) {
                this.page_num = page_num;
            }
        }
    }
}
