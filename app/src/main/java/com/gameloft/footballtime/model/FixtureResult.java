package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FixtureResult {

    @SerializedName("goalsHomeTeam")
    @Expose
    private String goalsHomeTeam;
    @SerializedName("goalsAwayTeam")
    @Expose
    private String goalsAwayTeam;


    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

}