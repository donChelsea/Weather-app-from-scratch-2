package com.example.weatherappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Periods {
    @SerializedName("periods")

    private List<Weather> weatherList;

    public Periods(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }
}
