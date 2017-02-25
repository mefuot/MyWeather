package com.pong.myweather;

import com.pong.myweather.model.WeatherModel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by USER on 25/2/2560.
 */

public class WeatherModelTest {
    private static final String CITY_NAME = "Bangkok";
    private static final String TIME = "08:55 PM";
    private static final String ICON_URL = "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0002_sunny_intervals.png";
    private static final String HUMIDITY = "55";
    private static final String DESCRIPTION = "Partly cloudy";

    @Test
    public void shouldNotNullWithBlankConstructor(){
        WeatherModel model = new WeatherModel();
        assertNotNull(model);
    }

    @Test
    public void shouldNotNullWithArgument(){
        WeatherModel model = new WeatherModel(CITY_NAME, ICON_URL,TIME, HUMIDITY,DESCRIPTION);
        assertNotNull(model);
    }

    @Test
    public void shouldShowCorrectSetData(){
        WeatherModel model = new WeatherModel();
        model.setCityName(CITY_NAME);
        model.setIconUrl(ICON_URL);
        model.setTime(TIME);
        model.setHumidity(HUMIDITY);
        model.setWeatherDescription(DESCRIPTION);

        assertEquals(model.getCityName(),CITY_NAME);
        assertEquals(model.getIconUrl(), ICON_URL);
        assertEquals(model.getTime(),TIME);
        assertEquals(model.getHumidity(), HUMIDITY);
        assertEquals(model.getWeatherDescription(),DESCRIPTION);
    }

    @Test
    public void shouldShowCorrectInitData(){
        WeatherModel model = new WeatherModel(CITY_NAME, ICON_URL,TIME, HUMIDITY,DESCRIPTION);

        assertEquals(model.getCityName(),CITY_NAME);
        assertEquals(model.getIconUrl(), ICON_URL);
        assertEquals(model.getTime(),TIME);
        assertEquals(model.getHumidity(), HUMIDITY);
        assertEquals(model.getWeatherDescription(),DESCRIPTION);
    }
}
