package healthy.tichuang.com.api;

import healthy.tichuang.com.modle.TestBean;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by punisher on 2017/3/2.
 */

public interface HealthyApiService {


    @POST ("/api/goods-list")
    Call<TestBean>   testApi(@Query("validData") String validData, @Query("executeData") String executeData);


}
