package sport.tc.com.modle;

/**
 * Created by punisher on 2017/4/10.
 * 文章列表请求的model
 */

public class ArticleRequest {
    /**
     * cur_page: 当前页数  (可选)
     * page_num: 一页条数 (可选)
     * is_index:  是否首推 （可选，1：是)
     * app_type:  应用类型
     * 1.健康圈
     * 2.局部知识
     * 3.营养推荐
     * 4.运动处方
     * type:  部位类型
     * "1": "颈部",
     * "2": "肩部",
     * "3": "上肢",
     * "4": "足裸部",
     * "5": "活动",
     * "6": "意见反馈"
     */
    public int cur_page;
    public int page_num;
    public String is_index;
    public String app_type;
    public String type;
}
