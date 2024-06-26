package com.example.lichthidaubongda.fragment.chart.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.google.gson.annotations.SerializedName;

public class Chart {

    @SerializedName("league_id")
    private int leagueID;

    @SerializedName("all")
    private Stat stat;
    @SerializedName("goals_diff")
    private int goalsDiff;
    @SerializedName("points")
    private int points;
    @SerializedName("team_name")
    private String teamName;
    @SerializedName("rank")
    private int rank;
    @SerializedName("logo")
    private String logo;

    public Chart(Stat stat, int leagueID, int goalsDiff, int points, String teamName, int rank, String logo) {
        this.leagueID = leagueID;
        this.stat = stat;
        this.goalsDiff = goalsDiff;
        this.points = points;
        this.teamName = teamName;
        this.rank = rank;
        this.logo = logo;
    }

    public int getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public static final DiffUtil.ItemCallback<Chart> CHART_DIFF_UTIL = new DiffUtil.ItemCallback<Chart>() {
        @Override
        public boolean areItemsTheSame(@NonNull Chart oldItem, @NonNull Chart newItem) {
            return oldItem.getRank() == newItem.getRank();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Chart oldItem, @NonNull Chart newItem) {
            return oldItem.getRank() == newItem.getRank()
                    && oldItem.getTeamName().equals(newItem.getTeamName())
                    && oldItem.getLogo().equals(newItem.getLogo());
        }
    };
}
