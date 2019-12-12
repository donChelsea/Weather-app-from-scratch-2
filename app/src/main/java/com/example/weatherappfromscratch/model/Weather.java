package com.example.weatherappfromscratch.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Weather {

    private String dateTimeISO;
    private String maxTempF;
    private String minTempF;
    private String maxTempC;
    private String minTempC;

    public Weather() {
    }

    public String getDateTimeISO() throws ParseException {
        String dateFormat = "MM-dd-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        Date date = sdf.parse(dateTimeISO);
        return date.toString();
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
