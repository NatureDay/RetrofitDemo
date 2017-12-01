package com.qianmo.retrofittest;

/**
 * Group:  阡陌科技
 * Author: daiyuanhong
 * Time:   2017/12/1 14:29
 */
public class ApiSubscriber<T> extends BaseSubscriber<ApiResponse<T>> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {
        super.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
    }

    @Override
    public void onNext(ApiResponse<T> tApiResponse) {
        super.onNext(tApiResponse);
    }
}
