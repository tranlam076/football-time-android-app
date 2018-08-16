package com.gameloft.footballtime.tab;

public class TabEplFixtures extends TabBaseFixtures{
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/445/fixtures");
    }
}