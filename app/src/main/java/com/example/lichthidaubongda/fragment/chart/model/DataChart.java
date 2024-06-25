package com.example.lichthidaubongda.fragment.chart.model;

import com.google.gson.annotations.SerializedName;

public class DataChart {
    @SerializedName("data")
    private IdChart dataIdChart;

    public DataChart(IdChart dataIdChart) {
        this.dataIdChart = dataIdChart;
    }

    public IdChart getDataIdChart() {
        return dataIdChart;
    }

    public void setDataIdChart(IdChart dataIdChart) {
        this.dataIdChart = dataIdChart;
    }
}
