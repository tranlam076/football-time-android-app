package com.gameloft.footballtime.model;


import android.os.SystemClock;
import android.util.Log;

import java.util.Calendar;
import java.util.TimeZone;

public class Date {
    int day, month, year, hour, min;

    public Date(String date) {
        hour = (date.charAt(11)-48)*10 + date.charAt(12) - 48;
        min = (date.charAt(14)-48)*10 + date.charAt(15) - 48;
        day = (date.charAt(8)-48)*10 + date.charAt(9) - 48;
        month = (date.charAt(5)-48)*10 + date.charAt(6) - 48;
        year = 2000 + (date.charAt(2)-48)*10 + date.charAt(3) - 48;
        switchToGMT(7);
    }

    public Date(String time, String date){
        hour = (time.charAt(0)-48)*10 + time.charAt(1) - 48;
        min = (time.charAt(3)-48)*10 + time.charAt(4) - 48;
        day = (date.charAt(0)-48)*10 + date.charAt(1) - 48;
        month = (date.charAt(3)-48)*10 + date.charAt(4) - 48;
        year = 2000+ (date.charAt(6)-48)*10 + date.charAt(7) - 48;
    }

    private boolean checkLeap(){
        if ((year%4)==0&&(year%100)!=0||(year%400)==0) return true;
        return false;
    }

    private int dayOfMonth(){
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 2: if (checkLeap()) return 29;
            return 28;
            case 4:
            case 6:
            case 9:
            case 11: return 30;

            default: return 30;
        }
    }

    private void switchToGMT(int i){
        hour += i;
        if (hour>=24) {
            hour -= 24;
            day++;
            if (day>dayOfMonth()){
                day -= dayOfMonth();
                month++;
                if (month>12) {
                    month -= 12;
                    year++;
                }
            }
        }
    }

    public String getTime(){
        String str="";
        if (hour<10) str+="0";
        str += String.valueOf(hour);
        str += ":";
        str += String.valueOf(min);
        if (min==0) str+="0";
        return str;
    }

    public String getDate(){
        String str="";
        str += String.valueOf(day);
        if (day<10) str = "0" + str;
        str += "/";
        if (month<10) str += "0" + String.valueOf(month); else str += String.valueOf(month);
        str += "/";
        str += String.valueOf(year-2000);
        return str;
    }

    public long getLeftTimeInMilis(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTimeInMillis() - System.currentTimeMillis();
    }

}
