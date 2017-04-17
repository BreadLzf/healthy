package sport.tc.com.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by punisher on 2017/4/17.
 * 健康圈 文章详情
 */

public class ArticleDetailResponse {


    /**
     * code : 000
     * msg : 成功
     * data : {"article_info":{"title":"2","article_json":[{"type":"list","paragraphs":["1212"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/b0d65db7d3dfff5ee4825e26927d1064.jpeg"},{"type":"orderedList","paragraphs":["运动处方段落","运动处方2"]},{"type":"list","paragraphs":["运动健康"]}],"is_top":"2","pics":["http://hsm.oztechgroup.com/uploads/1a7ebee80096fc29af039c33a0afe729.jpeg"],"create_time":"2017-04-07 17:45:22","type":"5","app_type":"4","sport_purpose":"B","sport_project":"C","sport_power":"D","is_index":"1","article_id":"5","price_num":"0","comment_num":"0","has_price":0,"has_collect":0},"cn_map":{"type":{"1":"颈部","2":"肩部","3":"上肢","4":"足裸部","5":"活动","6":"意见反馈"},"app_type":{"1":"健康圈","2":"局部知识","3":"营养推荐","4":"运动处方"},"is_top":{"1":"置顶","2":"不置顶"},"is_index":{"1":"首推","2":"非首推"}}}
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
         * article_info : {"title":"2","article_json":[{"type":"list","paragraphs":["1212"],"src":"http://hsm.oztechgroup.com/uploads/b0d65db7d3dfff5ee4825e26927d1064.jpeg"},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/b0d65db7d3dfff5ee4825e26927d1064.jpeg"},{"type":"orderedList","paragraphs":["运动处方段落","运动处方2"]},{"type":"list","paragraphs":["运动健康"]}],"is_top":"2","pics":["http://hsm.oztechgroup.com/uploads/1a7ebee80096fc29af039c33a0afe729.jpeg"],"create_time":"2017-04-07 17:45:22","type":"5","app_type":"4","sport_purpose":"B","sport_project":"C","sport_power":"D","is_index":"1","article_id":"5","price_num":"0","comment_num":"0","has_price":0,"has_collect":0}
         * cn_map : {"type":{"1":"颈部","2":"肩部","3":"上肢","4":"足裸部","5":"活动","6":"意见反馈"},"app_type":{"1":"健康圈","2":"局部知识","3":"营养推荐","4":"运动处方"},"is_top":{"1":"置顶","2":"不置顶"},"is_index":{"1":"首推","2":"非首推"}}
         */

        private ArticleInfoBean article_info;
        private CnMapBean cn_map;

        public ArticleInfoBean getArticle_info() {
            return article_info;
        }

        public void setArticle_info(ArticleInfoBean article_info) {
            this.article_info = article_info;
        }

        public CnMapBean getCn_map() {
            return cn_map;
        }

        public void setCn_map(CnMapBean cn_map) {
            this.cn_map = cn_map;
        }

        public static class ArticleInfoBean {
            /**
             * title : 2
             * article_json : [{"type":"list","paragraphs":["1212"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/b0d65db7d3dfff5ee4825e26927d1064.jpeg"},{"type":"orderedList","paragraphs":["运动处方段落","运动处方2"]},{"type":"list","paragraphs":["运动健康"]}]
             * is_top : 2
             * pics : ["http://hsm.oztechgroup.com/uploads/1a7ebee80096fc29af039c33a0afe729.jpeg"]
             * create_time : 2017-04-07 17:45:22
             * type : 5
             * app_type : 4
             * sport_purpose : B
             * sport_project : C
             * sport_power : D
             * is_index : 1
             * article_id : 5
             * price_num : 0
             * comment_num : 0
             * has_price : 0
             * has_collect : 0
             */

            private String title;
            private String is_top;
            private String create_time;
            private String type;
            private String app_type;
            private String sport_purpose;
            private String sport_project;
            private String sport_power;
            private String is_index;
            private String article_id;
            private String price_num;
            private String comment_num;
            private int has_price;
            private int has_collect;
            private List<ArticleJsonBean> article_json;
            private List<String> pics;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIs_top() {
                return is_top;
            }

            public void setIs_top(String is_top) {
                this.is_top = is_top;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getApp_type() {
                return app_type;
            }

            public void setApp_type(String app_type) {
                this.app_type = app_type;
            }

            public String getSport_purpose() {
                return sport_purpose;
            }

            public void setSport_purpose(String sport_purpose) {
                this.sport_purpose = sport_purpose;
            }

            public String getSport_project() {
                return sport_project;
            }

            public void setSport_project(String sport_project) {
                this.sport_project = sport_project;
            }

            public String getSport_power() {
                return sport_power;
            }

            public void setSport_power(String sport_power) {
                this.sport_power = sport_power;
            }

            public String getIs_index() {
                return is_index;
            }

            public void setIs_index(String is_index) {
                this.is_index = is_index;
            }

            public String getArticle_id() {
                return article_id;
            }

            public void setArticle_id(String article_id) {
                this.article_id = article_id;
            }

            public String getPrice_num() {
                return price_num;
            }

            public void setPrice_num(String price_num) {
                this.price_num = price_num;
            }

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public int getHas_price() {
                return has_price;
            }

            public void setHas_price(int has_price) {
                this.has_price = has_price;
            }

            public int getHas_collect() {
                return has_collect;
            }

            public void setHas_collect(int has_collect) {
                this.has_collect = has_collect;
            }

            public List<ArticleJsonBean> getArticle_json() {
                return article_json;
            }

            public void setArticle_json(List<ArticleJsonBean> article_json) {
                this.article_json = article_json;
            }

            public List<String> getPics() {
                return pics;
            }

            public void setPics(List<String> pics) {
                this.pics = pics;
            }

            public static class ArticleJsonBean {
                /**
                 * type : list
                 * paragraphs : ["1212"]
                 * src : http://hsm.oztechgroup.com/uploads/b0d65db7d3dfff5ee4825e26927d1064.jpeg
                 */

                private String type;
                private String src;
                private List<String> paragraphs;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public List<String> getParagraphs() {
                    return paragraphs;
                }

                public void setParagraphs(List<String> paragraphs) {
                    this.paragraphs = paragraphs;
                }
            }
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
    }
}
