package com.gameloft.footballtime.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player implements Comparable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("jerseyNumber")
    @Expose
    private String jerseyNumber;
    @SerializedName("dateOfBirth")
    @Expose
    private String dateOfBirth ;
    @SerializedName("nationality")
    @Expose
    private String nationality ;
    @SerializedName("contractUntil")
    @Expose
    private String contractUntil  ;


    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }

    public String getName() {
        return name;}

    public String getPosition() {
        return position ;}

    public String getJerseyNumber() {
        return jerseyNumber ;}

    public String getDateOfBirth () {
        return dateOfBirth ;}

    public String getNationality () {
        return nationality ;}

    public String getContractUntil  () {
        return contractUntil  ;}
}
