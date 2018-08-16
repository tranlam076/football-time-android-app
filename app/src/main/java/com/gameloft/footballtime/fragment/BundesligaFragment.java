package com.gameloft.footballtime.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.TabAdapter;
import com.gameloft.footballtime.tab.TabBundesligaFixtures;
import com.gameloft.footballtime.tab.TabBundesligaTable;

/**
 * Created by USER on 18/11/2017.
 */

public class BundesligaFragment extends BaseFragment {
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Bundesliga");
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new TabBundesligaFixtures(), getString(R.string.fixtures));
        tabAdapter.addFragment(new TabBundesligaTable(), getString(R.string.table));
        viewPager.setAdapter(tabAdapter);
    }
}
