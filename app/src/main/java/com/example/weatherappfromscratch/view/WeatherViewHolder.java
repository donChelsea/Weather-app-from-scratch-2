package com.example.weatherappfromscratch.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.weatherappfromscratch.R;
import com.example.weatherappfromscratch.model.Weather;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WeatherViewHolder extends RecyclerView.ViewHolder {
    TextView dateTv, maxTempTv, minTempTv;
    ImageView weatherIconIv;
    List<Integer> weatherIconsList;
    Switch aSwitch;


    public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);

        dateTv = itemView.findViewById(R.id.date_tv);
        maxTempTv = itemView.findViewById(R.id.max_temp_tv);
        minTempTv = itemView.findViewById(R.id.min_temp_tv);
        weatherIconIv = itemView.findViewById(R.id.weather_iv);
        aSwitch = itemView.findViewById(R.id.switch1);
        aSwitch.setChecked(false);

    }

    public void onBind(final Weather weather) throws ParseException {
        dateTv.setText(weather.getDateTimeISO());


        weatherIconsList = new ArrayList<>(Arrays.asList(R.drawable.rain, R.drawable.snow, R.drawable.sunny, R.drawable.tstorm, R.drawable.wind, R.drawable.wintrymix));
        Random rand = new Random();
        Picasso.get().load(weatherIconsList.get(rand.nextInt(weatherIconsList.size()))).into(weatherIconIv);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()) {
                    maxTempTv.setText(String.format("Max temp: %s C", weather.getMaxTempC()));
                    minTempTv.setText(String.format("Max temp: %s C", weather.getMinTempC()));
                } else {
                    maxTempTv.setText(String.format("Max temp: %s F", weather.getMaxTempF()));
                    minTempTv.setText(String.format("Min temp: %s F", weather.getMinTempF()));
                }
            }
        });

    }
}
