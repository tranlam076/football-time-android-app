package com.gameloft.footballtime.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.LeagueTableAdapter;
import com.gameloft.footballtime.data.ApiService;
import com.gameloft.footballtime.data.ApiUtils;
import com.gameloft.footballtime.model.LeagueTable;
import com.gameloft.footballtime.model.TeamRank;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USER on 18/11/2017.
 */

public class TabBaseTable extends Fragment {
    private final static String API_KEY = "b43fe5aa11494ddd897bdb0764bf2d7d";
    private static String TABLE_URL;
    private RecyclerView mRecyclerView;
    private LeagueTableAdapter mAdapter;
    private List<TeamRank> mTeam;
    private ApiService mService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_league_table, container, false);

        setUrl();

        mService = ApiUtils.getService();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvLeagueTable);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mTeam = new ArrayList<TeamRank>();
        mAdapter = new LeagueTableAdapter(mTeam, getContext());
        mRecyclerView.setAdapter(mAdapter);
        getData();

        return view;
    }

    public void getData() {
        mService.getLeagueTable(API_KEY, TABLE_URL).enqueue(new Callback<LeagueTable>() {
            @Override
            public void onResponse(Call<LeagueTable> call, Response<LeagueTable> response) {
                if (response.isSuccessful()) {
                    mAdapter.getTable(response.body().getTable());
                } else {
                }
            }

            @Override
            public void onFailure(Call<LeagueTable> call, Throwable t) {
            }

        });
    }

    public void setUrl() {
    }

    public void changeUrl(String url) {
        TABLE_URL = url;
    }
}


