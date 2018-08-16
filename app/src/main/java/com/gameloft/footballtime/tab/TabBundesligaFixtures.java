package com.gameloft.footballtime.tab;

public class TabBundesligaFixtures extends TabBaseFixtures{
    @Override
    public void setUrl() {
        super.setUrl();
        changeUrl("http://api.football-data.org/v1/competitions/452/fixtures");
    }
}