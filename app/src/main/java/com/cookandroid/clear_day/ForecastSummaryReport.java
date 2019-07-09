
package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastSummaryReport {
    @SerializedName("weather") @Expose public Weather weather;
    @SerializedName("common") @Expose public Common common;
    @SerializedName("result") @Expose public Result result;

    public Weather getWeather() { return weather; }
    public Common getCommon() { return common; }
    public Result getResult() { return result; }

    public class Weather {
        @SerializedName("summary") @Expose public List<Summary> summary = null;

        public List<Summary> getSummary() { return summary; }

        public class Summary {
            @SerializedName("grid") @Expose public Grid grid;
            @SerializedName("timeRelease") @Expose public String timeRelease;
            @SerializedName("yesterday") @Expose public Yesterday yesterday;
            @SerializedName("today") @Expose public Today today;
            @SerializedName("tomorrow") @Expose public Tomorrow tomorrow;
            @SerializedName("dayAfterTomorrow") @Expose public DayAfterTomorrow dayAfterTomorrow;

            public Grid getGrid() { return grid; }
            public String getTimeRelease() { return timeRelease; }
            public Yesterday getYesterday() { return yesterday; }
            public Today getToday() { return today; }
            public Tomorrow getTomorrow() { return tomorrow; }
            public DayAfterTomorrow getDayAfterTomorrow() { return dayAfterTomorrow; }

            public class Grid {
                @SerializedName("longitude") @Expose public String longitude;
                @SerializedName("latitude") @Expose public String latitude;
                @SerializedName("city") @Expose public String city;
                @SerializedName("county") @Expose public String county;
                @SerializedName("village") @Expose public String village;

                public String getLongitude() { return longitude; }
                public String getLatitude() { return latitude; }
                public String getCity() { return city; }
                public String getCounty() { return county; }
                public String getVillage() { return village; }
            }

            public class Yesterday {
                @SerializedName("precipitation") @Expose public Precipitation precipitation;
                @SerializedName("sky") @Expose public Sky sky;
                @SerializedName("temperature") @Expose public Temperature temperature;

                public Precipitation getPrecipitation() { return precipitation; }
                public Sky getSky() { return sky; }
                public Temperature getTemperature() { return temperature; }

                public class Precipitation {
                    @SerializedName("rain") @Expose public String rain;
                    @SerializedName("snow") @Expose public String snow;

                    public String getRain() { return rain; }
                    public String getSnow() { return snow; }
                }
                public class Sky {
                    @SerializedName("code") @Expose public String code;
                    @SerializedName("name") @Expose public String name;

                    public String getCode() { return code; }
                    public String getName() { return name; }
                }
                public class Temperature {
                    @SerializedName("tmax") @Expose public String tmax;
                    @SerializedName("tmin") @Expose public String tmin;

                    public String getTmax() { return tmax; }
                    public String getTmin() { return tmin; }
                }
            }

            public class Today {
                @SerializedName("sky") @Expose public Sky_ sky;
                @SerializedName("temperature") @Expose public Temperature_ temperature;

                public Sky_ getSky() { return sky; }
                public Temperature_ getTemperature() { return temperature; }

                public class Sky_ {
                    @SerializedName("code") @Expose public String code;
                    @SerializedName("name") @Expose public String name;

                    public String getCode() { return code; }
                    public String getName() { return name; }
                }
                public class Temperature_ {
                    @SerializedName("tmax") @Expose public String tmax;
                    @SerializedName("tmin") @Expose public String tmin;

                    public String getTmax() { return tmax; }
                    public String getTmin() { return tmin; }
                }
            }

            public class Tomorrow {
                @SerializedName("sky") @Expose public Sky__ sky;
                @SerializedName("temperature") @Expose public Temperature__ temperature;

                public Sky__ getSky() { return sky; }
                public Temperature__ getTemperature() { return temperature; }

                public class Sky__ {
                    @SerializedName("code") @Expose public String code;
                    @SerializedName("name") @Expose public String name;

                    public String getCode() { return code; }
                    public String getName() { return name; }
                }
                public class Temperature__ {
                    @SerializedName("tmax") @Expose public String tmax;
                    @SerializedName("tmin") @Expose public String tmin;

                    public String getTmax() { return tmax; }
                    public String getTmin() { return tmin; }
                }
            }

            public class DayAfterTomorrow {
                @SerializedName("sky") @Expose public Sky___ sky;
                @SerializedName("temperature") @Expose public Temperature___ temperature;

                public Sky___ getSky() { return sky; }
                public Temperature___ getTemperature() { return temperature; }

                public class Sky___ {
                    @SerializedName("code") @Expose public String code;
                    @SerializedName("name") @Expose public String name;

                    public String getCode() { return code; }
                    public String getName() { return name; }
                }
                public class Temperature___ {
                    @SerializedName("tmax") @Expose public String tmax;
                    @SerializedName("tmin") @Expose public String tmin;

                    public String getTmax() { return tmax; }
                    public String getTmin() { return tmin; }
                }
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
        @SerializedName("code") @Expose public Integer code;
        @SerializedName("requestUrl") @Expose public String requestUrl;
        @SerializedName("message") @Expose public String message;

        public Integer getCode() { return code; }
        public String getRequestUrl() { return requestUrl; }
        public String getMessage() { return message; }
    }

}
