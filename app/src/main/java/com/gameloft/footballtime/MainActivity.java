package com.gameloft.footballtime;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.gameloft.footballtime.fragment.BundesligaFragment;
import com.gameloft.footballtime.fragment.EplFragment;
import com.gameloft.footballtime.fragment.FavoriteFragment;
import com.gameloft.footballtime.fragment.HomeFragment;
import com.gameloft.footballtime.fragment.LaligaFragment;
import com.gameloft.footballtime.fragment.League1Fragment;
import com.gameloft.footballtime.fragment.NotiFragment;
import com.gameloft.footballtime.fragment.SerieAFragment;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    android.support.v4.app.FragmentManager mManager;
    SharedPreferences sharedPreferences;
    Toolbar mToolbar;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle mToggle;
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadLanguage();
        setContentView(R.layout.activity_main);

        getWidgets();
        setWidges();
        addFragment(new HomeFragment());

    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem change_team = menu.findItem(R.id.change_team);
        if (sharedPreferences.getString("FAVORITE_TEAM", "null").equals("null")) {
            change_team.setVisible(false);
        } else {
            change_team.setVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_exit) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(getString(R.string.exit));
            alertDialogBuilder.setMessage(getString(R.string.ask_for_sure));
            alertDialogBuilder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alertDialogBuilder.setNegativeButton(getString(R.string.no), null);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return true;
        }
        if (id == R.id.action_about) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(getString(R.string.developers));
            String text1 = getString(R.string.dev_1);
            String text2 = getString(R.string.dev_2);
            String text3 = getString(R.string.dev_3);
            alertDialogBuilder.setMessage(text1 + "\n" + text2 + "\n" + text3);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return true;
        }
        if (id == R.id.change_team) {
            Intent intent = new Intent(this, SelectTeamActivity.class);
            finish();
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_language) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            CharSequence items[] = new CharSequence[]{"English", "Tiếng Việt"};
            final int[] lang = {0};
            if (sharedPreferences.getString("LANGUAGE", "en").equals("vi")) lang[0] = 1;
            adb.setSingleChoiceItems(items, lang[0], new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface d, int n) {
                    switch (n) {
                        case 0:
                            lang[0] = 0;
                            break;
                        case 1:
                            lang[0] = 1;
                            break;
                    }
                }
            });
            adb.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (lang[0] == 0) {
                        editor.putString("LANGUAGE", "en");
                    } else {
                        editor.putString("LANGUAGE", "vi");
                    }
                    editor.apply();
                    Intent intent = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(getBaseContext().getPackageName());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    startActivity(intent);
                }
            });
            adb.setNegativeButton(getString(R.string.cancel), null);
            adb.setTitle(R.string.restart_app);
            adb.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                replaceFragment(new HomeFragment());
                break;
            case R.id.nav_epl:
                replaceFragment(new EplFragment());
                break;
            case R.id.nav_ligabbva:
                replaceFragment(new LaligaFragment());
                break;
            case R.id.nav_bundesliga:
                replaceFragment(new BundesligaFragment());
                break;
            case R.id.nav_seria:
                replaceFragment(new SerieAFragment());
                break;
            case R.id.nav_league1:
                replaceFragment(new League1Fragment());
                break;
            case R.id.nav_nofti:
                if (sharedPreferences.getString("FAVORITE_TEAM", "null").equals("null")) {
                    Intent intent = new Intent(MainActivity.this, SelectTeamActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    replaceFragment(new NotiFragment());
                }
                break;
            case R.id.nav_favorite:
                if (sharedPreferences.getString("FAVORITE_TEAM", "null").equals("null")) {
                    Intent intent = new Intent(MainActivity.this, SelectTeamActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    replaceFragment(new FavoriteFragment());
                }
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addFragment(android.support.v4.app.Fragment ft) {
        FragmentTransaction ft_add = mManager.beginTransaction();
        ft_add.add(R.id.contentFrame, ft);
        ft_add.commit();
    }

    private void replaceFragment(android.support.v4.app.Fragment ft) {
        FragmentTransaction ft_rep = mManager.beginTransaction();
        ft_rep.setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in, R.anim.slide_out);
        ft_rep.replace(R.id.contentFrame, ft);
        ft_rep.addToBackStack(null);
        ft_rep.commit();
    }

    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    private void loadLanguage() {
        sharedPreferences = getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        setLocale(sharedPreferences.getString("LANGUAGE", "en"));
    }

    private void getWidgets() {
        mManager = getSupportFragmentManager();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void setWidges() {
        setSupportActionBar(mToolbar);

        mToggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //noinspection deprecation
        mDrawer.setDrawerListener(mToggle);
        mToggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setItemIconTintList(null);
    }

}
