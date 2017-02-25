package com.pong.myweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pong.myweather.R;
import com.pong.myweather.model.WeatherModel;

import org.parceler.Parcels;

/**
 * Created by USER on 25/2/2560.
 */

public class WeatherDetailFragment extends Fragment {
    WeatherModel model;

    public static WeatherDetailFragment newInstance(WeatherModel model) {
        WeatherDetailFragment fm = new WeatherDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("model", Parcels.wrap(model));
        fm.setArguments(args);
        return fm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = Parcels.unwrap(getArguments().getParcelable("model"));
//        Log.d("myApp",model.toString());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weatherdetail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textCityName = (TextView) view.findViewById(R.id.text_weatherdetail_cityname);
        TextView textTime = (TextView) view.findViewById(R.id.text_weatherdetail_time);
        TextView textHumility = (TextView) view.findViewById(R.id.text_weatherdetail_humidity);
        TextView textWeatherDescription = (TextView) view.findViewById(R.id.text_weatherdetail_weatherdescription);

        textCityName.setText(model.getCityName());
        textTime.setText(model.getTime());
        textHumility.setText("Humidity "+model.getHumidity());
        textWeatherDescription.setText(model.getWeatherDescription());
    }
}
