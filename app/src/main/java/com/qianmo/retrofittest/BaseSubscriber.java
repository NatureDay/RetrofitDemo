package com.qianmo.retrofittest;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import rx.Subscriber;

/**
 * 针对Subscriber的封装处理，包括默认的启动，结束，异常处理
 * Author: Administrator
 * Time: 2017/5/10 14:28
 */
public abstract class BaseSubscriber<T> extends Subscriber<T> {

    protected Context mContext;
    protected AlertDialog mLoadingDialog;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }

}
