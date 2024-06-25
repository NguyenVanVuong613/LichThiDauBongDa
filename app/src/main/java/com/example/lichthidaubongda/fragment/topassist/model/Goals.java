package com.example.lichthidaubongda.fragment.topassist.model;

import com.google.gson.annotations.SerializedName;

public class Goals {
    @SerializedName("total")
    private Integer total;
    @SerializedName("assists")
    private Integer assists;


    public Goals(Integer total, Integer assists) {
        this.total = total;
        this.assists = assists;

    }

    public Integer getTatal() {
        return total;
    }

    public void setTatal(Integer total) {
        this.total = total;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

}
