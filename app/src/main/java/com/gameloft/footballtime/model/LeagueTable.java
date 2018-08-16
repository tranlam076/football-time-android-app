package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeagueTable {

    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("standing")
    @Expose
    private List<TeamRank> leagueTable = null;

    public List<TeamRank> getTable() {
        return leagueTable;
    }

    public void setLeagueTable(List<TeamRank> leagueTable) {
        this.leagueTable = leagueTable;
    }
}
