package com.qianmo.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

//    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ClearableCookieJar cookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(this));
//        mOkHttpClient = new OkHttpClient.Builder().cookieJar(cookieJar).build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                //.addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .baseUrl(Config.BASEURL)
//                .client(mOkHttpClient)
//                .build();
//
//        UserApi userApi = retrofit.create(UserApi.class);


        Call<JSONObject> call = ApiManager.getInstace(this).getUserApi().login("18505539466", "123456", true);

//        new BaseRequest(this,call).handleRequest(new ResponseCallBack() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                super.onResponse(call, response);
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                super.onFailure(call, t);
//            }
//
//            @Override
//            public void onRequest() {
//                super.onRequest();
//            }
//        });


        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.e("fff", "-------call====111=" + call);
                Log.e("fff", "-------response=====" + response.toString());
                Log.e("fff", "-------body=====" + response.body());
                Log.e("fff", "-------message=====" + response.message());
                Log.e("fff", "-------code=====" + response.code());
                Log.e("fff", "-------headers=====" + response.headers());
                Log.e("fff", "-------errorBody=====" + response.errorBody());
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.e("fff", "-------call====222=" + call);
                Log.e("fff", "-------Throwable====222=" + t);
            }
        });
    }


}