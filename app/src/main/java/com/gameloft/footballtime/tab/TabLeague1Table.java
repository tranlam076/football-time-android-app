package com.gameloft.footballtime.tab;

public class TabLeague1Table extends TabBaseTable {
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/450/leagueTable");
    }
}
