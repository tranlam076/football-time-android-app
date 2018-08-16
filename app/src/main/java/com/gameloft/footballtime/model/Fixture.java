package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Fixture {

    @SerializedName("_links")
    @Expose
    private FixtureLinks fixtureLinks;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("homeTeamName")
    @Expose
    private String homeTeamName;
    @SerializedName("awayTeamName")
    @Expose
    private String awayTeamName;
    @SerializedName("result")
    @Expose
    private FixtureResult result;

    public Info getHomeInfo() {
        return new Info(homeTeamName);
    }

    public Info getAwayInfo() {
       return new Info(awayTeamName);
    }

    public Date getDate() {
        return new Date(date);
    }

    public String getStatus() {
        return status;
    }

    public Integer getMatchday() {
        return matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public FixtureResult getResult() {
        return result;
    }

    public FixtureLinks getFixtureLinks() {
        return fixtureLinks;
    }
}