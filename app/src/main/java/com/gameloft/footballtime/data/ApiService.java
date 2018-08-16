package com.gameloft.footballtime.data;

import com.gameloft.footballtime.model.ListPlayers;
import com.gameloft.footballtime.model.LeagueTable;
import com.gameloft.footballtime.model.ListFixtures;
import com.gameloft.footballtime.model.ListTeams;
import com.gameloft.footballtime.model.Team;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Call<ListTeams> getLeagueTeams(@Header("X-Auth-Token") String apiKey, @Url String url);

    @GET
    Call<ListPlayers> getTeamPlayers(@Header("X-Auth-Token") String apiKey, @Url String url);

    @GET
    Call<ListFixtures> getTeamFixtures(@Header("X-Auth-Token") String apiKey, @Url String url);

    @GET
    Call<LeagueTable> getLeagueTable(@Header("X-Auth-Token") String apiKey, @Url String url);

    @GET
    Call<Team> getTeam(@Header("X-Auth-Token") String apiKey, @Url String url);
}