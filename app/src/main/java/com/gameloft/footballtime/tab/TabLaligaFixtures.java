package com.gameloft.footballtime.tab;

public class TabLaligaFixtures extends TabBaseFixtures{
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/455/fixtures");
    }
}