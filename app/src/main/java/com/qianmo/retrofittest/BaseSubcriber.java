package com.qianmo.retrofittest;

import rx.Subscriber;

public class BaseSubcriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {

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
