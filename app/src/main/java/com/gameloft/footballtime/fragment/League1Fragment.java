package com.gameloft.footballtime.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.TabAdapter;
import com.gameloft.footballtime.tab.TabLeague1Fixtures;
import com.gameloft.footballtime.tab.TabLeague1Table;

/**
 * Created by USER on 18/11/2017.
 */

public class League1Fragment extends BaseFragment {
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("League One");
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        TabAdapter tabAdapter = new TabAdapter(getChildFragmentManager());
        tabAdapter.addFragment(new TabLeague1Fixtures(), getString(R.string.fixtures));
        tabAdapter.addFragment(new TabLeague1Table(), getString(R.string.table));
        viewPager.setAdapter(tabAdapter);
    }
}