package com.pong.myweather.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pong.myweather.R;
import com.pong.myweather.model.WeatherModel;

/**
 * Created by USER on 25/2/2560.
 */

public class SearchFragment extends Fragment {
    public interface OnSearchWeatherListener{
        void onOpenWeatherDetail(WeatherModel model);
    }

    private EditText searchEditText;
    private Button searchButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchEditText = (EditText) view.findViewById(R.id.edittext_search);
        searchButton = (Button) view.findViewById(R.id.button_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherModel model = new WeatherModel();
                model.setCityName("Bangkok");
                model.setHumidity("44");
                model.setIconUrl("http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0002_sunny_intervals.png");
                model.setTime("08:47 AM");
                model.setWeatherDescription("Partly cloudy");
                ((OnSearchWeatherListener) getActivity()).onOpenWeatherDetail(model);
            }
        });
    }
}
