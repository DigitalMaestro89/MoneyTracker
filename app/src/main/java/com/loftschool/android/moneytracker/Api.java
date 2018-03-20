package com.loftschool.android.moneytracker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Vlad on 19.03.2018.
 */

public interface Api {
    @GET("/items")
    Call<List<Record>> getItem(@Query("type") String type);

    @POST("/items")
    Call<List<Record>> setItem(@Body String type);
}

