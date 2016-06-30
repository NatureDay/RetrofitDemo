package com.qianmo.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qianmo.retrofittest.persistentcookiejar.ClearableCookieJar;
import com.qianmo.retrofittest.persistentcookiejar.PersistentCookieJar;
import com.qianmo.retrofittest.persistentcookiejar.cache.SetCookieCache;
import com.qianmo.retrofittest.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(this));
        mOkHttpClient = new OkHttpClient.Builder().cookieJar(cookieJar).build();

        Retrofit retrofit = new Retrofit.Builder()
                //.addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(Config.BASEURL)
                .client(mOkHttpClient)
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<String> call = userService.login("***", "***", true);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("fff", "-------call====111=" + call);
                Log.e("fff", "-------response=====" + response);
                Log.e("fff", "-------body=====" + response.body());
                Log.e("fff", "-------message=====" + response.message());
                Log.e("fff", "-------code=====" + response.code());
                Log.e("fff", "-------headers=====" + response.headers());
                Log.e("fff", "-------errorBody=====" + response.errorBody());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("fff", "-------call====222=" + call);
                Log.e("fff", "-------Throwable====222=" + t);
            }
        });
    }


}