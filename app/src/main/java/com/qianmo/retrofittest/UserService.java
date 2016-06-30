package com.qianmo.retrofittest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface UserService {
    @FormUrlEncoded
    @POST("login")
    Call<String> login(@Field("username") String username, @Field("pwd") String pwd, @Field("remember_me") boolean rember);
}
