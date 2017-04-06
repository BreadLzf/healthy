package sport.tc.com.api;

import sport.tc.com.modle.BaseResponse;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by punisher on 2017/3/2.
 */

public interface HealthyApiService {


    @POST ("/api/goods-list")
    Observable<BaseResponse> testApi(@Query("validData") String validData, @Query("executeData") String executeData);



    @POST ("/api/user-register")
    Observable<BaseResponse>   registerApi(@Query("validData") String validData, @Query("executeData") String executeData);



    @POST ("/api/get-vcode")
    Observable<BaseResponse>   messageCodeAPI(@Query("validData") String validData, @Query("executeData") String executeData);



    @POST ("/api/user-login")
    Observable<BaseResponse> loginApi(@Query("validData") String validData, @Query("executeData") String executeData);


}
