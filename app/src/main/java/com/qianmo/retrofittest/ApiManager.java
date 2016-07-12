package com.qianmo.retrofittest;

import android.content.Context;

import com.qianmo.retrofittest.converter.JsonConverterFactory;
import com.qianmo.retrofittest.persistentcookiejar.ClearableCookieJar;
import com.qianmo.retrofittest.persistentcookiejar.PersistentCookieJar;
import com.qianmo.retrofittest.persistentcookiejar.cache.SetCookieCache;
import com.qianmo.retrofittest.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Auther: Administrator
 * @Date: 2016/7/5 11:40
 */
public class ApiManager {

    private static ApiManager sInstace;

    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    public ApiManager(Context context) {
        initRetrofit(context);
    }

    private void initRetrofit(Context context) {
        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        mOkHttpClient = new OkHttpClient.Builder().cookieJar(cookieJar).build();
        mRetrofit = new Retrofit.Builder()
                //.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(JsonConverterFactory.create())
                .baseUrl(Config.BASEURL)
                .client(mOkHttpClient)
                .build();
    }

    public static ApiManager getInstace(Context context) {
        if (sInstace == null) {
            sInstace = new ApiManager(context.getApplicationContext());
        }
        return sInstace;
    }

    private UserApi mUserApi;
    private PersonApi mPersonApi;

    public UserApi getUserApi() {
        if (mUserApi == null) {
            mUserApi = mRetrofit.create(UserApi.class);
        }
        return mUserApi;
    }

    public PersonApi getPersonApi() {
        if (mPersonApi == null) {
            mPersonApi = mRetrofit.create(PersonApi.class);
        }
        return mPersonApi;
    }
}
