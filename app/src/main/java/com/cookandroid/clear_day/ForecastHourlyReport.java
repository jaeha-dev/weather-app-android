package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastHourlyReport {
    @SerializedName("weather") @Expose public Weather weather;
    @SerializedName("common") @Expose public Common common;
    @SerializedName("result") @Expose public Result result;

    public Weather getWeather() { return weather; }
    public Common getCommon() { return common; }
    public Result getResult() { return result; }

    public class Weather {
        @SerializedName("hourly") @Expose public List<Hourly> hourly = null;

        public List<Hourly> getHourly() { return hourly; }

        public class Hourly {
            @SerializedName("grid") @Expose public Grid grid;
            @SerializedName("precipitation") @Expose public Precipitation precipitation;
            @SerializedName("sky") @Expose public Sky sky;
            @SerializedName("temperature") @Expose public Temperature temperature;
            @SerializedName("humidity") @Expose public String humidity;
            @SerializedName("lightning") @Expose public String lightning;
            @SerializedName("wind") @Expose public Wind wind;
            @SerializedName("timeRelease") @Expose public String timeRelease;

            public Grid getGrid() { return grid; }
            public Precipitation getPrecipitation() { return precipitation; }
            public Sky getSky() { return sky; }
            public Temperature getTemperature() { return temperature; }
            public String getHumidity() { return humidity; }
            public String getLightning() { return lightning; }
            public Wind getWind() { return wind; }
            public String getTimeRelease() { return timeRelease; }

            public class Grid {
                @SerializedName("latitude") @Expose public String latitude;
                @SerializedName("longitude") @Expose public String longitude;
                @SerializedName("city") @Expose public String city;
                @SerializedName("county") @Expose public String county;
                @SerializedName("village") @Expose public String village;

                public String getLatitude() { return latitude; }
                public String getLongitude() { return longitude; }
                public String getCity() { return city; }
                public String getCounty() { return county; }
                public String getVillage() { return village; }
            }

            public class Precipitation {
                @SerializedName("sinceOntime") @Expose public String sinceOntime;
                @SerializedName("type") @Expose public String type;

                public String getSinceOntime() { return sinceOntime; }
                public String getType() { return type; }
            }

            public class Sky {
                @SerializedName("code") @Expose public String code;
                @SerializedName("name") @Expose public String name;

                public String getCode() { return code; }
                public String getName() { return name; }
            }

            public class Temperature {
                @SerializedName("tc") @Expose public String tc;
                @SerializedName("tmax") @Expose public String tmax;
                @SerializedName("tmin") @Expose public String tmin;

                public String getTc() { return tc; }
                public String getTmax() { return tmax; }
                public String getTmin() { return tmin; }
            }

            public class Wind {
                @SerializedName("wdir") @Expose public String wdir;
                @SerializedName("wspd") @Expose public String wspd;

                public String getWdir() { return wdir; }
                public String getWspd() { return wspd; }
            }
        }
    }

    public class Common {
        @SerializedName("alertYn") @Expose public String alertYn;
        @SerializedName("stormYn") @Expose public String stormYn;

        public String getAlertYn() { return alertYn; }
        public String getStormYn() { return stormYn; }
    }

    public class Result {
        @SerializedName("code") @Expose public int code;
        @SerializedName("requestUrl") @Expose public String requestUrl;
        @SerializedName("message") @Expose public String message;

        public int getCode() { return code; }
        public String getRequestUrl() { return requestUrl; }
        public String getMessage() { return message; }
    }
}
