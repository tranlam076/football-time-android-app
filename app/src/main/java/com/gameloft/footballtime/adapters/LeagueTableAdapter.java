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
import com.gameloft.footballtime.model.TeamRank;

import java.util.List;

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.MyViewHolder>{
    List<TeamRank> mTeam;
    Context mContext;

    public LeagueTableAdapter(List<TeamRank> mTeam, Context mContext) {
        this.mTeam = mTeam;
        this.mContext = mContext;
    }

    @Override
    public LeagueTableAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_league_table, parent, false);
        return new LeagueTableAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TeamRank teamRank = mTeam.get(position);

        holder.tvRank.setText(String.valueOf(teamRank.getPosition()));

        Glide.with(mContext)
                .load(teamRank.getTeamInfo().getLogo())
                .placeholder(R.drawable.img_loading)
                .dontAnimate()
                .into(holder.ivLogo);

        holder.tvTeamName.setText(teamRank.getTeamName());
        holder.tvPlayed.setText(String.valueOf(teamRank.getPlayedGames()));
        holder.tvWin.setText(String.valueOf(teamRank.getWins()));
        holder.tvDraw.setText(String.valueOf(teamRank.getDraws()));
        holder.tvLose.setText(String.valueOf(teamRank.getLosses()));
        holder.tvGoal.setText(String.valueOf(teamRank.getGoals()));
        holder.tvGoalA.setText(String.valueOf(teamRank.getGoalAgainst()));
        holder.tvGoalD.setText(String.valueOf(teamRank.getGoalDifference()));
        holder.tvPoint.setText(String.valueOf(teamRank.getPoints()));
    }

    @Override
    public int getItemCount() {
        return mTeam.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeamName, tvRank, tvPlayed, tvWin, tvDraw, tvLose, tvGoal, tvGoalA,tvGoalD, tvPoint;
        ImageView ivLogo;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvTeamName = (TextView) itemView.findViewById(R.id.tvLeagueTableName);
            tvRank = (TextView) itemView.findViewById(R.id.tvLeagueTableRank);
            tvPlayed = (TextView) itemView.findViewById(R.id.tvLeagueTablePlayed);
            tvWin = (TextView) itemView.findViewById(R.id.tvLeagueTableWin);
            tvDraw = (TextView) itemView.findViewById(R.id.tvLeagueTableDraw);
            tvLose = (TextView) itemView.findViewById(R.id.tvLeagueTableLose);
            tvGoal = (TextView) itemView.findViewById(R.id.tvLeagueTableGoal);
            tvGoalA = (TextView) itemView.findViewById(R.id.tvLeagueTableGoalA);
            tvGoalD = (TextView) itemView.findViewById(R.id.tvLeagueTableGoalD);
            tvPoint = (TextView) itemView.findViewById(R.id.tvLeagueTablePoint);
            ivLogo = (ImageView) itemView.findViewById(R.id.ivLeagueTableLogo);
        }
    }

    public void getTable(List<TeamRank> mTeam) {
        this.mTeam = mTeam;
        notifyDataSetChanged();
    }
}
