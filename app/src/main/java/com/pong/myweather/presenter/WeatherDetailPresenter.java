package com.pong.myweather.presenter;

import android.content.Context;

import com.pong.myweather.model.WeatherModel;
import com.pong.myweather.service.WeatherService;
import com.pong.myweather.service.callback.OnLoadedWeatherCallback;
import com.pong.myweather.view.WeatherDetailView;

/**
 * Created by USER on 26/2/2560.
 */

public class WeatherDetailPresenter {
    private WeatherDetailView view;

    public WeatherDetailPresenter(WeatherDetailView view) {
        this.view = view;
    }

    public void refreshWeatherData(Context context, String cityName) {
        WeatherService.loadWeatherData(context, cityName, new OnLoadedWeatherCallback() {
            @Override
            public void onSuccess(WeatherModel model) {
                view.onUpdateWeatherData(model);
            }

            @Override
            public void onFailed(String message) {
                view.onFailedToUpdateWeatherData();
            }
        });
    }
}
