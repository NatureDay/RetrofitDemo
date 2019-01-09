package com.example.retrofittest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Group:  阡陌科技
 * Author: daiyuanhong
 * Time:   2018/2/11 11:21
 */
public abstract class HttpRequest<T> {

    private Context mContext;
    private OnLoadingListener mOnLoadingListener;

    public HttpRequest() {
        this(null, null);
    }

    public HttpRequest(Context context) {
        this(context, null);
    }

    public HttpRequest(Context context, OnLoadingListener onLoadingListener) {
        this.mContext = context;
        this.mOnLoadingListener = onLoadingListener;
        Call<ApiResponse<T>> call = createRequest();
        if (call == null) return;
        call.enqueue(new Callback<ApiResponse<T>>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                ApiResponse<T> result = response.body();
                if (response.isSuccessful() && result.isSuccessful()) {
                    onSuccess(result.getData());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                if (mContext != null) {
                    Toast.makeText(mContext, "---onFailure---", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onFailure(String msg) {

    }

    @NonNull
    protected abstract Call<ApiResponse<T>> createRequest();

    protected abstract void onSuccess(T data);


}
