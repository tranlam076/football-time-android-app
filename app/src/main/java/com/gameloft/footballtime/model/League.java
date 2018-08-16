package com.gameloft.footballtime.model;

public class League {
    String url;

    public League(String url) {
        this.url = url;
    }

    public String getName(){
        switch (url) {
            case "http://api.football-data.org/v1/competitions/445":
                return "Premier League";
            case "http://api.football-data.org/v1/competitions/452":
                return "Bundesliga";
            case "http://api.football-data.org/v1/competitions/456":
                return "Serie A";
            case "http://api.football-data.org/v1/competitions/455":
                return "Liga BBVA";
            case "http://api.football-data.org/v1/competitions/450":
                return "League One";
            case "http://api.football-data.org/v1/competitions/464":
                return "Champion League";
            default:
                return "Another League";
        }
    }

    public String getLogo(){
        switch (url) {
            case "http://api.football-data.org/v1/competitions/445":
                return "https://image.ibb.co/fvX5Sm/ic_epl.png";
            case "http://api.football-data.org/v1/competitions/452":
                return "https://image.ibb.co/juyenm/ic_bundesliga.png";
            case "http://api.football-data.org/v1/competitions/456":
                return "https://image.ibb.co/e5hdf6/ic_seriea.png";
            case "http://api.football-data.org/v1/competitions/455":
                return "https://image.ibb.co/fNXTf6/ic_bbva.png";
            case "http://api.football-data.org/v1/competitions/450":
                return "https://image.ibb.co/fhekSm/ic_league1.png";
            case "http://api.football-data.org/v1/competitions/464":
                return "https://image.ibb.co/hNwPnm/Champions_League_logo.png";
            default:
                return "https://image.ibb.co/ei0EL6/app_icon.png";
        }
    }
}
