package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast3DaysReport {
    @SerializedName("weather") @Expose private Weather weather;
    @SerializedName("common") @Expose private Common common;
    @SerializedName("result") @Expose private Result result;

    public Weather getWeather() { return weather; }
    public Common getCommon() { return common; }
    public Result getResult() { return result; }

    public class Weather {
        @SerializedName("forecast3days") @Expose private List<Forecast3day> forecast3days = null;

        public List<Forecast3day> getForecast3days() { return forecast3days; }

        public class Forecast3day {
            @SerializedName("grid") @Expose private Grid grid;
            @SerializedName("fcst3hour") @Expose private Fcst3hour fcst3hour;
            @SerializedName("timeRelease") @Expose private String timeRelease;
            @SerializedName("fcst6hour") @Expose private Fcst6hour fcst6hour;
            @SerializedName("fcstdaily") @Expose private Fcstdaily fcstdaily;

            public Grid getGrid() { return grid; }
            public Fcst3hour getFcst3hour() { return fcst3hour; }
            public String getTimeRelease() { return timeRelease; }
            public Fcst6hour getFcst6hour() { return fcst6hour; }
            public Fcstdaily getFcstdaily() { return fcstdaily; }

            public class Grid {
                @SerializedName("longitude") @Expose private String longitude;
                @SerializedName("latitude") @Expose private String latitude;
                @SerializedName("city") @Expose private String city;
                @SerializedName("county") @Expose private String county;
                @SerializedName("village") @Expose private String village;

                public String getLongitude() { return longitude; }
                public String getLatitude() { return latitude; }
                public String getCity() { return city; }
                public String getCounty() { return county; }
                public String getVillage() { return village; }
            }

            public class Fcst3hour {
                @SerializedName("wind") @Expose private Wind wind;
                @SerializedName("precipitation") @Expose private Precipitation precipitation;
                @SerializedName("sky") @Expose private Sky sky;
                @SerializedName("temperature") @Expose private Temperature temperature;
                @SerializedName("humidity") @Expose private Humidity humidity;

                public Wind getWind() { return wind; }
                public Precipitation getPrecipitation() { return precipitation; }
                public Sky getSky() { return sky; }
                public Temperature getTemperature() { return temperature; }
                public Humidity getHumidity() { return humidity; }

                public class Wind {
                    @SerializedName("wdir4hour") @Expose private String wdir4hour;
                    @SerializedName("wspd4hour") @Expose private String wspd4hour;
                    @SerializedName("wdir7hour") @Expose private String wdir7hour;
                    @SerializedName("wspd7hour") @Expose private String wspd7hour;
                    @SerializedName("wdir10hour") @Expose private String wdir10hour;
                    @SerializedName("wspd10hour") @Expose private String wspd10hour;
                    @SerializedName("wdir13hour") @Expose private String wdir13hour;
                    @SerializedName("wspd13hour") @Expose private String wspd13hour;
                    @SerializedName("wdir16hour") @Expose private String wdir16hour;
                    @SerializedName("wspd16hour") @Expose private String wspd16hour;
                    @SerializedName("wdir19hour") @Expose private String wdir19hour;
                    @SerializedName("wspd19hour") @Expose private String wspd19hour;
                    @SerializedName("wdir22hour") @Expose private String wdir22hour;
                    @SerializedName("wspd22hour") @Expose private String wspd22hour;
                    @SerializedName("wdir25hour") @Expose private String wdir25hour;
                    @SerializedName("wspd25hour") @Expose private String wspd25hour;
                    @SerializedName("wdir28hour") @Expose private String wdir28hour;
                    @SerializedName("wspd28hour") @Expose private String wspd28hour;
                    @SerializedName("wdir31hour") @Expose private String wdir31hour;
                    @SerializedName("wspd31hour") @Expose private String wspd31hour;
                    @SerializedName("wdir34hour") @Expose private String wdir34hour;
                    @SerializedName("wspd34hour") @Expose private String wspd34hour;
                    @SerializedName("wdir37hour") @Expose private String wdir37hour;
                    @SerializedName("wspd37hour") @Expose private String wspd37hour;
                    @SerializedName("wdir40hour") @Expose private String wdir40hour;
                    @SerializedName("wspd40hour") @Expose private String wspd40hour;
                    @SerializedName("wdir43hour") @Expose private String wdir43hour;
                    @SerializedName("wspd43hour") @Expose private String wspd43hour;
                    @SerializedName("wdir46hour") @Expose private String wdir46hour;
                    @SerializedName("wspd46hour") @Expose private String wspd46hour;
                    @SerializedName("wdir49hour") @Expose private String wdir49hour;
                    @SerializedName("wspd49hour") @Expose private String wspd49hour;
                    @SerializedName("wdir52hour") @Expose private String wdir52hour;
                    @SerializedName("wspd52hour") @Expose private String wspd52hour;
                    @SerializedName("wdir55hour") @Expose private String wdir55hour;
                    @SerializedName("wspd55hour") @Expose private String wspd55hour;
                    @SerializedName("wdir58hour") @Expose private String wdir58hour;
                    @SerializedName("wspd58hour") @Expose private String wspd58hour;
                    @SerializedName("wdir61hour") @Expose private String wdir61hour;
                    @SerializedName("wspd61hour") @Expose private String wspd61hour;
                    @SerializedName("wdir64hour") @Expose private String wdir64hour;
                    @SerializedName("wspd64hour") @Expose private String wspd64hour;
                    @SerializedName("wdir67hour") @Expose private String wdir67hour;
                    @SerializedName("wspd67hour") @Expose private String wspd67hour;

                    public String getWdir16hour() { return wdir16hour; }
                    public String getWspd16hour() { return wspd16hour; }
                    public String getWdir19hour() { return wdir19hour; }
                    public String getWspd19hour() { return wspd19hour; }
                    public String getWdir22hour() { return wdir22hour; }
                    public String getWspd22hour() { return wspd22hour; }
                    public String getWdir25hour() { return wdir25hour; }
                    public String getWspd25hour() { return wspd25hour; }
                    public String getWdir28hour() { return wdir28hour; }
                    public String getWspd28hour() { return wspd28hour; }
                    public String getWdir31hour() { return wdir31hour; }
                    public String getWspd31hour() { return wspd31hour; }
                    public String getWdir34hour() { return wdir34hour; }
                    public String getWspd34hour() { return wspd34hour; }
                    public String getWdir37hour() { return wdir37hour; }
                    public String getWspd37hour() { return wspd37hour; }
                    public String getWdir40hour() { return wdir40hour; }
                    public String getWspd40hour() { return wspd40hour; }
                    public String getWdir43hour() { return wdir43hour; }
                    public String getWspd43hour() { return wspd43hour; }
                    public String getWdir46hour() { return wdir46hour; }
                    public String getWspd46hour() { return wspd46hour; }
                    public String getWdir49hour() { return wdir49hour; }
                    public String getWspd49hour() { return wspd49hour; }
                    public String getWdir52hour() { return wdir52hour; }
                    public String getWspd52hour() { return wspd52hour; }
                    public String getWdir55hour() { return wdir55hour; }
                    public String getWspd55hour() { return wspd55hour; }
                    public String getWdir58hour() { return wdir58hour; }
                    public String getWspd58hour() { return wspd58hour; }
                    public String getWdir61hour() { return wdir61hour; }
                    public String getWspd61hour() { return wspd61hour; }
                    public String getWdir64hour() { return wdir64hour; }
                    public String getWspd64hour() { return wspd64hour; }
                    public String getWdir67hour() { return wdir67hour; }
                    public String getWspd67hour() { return wspd67hour; }
                    public String getWdir4hour() { return wdir4hour; }
                    public String getWspd4hour() { return wspd4hour; }
                    public String getWdir7hour() { return wdir7hour; }
                    public String getWspd7hour() { return wspd7hour; }
                    public String getWdir10hour() { return wdir10hour; }
                    public String getWspd10hour() { return wspd10hour; }
                    public String getWdir13hour() { return wdir13hour; }
                    public String getWspd13hour() { return wspd13hour; }
                }

                public class Precipitation {
                    @SerializedName("type4hour") @Expose private String type4hour;
                    @SerializedName("prob4hour") @Expose private String prob4hour;
                    @SerializedName("type7hour") @Expose private String type7hour;
                    @SerializedName("prob7hour") @Expose private String prob7hour;
                    @SerializedName("type10hour") @Expose private String type10hour;
                    @SerializedName("prob10hour") @Expose private String prob10hour;
                    @SerializedName("type13hour") @Expose private String type13hour;
                    @SerializedName("prob13hour") @Expose private String prob13hour;
                    @SerializedName("type16hour") @Expose private String type16hour;
                    @SerializedName("prob16hour") @Expose private String prob16hour;
                    @SerializedName("type19hour") @Expose private String type19hour;
                    @SerializedName("prob19hour") @Expose private String prob19hour;
                    @SerializedName("type22hour") @Expose private String type22hour;
                    @SerializedName("prob22hour") @Expose private String prob22hour;
                    @SerializedName("type25hour") @Expose private String type25hour;
                    @SerializedName("prob25hour") @Expose private String prob25hour;
                    @SerializedName("type28hour") @Expose private String type28hour;
                    @SerializedName("prob28hour") @Expose private String prob28hour;
                    @SerializedName("type31hour") @Expose private String type31hour;
                    @SerializedName("prob31hour") @Expose private String prob31hour;
                    @SerializedName("type34hour") @Expose private String type34hour;
                    @SerializedName("prob34hour") @Expose private String prob34hour;
                    @SerializedName("type37hour") @Expose private String type37hour;
                    @SerializedName("prob37hour") @Expose private String prob37hour;
                    @SerializedName("type40hour") @Expose private String type40hour;
                    @SerializedName("prob40hour") @Expose private String prob40hour;
                    @SerializedName("type43hour") @Expose private String type43hour;
                    @SerializedName("prob43hour") @Expose private String prob43hour;
                    @SerializedName("type46hour") @Expose private String type46hour;
                    @SerializedName("prob46hour") @Expose private String prob46hour;
                    @SerializedName("type49hour") @Expose private String type49hour;
                    @SerializedName("prob49hour") @Expose private String prob49hour;
                    @SerializedName("type52hour") @Expose private String type52hour;
                    @SerializedName("prob52hour") @Expose private String prob52hour;
                    @SerializedName("type55hour") @Expose private String type55hour;
                    @SerializedName("prob55hour") @Expose private String prob55hour;
                    @SerializedName("type58hour") @Expose private String type58hour;
                    @SerializedName("prob58hour") @Expose private String prob58hour;
                    @SerializedName("type61hour") @Expose private String type61hour;
                    @SerializedName("prob61hour") @Expose private String prob61hour;
                    @SerializedName("type64hour") @Expose private String type64hour;
                    @SerializedName("prob64hour") @Expose private String prob64hour;
                    @SerializedName("type67hour") @Expose private String type67hour;
                    @SerializedName("prob67hour") @Expose private String prob67hour;

                    public String getType4hour() { return type4hour; }
                    public String getProb4hour() { return prob4hour; }
                    public String getType7hour() { return type7hour; }
                    public String getProb7hour() { return prob7hour; }
                    public String getType10hour() { return type10hour; }
                    public String getProb10hour() { return prob10hour; }
                    public String getType13hour() { return type13hour; }
                    public String getProb13hour() { return prob13hour; }
                    public String getType16hour() { return type16hour; }
                    public String getProb16hour() { return prob16hour; }
                    public String getType19hour() { return type19hour; }
                    public String getProb19hour() { return prob19hour; }
                    public String getType22hour() { return type22hour; }
                    public String getProb22hour() { return prob22hour; }
                    public String getType25hour() { return type25hour; }
                    public String getProb25hour() { return prob25hour; }
                    public String getType28hour() { return type28hour; }
                    public String getProb28hour() { return prob28hour; }
                    public String getType31hour() { return type31hour; }
                    public String getProb31hour() { return prob31hour; }
                    public String getType34hour() { return type34hour; }
                    public String getProb34hour() { return prob34hour; }
                    public String getType37hour() { return type37hour; }
                    public String getProb37hour() { return prob37hour; }
                    public String getType40hour() { return type40hour; }
                    public String getProb40hour() { return prob40hour; }
                    public String getType43hour() { return type43hour; }
                    public String getProb43hour() { return prob43hour; }
                    public String getType46hour() { return type46hour; }
                    public String getProb46hour() { return prob46hour; }
                    public String getType49hour() { return type49hour; }
                    public String getProb49hour() { return prob49hour; }
                    public String getType52hour() { return type52hour; }
                    public String getProb52hour() { return prob52hour; }
                    public String getType55hour() { return type55hour; }
                    public String getProb55hour() { return prob55hour; }
                    public String getType58hour() { return type58hour; }
                    public String getProb58hour() { return prob58hour; }
                    public String getType61hour() { return type61hour; }
                    public String getProb61hour() { return prob61hour; }
                    public String getType64hour() { return type64hour; }
                    public String getProb64hour() { return prob64hour; }
                    public String getType67hour() { return type67hour; }
                    public String getProb67hour() { return prob67hour; }
                }
                public class Sky {
                    @SerializedName("code4hour") @Expose private String code4hour;
                    @SerializedName("name4hour") @Expose private String name4hour;
                    @SerializedName("code7hour") @Expose private String code7hour;
                    @SerializedName("name7hour") @Expose private String name7hour;
                    @SerializedName("code10hour") @Expose private String code10hour;
                    @SerializedName("name10hour") @Expose private String name10hour;
                    @SerializedName("code13hour") @Expose private String code13hour;
                    @SerializedName("name13hour") @Expose private String name13hour;
                    @SerializedName("code16hour") @Expose private String code16hour;
                    @SerializedName("name16hour") @Expose private String name16hour;
                    @SerializedName("code19hour") @Expose private String code19hour;
                    @SerializedName("name19hour") @Expose private String name19hour;
                    @SerializedName("code22hour") @Expose private String code22hour;
                    @SerializedName("name22hour") @Expose private String name22hour;
                    @SerializedName("code25hour") @Expose private String code25hour;
                    @SerializedName("name25hour") @Expose private String name25hour;
                    @SerializedName("code28hour") @Expose private String code28hour;
                    @SerializedName("name28hour") @Expose private String name28hour;
                    @SerializedName("code31hour") @Expose private String code31hour;
                    @SerializedName("name31hour") @Expose private String name31hour;
                    @SerializedName("code34hour") @Expose private String code34hour;
                    @SerializedName("name34hour") @Expose private String name34hour;
                    @SerializedName("code37hour") @Expose private String code37hour;
                    @SerializedName("name37hour") @Expose private String name37hour;
                    @SerializedName("code40hour") @Expose private String code40hour;
                    @SerializedName("name40hour") @Expose private String name40hour;
                    @SerializedName("code43hour") @Expose private String code43hour;
                    @SerializedName("name43hour") @Expose private String name43hour;
                    @SerializedName("code46hour") @Expose private String code46hour;
                    @SerializedName("name46hour") @Expose private String name46hour;
                    @SerializedName("code49hour") @Expose private String code49hour;
                    @SerializedName("name49hour") @Expose private String name49hour;
                    @SerializedName("code52hour") @Expose private String code52hour;
                    @SerializedName("name52hour") @Expose private String name52hour;
                    @SerializedName("code55hour") @Expose private String code55hour;
                    @SerializedName("name55hour") @Expose private String name55hour;
                    @SerializedName("code58hour") @Expose private String code58hour;
                    @SerializedName("name58hour") @Expose private String name58hour;
                    @SerializedName("code61hour") @Expose private String code61hour;
                    @SerializedName("name61hour") @Expose private String name61hour;
                    @SerializedName("code64hour") @Expose private String code64hour;
                    @SerializedName("name64hour") @Expose private String name64hour;
                    @SerializedName("code67hour") @Expose private String code67hour;
                    @SerializedName("name67hour") @Expose private String name67hour;

                    public String getCode16hour() { return code16hour; }
                    public String getName16hour() { return name16hour; }
                    public String getCode19hour() { return code19hour; }
                    public String getName19hour() { return name19hour; }
                    public String getCode22hour() { return code22hour; }
                    public String getName22hour() { return name22hour; }
                    public String getCode25hour() { return code25hour; }
                    public String getName25hour() { return name25hour; }
                    public String getCode28hour() { return code28hour; }
                    public String getName28hour() { return name28hour; }
                    public String getCode31hour() { return code31hour; }
                    public String getName31hour() { return name31hour; }
                    public String getCode34hour() { return code34hour; }
                    public String getName34hour() { return name34hour; }
                    public String getCode37hour() { return code37hour; }
                    public String getName37hour() { return name37hour; }
                    public String getCode40hour() { return code40hour; }
                    public String getName40hour() { return name40hour; }
                    public String getCode43hour() { return code43hour; }
                    public String getName43hour() { return name43hour; }
                    public String getCode46hour() { return code46hour; }
                    public String getName46hour() { return name46hour; }
                    public String getCode49hour() { return code49hour; }
                    public String getName49hour() { return name49hour; }
                    public String getCode52hour() { return code52hour; }
                    public String getName52hour() { return name52hour; }
                    public String getCode55hour() { return code55hour; }
                    public String getName55hour() { return name55hour; }
                    public String getCode58hour() { return code58hour; }
                    public String getName58hour() { return name58hour; }
                    public String getCode61hour() { return code61hour; }
                    public String getName61hour() { return name61hour; }
                    public String getCode64hour() { return code64hour; }
                    public String getName64hour() { return name64hour; }
                    public String getCode67hour() { return code67hour; }
                    public String getName67hour() { return name67hour; }
                    public String getCode4hour() { return code4hour; }
                    public String getName4hour() { return name4hour; }
                    public String getCode7hour() { return code7hour; }
                    public String getName7hour() { return name7hour; }
                    public String getCode10hour() { return code10hour; }
                    public String getName10hour() { return name10hour; }
                    public String getCode13hour() { return code13hour; }
                    public String getName13hour() { return name13hour; }
                }
                public class Temperature {
                    @SerializedName("temp4hour") @Expose private String temp4hour;
                    @SerializedName("temp7hour") @Expose private String temp7hour;
                    @SerializedName("temp10hour") @Expose private String temp10hour;
                    @SerializedName("temp13hour") @Expose private String temp13hour;
                    @SerializedName("temp16hour") @Expose private String temp16hour;
                    @SerializedName("temp19hour") @Expose private String temp19hour;
                    @SerializedName("temp22hour") @Expose private String temp22hour;
                    @SerializedName("temp25hour") @Expose private String temp25hour;
                    @SerializedName("temp28hour") @Expose private String temp28hour;
                    @SerializedName("temp31hour") @Expose private String temp31hour;
                    @SerializedName("temp34hour") @Expose private String temp34hour;
                    @SerializedName("temp37hour") @Expose private String temp37hour;
                    @SerializedName("temp40hour") @Expose private String temp40hour;
                    @SerializedName("temp43hour") @Expose private String temp43hour;
                    @SerializedName("temp46hour") @Expose private String temp46hour;
                    @SerializedName("temp49hour") @Expose private String temp49hour;
                    @SerializedName("temp52hour") @Expose private String temp52hour;
                    @SerializedName("temp55hour") @Expose private String temp55hour;
                    @SerializedName("temp58hour") @Expose private String temp58hour;
                    @SerializedName("temp61hour") @Expose private String temp61hour;
                    @SerializedName("temp64hour") @Expose private String temp64hour;
                    @SerializedName("temp67hour") @Expose private String temp67hour;

                    public String getTemp16hour() { return temp16hour; }
                    public String getTemp19hour() { return temp19hour; }
                    public String getTemp22hour() { return temp22hour; }
                    public String getTemp25hour() { return temp25hour; }
                    public String getTemp28hour() { return temp28hour; }
                    public String getTemp31hour() { return temp31hour; }
                    public String getTemp34hour() { return temp34hour; }
                    public String getTemp37hour() { return temp37hour; }
                    public String getTemp40hour() { return temp40hour; }
                    public String getTemp43hour() { return temp43hour; }
                    public String getTemp46hour() { return temp46hour; }
                    public String getTemp49hour() { return temp49hour; }
                    public String getTemp52hour() { return temp52hour; }
                    public String getTemp55hour() { return temp55hour; }
                    public String getTemp58hour() { return temp58hour; }
                    public String getTemp61hour() { return temp61hour; }
                    public String getTemp64hour() { return temp64hour; }
                    public String getTemp67hour() { return temp67hour; }
                    public String getTemp4hour() { return temp4hour; }
                    public String getTemp7hour() { return temp7hour; }
                    public String getTemp10hour() { return temp10hour; }
                    public String getTemp13hour() { return temp13hour; }
                }
                public class Humidity {
                    @SerializedName("rh4hour") @Expose private String rh4hour;
                    @SerializedName("rh64hour") @Expose private String rh64hour;
                    @SerializedName("rh67hour") @Expose private String rh67hour;
                    @SerializedName("rh7hour") @Expose private String rh7hour;
                    @SerializedName("rh10hour") @Expose private String rh10hour;
                    @SerializedName("rh13hour") @Expose private String rh13hour;
                    @SerializedName("rh16hour") @Expose private String rh16hour;
                    @SerializedName("rh19hour") @Expose private String rh19hour;
                    @SerializedName("rh22hour") @Expose private String rh22hour;
                    @SerializedName("rh25hour") @Expose private String rh25hour;
                    @SerializedName("rh28hour") @Expose private String rh28hour;
                    @SerializedName("rh31hour") @Expose private String rh31hour;
                    @SerializedName("rh34hour") @Expose private String rh34hour;
                    @SerializedName("rh37hour") @Expose private String rh37hour;
                    @SerializedName("rh40hour") @Expose private String rh40hour;
                    @SerializedName("rh43hour") @Expose private String rh43hour;
                    @SerializedName("rh46hour") @Expose private String rh46hour;
                    @SerializedName("rh49hour") @Expose private String rh49hour;
                    @SerializedName("rh52hour") @Expose private String rh52hour;
                    @SerializedName("rh55hour") @Expose private String rh55hour;
                    @SerializedName("rh58hour") @Expose private String rh58hour;
                    @SerializedName("rh61hour") @Expose private String rh61hour;

                    public String getRh64hour() { return rh64hour; }
                    public String getRh67hour() { return rh67hour; }
                    public String getRh16hour() { return rh16hour; }
                    public String getRh19hour() { return rh19hour; }
                    public String getRh22hour() { return rh22hour; }
                    public String getRh25hour() { return rh25hour; }
                    public String getRh28hour() { return rh28hour; }
                    public String getRh31hour() { return rh31hour; }
                    public String getRh34hour() { return rh34hour; }
                    public String getRh37hour() { return rh37hour; }
                    public String getRh40hour() { return rh40hour; }
                    public String getRh43hour() { return rh43hour; }
                    public String getRh46hour() { return rh46hour; }
                    public String getRh49hour() { return rh49hour; }
                    public String getRh52hour() { return rh52hour; }
                    public String getRh55hour() { return rh55hour; }
                    public String getRh58hour() { return rh58hour; }
                    public String getRh61hour() { return rh61hour; }
                    public String getRh4hour() { return rh4hour; }
                    public String getRh7hour() { return rh7hour; }
                    public String getRh10hour() { return rh10hour; }
                    public String getRh13hour() { return rh13hour; }
                }
            }
            public class Fcst6hour {
                @SerializedName("rain6hour") @Expose private String rain6hour;
                @SerializedName("rain12hour") @Expose private String rain12hour;
                @SerializedName("rain18hour") @Expose private String rain18hour;
                @SerializedName("rain24hour") @Expose private String rain24hour;
                @SerializedName("rain30hour") @Expose private String rain30hour;
                @SerializedName("rain36hour") @Expose private String rain36hour;
                @SerializedName("rain42hour") @Expose private String rain42hour;
                @SerializedName("rain48hour") @Expose private String rain48hour;
                @SerializedName("rain54hour") @Expose private String rain54hour;
                @SerializedName("snow6hour") @Expose private String snow6hour;
                @SerializedName("snow12hour") @Expose private String snow12hour;
                @SerializedName("snow18hour") @Expose private String snow18hour;
                @SerializedName("snow24hour") @Expose private String snow24hour;
                @SerializedName("snow30hour") @Expose private String snow30hour;
                @SerializedName("snow36hour") @Expose private String snow36hour;
                @SerializedName("snow42hour") @Expose private String snow42hour;
                @SerializedName("snow48hour") @Expose private String snow48hour;
                @SerializedName("snow54hour") @Expose private String snow54hour;
                @SerializedName("rain60hour") @Expose private String rain60hour;
                @SerializedName("rain66hour") @Expose private String rain66hour;
                @SerializedName("snow60hour") @Expose private String snow60hour;
                @SerializedName("snow66hour") @Expose private String snow66hour;

                public String getRain24hour() { return rain24hour; }
                public String getRain30hour() { return rain30hour; }
                public String getRain36hour() { return rain36hour; }
                public String getRain42hour() { return rain42hour; }
                public String getRain48hour() { return rain48hour; }
                public String getRain54hour() { return rain54hour; }
                public String getSnow24hour() { return snow24hour; }
                public String getSnow30hour() { return snow30hour; }
                public String getSnow36hour() { return snow36hour; }
                public String getSnow42hour() { return snow42hour; }
                public String getSnow48hour() { return snow48hour; }
                public String getSnow54hour() { return snow54hour; }
                public String getRain60hour() { return rain60hour; }
                public String getRain66hour() { return rain66hour; }
                public String getSnow60hour() { return snow60hour; }
                public String getSnow66hour() { return snow66hour; }
                public String getRain6hour() { return rain6hour; }
                public String getRain12hour() { return rain12hour; }
                public String getRain18hour() { return rain18hour; }
                public String getSnow6hour() { return snow6hour; }
                public String getSnow12hour() { return snow12hour; }
                public String getSnow18hour() { return snow18hour; }
            }
            public class Fcstdaily {
                @SerializedName("temperature") @Expose private Temperature_ temperature;

                public Temperature_ getTemperature() { return temperature; }

                public class Temperature_ {
                    @SerializedName("tmax1day") @Expose private String tmax1day;
                    @SerializedName("tmax2day") @Expose private String tmax2day;
                    @SerializedName("tmax3day") @Expose private String tmax3day;
                    @SerializedName("tmin1day") @Expose private String tmin1day;
                    @SerializedName("tmin2day") @Expose private String tmin2day;
                    @SerializedName("tmin3day") @Expose private String tmin3day;

                    public String getTmax1day() { return tmax1day; }
                    public String getTmax2day() { return tmax2day; }
                    public String getTmax3day() { return tmax3day; }
                    public String getTmin1day() { return tmin1day; }
                    public String getTmin2day() { return tmin2day; }
                    public String getTmin3day() { return tmin3day; }
                }
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

        public int getCode() { return code; }
        public String getRequestUrl() { return requestUrl; }
        public String getMessage() { return message; }
    }
}