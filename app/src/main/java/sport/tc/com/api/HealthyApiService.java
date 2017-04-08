package sport.tc.com.api;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import sport.tc.com.modle.Account;
import sport.tc.com.modle.BaseResponse;

/**
 * Created by punisher on 2017/3/2.
 */

public interface HealthyApiService {


    @FormUrlEncoded
    @POST ("api/goods-list")
    Observable<BaseResponse> testApi(@Field("validData") String validData, @Field("executeData") String executeData);

    /**
     * 注册
     * @param validData
     * @param executeData
     * @return
     */
    @FormUrlEncoded
    @POST ("api/user-register")
    Observable<BaseResponse>   registerApi(@Field("validData") String validData, @Field("executeData") String executeData);

    /**
     * 获取验证码
     * @param validData
     * @param executeData
     * @return
     */
    @FormUrlEncoded
    @POST ("api/get-vcode")
    Observable<BaseResponse>   messageCodeAPI(@Field("validData") String validData, @Field("executeData") String executeData);

    /**
     * 登录
     * @param validData
     * @param executeData
     * @return
     */
    @FormUrlEncoded
    @POST ("api/user-login")
    Observable<Account> loginApi(@Field("validData") String validData, @Field("executeData") String executeData);


    /**
     * 修改个人信息
     * @param validData
     * @param executeData
     * @return
     */
    @FormUrlEncoded
    @POST ("api/set-user-info")
    Observable<Account> modifyUserApi(@Field("validData") String validData, @Field("executeData") String executeData);


}
