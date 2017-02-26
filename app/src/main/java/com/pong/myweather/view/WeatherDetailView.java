package com.pong.myweather.view;

import com.pong.myweather.model.WeatherModel;

/**
 * Created by USER on 26/2/2560.
 */

public interface WeatherDetailView {
    void onUpdateWeatherData(WeatherModel model);
    void onFailedToUpdateWeatherData();
}
