package com.pong.myweather.service.model;

import java.util.List;

/**
 * Created by USER on 25/2/2560.
 */

public class WeatherResponseModel {

    /**
     * data : {"request":[{"type":"City","query":"Bangkok"}],"current_condition":[{"observation_time":"08:47 AM","temp_C":"35","temp_F":"95","weatherCode":"116","weatherIconUrl":[{"value":"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0002_sunny_intervals.png"}],"weatherDesc":[{"value":"Partly cloudy"}],"windspeedMiles":"9","windspeedKmph":"15","winddirDegree":"210","winddir16Point":"SSW","precipMM":"2.7","humidity":"53","visibility":"10","pressure":"1008","cloudcover":"50"}],"weather":[{"date":"2017-02-25","tempMaxC":"36","tempMaxF":"97","tempMinC":"27","tempMinF":"80","windspeedMiles":"7","windspeedKmph":"12","winddirection":"SE","winddir16Point":"SE","winddirDegree":"136","weatherCode":"353","weatherIconUrl":[{"value":"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png"}],"weatherDesc":[{"value":"Light rain shower"}],"precipMM":"0.3"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherResponseModel{" +
                "data=" + data +
                '}';
    }

    public static class DataBean {
        private List<RequestBean> request;
        private List<CurrentConditionBean> current_condition;
        private List<WeatherBean> weather;
        private List<ErrorBean> error;

        public List<RequestBean> getRequest() {
            return request;
        }

        public void setRequest(List<RequestBean> request) {
            this.request = request;
        }

        public List<CurrentConditionBean> getCurrentCondition() {
            return current_condition;
        }

        public void setCurrent_condition(List<CurrentConditionBean> current_condition) {
            this.current_condition = current_condition;
        }

        public List<WeatherBean> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherBean> weather) {
            this.weather = weather;
        }

        public List<ErrorBean> getError() {
            return error;
        }

        public void setError(List<ErrorBean> error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "request=" + request +
                    ", current_condition=" + current_condition +
                    ", weather=" + weather +
                    ", error=" + error +
                    '}';
        }

        public static class RequestBean {
            /**
             * type : City
             * query : Bangkok
             */

            private String type;
            private String query;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }

            @Override
            public String toString() {
                return "RequestBean{" +
                        "type='" + type + '\'' +
                        ", query='" + query + '\'' +
                        '}';
            }
        }

        public static class CurrentConditionBean {
            /**
             * observation_time : 08:47 AM
             * temp_C : 35
             * temp_F : 95
             * weatherCode : 116
             * weatherIconUrl : [{"value":"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0002_sunny_intervals.png"}]
             * weatherDesc : [{"value":"Partly cloudy"}]
             * windspeedMiles : 9
             * windspeedKmph : 15
             * winddirDegree : 210
             * winddir16Point : SSW
             * precipMM : 2.7
             * humidity : 53
             * visibility : 10
             * pressure : 1008
             * cloudcover : 50
             */

            private String observation_time;
            private String temp_C;
            private String temp_F;
            private String weatherCode;
            private String windspeedMiles;
            private String windspeedKmph;
            private String winddirDegree;
            private String winddir16Point;
            private String precipMM;
            private String humidity;
            private String visibility;
            private String pressure;
            private String cloudcover;
            private List<WeatherIconUrlBean> weatherIconUrl;
            private List<WeatherDescBean> weatherDesc;

            public String getObservation_time() {
                return observation_time;
            }

            public void setObservation_time(String observation_time) {
                this.observation_time = observation_time;
            }

            public String getTemp_C() {
                return temp_C;
            }

            public void setTemp_C(String temp_C) {
                this.temp_C = temp_C;
            }

            public String getTemp_F() {
                return temp_F;
            }

            public void setTemp_F(String temp_F) {
                this.temp_F = temp_F;
            }

            public String getWeatherCode() {
                return weatherCode;
            }

            public void setWeatherCode(String weatherCode) {
                this.weatherCode = weatherCode;
            }

            public String getWindspeedMiles() {
                return windspeedMiles;
            }

            public void setWindspeedMiles(String windspeedMiles) {
                this.windspeedMiles = windspeedMiles;
            }

            public String getWindspeedKmph() {
                return windspeedKmph;
            }

            public void setWindspeedKmph(String windspeedKmph) {
                this.windspeedKmph = windspeedKmph;
            }

            public String getWinddirDegree() {
                return winddirDegree;
            }

            public void setWinddirDegree(String winddirDegree) {
                this.winddirDegree = winddirDegree;
            }

            public String getWinddir16Point() {
                return winddir16Point;
            }

            public void setWinddir16Point(String winddir16Point) {
                this.winddir16Point = winddir16Point;
            }

            public String getPrecipMM() {
                return precipMM;
            }

            public void setPrecipMM(String precipMM) {
                this.precipMM = precipMM;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getVisibility() {
                return visibility;
            }

            public void setVisibility(String visibility) {
                this.visibility = visibility;
            }

            public String getPressure() {
                return pressure;
            }

            public void setPressure(String pressure) {
                this.pressure = pressure;
            }

            public String getCloudcover() {
                return cloudcover;
            }

            public void setCloudcover(String cloudcover) {
                this.cloudcover = cloudcover;
            }

            public List<WeatherIconUrlBean> getWeatherIconUrl() {
                return weatherIconUrl;
            }

            public void setWeatherIconUrl(List<WeatherIconUrlBean> weatherIconUrl) {
                this.weatherIconUrl = weatherIconUrl;
            }

            public List<WeatherDescBean> getWeatherDesc() {
                return weatherDesc;
            }

            public void setWeatherDesc(List<WeatherDescBean> weatherDesc) {
                this.weatherDesc = weatherDesc;
            }

            @Override
            public String toString() {
                return "CurrentConditionBean{" +
                        "observation_time='" + observation_time + '\'' +
                        ", temp_C='" + temp_C + '\'' +
                        ", temp_F='" + temp_F + '\'' +
                        ", weatherCode='" + weatherCode + '\'' +
                        ", windspeedMiles='" + windspeedMiles + '\'' +
                        ", windspeedKmph='" + windspeedKmph + '\'' +
                        ", winddirDegree='" + winddirDegree + '\'' +
                        ", winddir16Point='" + winddir16Point + '\'' +
                        ", precipMM='" + precipMM + '\'' +
                        ", humidity='" + humidity + '\'' +
                        ", visibility='" + visibility + '\'' +
                        ", pressure='" + pressure + '\'' +
                        ", cloudcover='" + cloudcover + '\'' +
                        ", weatherIconUrl=" + weatherIconUrl +
                        ", weatherDesc=" + weatherDesc +
                        '}';
            }

            public static class WeatherIconUrlBean {
                /**
                 * value : http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0002_sunny_intervals.png
                 */

                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class WeatherDescBean {
                /**
                 * value : Partly cloudy
                 */

                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }

        public static class WeatherBean {
            /**
             * date : 2017-02-25
             * tempMaxC : 36
             * tempMaxF : 97
             * tempMinC : 27
             * tempMinF : 80
             * windspeedMiles : 7
             * windspeedKmph : 12
             * winddirection : SE
             * winddir16Point : SE
             * winddirDegree : 136
             * weatherCode : 353
             * weatherIconUrl : [{"value":"http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png"}]
             * weatherDesc : [{"value":"Light rain shower"}]
             * precipMM : 0.3
             */

            private String date;
            private String tempMaxC;
            private String tempMaxF;
            private String tempMinC;
            private String tempMinF;
            private String windspeedMiles;
            private String windspeedKmph;
            private String winddirection;
            private String winddir16Point;
            private String winddirDegree;
            private String weatherCode;
            private String precipMM;
            private List<WeatherIconUrlBeanX> weatherIconUrl;
            private List<WeatherDescBeanX> weatherDesc;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTempMaxC() {
                return tempMaxC;
            }

            public void setTempMaxC(String tempMaxC) {
                this.tempMaxC = tempMaxC;
            }

            public String getTempMaxF() {
                return tempMaxF;
            }

            public void setTempMaxF(String tempMaxF) {
                this.tempMaxF = tempMaxF;
            }

            public String getTempMinC() {
                return tempMinC;
            }

            public void setTempMinC(String tempMinC) {
                this.tempMinC = tempMinC;
            }

            public String getTempMinF() {
                return tempMinF;
            }

            public void setTempMinF(String tempMinF) {
                this.tempMinF = tempMinF;
            }

            public String getWindspeedMiles() {
                return windspeedMiles;
            }

            public void setWindspeedMiles(String windspeedMiles) {
                this.windspeedMiles = windspeedMiles;
            }

            public String getWindspeedKmph() {
                return windspeedKmph;
            }

            public void setWindspeedKmph(String windspeedKmph) {
                this.windspeedKmph = windspeedKmph;
            }

            public String getWinddirection() {
                return winddirection;
            }

            public void setWinddirection(String winddirection) {
                this.winddirection = winddirection;
            }

            public String getWinddir16Point() {
                return winddir16Point;
            }

            public void setWinddir16Point(String winddir16Point) {
                this.winddir16Point = winddir16Point;
            }

            public String getWinddirDegree() {
                return winddirDegree;
            }

            public void setWinddirDegree(String winddirDegree) {
                this.winddirDegree = winddirDegree;
            }

            public String getWeatherCode() {
                return weatherCode;
            }

            public void setWeatherCode(String weatherCode) {
                this.weatherCode = weatherCode;
            }

            public String getPrecipMM() {
                return precipMM;
            }

            public void setPrecipMM(String precipMM) {
                this.precipMM = precipMM;
            }

            public List<WeatherIconUrlBeanX> getWeatherIconUrl() {
                return weatherIconUrl;
            }

            public void setWeatherIconUrl(List<WeatherIconUrlBeanX> weatherIconUrl) {
                this.weatherIconUrl = weatherIconUrl;
            }

            public List<WeatherDescBeanX> getWeatherDesc() {
                return weatherDesc;
            }

            public void setWeatherDesc(List<WeatherDescBeanX> weatherDesc) {
                this.weatherDesc = weatherDesc;
            }

            public static class WeatherIconUrlBeanX {
                /**
                 * value : http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0009_light_rain_showers.png
                 */

                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class WeatherDescBeanX {
                /**
                 * value : Light rain shower
                 */

                private String value;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }

        public static class ErrorBean{
            private String msg;

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            @Override
            public String toString() {
                return "ErrorBean{" +
                        "msg='" + msg + '\'' +
                        '}';
            }

        }
    }
}
