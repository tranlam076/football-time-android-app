package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CompetitionLink {
    @SerializedName("href")
    @Expose
    private String href;

    public String getHref() {
        return href;
    }

}
