package com.gameloft.footballtime.tab;

public class TabEplTable extends TabBaseTable {
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/445/leagueTable");
    }
}
