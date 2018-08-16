package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FixtureLinks {
    @SerializedName("competition")
    @Expose
    private CompetitionLink competitionLink;

    public CompetitionLink getCompetitionLink() {
        return competitionLink;
    }
}
