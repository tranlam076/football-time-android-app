package com.gameloft.footballtime.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.TabAdapter;
import com.gameloft.footballtime.tab.TabEplFixtures;
import com.gameloft.footballtime.tab.TabEplTable;

/**
 * Created by USER on 18/11/2017.
 */

public class EplFragment extends BaseFragment {
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Premier League");
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new TabEplFixtures(), getString(R.string.fixtures));
        tabAdapter.addFragment(new TabEplTable(), getString(R.string.table));
        viewPager.setAdapter(tabAdapter);
    }
}
