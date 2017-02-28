package com.pong.myweather.singleton;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.util.ArraySet;

import com.pong.myweather.utils.Utils;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by USER on 27/2/2560.
 */
public class CityManager {
    private static final String PREF_NAME = "CityNamePreferences";
    private static final String CITIES_KEY = "cities";
    private static final int MAX_SIZE = 10;
    private static CityManager instance;

    private SharedPreferences sp;

    private ArrayList<String> aryCities;

    public static CityManager getInstance(Context context) {
        if(instance == null) instance = new CityManager(context);
        return instance;
    }

    private CityManager(Context context) {
        sp = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> cities = sp.getStringSet(CITIES_KEY, new ArraySet<String>(MAX_SIZE));
        aryCities = new ArrayList<>(cities);
    }

    public ArrayList<String> getAllCityList() {
        return new ArrayList<>(aryCities);
    }

    public void addCityName(@NonNull String cityName) {
        if (!Utils.containsIgnoreCase(aryCities, cityName)) {
            if (aryCities.size() >= MAX_SIZE) {
                aryCities.remove(0);
            }
            aryCities.add(cityName);
            sp.edit().putStringSet(CITIES_KEY, new ArraySet<>(aryCities))
                    .apply();
        }
    }
}
