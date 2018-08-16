package com.gameloft.footballtime.tab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gameloft.footballtime.R;
import com.gameloft.footballtime.data.ApiService;
import com.gameloft.footballtime.data.ApiUtils;
import com.gameloft.footballtime.model.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabFavoriteInfo extends Fragment {
    private final static String API_KEY = "b43fe5aa11494ddd897bdb0764bf2d7d";
    private String mFavoriteTeam;
    private TextView tvFullName, tvFName, tvShortName, tvManager, tvCode, tvStadium, tvCapacity, tvNickname;
    private ImageView ivTeamLogo;
    private ApiService mService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_favorite_info, container, false);


        mService = ApiUtils.getService();
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        mFavoriteTeam = sharedPreferences.getString("FAVORITE_TEAM", "null");

        tvFullName = (TextView) view.findViewById(R.id.tvFullNameBody);
        tvFName = (TextView) view.findViewById(R.id.tvFullnameHeader);
        tvShortName = (TextView) view.findViewById(R.id.tvShortname);
        tvCapacity = (TextView) view.findViewById(R.id.tvCapacity);
        tvManager = (TextView) view.findViewById(R.id.tvManager);
        tvStadium = (TextView) view.findViewById(R.id.tvStadium);
        tvCode = (TextView) view.findViewById(R.id.tvCode);
        tvNickname = (TextView) view.findViewById(R.id.tvNickname);
        ivTeamLogo = (ImageView) view.findViewById(R.id.ivTeamLogo);

        mService.getTeam(API_KEY, mFavoriteTeam).enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                if (response.isSuccessful()) {
                    Team team = response.body();
                    ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(team.getName());
                    tvFullName.setText(team.getName());
                    tvNickname.setText(team.getTeamInfo().getNickname());
                    tvFName.setText(team.getName());
                    tvShortName.setText(team.getShortName());
                    tvStadium.setText(team.getTeamInfo().getStadium());
                    tvCapacity.setText(team.getTeamInfo().getCapacity());
                    tvCode.setText(team.getCode());
                    tvManager.setText(team.getTeamInfo().getManager());
                    Glide.with(getContext())
                            .load(team.getTeamInfo().getLogo())
                            .placeholder(R.drawable.img_loading)
                            .dontAnimate()
                            .into(ivTeamLogo);
                } else {
                }
            }

            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                tvFullName.setText(getString(R.string.cant_access));
                tvNickname.setText(getString(R.string.cant_access));
                tvFName.setText(getString(R.string.cant_access));
                tvShortName.setText(getString(R.string.cant_access));
                tvStadium.setText(getString(R.string.cant_access));
                tvCapacity.setText(getString(R.string.cant_access));
                tvCode.setText(getString(R.string.cant_access));
                tvManager.setText(getString(R.string.cant_access));
            }
        });
        return view;
    }


}
