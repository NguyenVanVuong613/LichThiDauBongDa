package com.example.lichthidaubongda.fragment.topscorer.model;

import com.google.gson.annotations.SerializedName;

public class IdTopscorer {
    @SerializedName("5284")
    private Topscorers idTopscorers;

    public IdTopscorer(Topscorers idTopscorers) {
        this.idTopscorers = idTopscorers;
    }

    public Topscorers getIdToscorers() {
        return idTopscorers;
    }

    public void setIdToscorers(Topscorers idTopscorers) {
        this.idTopscorers = idTopscorers;
    }
}
