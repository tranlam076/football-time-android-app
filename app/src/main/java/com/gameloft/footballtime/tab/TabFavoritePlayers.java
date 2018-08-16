package com.gameloft.footballtime.tab;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.PlayersAdapter;
import com.gameloft.footballtime.adapters.RecyclerTouchListener;
import com.gameloft.footballtime.data.ApiService;
import com.gameloft.footballtime.data.ApiUtils;
import com.gameloft.footballtime.model.ListPlayers;
import com.gameloft.footballtime.model.Player;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabFavoritePlayers extends Fragment {
    private final static String API_KEY = "b43fe5aa11494ddd897bdb0764bf2d7d";
    private String mFavoriteTeam;
    private ApiService mService;
    private RecyclerView mRecyclerView;
    private PlayersAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_favorite_players, container, false);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        mFavoriteTeam = sharedPreferences.getString("FAVORITE_TEAM", "null");
        mFavoriteTeam += "/players";
        mService = ApiUtils.getService();
        if (mFavoriteTeam.equals("null")) {
            return view;
        } else {

            displayPlayers();
            mRecyclerView = (RecyclerView) view.findViewById(R.id.rvPlayers);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            mAdapter = new PlayersAdapter(new ArrayList<Player>(), getContext());
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Toast.makeText(getContext(), getContext().getResources().getString(R.string.player) + " " + mAdapter.mPlayer.get(position).getName()
                                    + "\n" + getContext().getResources().getString(R.string.player_birthday) + " " + mAdapter.mPlayer.get(position).getDateOfBirth()
                                    + "\n" + getContext().getResources().getString(R.string.player_nationality) + " " + mAdapter.mPlayer.get(position).getNationality()
                                    + "\n" + getContext().getResources().getString(R.string.player_contract) + " " + mAdapter.mPlayer.get(position).getContractUntil()
                            , Toast.LENGTH_LONG)
                            .show();
                }

                @Override
                public void onLongClick(View view, int position) {
                }
            }));
            mAdapter.notifyDataSetChanged();
            return view;
        }
    }

    private void displayPlayers() {
        mService.getTeamPlayers(API_KEY, mFavoriteTeam).enqueue(new Callback<ListPlayers>() {
            @Override
            public void onResponse(Call<ListPlayers> call, Response<ListPlayers> response) {
                if (response.isSuccessful()) {
                    mAdapter.getFavoritePlayers(response.body().getPlayerList());
                    mAdapter.sortListPlayer();
                    mAdapter.notifyDataSetChanged();
                } else {
                }
            }

            @Override
            public void onFailure(Call<ListPlayers> call, Throwable t) {
            }
        });
    }
}