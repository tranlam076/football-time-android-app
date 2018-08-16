package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2017/08/29.
 */

public class Team {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("squadMarketValue")
    @Expose
    private String squadMarketValue;
    @SerializedName("_links")
    @Expose
    private TeamLinks teamLinks;

    public Info getTeamInfo() {
        return new Info(name);
    }


    public String getName() {
        return name;
    }

    public TeamLinks getLinks() {
        return teamLinks;
    }

    public String getShortName() {
        return shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public String getCode() {
        return code;
    }
}
