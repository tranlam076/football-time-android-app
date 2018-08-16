package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TeamRank {
    @SerializedName("position")
    @Expose
    private int position;
    @SerializedName("teamName")
    @Expose
    private String teamName;
    @SerializedName("playedGames")
    @Expose
    private int playedGames;
    @SerializedName("points")
    @Expose
    private int points;
    @SerializedName("goals")
    @Expose
    private int goals;
    @SerializedName("goalsAgainst")
    @Expose
    private int goalAgainst;
    @SerializedName("goalDifference")
    @Expose
    private int goalDifference;
    @SerializedName("wins")
    @Expose
    private int wins;
    @SerializedName("draws")
    @Expose
    private int draws;
    @SerializedName("losses")
    @Expose
    private int losses;

    public Info getTeamInfo() {
        return new Info(teamName);
    }

    public int getPosition() {
        return position;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getPoints() {
        return points;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalAgainst() {
        return goalAgainst;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }
}
