package com.gameloft.footballtime.tab;

public class TabBundesligaTable extends TabBaseTable {
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/452/leagueTable");
    }
}
