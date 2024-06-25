package com.example.lichthidaubongda.fragment.topscorer.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Topscorers {
    @SerializedName("data")
    private List<Topscorer> topscorers;

    public Topscorers(List<Topscorer> topscorers) {
        this.topscorers = topscorers;
    }

    public List<Topscorer> getTopscorers() {
        return topscorers;
    }

    public void setSchedules(List<Topscorer> topscorers) {
        this.topscorers = topscorers;
    }
}
