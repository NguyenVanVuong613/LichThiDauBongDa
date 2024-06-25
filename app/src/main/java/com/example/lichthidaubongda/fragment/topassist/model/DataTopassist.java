package com.example.lichthidaubongda.fragment.topassist.model;

import com.google.gson.annotations.SerializedName;

public class DataTopassist {
    @SerializedName("data")
    private IdTopassist dataIdTopassist;

    public DataTopassist(IdTopassist dataIdTopassist) {
        this.dataIdTopassist = dataIdTopassist;
    }

    public IdTopassist getDataIdTopscorer() {
        return dataIdTopassist;
    }

    public void setDataIdSchedule(IdTopassist dataIdTopassist) {
        this.dataIdTopassist = dataIdTopassist;
    }
}
