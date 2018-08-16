package com.gameloft.footballtime.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ListPlayers {


    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("players")
    @Expose
    private List<Player> playerList = null;

    public Integer getCount() {
        return count;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setFavoriteTeamPlayers(List<Player> players) {
        this.playerList = players;
    }

}