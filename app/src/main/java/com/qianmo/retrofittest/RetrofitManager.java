package com.qianmo.retrofittest;

import android.content.Context;

import com.qianmo.retrofittest.converter.JsonConverterFactory;
import com.qianmo.retrofittest.persistentcookiejar.ClearableCookieJar;
import com.qianmo.retrofittest.persistentcookiejar.PersistentCookieJar;
import com.qianmo.retrofittest.persistentcookiejar.cache.SetCookieCache;
import com.qianmo.retrofittest.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/8/3.
 */
public class RetrofitManager {

    private static final String HTTP_RESPONSE_CACHE = "HttpResponseCache";
    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 10 * 1024 * 1024;
    private static final int TIMEOUT_READ = 15;
    private static final int TIMEOUT_CONNECTION = 15;

    private static RetrofitManager sInstace;

    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    public RetrofitManager(Context context) {
        initRetrofit(context);
    }

    public static RetrofitManager getInstace(Context context) {
        if (sInstace == null) {
            sInstace = new RetrofitManager(context.getApplicationContext());
        }
        return sInstace;
    }

    private void initRetrofit(Context context) {
        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File file = new File(context.getExternalCacheDir(), HTTP_RESPONSE_CACHE);
        Cache cache = new Cache(file, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);

        mOkHttpClient = new OkHttpClient.Builder()
                //.addInterceptor(interceptor)
                .addNetworkInterceptor(interceptor)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .cookieJar(cookieJar)
                .cache(cache)
                .build();
        mRetrofit = new Retrofit.Builder()
                //.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(JsonConverterFactory.create())
                // RxAndroid实现
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Config.BASEURL)
                .client(mOkHttpClient)
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}