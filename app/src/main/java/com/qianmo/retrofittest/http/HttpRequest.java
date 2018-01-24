package com.qianmo.retrofittest.http;

import android.content.Context;
import android.support.annotation.NonNull;

import com.qianmo.retrofittest.RetrofitManager;

import retrofit2.Call;

/**
 * Group:  阡陌科技
 * Author: daiyuanhong
 * Time:   2018/1/23 16:26
 */
public abstract class HttpRequest<T> {

    private HttpRequest() {
        //Call<T> call = createHttpRequest(service());
    }

    protected <T> T createHttpRequest(Class<T> service) {
        return RetrofitManager.getInstace().create(service);
    }

    protected abstract Class service();

}
