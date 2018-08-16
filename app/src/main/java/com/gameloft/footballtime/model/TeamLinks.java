package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 14/11/2017.
 */

public class TeamLinks {
    @SerializedName("self")
    @Expose
    private ClubLink clubLink;

    public ClubLink getClubLink() {
        return clubLink;
    }
}
