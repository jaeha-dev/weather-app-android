package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast3HoursReport {
    @SerializedName("weather") @Expose private Weather weather;
    @SerializedName("common") @Expose private Common common;
    @SerializedName("result") @Expose private Result result;

    public Weather getWeather() { return weather; }
    public Common getCommon() { return common; }
    public Result getResult() { return result; }

    public class Weather {
        @SerializedName("forecast3hours") @Expose private List<Forecast3hour> forecast3hours = null;

        public List<Forecast3hour> getForecast3hours() { return forecast3hours; }

        public class Forecast3hour {
            @SerializedName("grid") @Expose private Grid grid;
            @SerializedName("lightning1hour") @Expose private String lightning1hour;
            @SerializedName("lightning2hour") @Expose private String lightning2hour;
            @SerializedName("lightning3hour") @Expose private String lightning3hour;
            @SerializedName("lightning4hour") @Expose private String lightning4hour;
            @SerializedName("wind") @Expose private Wind wind;
            @SerializedName("precipitation") @Expose private Precipitation precipitation;
            @SerializedName("sky") @Expose private Sky sky;
            @SerializedName("temperature") @Expose private Temperature temperature;
            @SerializedName("humidity") @Expose private Humidity humidity;
            @SerializedName("timeRelease") @Expose private String timeRelease;

            public Grid getGrid() { return grid; }
            public String getLightning1hour() { return lightning1hour; }
            public String getLightning2hour() { return lightning2hour; }
            public String getLightning3hour() { return lightning3hour; }
            public String getLightning4hour() { return lightning4hour; }
            public Wind getWind() { return wind; }
            public Precipitation getPrecipitation() { return precipitation; }
            public Sky getSky() { return sky; }
            public Temperature getTemperature() { return temperature; }
            public Humidity getHumidity() { return humidity; }
            public String getTimeRelease() { return timeRelease; }

            public class Grid {
                @SerializedName("city") @Expose private String city;
                @SerializedName("county") @Expose private String county;
                @SerializedName("village") @Expose private String village;
                @SerializedName("longitude") @Expose private String longitude;
                @SerializedName("latitude") @Expose private String latitude;

                public String getCity() { return city; }
                public String getCounty() { return county; }
                public String getVillage() { return village; }
                public String getLongitude() { return longitude; }
                public String getLatitude() { return latitude; }
            }

            public class Wind {
                @SerializedName("wdir3hour") @Expose private String wdir3hour;
                @SerializedName("wdir1hour") @Expose private String wdir1hour;
                @SerializedName("wspd1hour") @Expose private String wspd1hour;
                @SerializedName("wdir2hour") @Expose private String wdir2hour;
                @SerializedName("wspd2hour") @Expose private String wspd2hour;
                @SerializedName("wspd3hour") @Expose private String wspd3hour;
                @SerializedName("wdir4hour") @Expose private String wdir4hour;
                @SerializedName("wspd4hour") @Expose private String wspd4hour;

                public String getWdir3hour() { return wdir3hour; }
                public String getWdir1hour() { return wdir1hour; }
                public String getWspd1hour() { return wspd1hour; }
                public String getWdir2hour() { return wdir2hour; }
                public String getWspd2hour() { return wspd2hour; }
                public String getWspd3hour() { return wspd3hour; }
                public String getWdir4hour() { return wdir4hour; }
                public String getWspd4hour() { return wspd4hour; }
            }

            public class Precipitation {
                @SerializedName("sinceOntime4hour") @Expose private String sinceOntime4hour;
                @SerializedName("type4hour") @Expose private String type4hour;
                @SerializedName("sinceOntime1hour") @Expose private String sinceOntime1hour;
                @SerializedName("type1hour") @Expose private String type1hour;
                @SerializedName("sinceOntime2hour") @Expose private String sinceOntime2hour;
                @SerializedName("type2hour") @Expose private String type2hour;
                @SerializedName("sinceOntime3hour") @Expose private String sinceOntime3hour;
                @SerializedName("type3hour") @Expose private String type3hour;

                public String getSinceOntime4hour() { return sinceOntime4hour; }
                public String getType4hour() { return type4hour; }
                public String getSinceOntime1hour() { return sinceOntime1hour; }
                public String getType1hour() { return type1hour; }
                public String getSinceOntime2hour() { return sinceOntime2hour; }
                public String getType2hour() { return type2hour; }
                public String getSinceOntime3hour() { return sinceOntime3hour; }
                public String getType3hour() { return type3hour; }
            }

            public class Sky {
                @SerializedName("code1hour") @Expose private String code1hour;
                @SerializedName("name1hour") @Expose private String name1hour;
                @SerializedName("code2hour") @Expose private String code2hour;
                @SerializedName("name2hour") @Expose private String name2hour;
                @SerializedName("code3hour") @Expose private String code3hour;
                @SerializedName("name3hour") @Expose private String name3hour;
                @SerializedName("code4hour") @Expose private String code4hour;
                @SerializedName("name4hour") @Expose private String name4hour;

                public String getCode1hour() { return code1hour; }
                public String getName1hour() { return name1hour; }
                public String getCode2hour() { return code2hour; }
                public String getName2hour() { return name2hour; }
                public String getCode3hour() { return code3hour; }
                public String getName3hour() { return name3hour; }
                public String getCode4hour() { return code4hour; }
                public String getName4hour() { return name4hour; }
            }

            public class Temperature {
                @SerializedName("temp3hour") @Expose private String temp3hour;
                @SerializedName("temp1hour") @Expose private String temp1hour;
                @SerializedName("temp2hour") @Expose private String temp2hour;
                @SerializedName("temp4hour") @Expose private String temp4hour;

                public String getTemp3hour() { return temp3hour; }
                public String getTemp1hour() { return temp1hour; }
                public String getTemp2hour() { return temp2hour; }
                public String getTemp4hour() { return temp4hour; }
            }

            public class Humidity {
                @SerializedName("rh1hour") @Expose private String rh1hour;
                @SerializedName("rh2hour") @Expose private String rh2hour;
                @SerializedName("rh3hour") @Expose private String rh3hour;
                @SerializedName("rh4hour") @Expose private String rh4hour;

                public String getRh1hour() { return rh1hour; }
                public String getRh2hour() { return rh2hour; }
                public String getRh3hour() { return rh3hour; }
                public String getRh4hour() { return rh4hour; }
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
        @SerializedName("code") @Expose private int code;
        @SerializedName("requestUrl") @Expose private String requestUrl;
        @SerializedName("message") @Expose private String message;

        public Integer getCode() { return code; }
        public String getRequestUrl() { return requestUrl; }
        public String getMessage() { return message; }
    }
}

