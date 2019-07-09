package com.cookandroid.clear_day;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastApiService {
    public static final String BASEURL = "https://api2.sktelecom.com/";
    public static final String APPKEY = "16261fbf-2f3e-4385-99fd-b5713a5c2995";
    // https://api2.sktelecom.com/weather/current/minutely?version=1&lat=37.7518003&lon=127.0654705&appKey=16261fbf-2f3e-4385-99fd-b5713a5c2995
    // https://api2.sktelecom.com/weather/current/hourly?version=1&lat=37.7518003&lon=127.0654705&appKey=16261fbf-2f3e-4385-99fd-b5713a5c2995
    // https://api2.sktelecom.com/weather/forecast/3hours?version=1&lat=37.7518003&lon=127.0654705&appKey=16261fbf-2f3e-4385-99fd-b5713a5c2995
    // https://api2.sktelecom.com/weather/forecast/3days?version=1&lat=37.7518003&lon=127.0654705&appKey=16261fbf-2f3e-4385-99fd-b5713a5c2995
    // https://api2.sktelecom.com/weather/summary?version=1&lat=37.7518003&lon=127.0654705&appKey=16261fbf-2f3e-4385-99fd-b5713a5c2995
    // https://jsonlint.com/

    @GET("weather/current/minutely/?version=1&appKey=" + APPKEY)
    Observable<ForecastMinutelyReport> getForecastMinutelyData(
            @Query("lat") double lat,
            @Query("lon") double lon
    );

    @GET("weather/current/hourly/?version=1&appKey=" + APPKEY)
    Observable<ForecastHourlyReport> getForecastHourlyData(
            @Query("lat") double lat,
            @Query("lon") double lon
    );

//    @GET("weather/forecast/3hours?version=1&appKey=" + APPKEY)
//    Observable<Forecast3HoursReport> getForecast3HoursData(
//            @Query("lat") double lat,
//            @Query("lon") double lon
//    );

    @GET("weather/forecast/3days?version=1&appKey=" + APPKEY)
    Observable<Forecast3DaysReport> getForecast3DaysData(
            @Query("lat") double lat,
            @Query("lon") double lon
    );

    @GET("weather/summary?version=1&appKey=" + APPKEY)
    Observable<ForecastSummaryReport> getForecastSummaryData(
            @Query("lat") double lat,
            @Query("lon") double lon
    );
}