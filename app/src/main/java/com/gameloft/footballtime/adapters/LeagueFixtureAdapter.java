package com.gameloft.footballtime.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gameloft.footballtime.R;
import com.gameloft.footballtime.model.Fixture;

import java.util.List;

public class LeagueFixtureAdapter extends RecyclerView.Adapter<LeagueFixtureAdapter.MyViewHolder> {

    private List<Fixture> mFixture;
    private Context mContext;

    public LeagueFixtureAdapter(List<Fixture> mFixture, Context context) {
        this.mContext = context;
        this.mFixture = mFixture;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_league_fixture, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Fixture fixture = mFixture.get(position);

        if (fixture.getStatus().equals("FINISHED")||fixture.getStatus().equals("IN_PLAY")||fixture.getStatus().equals("CANCELED")){
            holder.tvCenter.setText(fixture.getStatus());
            holder.tvCenter2.setText(fixture.getResult().getGoalsHomeTeam().toString() + " - " + fixture.getResult().getGoalsAwayTeam().toString());
        } else {
            holder.tvCenter.setText(fixture.getDate().getTime());
            holder.tvCenter2.setText(fixture.getDate().getDate());
        }
        holder.tvNameTeamA.setText(fixture.getHomeTeamName());
        holder.tvNameTeamB.setText(fixture.getAwayTeamName());

        Glide.with(mContext)
                .load(fixture.getHomeInfo().getLogo())
                .placeholder(R.drawable.img_loading)
                .dontAnimate()
                .into(holder.imgTeamA);
        Glide.with(mContext)
                .load(fixture.getAwayInfo().getLogo())
                .placeholder(R.drawable.img_loading)
                .dontAnimate()
                .into(holder.imgTeamB);
    }

    @Override
    public int getItemCount() {
        return mFixture.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCenter2, tvCenter, tvNameTeamA, tvNameTeamB;
        ImageView imgTeamA,imgTeamB;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvCenter2 = (TextView) itemView.findViewById(R.id.tvCenter1);
            tvCenter = (TextView) itemView.findViewById(R.id.tvCenter);
            tvNameTeamA = (TextView) itemView.findViewById(R.id.tvHomeName);
            tvNameTeamB = (TextView) itemView.findViewById(R.id.tvAwayName);
            imgTeamA=(ImageView) itemView.findViewById(R.id.ivHomeLogo);
            imgTeamB=(ImageView) itemView.findViewById(R.id.ivAwayLogo);
        }
    }

    public void getFootBallFixtures(List<Fixture> team) {
        mFixture = team;
        notifyDataSetChanged();
    }

    public int getPosNow(){
        for (int i=0;i<mFixture.size();i++){
            if (mFixture.get(i).getStatus().equals("FINISHED")||mFixture.get(i).getStatus().equals("CANCELED")) {
            } else return i;
        }
        return 1;
    }

}