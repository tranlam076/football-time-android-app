package com.gameloft.footballtime.fragment;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.gameloft.footballtime.NotificationPublisher;
import com.gameloft.footballtime.R;
import com.gameloft.footballtime.adapters.HomeFixtureAdapter;
import com.gameloft.footballtime.data.ApiService;
import com.gameloft.footballtime.data.ApiUtils;
import com.gameloft.footballtime.model.Date;
import com.gameloft.footballtime.model.Fixture;
import com.gameloft.footballtime.model.ListFixtures;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    private final static String API_KEY = "b43fe5aa11494ddd897bdb0764bf2d7d";
    private android.support.v4.app.FragmentManager mManager;
    private RelativeLayout rlEpl, rlBbva, rlBundesliga, rlLeague1, rlSerieA;
    private RecyclerView mRecyclerView;
    private HomeFixtureAdapter mAdapter;
    private List<Fixture> mFixtures;
    private ApiService mService;
    private String mFavoriteTeam;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        sharedPreferences = getContext().getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        mFavoriteTeam = sharedPreferences.getString("FAVORITE_TEAM", "null");
        if (!mFavoriteTeam.equals("null")) mFavoriteTeam += "/fixtures";
        if (mFavoriteTeam.equals("null")) {
            View view = inflater.inflate(R.layout.fragment_home_null, container, false);
            mManager = getActivity().getSupportFragmentManager();
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_home_fixture, container, false);
            mService = ApiUtils.getService();
            mRecyclerView = (RecyclerView) view.findViewById(R.id.rvHomeFixture);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            mFixtures = new ArrayList<Fixture>();
            mAdapter = new HomeFixtureAdapter(mFixtures, this.getContext());
            mRecyclerView.setAdapter(mAdapter);
            getData();

            return view;
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        if (mFavoriteTeam.equals("null")) {
            rlEpl = getView().findViewById(R.id.rlEpl);
            rlEpl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceFragment(new EplFragment());
                }
            });

            rlBbva = getView().findViewById(R.id.rlBbva);
            rlBbva.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceFragment(new LaligaFragment());
                }
            });

            rlBundesliga = getView().findViewById(R.id.rlBundesliga);
            rlBundesliga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceFragment(new BundesligaFragment());
                }
            });

            rlLeague1 = getView().findViewById(R.id.rlLeague1);
            rlLeague1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceFragment(new League1Fragment());
                }
            });

            rlSerieA = getView().findViewById(R.id.rlSeriea);
            rlSerieA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    replaceFragment(new SerieAFragment());
                }
            });
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getContext().getResources().getString(R.string.app_name));
    }

    public void getData(){
        final AlertDialog dialog = new SpotsDialog(getContext(),R.style.ProgressCustom);
        dialog.show();
        mService.getTeamFixtures(API_KEY, mFavoriteTeam).enqueue(new Callback<ListFixtures>() {
            @Override
            public void onResponse(Call<ListFixtures> call, Response<ListFixtures> response) {
                if (response.isSuccessful()) {
                    mAdapter.getFootBallFixtures(response.body().getFixtures());
                    mRecyclerView.scrollToPosition(mAdapter.getPosNow());
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        setNotification();
                    }
                    dialog.dismiss();
                } else {
                    dialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<ListFixtures> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }

    public void replaceFragment(android.support.v4.app.Fragment ft) {
        FragmentTransaction ft_rep = mManager.beginTransaction();
        ft_rep.setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in, R.anim.slide_out);
        ft_rep.replace(R.id.contentFrame, ft);
        ft_rep.addToBackStack(null);
        ft_rep.commit();
    }

    private void scheduleNotification(Notification notification, long delay) {
        Intent notificationIntent = new Intent(getActivity(), NotificationPublisher.class);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private Notification getNotification(String title, String content, String league) {
        Notification.Builder builder = new Notification.Builder(getActivity());
        builder.setContentTitle(title);
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.app_icon);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        builder.setVibrate(new long[] { 1000, 1000});
        switch (league) {
            case "http://api.football-data.org/v1/competitions/445":
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_epl_small));
                break;
            case "http://api.football-data.org/v1/competitions/452":
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_bundesliga_small));
                break;
            case "http://api.football-data.org/v1/competitions/456":
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_seriea_small));
                break;
            case "http://api.football-data.org/v1/competitions/455":
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_bbva_small));
                break;
            case "http://api.football-data.org/v1/competitions/450":
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_league1_small));
                break;
            case "http://api.football-data.org/v1/competitions/464":
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_c1));
                break;
            default:
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app_icon_small));
        }
        return builder.build();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setNotification(){
        boolean noti = sharedPreferences.getBoolean("NOTIFICATIONS",false);
        boolean before1d = sharedPreferences.getBoolean("BEFORE_1D",false);
        boolean before1h = sharedPreferences.getBoolean("BEFORE_1H",false);
        boolean before15m = sharedPreferences.getBoolean("BEFORE_15M",false);
        String date = sharedPreferences.getString("NOTI_DATE","null");
        String time = sharedPreferences.getString("NOTI_TIME","null");
        String league = sharedPreferences.getString("NOTI_LEAGUE", "null");
        String content = sharedPreferences.getString("NOTI_HOME_TEAM","null") + " - " +  sharedPreferences.getString("NOTI_AWAY_TEAM","null");
        Date date1 = new Date(time, date);
        if (noti){
            if (before1d){
                if (date1.getLeftTimeInMilis()-24*60*60*1000 >0){
                    scheduleNotification(getNotification(time + " " + date,content,league),date1.getLeftTimeInMilis()-24*60*60*1000);
                }
            }
            if (before1h){
                if (date1.getLeftTimeInMilis()-60*60*1000 >0){
                    scheduleNotification(getNotification(time + " " + date,content,league),date1.getLeftTimeInMilis()-60*60*1000);
                }
            }
            if (before15m){
                if (date1.getLeftTimeInMilis()-15*60*1000 >0) {
                    scheduleNotification(getNotification(time + " " + date, content, league), date1.getLeftTimeInMilis() - 15 * 60 * 1000);
                }
            }
        }
    }
}
