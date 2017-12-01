package com.qianmo.retrofittest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Auther: Administrator
 * @Date: 2016/7/5 15:13
 */
public abstract class ResponseCallBack<T> implements Callback<T> {




    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    /**
     * 初始化的时候调用
     * 一般用于处理加载进度
     */
    public void onRequest() {

    }
}
