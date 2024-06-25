package com.example.lichthidaubongda.fragment.topscorer.model;

import com.google.gson.annotations.SerializedName;

public class DataTopscorer {
    @SerializedName("data")
    private IdTopscorer dataIdTopscorer;

    public DataTopscorer(IdTopscorer dataIdTopscorer) {
        this.dataIdTopscorer = dataIdTopscorer;
    }

    public IdTopscorer getDataIdTopscorer() {
        return dataIdTopscorer;
    }

    public void setDataIdSchedule(IdTopscorer dataIdTopscorer) {
        this.dataIdTopscorer = dataIdTopscorer;
    }
}
