package healthy.tichuang.com.api;

import healthy.tichuang.com.AppContents;
import healthy.tichuang.com.modle.TestBean;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by punisher on 2017/3/2.
 */

public class HealthyApi {
    public static HealthyApi instance;
    private HealthyApiService service;

    public HealthyApi(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppContents.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(HealthyApiService.class);
    }

    public static HealthyApi getInstance() {
        OkHttpClient okHttpClient=new OkHttpClient();
        if (instance == null)
            instance = new HealthyApi(okHttpClient);
        return instance;
    }



    public Call<TestBean> testApi(String  validData, String executeData) {
        return service.testApi(validData,executeData);
    }


    public Call<TestBean> login(String  validData, String executeData) {
        return service.loginApi(validData,executeData);
    }



    public Call<TestBean> register(String  validData, String executeData) {
        return service.registerApi(validData,executeData);
    }


    public Call<TestBean> messageCode(String  validData, String executeData) {
        return service.messageCodeAPI(validData,executeData);
    }





}
