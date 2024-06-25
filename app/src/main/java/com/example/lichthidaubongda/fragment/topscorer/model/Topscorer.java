package com.example.lichthidaubongda.fragment.topscorer.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.SerializedName;

public class Topscorer {
    @SerializedName("team_name")
    private String teamName;
    @SerializedName("player_name")
    private String playerName;

    @SerializedName("goals")
    private Goals goals;
    @SerializedName("logo_team")
    private String logoTeam;
    public Topscorer(String teamName , String playerName , Goals goals , String logoTeam) {
        this.teamName = teamName;
        this.playerName = playerName;
        this.goals = goals;
        this.logoTeam = logoTeam;
    }

    public String getLogoTeam() {
        return logoTeam;
    }

    public void setLogoTeam(String logoTeam) {
        this.logoTeam = logoTeam;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public static final DiffUtil.ItemCallback<Topscorer> SCHEDULE_DIFF_UTIL = new DiffUtil.ItemCallback<Topscorer>() {
        @Override
        public boolean areItemsTheSame(@NonNull Topscorer oldItem, @NonNull Topscorer newItem) {
            return oldItem.getGoals().getTotal().equals(newItem.getGoals().getTotal());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Topscorer oldItem, @NonNull Topscorer newItem) {
            return oldItem.getTeamName().equals(newItem.getTeamName())&&
                    oldItem.getPlayerName().equals(newItem.getPlayerName())&&
                    oldItem.getGoals().getTotal().equals(newItem.getGoals().getTotal())&&
                    oldItem.getLogoTeam().equals(newItem.getLogoTeam())
                    ;
        }
    };
}
