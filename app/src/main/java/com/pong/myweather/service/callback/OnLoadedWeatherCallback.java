package com.pong.myweather.service.callback;

import com.pong.myweather.model.WeatherModel;

/**
 * Created by USER on 25/2/2560.
 */

public interface OnLoadedWeatherCallback {
    void onSuccess(WeatherModel model);
    void onFailed(String message);
}
