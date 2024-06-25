package com.example.lichthidaubongda.fragment.chart.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InforChart {

    @SerializedName("data")
    private List<Chart> charts;

    public InforChart( List<Chart> charts) {

        this.charts = charts;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }
}
