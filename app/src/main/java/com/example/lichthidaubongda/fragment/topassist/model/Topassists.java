package com.example.lichthidaubongda.fragment.topassist.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Topassists {
    @SerializedName("data")
    private List<Topassist> topassists;

    public Topassists(List<Topassist> topassists) {
        this.topassists = topassists;
    }

    public List<Topassist> getTopassists() {
        return topassists;
    }

    public void setSchedules(List<Topassist> topassists) {
        this.topassists = topassists;
    }
}
