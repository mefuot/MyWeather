package com.pong.myweather.service;

import android.content.Context;
import android.util.Log;

import com.pong.myweather.BuildConfig;
import com.pong.myweather.R;
import com.pong.myweather.constant.Constant;
import com.pong.myweather.model.WeatherModel;
import com.pong.myweather.service.callback.OnLoadedWeatherCallback;
import com.pong.myweather.service.model.WeatherResponseModel;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by USER on 25/2/2560.
 */

public class WeatherService {
    private interface APIService {
        @GET("free/v1/weather.ashx?fx=yes&format=json")
        Call<WeatherResponseModel> getWeatherData(@Query("key") String key, @Query("q") String cityName);
    }

    private static APIService getService() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                okhttp3.Response response = chain.proceed(request);
                String rawJson = response.body().string();

                Log.d(BuildConfig.APPLICATION_ID, String.format("raw JSON response is: %s", rawJson));

                return response.newBuilder()
                        .body(ResponseBody.create(response.body().contentType(), rawJson)).build();
            }
        };

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(APIService.class);
    }

    public static void loadWeatherData(final Context context, final String cityName, final OnLoadedWeatherCallback callback) {
        Call<WeatherResponseModel> call = getService().getWeatherData(Constant.API_KEY, cityName);
        call.enqueue(new Callback<WeatherResponseModel>() {
            @Override
            public void onResponse(Call<WeatherResponseModel> call, Response<WeatherResponseModel> response) {

                if (response.isSuccessful() && response.body().getData().getError() == null) {
//                    Log.d("myApp", response.body().getData().toString());
                    WeatherResponseModel.DataBean data = response.body().getData();
                    WeatherModel model = new WeatherModel(data.getRequest().get(0).getQuery(), // City Name
                            data.getCurrentCondition().get(0).getWeatherIconUrl().get(0).getValue(), // IconUrl
                            data.getCurrentCondition().get(0).getObservation_time(), // Time
                            data.getCurrentCondition().get(0).getHumidity(), // Humidity
                            data.getCurrentCondition().get(0).getWeatherDesc().get(0).getValue()); // Weather Description
                    callback.onSuccess(model);
                } else if (response.body().getData().getError() != null) {
                    callback.onFailed(response.body().getData().getError().get(0).getMsg());
                } else {
                    callback.onFailed(context.getString(R.string.error_connection));
                }
            }

            @Override
            public void onFailure(Call<WeatherResponseModel> call, Throwable t) {
                if (t.getCause() instanceof SocketTimeoutException) {
                    callback.onFailed(context.getString(R.string.error_connection_timeout));
                } else {
                    callback.onFailed(context.getString(R.string.error_connection));
                }
            }
        });
    }
}