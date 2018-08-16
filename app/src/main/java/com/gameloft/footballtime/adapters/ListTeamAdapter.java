package com.gameloft.footballtime.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gameloft.footballtime.R;
import com.gameloft.footballtime.model.Team;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ListTeamAdapter extends RecyclerView.Adapter<ListTeamAdapter.MyViewHolder> implements Filterable {

    public String filter = "";
    public List<Team> mTeam;
    private List<Team> filteredUserList;
    private ListTeamFilter userFilter;
    private String itemValue = "";
    private Context mContext;

    public ListTeamAdapter(List<Team> mTeam, Context context) {
        this.mContext = context;
        this.mTeam = mTeam;
        mTeam.clear();
    }

    @Override
    public Filter getFilter() {
        this.filteredUserList = mTeam;
        if (userFilter == null) {
            userFilter = new ListTeamFilter(filteredUserList, this);
            filter = "";
        }
        return userFilter;
    }

    @Override
    public ListTeamAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.row_select_team, parent, false);
        return new ListTeamAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListTeamAdapter.MyViewHolder holder, int position) {
        Team team = mTeam.get(position);
        if (filter.toString().equals("")) {
            holder.tvNameTeam.setText(team.getName());
        } else {
            itemValue = team.getName();

            int startPos = itemValue.toLowerCase(Locale.US).indexOf(filter.toLowerCase(Locale.US));
            int endPos = startPos + filter.length();

            if (startPos != -1) {
                Spannable spannable = new SpannableString(itemValue);
                ColorStateList color = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.RED});
                TextAppearanceSpan highlightSpan = new TextAppearanceSpan(null, Typeface.BOLD, -1, color, null);
                spannable.setSpan(highlightSpan, startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.tvNameTeam.setText(spannable);
            } else
                holder.tvNameTeam.setText(itemValue);
        }

        holder.tvNameTeam.setText(team.getName());
        Glide.with(mContext)
                .load(team.getTeamInfo().getLogo())
                .placeholder(R.drawable.img_loading)
                .dontAnimate()
                .into(holder.imgTeam);
    }

    @Override
    public int getItemCount() {
        return mTeam.size();
    }

    public void getTeams(List<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            mTeam.add(teams.get(i));
        }
        sortListTeam();
        notifyDataSetChanged();
    }

    public void sortListTeam(){
        Collections.sort(mTeam, new Comparator<Team>() {
            @Override
            public int compare(Team o1, Team o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameTeam;
        ImageView imgTeam;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvNameTeam = (TextView) itemView.findViewById(R.id.tvName);
            imgTeam = (ImageView) itemView.findViewById(R.id.ivLogo);
        }
    }

}

