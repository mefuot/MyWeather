package com.pong.myweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pong.myweather.R;
import com.pong.myweather.model.WeatherModel;
import com.pong.myweather.utils.Utils;

import org.parceler.Parcels;

import static android.text.method.TextKeyListener.Capitalize.WORDS;

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weatherdetail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setWeatherDataToDisplay(view,model);
    }

    private void setWeatherDataToDisplay(final View view,final WeatherModel model){

        ((TextView) view.findViewById(R.id.text_weatherdetail_cityname))
                .setText(Utils.capitalize(model.getCityName()));
        ((TextView) view.findViewById(R.id.text_weatherdetail_time))
                .setText(model.getTime());
        ((TextView) view.findViewById(R.id.text_weatherdetail_humidity))
                .setText("Humidity "+model.getHumidity());
        ((TextView) view.findViewById(R.id.text_weatherdetail_weatherdescription))
                .setText(model.getWeatherDescription());

        Glide.with(getContext())
                .load(model.getIconUrl())
                .fitCenter()
                .error(android.R.drawable.ic_dialog_alert)
                .into(((ImageView) view.findViewById(R.id.img_weatherdetail_weathericon)));
    }
}
