package com.qianmo.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

//    private OkHttpClient mOkHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Call<JSONObject> call = ApiManager.getInstace(this).getUserApi().login("18505539466", "123456", true);
//
//        call.enqueue(new Callback<JSONObject>() {
//            @Override
//            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
////                Log.e("fff", "-------call====111=" + call);
////                Log.e("fff", "-------response=====" + response.toString());
////                Log.e("fff", "-------body=====" + response.body());
//
//                Call<JSONObject> call1 = ApiManager.getInstace(MainActivity.this).getUserApi().getUser();
//                call1.enqueue(new Callback<JSONObject>() {
//                    @Override
//                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<JSONObject> call, Throwable t) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Call<JSONObject> call, Throwable t) {
//                Log.e("fff", "-------call====222=" + call);
//                Log.e("fff", "-------Throwable====222=" + t);
//            }
//        });

        /**
         * RxAndroid实现
         */
        Observable<JSONObject> observable = ApiManager.getInstace(this).getUserApi().login("18505539466", "123456", true);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<JSONObject>() {
                    @Override
                    public void onStart() {
                        Log.e("fff", "-------onStart=====");
                    }

                    @Override
                    public void onCompleted() {
                        Log.e("fff", "-------onCompleted=====");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("fff", "-------onNext=====");
                    }

                    @Override
                    public void onNext(JSONObject jsonObject) {
                        Log.e("fff", "-------onNext=====" + jsonObject.toString());
                    }
                });
    }


}