package com.pong.myweather.view;

import com.pong.myweather.model.WeatherModel;

/**
 * Created by USER on 25/2/2560.
 */

public interface SearchView {
    void onSuccessLoadWeatherData(final WeatherModel model);
    void onFailedLoadWeatherData(String message);
}
