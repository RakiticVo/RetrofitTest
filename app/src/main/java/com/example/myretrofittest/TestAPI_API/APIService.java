package com.example.myretrofittest.TestAPI_API;



import com.example.myretrofittest.TestAPI_Model.TestAPIClass;
import com.example.myretrofittest.TestAPI_Model.TestAPI_User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    // Link API : "https://jsonplaceholder.typicode.com/posts?userId=4&id=39"
    // baseUrl chỉ lấy 1 phần domain của API
    String baseUrl = "https://jsonplaceholder.typicode.com/";

    // Khởi tạo 1 Gson
    Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

    // Khởi tạo 1 Retrofit
    APIService apiService = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build()
                            .create(APIService.class);

    @GET("posts") // tiếp tục lấy phần còn lại của domain để ghép vs baseUrl
                     // để tạo ra một domain hoàn chỉnh
    Call<List<TestAPI_User>> testGetdata1(@Query("userId") int userId,
                                         @Query("id") int id1,
                                         @Query("id") int id2);

    @GET("posts?userId=2&id=19") // tiếp tục lấy tất cả phần còn lại
                                // để tạo ra một URL hoàn chỉnh
    Call<List<TestAPI_User>> testGetdata2();

    @POST("posts") // tiếp tục lấy phần còn lại của domain để ghép vs baseUrl
                    // để tạo ra một domain hoàn chỉnh
    Call<TestAPI_User> testPostdata1(@Body TestAPI_User user);
}
