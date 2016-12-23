package com.kelin.mvvmlight.zhihu.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dingzhihu on 15/5/7.
 */
public class RetrofitProvider {

    private static Retrofit retrofit;

    private RetrofitProvider() {
    }

    public static Retrofit getInstance() {
        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(new ApiTypeAdapterFactory("data"))
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://news-at.zhihu.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;

    }
}
