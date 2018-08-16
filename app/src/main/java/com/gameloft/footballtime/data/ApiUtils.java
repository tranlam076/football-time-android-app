package com.gameloft.footballtime.data;

public class ApiUtils {
    public static final String BASE_URL = "http://api.football-data.org/";

    public static ApiService getService() {
        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}