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

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "main activity";
    private Disposable retrofit;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        retrofit = RetrofitSingleton.getInstance()
                .create(WeatherService.class)
                .getResponseList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseList>() {
                    @Override
                    public void accept(ResponseList responseList) throws Exception {
                        List<Weather> weatherList = responseList.getResponse().get(0).getWeatherList();
                        recyclerView.setAdapter(new WeatherAdapter(getApplicationContext(), weatherList));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "on failure: " + throwable.getMessage());
                    }
                });

    }
}
