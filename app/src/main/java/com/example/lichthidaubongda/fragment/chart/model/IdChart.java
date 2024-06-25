package com.example.lichthidaubongda.fragment.chart.model;

import com.google.gson.annotations.SerializedName;

public class IdChart {

    @SerializedName("5284")
    private InforChart inforChart;

    public IdChart(InforChart inforChart) {
        this.inforChart = inforChart;
    }

    public InforChart getInforChart() {
        return inforChart;
    }

    public void setInforChart(InforChart inforChart) {
        this.inforChart = inforChart;
    }
}
