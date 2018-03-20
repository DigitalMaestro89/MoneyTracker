package com.loftschool.android.moneytracker;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vlad on 19.03.2018.
 */

public class App extends Application {
    private static final String TAG = "App";
    private Api api;
    private static String patch1 = "http://loftschoolandroid.getsandbox.com/";
    private static String patch2 = "http://data-base.getsandbox.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, " OnCreate: ");
        String[] titles;
        titles = this.getResources().getStringArray(R.array.tab_title);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG
                ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE
        );

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setDateFormat("dd.mmmm.yyyy")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(patch2)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        api = retrofit.create(Api.class);

    }
    public Api getApi(){
        return api;
    }
}
