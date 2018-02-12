package com.qianmo.retrofittest;

/**
 *
 * Group:  阡陌科技
 * Author: daiyuanhong
 * Time:   2017/11/20 10:46
 */
public interface OnLoadingListener {

    void onStartLoading();

    void onStartLoading(String loadMsg);

    void onLoadingFinish();

}
