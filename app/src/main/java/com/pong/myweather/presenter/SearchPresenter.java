package com.pong.myweather.presenter;

import android.content.Context;

import com.pong.myweather.model.WeatherModel;
import com.pong.myweather.service.WeatherService;
import com.pong.myweather.service.callback.OnLoadedWeatherCallback;
import com.pong.myweather.view.SearchView;

/**
 * Created by USER on 25/2/2560.
 */

public class SearchPresenter {

    private SearchView view;

    public SearchPresenter(SearchView view) {
        this.view = view;
    }

    public void loadWeatherData(Context context, String cityName) {
        WeatherService.loadWeatherData(context, cityName, new OnLoadedWeatherCallback() {
            @Override
            public void onSuccess(WeatherModel model) {
                view.onSuccessLoadWeatherData(model);
            }

            @Override
            public void onFailed(String message) {
                view.onFailedLoadWeatherData(message);
            }
        });
    }
}
