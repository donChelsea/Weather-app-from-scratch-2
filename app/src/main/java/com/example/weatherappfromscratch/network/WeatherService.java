package com.example.weatherappfromscratch.network;

import com.example.weatherappfromscratch.model.ResponseList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface WeatherService {

    @GET("/forecasts/11101?client_id=Xrojwf0CVEM7GcVysgEbl&client_secret=4U5n53YUKe7hdIBQdY6toMmCi2iIu2a2siNuIBJn")
    Observable<ResponseList> getResponseList();

}
