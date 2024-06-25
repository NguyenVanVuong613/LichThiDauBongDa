package com.example.lichthidaubongda.fragment.topassist.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.SerializedName;

public class Topassist {
    @SerializedName("team_name")
    private String teamName;
    @SerializedName("player_name")
    private String playerName;

    @SerializedName("goals")
    private Goals goals;
    @SerializedName("logo_team")
    private String logoTeam;
    public Topassist(String teamName , String playerName , Goals goals , String logoTeam) {
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

    public static final DiffUtil.ItemCallback<Topassist> SCHEDULE_DIFF_UTIL = new DiffUtil.ItemCallback<Topassist>() {
        @Override
        public boolean areItemsTheSame(@NonNull Topassist oldItem, @NonNull Topassist newItem) {
            return oldItem.getGoals().getTatal().equals(newItem.getGoals().getTatal());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Topassist oldItem, @NonNull Topassist newItem) {
            return oldItem.getTeamName().equals(newItem.getTeamName())&&
                    oldItem.getPlayerName().equals(newItem.getPlayerName())&&
                    oldItem.getGoals().getAssists().equals(newItem.getGoals().getAssists())&&
                    oldItem.getLogoTeam().equals(newItem.getLogoTeam())
                    ;
        }
    };
}
