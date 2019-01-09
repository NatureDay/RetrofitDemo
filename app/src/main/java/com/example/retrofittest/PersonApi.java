package com.example.retrofittest;

import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PersonApi {
    @Headers({
            "Cache-Control: max-age=640000",
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko"
    })
    //通过注解设置请求头
    @GET("/{test}/rest.php")
        //设置请求方法为get，相对路径为注解内内容，其中{test}会被@Path注解指定内容替换
    Person getPerson(@Path("test") String dir, @Query("name") String name);
    //@Query用于指定参数

    @FormUrlEncoded
    //urlencode
    @POST("/test/rest1.php")
        //post提交
    Person updatePerson(@Field("name") String name, @Field("age") int age);
    //@Field提交的域

    @POST("/test/rest1.php")
    void updatePerson(@Field("name") String name, @Field("age") int age, Callback<Person> callback);
    //异步回调，不能指定返回值
}