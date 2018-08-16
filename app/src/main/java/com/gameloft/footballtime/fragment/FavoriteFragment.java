package com.gameloft.footballtime.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.TabAdapter;
import com.gameloft.footballtime.tab.TabFavoriteInfo;
import com.gameloft.footballtime.tab.TabFavoritePlayers;


public class FavoriteFragment extends BaseFragment {
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle(getString(R.string.favorite_title));
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new TabFavoriteInfo(), getString(R.string.info));
        tabAdapter.addFragment(new TabFavoritePlayers(), getString(R.string.players));
        viewPager.setAdapter(tabAdapter);
    }

}

