package com.gameloft.footballtime.adapters;

import android.widget.Filter;

import com.gameloft.footballtime.model.Team;

import java.util.LinkedList;
import java.util.List;

public class ListTeamFilter extends Filter {

    ListTeamAdapter mAdapter;
    List<Team> mTeam;

    public ListTeamFilter(List<Team> mTeam, ListTeamAdapter mAdapter) {
        this.mAdapter = mAdapter;
        this.mTeam = mTeam;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (constraint != null && constraint.length() > 0) {
            constraint = constraint.toString().toUpperCase();
            List<Team> filteredPlayers=new LinkedList<>();

            for (int i = 0; i < mTeam.size(); i++) {
                if (mTeam.get(i).getName().toUpperCase().contains(constraint)) {
                    filteredPlayers.add(mTeam.get(i));
                    mAdapter.filter = constraint.toString();
                }
            }
            results.count = filteredPlayers.size();
            results.values = filteredPlayers;
        } else {
            results.count = mTeam.size();
            results.values = mTeam;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        mAdapter.mTeam = (List<Team>) results.values;
        mAdapter.notifyDataSetChanged();
    }
}
