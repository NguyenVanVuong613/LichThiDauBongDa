package com.example.lichthidaubongda.fragment.chart.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.lichthidaubongda.fragment.chart.api.ApiChart;
import com.example.lichthidaubongda.fragment.chart.model.Chart;
import com.example.lichthidaubongda.fragment.chart.model.DataChart;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartRepository {
    private MutableLiveData<List<Chart>> chartML;

    public ChartRepository() {
        chartML = new MutableLiveData<>();
    }

    public MutableLiveData<List<Chart>> getChartML() {
        setChartML();
        return chartML;
    }

    private void setChartML() {
        ApiChart.apiChart.getChart().enqueue(new Callback<DataChart>() {
            @Override
            public void onResponse(@NonNull Call<DataChart> call, @NonNull Response<DataChart> response) {
                Log.i("Dunno", "Chart: Success");
                DataChart dataChart = response.body();
                if (dataChart != null) {
                    List<Chart> charts = dataChart.getDataIdChart().getInforChart().getCharts();
                    chartML.postValue(charts);
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataChart> call, @NonNull Throwable t) {
                Log.i("Dunno", "Chart: " + t);
            }
        });
    }
}
