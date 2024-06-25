package com.example.lichthidaubongda.fragment.topscorer.api;

import com.example.lichthidaubongda.fragment.topscorer.model.DataTopscorer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiSchedule {

    String url = "https://gw.vnexpress.net/football/";

    Gson gson = new GsonBuilder().create();

    ApiSchedule apiSchedule = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiSchedule.class);

    @GET("topscorer?league_id=5284")
    Call<DataTopscorer> getListTopscorer();
}
