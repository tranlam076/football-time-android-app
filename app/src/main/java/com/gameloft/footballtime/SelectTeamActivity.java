package com.gameloft.footballtime;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gameloft.footballtime.adapters.RecyclerTouchListener;
import com.gameloft.footballtime.adapters.ListTeamAdapter;
import com.gameloft.footballtime.data.ApiService;
import com.gameloft.footballtime.data.ApiUtils;
import com.gameloft.footballtime.model.ListTeams;
import com.gameloft.footballtime.model.Team;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectTeamActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private final static String API_KEY = "b43fe5aa11494ddd897bdb0764bf2d7d";
    private final static String EPL_URL = "/v1/competitions/445/teams";
    private final static String BBVA_URL = "/v1/competitions/455/teams";
    private final static String BUNDES_URL = "/v1/competitions/452/teams";
    private final static String SERIEA_URL = "/v1/competitions/456/teams";
    private final static String LEAGUE1_URL = "/v1/competitions/450/teams";
    private Button btnSkip;
    private ApiService mService;
    private RecyclerView mRecyclerView;
    private ListTeamAdapter mAdapter;
    private SearchView mSearchView;
    private SharedPreferences sharedPreferences;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadLanguage();
        setContentView(R.layout.activity_team_select);

        init();
        getWidgets();
        setWidgets();
        displayTeams();
        setWidgetsListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_select_team_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.btnsearch);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setQueryHint(getString(R.string.search_team_hint));
        SearchView.SearchAutoComplete searchAutoComplete = (SearchView.SearchAutoComplete)
                mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchAutoComplete.setHintTextColor(getResources().getColor(R.color.colorWhite));
        searchAutoComplete.setTextColor(getResources().getColor(R.color.colorWhite));
        mSearchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_language){
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            CharSequence items[] = new CharSequence[] {"English", "Tiếng Việt"};
            final int[] lang = {0};
            if (sharedPreferences.getString("LANGUAGE","en").equals("vi")) lang[0] = 1;
            adb.setSingleChoiceItems(items, lang[0], new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface d, int n) {
                    switch (n){
                        case 0:
                            lang[0]=0;
                            break;
                        case 1:
                            lang[0]=1;
                            break;
                    }
                }
            });
            adb.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (lang[0]==0) {
                        editor.putString("LANGUAGE","en");
                    } else {
                        editor.putString("LANGUAGE","vi");
                    }
                    editor.apply();
                    Intent intent = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }
            });
            adb.setNegativeButton(getString(R.string.cancel), null);
            adb.setTitle(R.string.restart_app);
            adb.show();
        }
        if (id == R.id.action_exit) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mAdapter.filter = newText;
        mAdapter.getFilter().filter(newText);
        return false;
    }

    private void displayTeams() {
        loadTeams(EPL_URL);
        loadTeams(BBVA_URL);
        loadTeams(BUNDES_URL);
        loadTeams(SERIEA_URL);
        loadTeams(LEAGUE1_URL);
    }

    private void init(){
        mAdapter = new ListTeamAdapter(new ArrayList<Team>(), this);
    }

    private void getWidgets(){
        mService = ApiUtils.getService();
        mToolbar = (Toolbar) findViewById(R.id.toolBar);
        btnSkip = (Button) findViewById(R.id.btnSkip);
        mRecyclerView = (RecyclerView) findViewById(R.id.rvListTeam);
    }

    private void setWidgets(){
        mToolbar.setTitle(getResources().getText(R.string.select_title));
        setSupportActionBar(mToolbar);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setWidgetsListener(){
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sharedPreferences.getString("FAVORITE_TEAM", "null").equals("null")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("FAVORITE_TEAM", "null");
                    editor.apply();
                }
                finish();
                Intent intent = new Intent(SelectTeamActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FAVORITE_TEAM", mAdapter.mTeam.get(position).getLinks().getClubLink().getHref());
                editor.apply();
                finish();
                Intent intent = new Intent(SelectTeamActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    private void loadLanguage(){
        sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        setLocale(sharedPreferences.getString("LANGUAGE","en"));
    }

    private void loadTeams(String url){
        mService.getLeagueTeams(API_KEY,url).enqueue(new Callback<ListTeams>() {
            @Override
            public void onResponse(Call<ListTeams> call, Response<ListTeams> response) {
                if (response.isSuccessful()) {
                    mAdapter.getTeams(response.body().getTeams());
                }
            }
            @Override
            public void onFailure(Call<ListTeams> call, Throwable t) {
            }
        });
    }
}