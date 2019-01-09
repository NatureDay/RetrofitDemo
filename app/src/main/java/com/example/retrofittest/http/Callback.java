package com.example.retrofittest.http;

/**
 * 网络请求回调，用以封装其他网络框架的请求回调
 * Group:  阡陌科技
 * Author: daiyuanhong
 * Time:   2018/1/18 14:39
 */
public interface Callback<T> {

    /**
     * 请求开始
     */
    void onStart();

    /**
     * 请求结束
     */
    void onCompleted();

    /**
     * 请求成功
     *
     * @param data
     */
    void onSuccess(T data);

    /**
     * 请求失败
     *
     * @param msg
     */
    void onFailure(String msg);
}
