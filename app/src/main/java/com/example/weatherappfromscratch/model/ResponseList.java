package com.example.weatherappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseList {
    @SerializedName("response")

    private List<Periods> response;

    public ResponseList(List<Periods> response) {
        this.response = response;
    }

    public List<Periods> getResponse() {
        return response;
    }
}
