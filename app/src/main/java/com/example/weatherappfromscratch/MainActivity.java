package com.example.weatherappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Switch;

import com.example.weatherappfromscratch.controller.WeatherAdapter;
import com.example.weatherappfromscratch.model.ResponseList;
import com.example.weatherappfromscratch.model.Weather;
import com.example.weatherappfromscratch.network.RetrofitSingleton;
import com.example.weatherappfromscratch.network.WeatherService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main activity";
    private Retrofit retrofit;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        retrofit = RetrofitSingleton.getInstance();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<ResponseList> responseCall = weatherService.getResponseList();
        responseCall.enqueue(new Callback<ResponseList>() {
            @Override
            public void onResponse(Call<ResponseList> call, Response<ResponseList> response) {
                List<Weather> weatherList = response.body().getResponse().get(0).getWeatherList();
                recyclerView.setAdapter(new WeatherAdapter(getApplicationContext(), weatherList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ResponseList> call, Throwable t) {
                Log.d(TAG, "on failure: " + t.getMessage());
            }
        });

    }
}
