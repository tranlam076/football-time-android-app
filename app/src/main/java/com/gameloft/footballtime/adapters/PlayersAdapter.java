package com.gameloft.footballtime.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.model.Player;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.MyViewHolder> {

    public List<Player> mPlayer;
    private Context mContext;
    private LayoutInflater mInflater;

    public PlayersAdapter(List<Player> mPlayer, Context mContext) {
        this.mContext = mContext;
        this.mPlayer = mPlayer;
        this.mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public PlayersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.row_favorite_player, parent, false);
        return new PlayersAdapter.MyViewHolder(itemView);
    }

    @SuppressLint({"ResourceAsColor", "NewApi"})
    @Override
    public void onBindViewHolder(PlayersAdapter.MyViewHolder holder, int position) {
        Player player = mPlayer.get(position);

        holder.tvPlayerNumber.setText(String.valueOf(player.getJerseyNumber()));
        holder.tvPlayerPosition.setTextColor(R.color.colorWhite);
        holder.tvPlayerName.setText(player.getName());
        switch (player.getPosition()) {
            case "Keeper":
                holder.tvPlayerPosition.setText("GK");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_gk_bg);
                break;
            case "Centre-Back":
                holder.tvPlayerPosition.setText("CB");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_df_bg);
                break;
            case "Left-Back":
                holder.tvPlayerPosition.setText("LB");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_df_bg);
                break;
            case "Right-Back":
                holder.tvPlayerPosition.setText("RB");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_df_bg);
                break;
            case "Central Midfield":
                holder.tvPlayerPosition.setText("CM");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_mf_bg);
                break;
            case "Attacking Midfield":
                holder.tvPlayerPosition.setText("CAM");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_mf_bg);
                break;
            case "Defensive Midfield":
                holder.tvPlayerPosition.setText("CDM");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_mf_bg);
                break;
            case "Left Midfield":
                holder.tvPlayerPosition.setText("LM");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_mf_bg);
                break;
            case "Right Midfield":
                holder.tvPlayerPosition.setText("RM");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_mf_bg);
                break;
            case "Right Wing":
                holder.tvPlayerPosition.setText("RW");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_fw_bg);
                break;
            case "Left Wing":
                holder.tvPlayerPosition.setText("LW");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_fw_bg);
                break;
            case "Centre-Forward":
                holder.tvPlayerPosition.setText("CF");
                holder.tvPlayerPosition.setBackgroundResource(R.drawable.player_fw_bg);
                break;
            default:
        }
    }

    @Override
    public int getItemCount() {
        return mPlayer.size();
    }

    public void getFavoritePlayers(List<Player> players) {
        this.mPlayer = players;
    }

    public void sortListPlayer() {
        Collections.sort(mPlayer, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getJerseyNumber() == null || o2.getJerseyNumber() == null)
                {
                    if(o1.getJerseyNumber()==null) return 1;
                        else return -1;
                }
                if (Integer.parseInt(o1.getJerseyNumber()) <= Integer.parseInt(o2.getJerseyNumber())) return -1;
                    else return 1;

            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlayerPosition, tvPlayerName, tvPlayerNumber;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvPlayerPosition = (TextView) itemView.findViewById(R.id.tvPlayerPos);
            tvPlayerName = (TextView) itemView.findViewById(R.id.tvPlayerName);
            tvPlayerNumber = (TextView) itemView.findViewById(R.id.tvPlayerNumber);
        }
    }
}

