package com.gameloft.footballtime.fragment;

import android.app.AlarmManager;
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
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.gameloft.footballtime.NotificationPublisher;
import com.gameloft.footballtime.R;
import com.gameloft.footballtime.model.Date;

public class NotiFragment extends Fragment {
    Switch sbtnNoti, sbtnBefore1h, sbtnBefore15m, sbtnBefore1d;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_noti, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getContext().getResources().getString(R.string.notifications));

        sbtnNoti = (Switch) getActivity().findViewById(R.id.sbtnNoti);
        sbtnBefore1d = (Switch) getActivity().findViewById(R.id.sbtnBefore1d);
        sbtnBefore1h = (Switch) getActivity().findViewById(R.id.sbtnBefore1h);
        sbtnBefore15m = (Switch) getActivity().findViewById(R.id.sbtnBefore15m);

        sharedPreferences = getActivity().getSharedPreferences("shared_preferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        boolean notiState = sharedPreferences.getBoolean("NOTIFICATIONS", false);
        boolean before1dState = sharedPreferences.getBoolean("BEFORE_1D", false);
        boolean before1hState = sharedPreferences.getBoolean("BEFORE_1H", false);
        boolean before15mState = sharedPreferences.getBoolean("BEFORE_15M", false);

        if (!notiState) sbtnNoti.setChecked(false);
        else {
            sbtnNoti.setChecked(true);
            if (!before1dState) sbtnBefore1d.setChecked(false);
            else sbtnBefore1d.setChecked(true);
            if (!before1hState) sbtnBefore1h.setChecked(false);
            else sbtnBefore1h.setChecked(true);
            if (!before15mState) sbtnBefore15m.setChecked(false);
            else sbtnBefore15m.setChecked(true);
        }

        sbtnBefore1d.setEnabled(notiState);
        sbtnBefore1h.setEnabled(notiState);
        sbtnBefore15m.setEnabled(notiState);
        sbtnNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sbtnBefore1d.setEnabled(sbtnNoti.isChecked());
                sbtnBefore1h.setEnabled(sbtnNoti.isChecked());
                sbtnBefore15m.setEnabled(sbtnNoti.isChecked());
                if (sbtnNoti.isChecked()) {
                    editor.putBoolean("NOTIFICATIONS", true);
                    editor.putBoolean("BEFORE_1D", true);
                    editor.putBoolean("BEFORE_1H", true);
                    editor.putBoolean("BEFORE_15M", true);
                    sbtnBefore1d.setChecked(true);
                    sbtnBefore1h.setChecked(true);
                    sbtnBefore15m.setChecked(true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        setNotification();
                    }
                } else {
                    editor.putBoolean("NOTIFICATIONS", false);
                    editor.putBoolean("BEFORE_1D", false);
                    editor.putBoolean("BEFORE_1H", false);
                    editor.putBoolean("BEFORE_15M", false);
                    sbtnBefore1d.setChecked(false);
                    sbtnBefore1h.setChecked(false);
                    sbtnBefore15m.setChecked(false);
                }
                editor.apply();
            }
        });

        sbtnBefore1d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sbtnBefore1d.isChecked()) {
                    editor.putBoolean("BEFORE_1D", true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        setNotification();
                    }
                }
                else editor.putBoolean("BEFORE_1D", false);
                editor.apply();
                checkNoti();
            }
        });

        sbtnBefore1h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sbtnBefore1h.isChecked()) {
                    editor.putBoolean("BEFORE_1H", true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        setNotification();
                    }
                }
                else editor.putBoolean("BEFORE_1H", false);
                editor.apply();
                checkNoti();
            }
        });

        sbtnBefore15m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sbtnBefore15m.isChecked()) {
                    editor.putBoolean("BEFORE_15M", true);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        setNotification();
                    }
                }
                else editor.putBoolean("BEFORE_15M", false);
                editor.apply();
                checkNoti();
            }
        });
    }

    private void checkNoti(){
        if (!sbtnBefore1d.isChecked()&&!sbtnBefore1h.isChecked()&&!sbtnBefore15m.isChecked()) {
            sbtnNoti.setChecked(false);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("NOTIFICATIONS", false);
            editor.apply();
            sbtnBefore1d.setEnabled(false);
            sbtnBefore1h.setEnabled(false);
            sbtnBefore15m.setEnabled(false);
        }
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
