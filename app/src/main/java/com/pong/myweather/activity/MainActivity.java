package com.pong.myweather.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pong.myweather.R;
import com.pong.myweather.fragment.SearchFragment;
import com.pong.myweather.fragment.WeatherDetailFragment;
import com.pong.myweather.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnSearchWeatherListener {
    SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            openSearchFragment();
        }
    }

    private void openSearchFragment() {
        searchFragment = new SearchFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, searchFragment);
        ft.commit();
    }

    @Override
    public void onOpenWeatherDetail(WeatherModel model) {
        openWeatherDetailFragment(model);
    }

    private void openWeatherDetailFragment(WeatherModel model) {
        WeatherDetailFragment weatherDetailFragment = WeatherDetailFragment.newInstance(model);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, weatherDetailFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
