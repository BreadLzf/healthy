package sport.tc.com.modle;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by punisher on 2017/4/17.
 */

public class TestHealthyList {

    /**
     * code : 000
     * msg : 成功
     * data : {"cn_map":{"type":{"1":"颈部","2":"肩部","3":"上肢","4":"足裸部","5":"活动","6":"意见反馈"},"app_type":{"1":"健康圈","2":"局部知识","3":"营养推荐","4":"运动处方"},"is_top":{"1":"置顶","2":"不置顶"},"is_index":{"1":"首推","2":"非首推"}},"page":{"total_page":1,"total_num":"1","cur_page":1,"page_num":20},"article_list":[{"id":"7","title":"想减多少就减多少","article_json":[{"type":"list","paragraphs":["我叫张倩倩，是一个典型的吃货。从小就很胖，高中时，我就想减肥，可自己一个人摸索着尝试，又有效又能坚持的方法很少，体重偶尔会轻，但人并没有瘦，减减停停这几年走过不少辛酸路。"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/0d458db2c0ca276053ba9bacf55e708c.jpg"},{"type":"list","paragraphs":["后来经朋友介绍，加了静涵的微信，看到那么多成功的瘦身例子，我也看到了希望，通过几次了解，她很快给出了适合我的减肥方案！这个方案可以根据不同人的体质进行调配。"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/3df9f68d378ee43c5363800dc5d085ea.jpg"},{"type":"list","paragraphs":["用了这个减肥方案后，我一个月瘦了26斤，如今体重维持在96斤，没任何反弹！为了拯救更多绝望的胖子，为了感谢静涵，我下定决心尽我所能，免费宣传它。想和我一样瘦身成功的，可以加静涵微信，里面有很多粉丝瘦身成功的心得，可以学习下，还可以免费得到静涵的瘦身指导！"]}],"is_top":"1","pics":["http://hsm.oztechgroup.com/uploads/d68fd4d53cd93b5f44f17ba1f9030dd7.png"],"create_time":"2017-04-17 13:04:40","type":"1","app_type":"1","sport_purpose":"","sport_project":"","sport_power":"","is_index":"1","article_id":"7","price_num":"0","comment_num":"0"}]}
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
         * page : {"total_page":1,"total_num":"1","cur_page":1,"page_num":20}
         * article_list : [{"id":"7","title":"想减多少就减多少","article_json":[{"type":"list","paragraphs":["我叫张倩倩，是一个典型的吃货。从小就很胖，高中时，我就想减肥，可自己一个人摸索着尝试，又有效又能坚持的方法很少，体重偶尔会轻，但人并没有瘦，减减停停这几年走过不少辛酸路。"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/0d458db2c0ca276053ba9bacf55e708c.jpg"},{"type":"list","paragraphs":["后来经朋友介绍，加了静涵的微信，看到那么多成功的瘦身例子，我也看到了希望，通过几次了解，她很快给出了适合我的减肥方案！这个方案可以根据不同人的体质进行调配。"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/3df9f68d378ee43c5363800dc5d085ea.jpg"},{"type":"list","paragraphs":["用了这个减肥方案后，我一个月瘦了26斤，如今体重维持在96斤，没任何反弹！为了拯救更多绝望的胖子，为了感谢静涵，我下定决心尽我所能，免费宣传它。想和我一样瘦身成功的，可以加静涵微信，里面有很多粉丝瘦身成功的心得，可以学习下，还可以免费得到静涵的瘦身指导！"]}],"is_top":"1","pics":["http://hsm.oztechgroup.com/uploads/d68fd4d53cd93b5f44f17ba1f9030dd7.png"],"create_time":"2017-04-17 13:04:40","type":"1","app_type":"1","sport_purpose":"","sport_project":"","sport_power":"","is_index":"1","article_id":"7","price_num":"0","comment_num":"0"}]
         */

        private CnMapBean cn_map;
        private PageBean page;
        private List<ArticleListBean> article_list;

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

        public List<ArticleListBean> getArticle_list() {
            return article_list;
        }

        public void setArticle_list(List<ArticleListBean> article_list) {
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
             * total_page : 1
             * total_num : 1
             * cur_page : 1
             * page_num : 20
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

        public static class ArticleListBean {
            /**
             * id : 7
             * title : 想减多少就减多少
             * article_json : [{"type":"list","paragraphs":["我叫张倩倩，是一个典型的吃货。从小就很胖，高中时，我就想减肥，可自己一个人摸索着尝试，又有效又能坚持的方法很少，体重偶尔会轻，但人并没有瘦，减减停停这几年走过不少辛酸路。"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/0d458db2c0ca276053ba9bacf55e708c.jpg"},{"type":"list","paragraphs":["后来经朋友介绍，加了静涵的微信，看到那么多成功的瘦身例子，我也看到了希望，通过几次了解，她很快给出了适合我的减肥方案！这个方案可以根据不同人的体质进行调配。"]},{"type":"image","src":"http://hsm.oztechgroup.com/uploads/3df9f68d378ee43c5363800dc5d085ea.jpg"},{"type":"list","paragraphs":["用了这个减肥方案后，我一个月瘦了26斤，如今体重维持在96斤，没任何反弹！为了拯救更多绝望的胖子，为了感谢静涵，我下定决心尽我所能，免费宣传它。想和我一样瘦身成功的，可以加静涵微信，里面有很多粉丝瘦身成功的心得，可以学习下，还可以免费得到静涵的瘦身指导！"]}]
             * is_top : 1
             * pics : ["http://hsm.oztechgroup.com/uploads/d68fd4d53cd93b5f44f17ba1f9030dd7.png"]
             * create_time : 2017-04-17 13:04:40
             * type : 1
             * app_type : 1
             * sport_purpose :
             * sport_project :
             * sport_power :
             * is_index : 1
             * article_id : 7
             * price_num : 0
             * comment_num : 0
             */

            private String id;
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
            private List<ArticleJsonBean> article_json;
            private List<String> pics;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

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
                 * paragraphs : ["我叫张倩倩，是一个典型的吃货。从小就很胖，高中时，我就想减肥，可自己一个人摸索着尝试，又有效又能坚持的方法很少，体重偶尔会轻，但人并没有瘦，减减停停这几年走过不少辛酸路。"]
                 * src : http://hsm.oztechgroup.com/uploads/0d458db2c0ca276053ba9bacf55e708c.jpg
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
    }
}
