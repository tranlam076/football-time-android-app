package com.gameloft.footballtime.tab;

public class TabLeague1Fixtures extends TabBaseFixtures{
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/450/fixtures");
    }
}