package com.pong.myweather.model;

import org.parceler.Parcel;

/**
 * Created by USER on 25/2/2560.
 */

@Parcel
public class WeatherModel {
    String cityName;
    String iconUrl;
    String time;
    String humidity;
    String weatherDescription;

    public WeatherModel() {
    }

    /**
     * WeatherModel
     *
     * @param cityName Name of city.
     * @param iconUrl Url of icon showing current weather.
     * @param time Observation Time.
     * @param humidity Humidity value.
     * @param weatherDescription Weather description.
     */
    public WeatherModel(String cityName, String iconUrl, String time, String humidity, String weatherDescription) {
        this.cityName = cityName;
        this.iconUrl = iconUrl;
        this.time = time;
        this.humidity = humidity;
        this.weatherDescription = weatherDescription;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "cityName='" + cityName + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", time='" + time + '\'' +
                ", humidity='" + humidity + '\'' +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
    }
}
