package com.example.lichthidaubongda.fragment.chart.api;

import com.example.lichthidaubongda.fragment.chart.model.DataChart;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiChart {
    String url = "https://gw.vnexpress.net/football/";
    Gson gson = new GsonBuilder().create();

    ApiChart apiChart = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiChart.class);

    @GET("standing?league_id=5284")
    Call<DataChart> getChart();
}
