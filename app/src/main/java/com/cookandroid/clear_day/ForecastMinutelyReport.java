package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastMinutelyReport {
    @SerializedName("weather") @Expose private Weather weather;
    @SerializedName("common") @Expose private Common common;
    @SerializedName("result") @Expose private Result result;

    public Weather getWeather() { return weather; }
    public Common getCommon() { return common; }
    public Result getResult() { return result; }

    public class Weather {
        @SerializedName("minutely") @Expose private List<Minutely> minutely = null;

        public List<Minutely> getMinutely() { return minutely; }

        public class Minutely {
            @SerializedName("precipitation") @Expose private Precipitation precipitation;
            @SerializedName("sky") @Expose private Sky sky;
            @SerializedName("rain") @Expose private Rain rain;
            @SerializedName("temperature") @Expose private Temperature temperature;
            @SerializedName("humidity") @Expose private String humidity;
            @SerializedName("pressure") @Expose private Pressure pressure;
            @SerializedName("lightning") @Expose private String lightning;
            @SerializedName("timeObservation") @Expose private String timeObservation;
            @SerializedName("station") @Expose private Station station;
            @SerializedName("wind") @Expose private Wind wind;

            public Precipitation getPrecipitation() { return precipitation; }
            public Sky getSky() { return sky; }
            public Rain getRain() { return rain; }
            public Temperature getTemperature() { return temperature; }
            public String getHumidity() { return humidity; }
            public Pressure getPressure() { return pressure; }
            public String getLightning() { return lightning; }
            public String getTimeObservation() { return timeObservation; }
            public Station getStation() { return station; }
            public Wind getWind() { return wind; }

            public class Precipitation {
                @SerializedName("sinceOntime") @Expose private String sinceOntime;
                @SerializedName("type") @Expose private String type;

                public String getSinceOntime() { return sinceOntime; }
                public String getType() { return type; }
            }
            public class Sky {
                @SerializedName("code") @Expose private String code;
                @SerializedName("name") @Expose private String name;

                public String getCode() { return code; }
                public String getName() { return name; }
            }
            public class Rain {
                @SerializedName("sinceOntime") @Expose private String sinceOntime;
                @SerializedName("last30min") @Expose private String last30min;
                @SerializedName("last1hour") @Expose private String last1hour;
                @SerializedName("last6hour") @Expose private String last6hour;
                @SerializedName("last12hour") @Expose private String last12hour;
                @SerializedName("last24hour") @Expose private String last24hour;
                @SerializedName("sinceMidnight") @Expose private String sinceMidnight;
                @SerializedName("last10min") @Expose private String last10min;
                @SerializedName("last15min") @Expose private String last15min;

                public String getSinceOntime() { return sinceOntime; }
                public String getLast30min() { return last30min; }
                public String getLast1hour() { return last1hour; }
                public String getLast6hour() { return last6hour; }
                public String getLast12hour() { return last12hour; }
                public String getLast24hour() { return last24hour; }
                public String getSinceMidnight() { return sinceMidnight; }
                public String getLast10min() { return last10min; }
                public String getLast15min() { return last15min; }
            }
            public class Temperature {
                @SerializedName("tc") @Expose private String tc;
                @SerializedName("tmax") @Expose private String tmax;
                @SerializedName("tmin") @Expose private String tmin;

                public String getTc() { return tc; }
                public String getTmax() { return tmax; }
                public String getTmin() { return tmin; }
            }
            public class Pressure {
                @SerializedName("surface") @Expose private String surface;
                @SerializedName("seaLevel") @Expose private String seaLevel;

                public String getSurface() { return surface; }
                public String getSeaLevel() { return seaLevel; }
            }
            public class Station {
                @SerializedName("latitude") @Expose private String latitude;
                @SerializedName("longitude") @Expose private String longitude;
                @SerializedName("name") @Expose private String name;
                @SerializedName("id") @Expose private String id;
                @SerializedName("type") @Expose private String type;

                public String getLatitude() { return latitude; }
                public String getLongitude() { return longitude; }
                public String getName() { return name; }
                public String getId() { return id; }
                public String getType() { return type; }
            }
            public class Wind {
                @SerializedName("wdir") @Expose private String wdir;
                @SerializedName("wspd") @Expose private String wspd;

                public String getWdir() { return wdir; }
                public String getWspd() { return wspd; }
            }
        }
    }

    public class Common {
        @SerializedName("alertYn") @Expose private String alertYn;
        @SerializedName("stormYn") @Expose private String stormYn;

        public String getAlertYn() { return alertYn; }
        public String getStormYn() { return stormYn; }
    }
    public class Result {
        @SerializedName("code") @Expose private Integer code;
        @SerializedName("requestUrl") @Expose private String requestUrl;
        @SerializedName("message") @Expose private String message;

        public Integer getCode() { return code; }
        public String getRequestUrl() { return requestUrl; }
        public String getMessage() { return message; }
    }
}