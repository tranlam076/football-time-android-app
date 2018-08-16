package com.gameloft.footballtime.tab;

public class TabSerieATable extends TabBaseTable {
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/456/leagueTable");
    }
}
