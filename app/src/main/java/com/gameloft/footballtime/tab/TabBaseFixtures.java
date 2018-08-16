package com.gameloft.footballtime.tab;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.LeagueFixtureAdapter;
import com.gameloft.footballtime.data.ApiService;
import com.gameloft.footballtime.data.ApiUtils;
import com.gameloft.footballtime.model.Fixture;
import com.gameloft.footballtime.model.ListFixtures;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TabBaseFixtures extends Fragment {
    private final static String API_KEY = "b43fe5aa11494ddd897bdb0764bf2d7d";
    private String FIXTURES_URL;
    private RecyclerView mRecyclerView;
    private LeagueFixtureAdapter mAdapter;
    private List<Fixture> mFixtures;
    private ApiService mService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_league_fixture, container, false);

        setUrl();

        mService = ApiUtils.getService();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvLeagueFixture);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mFixtures = new ArrayList<Fixture>();
        mAdapter = new LeagueFixtureAdapter(mFixtures, this.getContext());
        mRecyclerView.setAdapter(mAdapter);
        getData();
        return view;
    }

    public void getData() {
        final AlertDialog dialog = new SpotsDialog(getContext(), R.style.ProgressCustom);
        dialog.show();
        mService.getTeamFixtures(API_KEY, FIXTURES_URL).enqueue(new Callback<ListFixtures>() {
            @Override
            public void onResponse(Call<ListFixtures> call, Response<ListFixtures> response) {
                if (response.isSuccessful()) {
                    mAdapter.getFootBallFixtures(response.body().getFixtures());
                    mRecyclerView.scrollToPosition(mAdapter.getPosNow());
                    dialog.dismiss();
                } else {
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListFixtures> call, Throwable t) {
                dialog.dismiss();
            }

        });
    }

    public void setUrl() {
    }

    public void changeUrl(String url) {
        FIXTURES_URL = url;
    }
}
