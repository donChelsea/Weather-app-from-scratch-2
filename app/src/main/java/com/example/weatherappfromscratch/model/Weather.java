package com.example.weatherappfromscratch.model;

public class Weather {

    private String dateTimeISO;
    private String maxTempF;
    private String minTempF;
    private String maxTempC;
    private String minTempC;

    public Weather() {
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public String getMaxTempF() {
        return maxTempF;
    }

    public String getMinTempF() {
        return minTempF;
    }

    public String getMaxTempC() {
        return maxTempC;
    }

    public String getMinTempC() {
        return minTempC;
    }
}
