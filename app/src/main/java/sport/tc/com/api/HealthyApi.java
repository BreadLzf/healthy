package sport.tc.com.api;

import android.content.Context;

import com.tamic.novate.Novate;

import sport.tc.com.AppContents;
import sport.tc.com.modle.BaseResponse;
import retrofit2.Call;

/**
 * Created by punisher on 2017/3/2.
 */

public class HealthyApi {

    private HealthyApiService service;
    private Context context;


    public HealthyApi(Context context) {
        this.context = context;
        Novate novate = new Novate.Builder(context).baseUrl(AppContents.API_BASE_URL).build();
        service=novate.create(HealthyApiService.class);
    }

    public Call<BaseResponse> login(String validData, String executeData) {
        return (Call<BaseResponse>) service.loginApi(validData, executeData);
    }

}
