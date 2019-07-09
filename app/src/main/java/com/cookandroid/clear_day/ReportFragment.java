package com.cookandroid.clear_day;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.cookandroid.clear_day.MainActivity.*;

public class ReportFragment extends Fragment {
    private static final String TAG = "report_data";

    private ImageView iv_Yesterday_SkyCode, iv_Today_SkyCode, iv_Tomorrow_SkyCode, iv_PM10_Status, iv_Khai_Status, iv_PM25_Status;
    private TextView tv_Location_Report_1, tv_Location_Report_2;
    private TextView tv_Observation_Location_Forecast, tv_Observation_Time_Forecast, tv_Yesterday_SkyCode, tv_Today_SkyCode, tv_Tomorrow_SkyCode;
    private TextView tv_Yesterday_Tmax, tv_Yesterday_Tmin, tv_Today_Report_Tmax, tv_Today_Report_Tmin, tv_Tomorrow_Tmax, tv_Tomorrow_Tmin;
    private TextView tv_Observation_Location_Dust, tv_Observation_Time_Dust;
    private TextView tv_PM10_Status, tv_Khai_Status, tv_PM25_Status, tv_PM10_Report_Value, tv_Khai_Report_Value, tv_PM25_Report_Value;

    public static ReportFragment newInstance() {
        ReportFragment fragment = new ReportFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_report, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv_Yesterday_SkyCode = (ImageView) getView().findViewById(R.id.iv_Yesterday_SkyCode);
        iv_Today_SkyCode = (ImageView) getView().findViewById(R.id.iv_Today_SkyCode);
        iv_Tomorrow_SkyCode = (ImageView) getView().findViewById(R.id.iv_Tomorrow_SkyCode);
        iv_PM10_Status = (ImageView) getView().findViewById(R.id.iv_PM10_Status);
        iv_Khai_Status = (ImageView) getView().findViewById(R.id.iv_Khai_Status);
        iv_PM25_Status = (ImageView) getView().findViewById(R.id.iv_PM25_Status);
        tv_Location_Report_1 = (TextView) getView().findViewById(R.id.tv_Location_Report_1);
        tv_Location_Report_2 = (TextView) getView().findViewById(R.id.tv_Location_Report_2);
        tv_Observation_Location_Forecast = (TextView) getView().findViewById(R.id.tv_Observation_Location_Forecast);
        tv_Observation_Time_Forecast = (TextView) getView().findViewById(R.id.tv_Observation_Time_Forecast);
        tv_Yesterday_SkyCode = (TextView) getView().findViewById(R.id.tv_Yesterday_SkyCode);
        tv_Today_SkyCode = (TextView) getView().findViewById(R.id.tv_Today_SkyCode);
        tv_Tomorrow_SkyCode = (TextView) getView().findViewById(R.id.tv_Tomorrow_SkyCode);
        tv_Yesterday_Tmax = (TextView) getView().findViewById(R.id.tv_Yesterday_Tmax);
        tv_Yesterday_Tmin = (TextView) getView().findViewById(R.id.tv_Yesterday_Tmin);
        tv_Today_Report_Tmax = (TextView) getView().findViewById(R.id.tv_Today_Report_Tmax);
        tv_Today_Report_Tmin = (TextView) getView().findViewById(R.id.tv_Today_Report_Tmin);
        tv_Tomorrow_Tmax = (TextView) getView().findViewById(R.id.tv_Tomorrow_Tmax);
        tv_Tomorrow_Tmin = (TextView) getView().findViewById(R.id.tv_Tomorrow_Tmin);
        tv_Observation_Location_Dust = (TextView) getView().findViewById(R.id.tv_Observation_Location_Dust);
        tv_Observation_Time_Dust = (TextView) getView().findViewById(R.id.tv_Observation_Time_Dust);
        tv_PM10_Status = (TextView) getView().findViewById(R.id.tv_PM10_Status);
        tv_Khai_Status = (TextView) getView().findViewById(R.id.tv_Khai_Status);
        tv_PM25_Status = (TextView) getView().findViewById(R.id.tv_PM25_Status);
        tv_PM10_Report_Value = (TextView) getView().findViewById(R.id.tv_PM10_Report_Value);
        tv_Khai_Report_Value = (TextView) getView().findViewById(R.id.tv_Khai_Report_Value);
        tv_PM25_Report_Value = (TextView) getView().findViewById(R.id.tv_PM25_Report_Value);
        // 사용자 위치정보 출력
        tv_Location_Report_1.setText(location_1);
        tv_Location_Report_2.setText(location_2);
        // 정보 설정하기
        this.setYesterDayForecastData();
        this.setToDayForecastData();
        this.setTomorrowForecastData();
        this.setStation();
        this.setDustData();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void setStation() {
        tv_Observation_Location_Forecast.setText(forecastStation);
        tv_Observation_Location_Dust.setText(dustStation);
        tv_Observation_Time_Forecast.setText(forecastTime);
        tv_Observation_Time_Dust.setText(dustTime);
    }

    public void setYesterDayForecastData() {
        switch (skyCode_Yesterday) {
            case "SKY_Y01":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                tv_Yesterday_SkyCode.setText("맑음");
                break;
            case "SKY_Y02":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                tv_Yesterday_SkyCode.setText("구름조금");
                break;
            case "SKY_Y03":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Yesterday_SkyCode.setText("구름많음");
                break;
            case "SKY_Y04":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Yesterday_SkyCode.setText("흐림");
                break;
            case "SKY_Y05":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_Yesterday_SkyCode.setText("비");
                break;
            case "SKY_Y06":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_Yesterday_SkyCode.setText("눈");
                break;
            case "SKY_Y07":
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_Yesterday_SkyCode.setText("비/눈");
                break;
            default:
                iv_Yesterday_SkyCode.setImageResource(R.drawable.ic_unknown);
                tv_Yesterday_SkyCode.setText("알수없음");
                break;
        }
        tv_Yesterday_Tmax.setText(String.valueOf(tc_Max_Yesterday_Integer));
        tv_Yesterday_Tmin.setText(String.valueOf(tc_Min_Yesterday_Integer));
    }
    public void setToDayForecastData() {
        switch (skyCode_Today) {
            case "SKY_D01":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                tv_Today_SkyCode.setText("맑음");
                break;
            case "SKY_D02":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                tv_Today_SkyCode.setText("구름조금");
                break;
            case "SKY_D03":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Today_SkyCode.setText("구름많음");
                break;
            case "SKY_D04":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Today_SkyCode.setText("흐림");
                break;
            case "SKY_D05":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_Today_SkyCode.setText("비");
                break;
            case "SKY_D06":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_Today_SkyCode.setText("눈");
                break;
            case "SKY_D07":
                iv_Today_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_Today_SkyCode.setText("비/눈");
                break;
            default:
                iv_Today_SkyCode.setImageResource(R.drawable.ic_unknown);
                tv_Today_SkyCode.setText("알수없음");
                break;
        }
        tv_Today_Report_Tmax.setText(String.valueOf(tc_Max_Today_Integer));
        tv_Today_Report_Tmin.setText(String.valueOf(tc_Min_Yesterday_Integer));
    }
    public void setTomorrowForecastData() {
        switch (skyCode_Tomorrow) {
            case "SKY_M01":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_clear_sun);
                tv_Tomorrow_SkyCode.setText("맑음");
                break;
            case "SKY_M02":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_partly_cloudy_sun);
                tv_Tomorrow_SkyCode.setText("구름조금");
                break;
            case "SKY_M03":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Tomorrow_SkyCode.setText("구름많음");
                break;
            case "SKY_M04":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_mostly_cloudy);
                tv_Tomorrow_SkyCode.setText("흐림");
                break;
            case "SKY_M05":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_rain);
                tv_Tomorrow_SkyCode.setText("비");
                break;
            case "SKY_M06":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_snow);
                tv_Tomorrow_SkyCode.setText("눈");
                break;
            case "SKY_M07":
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_snow_rain);
                tv_Tomorrow_SkyCode.setText("비/눈");
                break;
            default:
                iv_Tomorrow_SkyCode.setImageResource(R.drawable.ic_unknown);
                tv_Tomorrow_SkyCode.setText("알수없음");
                break;
        }
        tv_Tomorrow_Tmax.setText(String.valueOf(tc_Max_Tomorrow_Integer));
        tv_Tomorrow_Tmin.setText(String.valueOf(tc_Min_Tomorrow_Integer));
    }

    public void setDustData() {
        if(status_Khai.equals("매우좋음")) {
            iv_Khai_Status.setImageResource(R.drawable.ic_dust_level1);
            tv_Khai_Status.setText("매우좋음");
        } else if (status_Khai.equals("좋음")) {
            iv_Khai_Status.setImageResource(R.drawable.ic_dust_level2);
            tv_Khai_Status.setText("좋음");
        } else if (status_Khai.equals("보통")) {
            iv_Khai_Status.setImageResource(R.drawable.ic_dust_level3);
            tv_Khai_Status.setText("보통");
        } else if (status_Khai.equals("나쁨")) {
            iv_Khai_Status.setImageResource(R.drawable.ic_dust_level4);
            tv_Khai_Status.setText("나쁨");
        } else if (status_Khai.equals("매우나쁨")) {
            iv_Khai_Status.setImageResource(R.drawable.ic_dust_level5);
            tv_Khai_Status.setText("매우나쁨");
        } else {
            iv_Khai_Status.setImageResource(R.drawable.ic_unknown);
            tv_Khai_Status.setText("알수없음");
        }

        if(status_PM10.equals("좋음")) {
            iv_PM10_Status.setImageResource(R.drawable.ic_dust_level2);
            tv_PM10_Status.setText("좋음");
        } else if (status_Khai.equals("보통")) {
            iv_PM10_Status.setImageResource(R.drawable.ic_dust_level3);
            tv_PM10_Status.setText("보통");
        } else if (status_Khai.equals("나쁨")) {
            iv_PM10_Status.setImageResource(R.drawable.ic_dust_level4);
            tv_PM10_Status.setText("나쁨");
        } else if (status_Khai.equals("매우나쁨")) {
            iv_PM10_Status.setImageResource(R.drawable.ic_dust_level5);
            tv_PM10_Status.setText("매우나쁨");
        } else {
            iv_PM10_Status.setImageResource(R.drawable.ic_unknown);
            tv_PM10_Status.setText("알수없음");
        }

        if(status_PM25.equals("좋음")) {
            iv_PM25_Status.setImageResource(R.drawable.ic_dust_level2);
            tv_PM25_Status.setText("좋음");
        } else if (status_Khai.equals("보통")) {
            iv_PM25_Status.setImageResource(R.drawable.ic_dust_level3);
            tv_PM25_Status.setText("보통");
        } else if (status_Khai.equals("나쁨")) {
            iv_PM25_Status.setImageResource(R.drawable.ic_dust_level4);
            tv_PM25_Status.setText("나쁨");
        } else if (status_Khai.equals("매우나쁨")) {
            iv_PM25_Status.setImageResource(R.drawable.ic_dust_level5);
            tv_PM25_Status.setText("매우나쁨");
        } else {
            iv_PM25_Status.setImageResource(R.drawable.ic_unknown);
            tv_PM25_Status.setText("알수없음");
        }

        tv_Khai_Report_Value.setText(value_Khai);
        tv_PM10_Report_Value.setText(value_PM10);
        tv_PM25_Report_Value.setText(value_PM25);
    }
}
