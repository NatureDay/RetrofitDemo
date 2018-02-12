package com.qianmo.retrofittest;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

public interface UserApi {

    @FormUrlEncoded
    @POST("login")
    Call<ApiResponse> login(@Field("user_name") String username, @Field("password") String pwd);

    @GET("buyer/total")
    Call<JSONObject> getUser();

    /**
     * 获取资讯分类
     */
    @GET("noa/news/type_list")
    Call<ApiResponse<JSONObject>> getNewsType();

//    @FormUrlEncoded
//    @POST("noa/login")
//    Observable<ApiResponse<UserEntity>> login(@Field("user_name") String phone, @Field("password") String phonecode);

//    @GET("buyer/total")
//    Observable<JSONObject> getUser();

}
