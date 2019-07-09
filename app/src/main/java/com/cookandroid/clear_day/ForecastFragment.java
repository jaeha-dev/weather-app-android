package com.cookandroid.clear_day;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cookandroid.clear_day.ForecastApiService.BASEURL;
import static com.cookandroid.clear_day.MainActivity.*;

public class ForecastFragment extends Fragment {
    private static final String TAG = "forecast_Data";
    private static final int FORECAST_INDEX = 0;

    private CompositeDisposable mCompositeDisposableForecast;
    // 데이터 리스트
    private ArrayList<ForecastMinutelyReport.Weather.Minutely> mForecastMinutelyList;
    private ArrayList<ForecastHourlyReport.Weather.Hourly> mForecastHourlyList;
    private ArrayList<Forecast3DaysReport.Weather.Forecast3day> mForecast3DaysList;
    private ArrayList<ForecastSummaryReport.Weather.Summary> mForecastSummaryList;
    // 위젯 정보
    ImageView iv_Current_SkyCode, iv_4Hours_SkyCode, iv_7Hours_SkyCode, iv_10Hours_SkyCode; // 하늘 상태 코드(이미지)
    TextView tv_Location_Forecast_1, tv_Location_Forecast_2; // 사용자 위치정보
    TextView tv_4Hours_Time, tv_7Hours_Time, tv_10Hours_Time; // 4/7/10시간 뒤 시간
    TextView tv_Current_SkyCode, tv_4Hours_SkyCode, tv_7Hours_SkyCode, tv_10Hours_SkyCode; // 하늘 상태 코드(텍스트)
    TextView tv_Current_Tc, tv_Today_Tmax, tv_Today_Tmin, tv_4Hours_Tc, tv_7Hours_Tc, tv_10Hours_Tc; // 기온, 일 최고기온, 일 최저기온, 4/7/10시간 뒤 기온
    TextView tv_Current_Wdir, tv_Current_Wspd, tv_Current_Humidity, tv_Current_SinceOntime_Rain; // 현재 풍향, 풍속, 습도, 강수량
    TextView tv_4Hours_Prob, tv_7Hours_Prob, tv_10Hours_Prob; // 4/7/10시간 뒤 강수확률

    // 생성자
    public static ForecastFragment newInstance() {
        ForecastFragment fragment = new ForecastFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 위젯ID
        iv_Current_SkyCode = (ImageView) getView().findViewById(R.id.iv_Current_SkyCode);
        iv_4Hours_SkyCode = (ImageView) getView().findViewById(R.id.iv_4Hours_SkyCode);
        iv_7Hours_SkyCode = (ImageView) getView().findViewById(R.id.iv_7Hours_SkyCode);
        iv_10Hours_SkyCode = (ImageView) getView().findViewById(R.id.iv_10Hours_SkyCode);
        tv_Location_Forecast_1 = (TextView) getView().findViewById(R.id.tv_Location_Forecast_1);
        tv_Location_Forecast_2 = (TextView) getView().findViewById(R.id.tv_Location_Forecast_2);
        tv_4Hours_Time = (TextView) getView().findViewById(R.id.tv_4Hours_Time);
        tv_7Hours_Time = (TextView) getView().findViewById(R.id.tv_7Hours_Time);
        tv_10Hours_Time = (TextView) getView().findViewById(R.id.tv_10Hours_Time);
        tv_Current_SkyCode = (TextView) getView().findViewById(R.id.tv_Current_SkyCode);
        tv_4Hours_SkyCode = (TextView) getView().findViewById(R.id.tv_4Hours_SkyCode);
        tv_7Hours_SkyCode = (TextView) getView().findViewById(R.id.tv_7Hours_SkyCode);
        tv_10Hours_SkyCode = (TextView) getView().findViewById(R.id.tv_10Hours_SkyCode);
        tv_Current_Tc = (TextView) getView().findViewById(R.id.tv_Current_Tc);
        tv_Today_Tmax = (TextView) getView().findViewById(R.id.tv_Today_Tmax);
        tv_Today_Tmin = (TextView) getView().findViewById(R.id.tv_Today_Tmin);
        tv_4Hours_Tc = (TextView) getView().findViewById(R.id.tv_4Hours_Tc);
        tv_7Hours_Tc = (TextView) getView().findViewById(R.id.tv_7Hours_Tc);
        tv_10Hours_Tc = (TextView) getView().findViewById(R.id.tv_10Hours_Tc);
        tv_Current_Wdir = (TextView) getView().findViewById(R.id.tv_Current_Wdir);
        tv_Current_Wspd = (TextView) getView().findViewById(R.id.tv_Current_Wspd);
        tv_Current_Humidity = (TextView) getView().findViewById(R.id.tv_Current_Humidity);
        tv_Current_SinceOntime_Rain = (TextView) getView().findViewById(R.id.tv_Current_SinceOntime_Rain);
        tv_4Hours_Prob = (TextView) getView().findViewById(R.id.tv_4Hours_Prob);
        tv_7Hours_Prob = (TextView) getView().findViewById(R.id.tv_7Hours_Prob);
        tv_10Hours_Prob = (TextView) getView().findViewById(R.id.tv_10Hours_Prob);
        // 사용자 위치정보 출력
        tv_Location_Forecast_1.setText(location_1);
        tv_Location_Forecast_2.setText(location_2);
        // 현재(분별, 시간별) 및 단기 기상 정보 받아오기
        this.mCompositeDisposableForecast = new CompositeDisposable();
        this.getForecastMinutelyData(mLatitude, mLongitude);
        this.getForecastHourlyData(mLatitude, mLongitude);
        this.getForecast3DaysData(mLatitude, mLongitude);
        this.getForecastSummaryData(mLatitude, mLongitude);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mCompositeDisposableForecast.clear();
    }

    public void getForecastMinutelyData(double lat, double lon) {
        // 분별 기상 정보 (발표 시간 시점에 값 없음)
        ForecastApiService forecastApiService = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ForecastApiService.class);
        mCompositeDisposableForecast.add(forecastApiService.getForecastMinutelyData(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<ForecastMinutelyReport>() {
                    @Override
                    public void onNext(@NonNull ForecastMinutelyReport forecastMinutelyReport) {
                        ResponseForecastMinutely(forecastMinutelyReport);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        handleError(e);
                    }
                    @Override
                    public void onComplete() {
                    }
                }));
    }
    public void ResponseForecastMinutely(ForecastMinutelyReport forecastMinutelyReport) {
        this.mForecastMinutelyList = new ArrayList<>(forecastMinutelyReport.getWeather().getMinutely());
        Log.d("측정소 정보(분별)", "측정소명: " + this.mForecastMinutelyList.get(FORECAST_INDEX).getStation().getName());
        Log.d("현재 하늘(분별)", "현재 하늘: " + this.mForecastMinutelyList.get(FORECAST_INDEX).getSky().getName());
        Log.d("현재 기온(분별)", "현재 기온: " + this.mForecastMinutelyList.get(FORECAST_INDEX).getTemperature().getTc());
        this.setForecastMinutelyData();
    }

    public void getForecastHourlyData(double lat, double lon) {
        // 시간별 기상 정보
        ForecastApiService forecastApiService = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ForecastApiService.class);
        mCompositeDisposableForecast.add(forecastApiService.getForecastHourlyData(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<ForecastHourlyReport>() {
                    @Override
                    public void onNext(@NonNull ForecastHourlyReport forecastHourlyReport) {
                        ResponseForecastHourly(forecastHourlyReport);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        handleError(e);
                    }
                    @Override
                    public void onComplete() {
                    }
                }));
    }
    public void ResponseForecastHourly(ForecastHourlyReport forecastHourlyReport) {
        this.mForecastHourlyList = new ArrayList<>(forecastHourlyReport.getWeather().getHourly());
        Log.d("현재 하늘(시간별)", "현재 하늘(텍스트): " + this.mForecastHourlyList.get(FORECAST_INDEX).getSky().getName());
        Log.d("현재 하늘(시간별)", "현재 하늘(코드): " + this.mForecastHourlyList.get(FORECAST_INDEX).getSky().getCode());
        Log.d("현재 기온(시간별)", "현재 기온: " + this.mForecastHourlyList.get(FORECAST_INDEX).getTemperature().getTc());
        this.setTimeData();
        this.setForecastHourlyData();
        this.checkCurrentTime();
        this.checkCurrentSkyStatus(skyCode_Current);
        this.checkWindDirection(wdir_Current);
    }

    public void getForecast3DaysData(double lat, double lon) {
        // 단기 기상 정보
        ForecastApiService forecastApiService = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ForecastApiService.class);
        mCompositeDisposableForecast.add(forecastApiService.getForecast3DaysData(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<Forecast3DaysReport>() {
                    @Override
                    public void onNext(@NonNull Forecast3DaysReport forecast3DaysReport) {
                        ResponseForecast3Days(forecast3DaysReport);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        handleError(e);
                    }
                    @Override
                    public void onComplete() {
                    }
                }));
    }
    public void ResponseForecast3Days(Forecast3DaysReport forecast3DaysReport) {
        this.mForecast3DaysList = new ArrayList<>(forecast3DaysReport.getWeather().getForecast3days());
        Log.d("4시간 후 하늘(시간별)", "하늘(텍스트): " + this.mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getSky().getName4hour());
        Log.d("7시간 후 하늘(시간별)", "하늘(텍스트): " + this.mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getSky().getName7hour());
        Log.d("10시간 후 기온(시간별)", "하늘(텍스트): " + this.mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getSky().getName10hour());
        this.setForecastDailyData();
        this.check4HoursSkyStatus(skyCode_4Hours);
        this.check7HoursSkyStatus(skyCode_7Hours);
        this.check10HoursSkyStatus(skyCode_10Hours);
    }

    public void getForecastSummaryData(double lat, double lon) {
        // 간편 기상 정보
        ForecastApiService forecastApiService = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ForecastApiService.class);
        mCompositeDisposableForecast.add(forecastApiService.getForecastSummaryData(lat, lon)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<ForecastSummaryReport>() {
                    @Override
                    public void onNext(@NonNull ForecastSummaryReport forecastSummaryReport) {
                        ResponseForecastSummary(forecastSummaryReport);
                    }
                    @Override
                    public void onError(@NonNull Throwable e) {
                        handleError(e);
                    }
                    @Override
                    public void onComplete() {
                    }
                }));
    }
    public void ResponseForecastSummary(ForecastSummaryReport forecastSummaryReport) {
        this.mForecastSummaryList = new ArrayList<>(forecastSummaryReport.getWeather().getSummary());
        Log.d("어제 최고기온", "최고기온: " + this.mForecastSummaryList.get(FORECAST_INDEX).getYesterday().getTemperature().getTmax());
        Log.d("오늘 최고기온", "최고기온: " + this.mForecastSummaryList.get(FORECAST_INDEX).getToday().getTemperature().getTmax());
        Log.d("내일 최고기온", "최고기온: " + this.mForecastSummaryList.get(FORECAST_INDEX).getTomorrow().getTemperature().getTmax());
        this.setForecastSummaryData();
    }

    public void handleError(Throwable error) {
        Toast.makeText(getContext(), "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    public void setForecastMinutelyData() {
        // 관측소
        forecastStation = mForecastMinutelyList.get(FORECAST_INDEX).getStation().getName();
    }
    public void setForecastHourlyData() {
        // 관측시간
        String tempStr = mForecastHourlyList.get(FORECAST_INDEX).getTimeRelease();
        forecastTime = tempStr.substring(11, 16);
        // 하늘상태
        skyCode_Current = mForecastHourlyList.get(FORECAST_INDEX).getSky().getCode();
        // 현재기온, 최고기온, 최저기온
        tc_Current = mForecastHourlyList.get(FORECAST_INDEX).getTemperature().getTc();
        tc_Current_Integer = (int) Double.parseDouble(tc_Current);
        tv_Current_Tc.setText(String.valueOf(tc_Current_Integer));
        tc_Max = mForecastHourlyList.get(FORECAST_INDEX).getTemperature().getTmax();
        tc_Max_Integer = (int) Double.parseDouble(tc_Max);
        tv_Today_Tmax.setText(String.valueOf(tc_Max_Integer));
        tc_Min = mForecastHourlyList.get(FORECAST_INDEX).getTemperature().getTmin();
        tc_Min_Integer = (int) Double.parseDouble(tc_Min);
        tv_Today_Tmin.setText(String.valueOf(tc_Min_Integer));
        // 풍향, 풍속
        wdir_Current = mForecastHourlyList.get(FORECAST_INDEX).getWind().getWdir();
        wspd_Current = mForecastHourlyList.get(FORECAST_INDEX).getWind().getWspd();
        wspd_Current_Integer = (int) Double.parseDouble(wspd_Current);
        tv_Current_Wspd.setText(String.valueOf(wspd_Current_Integer));
        // 습도, 강우량
        humidity_Current = mForecastHourlyList.get(FORECAST_INDEX).getHumidity();
        humidity_Current_Integer = (int) Double.parseDouble(humidity_Current);
        tv_Current_Humidity.setText(String.valueOf(humidity_Current_Integer));
        sinceOntime_Rain_Current = mForecastHourlyList.get(FORECAST_INDEX).getPrecipitation().getSinceOntime();
        sinceOntime_Rain_Current_Integer = (int) Double.parseDouble(sinceOntime_Rain_Current);
        tv_Current_SinceOntime_Rain.setText(String.valueOf(sinceOntime_Rain_Current_Integer));
    }

    public void setForecastDailyData() {
        // 4시간 후
        skyCode_4Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getSky().getCode4hour();
        tc_4Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getTemperature().getTemp4hour();
        tc_4Hours_Integer = (int) Double.parseDouble(tc_4Hours);
        tv_4Hours_Tc.setText(String.valueOf(tc_4Hours_Integer));
        prob_4Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getPrecipitation().getProb4hour();
        prob_4Hours_Integer = (int) Double.parseDouble(prob_4Hours);
        tv_4Hours_Prob.setText(String.valueOf(prob_4Hours_Integer));
        // 7시간 후
        skyCode_7Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getSky().getCode7hour();
        tc_7Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getTemperature().getTemp7hour();
        tc_7Hours_Integer = (int) Double.parseDouble(tc_7Hours);
        tv_7Hours_Tc.setText(String.valueOf(tc_7Hours_Integer));
        prob_7Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getPrecipitation().getProb7hour();
        prob_7Hours_Integer = (int) Double.parseDouble(prob_7Hours);
        tv_7Hours_Prob.setText(String.valueOf(prob_7Hours_Integer));
        // 10시간 후
        skyCode_10Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getSky().getCode10hour();
        tc_10Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getTemperature().getTemp10hour();
        tc_10Hours_Integer = (int) Double.parseDouble(tc_10Hours);
        tv_10Hours_Tc.setText(String.valueOf(tc_10Hours_Integer));
        prob_10Hours = mForecast3DaysList.get(FORECAST_INDEX).getFcst3hour().getPrecipitation().getProb10hour();
        prob_10Hours_Integer = (int) Double.parseDouble(prob_10Hours);
        tv_10Hours_Prob.setText(String.valueOf(prob_10Hours_Integer));
    }

    public void setForecastSummaryData() {
        // 어제 하늘, 최고기온, 최저기온
        skyCode_Yesterday = mForecastSummaryList.get(FORECAST_INDEX).getYesterday().getSky().getCode();
        tc_Max_Yesterday = mForecastSummaryList.get(FORECAST_INDEX).getYesterday().getTemperature().getTmax();
        tc_Max_Yesterday_Integer = (int) Double.parseDouble(tc_Max_Yesterday);
        tc_Min_Yesterday = mForecastSummaryList.get(FORECAST_INDEX).getYesterday().getTemperature().getTmin();
        tc_Min_Yesterday_Integer = (int) Double.parseDouble(tc_Min_Yesterday);
        // 오늘 하늘, 최고기온, 최저기온
        skyCode_Today = mForecastSummaryList.get(FORECAST_INDEX).getToday().getSky().getCode();
        tc_Max_Today = mForecastSummaryList.get(FORECAST_INDEX).getToday().getTemperature().getTmax();
        tc_Max_Today_Integer = (int) Double.parseDouble(tc_Max_Today);
        tc_Min_Today = mForecastSummaryList.get(FORECAST_INDEX).getToday().getTemperature().getTmin();
        tc_Min_Today_Integer = (int) Double.parseDouble(tc_Min_Today);
        // 내일 하늘, 최고기온, 최저기온
        skyCode_Tomorrow = mForecastSummaryList.get(FORECAST_INDEX).getTomorrow().getSky().getCode();
        tc_Max_Tomorrow = mForecastSummaryList.get(FORECAST_INDEX).getTomorrow().getTemperature().getTmax();
        tc_Max_Tomorrow_Integer = (int) Double.parseDouble(tc_Max_Tomorrow);
        tc_Min_Tomorrow = mForecastSummaryList.get(FORECAST_INDEX).getTomorrow().getTemperature().getTmin();
        tc_Min_Tomorrow_Integer = (int) Double.parseDouble(tc_Min_Tomorrow);
    }

    public void setTimeData() {
        m4Hours_Integer = mHour_Integer + 4;
        m7Hours_Integer = mHour_Integer + 7;
        m10Hours_Integer = mHour_Integer + 10;

        String m4Hours = "";
        String m7Hours = "";
        String m10Hours = "";

        if(m4Hours_Integer == 24) {
            m4Hours = "00:00";
        } else if (m4Hours_Integer > 24) {
            int num = m4Hours_Integer - 24;
            if (num < 10) {
                m4Hours = "0" + String.valueOf(num) + ":00";
            } else {
                m4Hours = String.valueOf(num) + ":00";
            }
        } else if (m4Hours_Integer < 24) {
            if (m4Hours_Integer < 10) {
                m4Hours = "0" + String.valueOf(m4Hours_Integer) + ":00";
            } else {
                m4Hours = String.valueOf(m4Hours_Integer) + ":00";
            }
        }
        if(m7Hours_Integer == 24) {
            m7Hours = "00:00";
        } else if (m7Hours_Integer > 24) {
            int num = m7Hours_Integer - 24;
            if (num < 10) {
                m7Hours = "0" + String.valueOf(num) + ":00";
            } else {
                m7Hours = String.valueOf(num) + ":00";
            }
        } else if (m7Hours_Integer < 24) {
            if (m7Hours_Integer < 10) {
                m7Hours = "0" + String.valueOf(m7Hours_Integer) + ":00";
            } else {
                m7Hours = String.valueOf(m7Hours_Integer) + ":00";
            }
        }
        if(m10Hours_Integer == 24) {
            m10Hours = "00:00";
        } else if (m10Hours_Integer > 24) {
            int num = m10Hours_Integer - 24;
            if (num < 10) {
                m10Hours = "0" + String.valueOf(num) + ":00";
            } else {
                m10Hours = String.valueOf(num) + ":00";
            }
        } else if (m10Hours_Integer < 24) {
            if (m10Hours_Integer < 10) {
                m10Hours = "0" + String.valueOf(m10Hours_Integer) + ":00";
            } else {
                m10Hours = String.valueOf(m10Hours_Integer) + ":00";
            }
        }

        tv_4Hours_Time.setText(m4Hours);
        tv_7Hours_Time.setText(m7Hours);
        tv_10Hours_Time.setText(m10Hours);
    }

    public void checkCurrentTime() {
        int currentHour = mHour_Integer;
        Log.d("현재 시각(24시간)", "현재 시각: " + currentHour);
        if(6 <= currentHour && currentHour < 18) {
            // 오전 06시부터 오후 18시까지
            dayOrNight = true;
        } else {
            // 나머지
            dayOrNight = false;
        }
    }
    public void checkCurrentSkyStatus(String skyCode) {
        switch (skyCode) {
            case "SKY_O01":
                if (dayOrNight == true) {
                    iv_Current_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                    tv_Current_SkyCode.setText("맑음");
                } else {
                    iv_Current_SkyCode.setImageResource(R.drawable.ic_clear_moon);
                    tv_Current_SkyCode.setText("맑음");
                }
                break;
            case "SKY_O02":
                if (dayOrNight == true) {
                    iv_Current_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                    tv_Current_SkyCode.setText("구름조금");
                } else {
                    iv_Current_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_moon);
                    tv_Current_SkyCode.setText("구름조금");
                }
                break;
            case "SKY_O03":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Current_SkyCode.setText("구름많음");
                break;
            case "SKY_O04":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_Current_SkyCode.setText("비");
                break;
            case "SKY_O05":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_Current_SkyCode.setText("눈");
                break;
            case "SKY_O06":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_Current_SkyCode.setText("비/눈");
                break;
            case "SKY_O07":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Current_SkyCode.setText("흐림");
                break;
            case "SKY_O08":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_Current_SkyCode.setText("비");
                break;
            case "SKY_O09":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_Current_SkyCode.setText("눈");
                break;
            case "SKY_O10":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_Current_SkyCode.setText("비/눈");
                break;
            case "SKY_O11":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_thunderbolt);
                tv_Current_SkyCode.setText("낙뢰");
                break;
            case "SKY_O12":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_storm);
                tv_Current_SkyCode.setText("뇌우");
                break;
            case "SKY_O13":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_storm_snow);
                tv_Current_SkyCode.setText("뇌우");
                break;
            case "SKY_O14":
                iv_Current_SkyCode.setImageResource(R.drawable.ic_storm_snow_rain);
                tv_Current_SkyCode.setText("뇌우");
                break;
            default:
                break;
        }
    }
    public void check4HoursSkyStatus(String skyCode) {
        boolean dayOrNight_4Hours; // T: Day, F: Night
        if (6 <= m4Hours_Integer && m4Hours_Integer < 18) {
            dayOrNight_4Hours = true;
        } else {
            dayOrNight_4Hours = false;
        }
        switch (skyCode) {
            case "SKY_S01":
                if (dayOrNight_4Hours == true) {
                    iv_4Hours_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                    tv_4Hours_SkyCode.setText("맑음");
                } else {
                    iv_4Hours_SkyCode.setImageResource(R.drawable.ic_clear_moon);
                    tv_4Hours_SkyCode.setText("맑음");
                }
                break;
            case "SKY_S02":
                if (dayOrNight_4Hours == true) {
                    iv_4Hours_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                    tv_4Hours_SkyCode.setText("구름조금");
                } else {
                    iv_4Hours_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_moon);
                    tv_4Hours_SkyCode.setText("구름조금");
                }
                break;
            case "SKY_S03":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_4Hours_SkyCode.setText("구름많음");
                break;
            case "SKY_S04":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_4Hours_SkyCode.setText("비");
                break;
            case "SKY_S05":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_4Hours_SkyCode.setText("눈");
                break;
            case "SKY_S06":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_4Hours_SkyCode.setText("비/눈");
                break;
            case "SKY_S07":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_4Hours_SkyCode.setText("흐림");
                break;
            case "SKY_S08":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_4Hours_SkyCode.setText("비");
                break;
            case "SKY_S09":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_4Hours_SkyCode.setText("눈");
                break;
            case "SKY_S10":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_4Hours_SkyCode.setText("비/눈");
                break;
            case "SKY_S11":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_thunderbolt);
                tv_4Hours_SkyCode.setText("낙뢰");
                break;
            case "SKY_S12":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_storm);
                tv_4Hours_SkyCode.setText("뇌우");
                break;
            case "SKY_S13":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_storm_snow);
                tv_4Hours_SkyCode.setText("뇌우");
                break;
            case "SKY_S14":
                iv_4Hours_SkyCode.setImageResource(R.drawable.ic_storm_snow_rain);
                tv_4Hours_SkyCode.setText("뇌우");
                break;
            default:
                break;
        }
    }
    public void check7HoursSkyStatus(String skyCode) {
        boolean dayOrNight_7Hours; // T: Day, F: Night
        if (6 <= m7Hours_Integer && m7Hours_Integer < 18) {
            dayOrNight_7Hours = true;
        } else {
            dayOrNight_7Hours = false;
        }
        switch (skyCode) {
            case "SKY_S01":
                if (dayOrNight_7Hours == true) {
                    iv_7Hours_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                    tv_7Hours_SkyCode.setText("맑음");
                } else {
                    iv_7Hours_SkyCode.setImageResource(R.drawable.ic_clear_moon);
                    tv_7Hours_SkyCode.setText("맑음");
                }
                break;
            case "SKY_S02":
                if (dayOrNight_7Hours == true) {
                    iv_7Hours_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                    tv_7Hours_SkyCode.setText("구름조금");
                } else {
                    iv_7Hours_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_moon);
                    tv_7Hours_SkyCode.setText("구름조금");
                }
                break;
            case "SKY_S03":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_7Hours_SkyCode.setText("구름많음");
                break;
            case "SKY_S04":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_7Hours_SkyCode.setText("비");
                break;
            case "SKY_S05":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_7Hours_SkyCode.setText("눈");
                break;
            case "SKY_S06":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_7Hours_SkyCode.setText("비/눈");
                break;
            case "SKY_S07":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_7Hours_SkyCode.setText("흐림");
                break;
            case "SKY_S08":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_7Hours_SkyCode.setText("비");
                break;
            case "SKY_S09":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_7Hours_SkyCode.setText("눈");
                break;
            case "SKY_S10":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_7Hours_SkyCode.setText("비/눈");
                break;
            case "SKY_S11":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_thunderbolt);
                tv_7Hours_SkyCode.setText("낙뢰");
                break;
            case "SKY_S12":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_storm);
                tv_7Hours_SkyCode.setText("뇌우");
                break;
            case "SKY_S13":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_storm_snow);
                tv_7Hours_SkyCode.setText("뇌우");
                break;
            case "SKY_S14":
                iv_7Hours_SkyCode.setImageResource(R.drawable.ic_storm_snow_rain);
                tv_7Hours_SkyCode.setText("뇌우");
                break;
            default:
                break;
        }
    }
    public void check10HoursSkyStatus(String skyCode) {
        boolean dayOrNight_10Hours; // T: Day, F: Night
        if (6 <= m10Hours_Integer && m10Hours_Integer < 18) {
            dayOrNight_10Hours = true;
        } else {
            dayOrNight_10Hours = false;
        }
        switch (skyCode) {
            case "SKY_S01":
                if (dayOrNight_10Hours == true) {
                    iv_10Hours_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                    tv_10Hours_SkyCode.setText("맑음");
                } else {
                    iv_10Hours_SkyCode.setImageResource(R.drawable.ic_clear_moon);
                    tv_10Hours_SkyCode.setText("맑음");
                }
                break;
            case "SKY_S02":
                if (dayOrNight_10Hours == true) {
                    iv_10Hours_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                    tv_10Hours_SkyCode.setText("구름조금");
                } else {
                    iv_10Hours_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_moon);
                    tv_10Hours_SkyCode.setText("구름조금");
                }
                break;
            case "SKY_S03":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_10Hours_SkyCode.setText("구름많음");
                break;
            case "SKY_S04":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_10Hours_SkyCode.setText("비");
                break;
            case "SKY_S05":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_10Hours_SkyCode.setText("눈");
                break;
            case "SKY_S06":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_10Hours_SkyCode.setText("비/눈");
                break;
            case "SKY_S07":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_10Hours_SkyCode.setText("흐림");
                break;
            case "SKY_S08":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_10Hours_SkyCode.setText("비");
                break;
            case "SKY_S09":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_10Hours_SkyCode.setText("눈");
                break;
            case "SKY_S10":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_10Hours_SkyCode.setText("비/눈");
                break;
            case "SKY_S11":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_thunderbolt);
                tv_10Hours_SkyCode.setText("낙뢰");
                break;
            case "SKY_S12":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_storm);
                tv_10Hours_SkyCode.setText("뇌우");
                break;
            case "SKY_S13":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_storm_snow);
                tv_10Hours_SkyCode.setText("뇌우");
                break;
            case "SKY_S14":
                iv_10Hours_SkyCode.setImageResource(R.drawable.ic_storm_snow_rain);
                tv_10Hours_SkyCode.setText("뇌우");
                break;
            default:
                break;
        }
    }
    public void checkWindDirection(String wdir) {
        // 풍향 8방위
        // N(북) / NE(북동) / E(동) / SE(남동) / S(남) / SW(남서) / W(서) / NW(북서)
        // N - 0.00 or 360.00, NE - 45.00, E - 90.00, SE - 135.00, S - 180.00, SW - 225.00, W - 270.00, NW - 315.00
        // N - 337.50 < wdir && wdir <= 22.50
        // NE - 22.50 < wdir && wdir <= 67.50
        // E - 67.50 < wdir && wdir <= 112.50
        // SE - 112.50 < wdir && wdir <= 157.50
        // S - 157.50 < wdir && wdir <= 202.50
        // SW - 202.50 < wdir && wdir <= 247.50
        // W - 247.50 < wdir && wdir <= 292.50
        // NW - 292.50 < wdir && wdir <= 337.50
        String wdir_Text = "";
        Log.d("현재 풍향", "현재 풍향: " + this.mForecastHourlyList.get(FORECAST_INDEX).getWind().getWdir());
        wdir_Current_Double = Double.parseDouble(wdir_Current);
        if (337.50 < wdir_Current_Double || (0 <= wdir_Current_Double && wdir_Current_Double <= 22.50)) {
            tv_Current_Wdir.setText("북");
            wdir_Text = "북";
        } else if (22.50 < wdir_Current_Double && wdir_Current_Double <= 67.50) {
            tv_Current_Wdir.setText("북동");
            wdir_Text = "북동";
        } else if (67.50 < wdir_Current_Double && wdir_Current_Double <= 112.50) {
            tv_Current_Wdir.setText("동");
            wdir_Text = "동";
        } else if (112.50 < wdir_Current_Double && wdir_Current_Double <= 157.50) {
            tv_Current_Wdir.setText("남동");
            wdir_Text = "남동";
        } else if (157.50 < wdir_Current_Double && wdir_Current_Double <= 202.50) {
            tv_Current_Wdir.setText("남");
            wdir_Text = "남";
        } else if (202.50 < wdir_Current_Double && wdir_Current_Double <= 247.50) {
            tv_Current_Wdir.setText("남서");
            wdir_Text = "남서";
        } else if (247.50 < wdir_Current_Double && wdir_Current_Double <= 292.50) {
            tv_Current_Wdir.setText("서");
            wdir_Text = "서";
        } else if (292.50 < wdir_Current_Double && wdir_Current_Double <= 337.50) {
            tv_Current_Wdir.setText("북서");
            wdir_Text = "북서";
        }
        Log.d("현재 풍향", "현재 풍향: " + wdir_Text);
    }
}