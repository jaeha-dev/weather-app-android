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

import static com.cookandroid.clear_day.DustApiService.BASEURL;
import static com.cookandroid.clear_day.MainActivity.*;

public class DustFragment extends Fragment {
    // 프래그먼트는 getActivity(), getView(), getArguments() 등을 사용해야 한다.
    // Context를 보내려면 this가 아닌 getActivity() 또는 getContext()

    private static final String TAG = "dust_data";
    private static final int DUST_INDEX = 0;
    private CompositeDisposable mCompositeDisposableDust;
    private ArrayList<DustStationReport.List> mDustStationList;
    private ArrayList<DustReport.List> mDustList;
    private double tmX, tmY;

    private ImageView iv_Current_Dust, iv_Current_CO, iv_Current_NO2, iv_Current_SO2;
    private TextView tv_Location_Dust_1, tv_Location_Dust_2, tv_Current_Dust, tv_PM10_Value, tv_PM25_Value, tv_O3_Value, tv_CO_Value, tv_NO2_Value, tv_SO2_Value;

    public static DustFragment newInstance() {
        DustFragment fragment = new DustFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_dust, container, false);
        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iv_Current_Dust = (ImageView) getView().findViewById(R.id.iv_Current_Dust);
        iv_Current_CO = (ImageView) getView().findViewById(R.id.iv_Current_CO);
        iv_Current_NO2 = (ImageView) getView().findViewById(R.id.iv_Current_NO2);
        iv_Current_SO2 = (ImageView) getView().findViewById(R.id.iv_Current_SO2);
        tv_Location_Dust_1 = (TextView) getView().findViewById(R.id.tv_Location_Dust_1);
        tv_Location_Dust_2 = (TextView) getView().findViewById(R.id.tv_Location_Dust_2);
        tv_Current_Dust = (TextView) getView().findViewById(R.id.tv_Current_Dust);
        tv_PM10_Value = (TextView) getView().findViewById(R.id.tv_PM10_Value);
        tv_PM25_Value = (TextView) getView().findViewById(R.id.tv_PM25_Value);
        tv_O3_Value = (TextView) getView().findViewById(R.id.tv_O3_Value);
        tv_CO_Value = (TextView) getView().findViewById(R.id.tv_CO_Value);
        tv_NO2_Value = (TextView) getView().findViewById(R.id.tv_NO2_Value);
        tv_SO2_Value = (TextView) getView().findViewById(R.id.tv_SO2_Value);
        // 사용자 위치정보 출력
        tv_Location_Dust_1.setText(location_1);
        tv_Location_Dust_2.setText(location_2);
        // 대기 정보 받아오기
        mCompositeDisposableDust = new CompositeDisposable();
        this.getStation(mLatitude, mLongitude);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mCompositeDisposableDust.clear();
    }

    public void getStation(double lat, double lon) {
        if (lat != 0 && lon != 0) {
            GeoPoint in_pt = new GeoPoint(lon, lat);
            System.out.println("geo in : xGeo=" + in_pt.getX() + ", yGeo=" + in_pt.getY());
            GeoPoint tm_pt = GeoTrans.convert(GeoTrans.GEO, GeoTrans.TM, in_pt);
            System.out.println("tm : xTM=" + tm_pt.getX() + ", yTM=" + tm_pt.getY());
            this.tmX = tm_pt.getX();
            this.tmY = tm_pt.getY();
            this.getDustStation(tmY, tmX);
        } else {
            Toast.makeText(getContext(), "잘못된 좌표 값.", Toast.LENGTH_SHORT).show();
        }
    }
    public void getDustStation(double yGrid, double xGrid) {
        DustApiService dustApiService = new Retrofit.Builder()
                .baseUrl(BASEURL)
                //.client(httpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DustApiService.class);
        mCompositeDisposableDust.add(dustApiService.getDustStationData(xGrid, yGrid, String.valueOf("1"), String.valueOf("10"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<DustStationReport>() {
                    @Override
                    public void onNext(@NonNull DustStationReport dustStationReport) {
                        ResponseDustStation(dustStationReport);
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
    public void getDust(String address) {
        DustApiService dustApiService = new Retrofit.Builder()
                .baseUrl(BASEURL)
                //.client(httpClient.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DustApiService.class);
        mCompositeDisposableDust.add(dustApiService.getDustData(address, String.valueOf("1"), String.valueOf("10"))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<DustReport>() {
                    @Override
                    public void onNext(@NonNull DustReport dustReport) {
                        ResponseDust(dustReport);
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
    public void ResponseDustStation(DustStationReport dustStationReport) {
        mDustStationList = new ArrayList<>(dustStationReport.getList());
        Log.d("측정소", "가까운 측정소 이름: " + mDustStationList.get(DUST_INDEX).getStationName());
        this.setDustStationData();
        this.getDust(dustStation);
    }
    public void ResponseDust(DustReport dustReport) {
        mDustList = new ArrayList<>(dustReport.getList());
        Log.d("미세먼지", "미세먼지 농도: " + mDustList.get(DUST_INDEX).getPm10Value());
        // 0: 현재 시간 수치, 1: 1시간 전 수치, 2: 2시간 전 수치
        this.setDustData(DUST_INDEX);
    }
    public void handleError(Throwable error) {
        Toast.makeText(getContext(), "Error " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }

    public void setDustStationData() {
        // 관측소
        dustStation = mDustStationList.get(DUST_INDEX).getStationName();
    }
    public void setDustData(int index) {
        // 관측시간
        String tempStr = mDustList.get(DUST_INDEX).getDataTime();
        dustTime = tempStr.substring(11, 16);

        // 대기 정보
        value_Khai = mDustList.get(index).getKhaiValue();
        value_PM10 = mDustList.get(index).getPm10Value();
        value_PM25 = mDustList.get(index).getPm25Value();
        value_O3 = mDustList.get(index).getO3Value();
        value_CO = mDustList.get(index).getCoValue();
        value_NO2 = mDustList.get(index).getNo2Value();
        value_SO2 = mDustList.get(index).getSo2Value();

        if(isStringInteger(value_Khai)) {
            status_Khai = this.checkKhai(value_Khai);
        } else {
            status_Khai = "알수없음";
        }
        if(isStringInteger(value_PM10)) {
            status_PM10 = this.checkPM10(value_PM10);
        } else {
            status_PM10 = "알수없음";
        }
        if(isStringInteger(value_PM25)) {
            status_PM25 = this.checkPM25(value_PM25);
        } else {
            status_PM25 = "알수없음";
        }
        if(isStringDouble(value_O3)) {
            status_O3 = this.checkO3(value_O3);
        } else {
            status_O3 = "알수없음";
        }
        if(isStringDouble(value_CO)) {
            status_CO = this.checkCO(value_CO);
        } else {
            status_CO = "알수없음";
        }
        if(isStringDouble(value_NO2)) {
            status_NO2 = this.checkNO2(value_NO2);
        } else {
            status_NO2 = "알수없음";
        }
        if(isStringDouble(value_SO2)) {
            status_SO2 = this.checkSO2(value_SO2);
        } else {
            status_SO2 = "알수없음";
        }

        if (status_PM10.equals("좋음") && (status_PM25.equals("좋음"))) {
            iv_Current_Dust.setImageResource(R.drawable.ic_dust_level1);
            tv_Current_Dust.setText("매우좋음");
        } else if (status_PM10.equals("좋음")) {
            iv_Current_Dust.setImageResource(R.drawable.ic_dust_level2);
            tv_Current_Dust.setText("좋음");
        } else if (status_PM10.equals("보통")) {
            iv_Current_Dust.setImageResource(R.drawable.ic_dust_level3);
            tv_Current_Dust.setText("보통");
        } else if (status_PM10.equals("나쁨")) {
            iv_Current_Dust.setImageResource(R.drawable.ic_dust_level4);
            tv_Current_Dust.setText("나쁨");
        } else if (status_PM10.equals("매우나쁨")) {
            iv_Current_Dust.setImageResource(R.drawable.ic_dust_level5);
            tv_Current_Dust.setText("매우나쁨");
        } else {
            iv_Current_Dust.setImageResource(R.drawable.ic_unknown);
            tv_Current_Dust.setText("알수없음");
        }

        if (status_CO.equals("좋음")) {
            iv_Current_CO.setImageResource(R.drawable.ic_dust_level2);
        } else if (status_CO.equals("보통")) {
            iv_Current_CO.setImageResource(R.drawable.ic_dust_level3);
        } else if (status_CO.equals("나쁨")) {
            iv_Current_CO.setImageResource(R.drawable.ic_dust_level4);
        } else if (status_CO.equals("매우나쁨")) {
            iv_Current_CO.setImageResource(R.drawable.ic_dust_level5);
        } else {
            iv_Current_CO.setImageResource(R.drawable.ic_unknown);
        }
        if (status_NO2.equals("좋음")) {
            iv_Current_NO2.setImageResource(R.drawable.ic_dust_level2);
        } else if (status_NO2.equals("보통")) {
            iv_Current_NO2.setImageResource(R.drawable.ic_dust_level3);
        } else if (status_NO2.equals("나쁨")) {
            iv_Current_NO2.setImageResource(R.drawable.ic_dust_level4);
        } else if (status_NO2.equals("매우나쁨")) {
            iv_Current_NO2.setImageResource(R.drawable.ic_dust_level5);
        } else {
            iv_Current_NO2.setImageResource(R.drawable.ic_unknown);
        }
        if (status_SO2.equals("좋음")) {
            iv_Current_SO2.setImageResource(R.drawable.ic_dust_level2);
        } else if (status_SO2.equals("보통")) {
            iv_Current_SO2.setImageResource(R.drawable.ic_dust_level3);
        } else if (status_SO2.equals("나쁨")) {
            iv_Current_SO2.setImageResource(R.drawable.ic_dust_level4);
        } else if (status_SO2.equals("매우나쁨")) {
            iv_Current_SO2.setImageResource(R.drawable.ic_dust_level5);
        } else {
            iv_Current_SO2.setImageResource(R.drawable.ic_unknown);
        }
    }
    public String checkKhai(String value) {
        String data = "";
        int value_Khai = Integer.parseInt(value);
        if (0 <= value_Khai && value_Khai <= 25) {
            data = "매우좋음";
        } else if (25 < value_Khai && value_Khai <= 50) {
            data = "좋음";
        } else if (50 < value_Khai && value_Khai <= 100) {
            data = "보통";
        } else if (100 < value_Khai && value_Khai <= 250) {
            data = "나쁨";
        } else if (250 < value_Khai) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        return data;
    }
    public String checkPM10(String value) {
        String data = "";
        int value_PM10 = Integer.parseInt(value);
        if (0 <= value_PM10 && value_PM10 <= 30) {
            data = "좋음";
        } else if (30 < value_PM10 && value_PM10 <= 80) {
            data = "보통";
        } else if (80 < value_PM10 && value_PM10 <= 150) {
            data = "나쁨";
        } else if (150 < value_PM10) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        tv_PM10_Value.setText(value);
        return data;
    }
    public String checkPM25(String value) {
        String data = "";
        int value_PM25 = Integer.parseInt(value);
        if (0 <= value_PM25 && value_PM25 <= 15) {
            data = "좋음";
        } else if (15 < value_PM25 && value_PM25 <= 35) {
            data = "보통";
        } else if (35 < value_PM25 && value_PM25 <= 75) {
            data = "나쁨";
        } else if (75 < value_PM25) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        tv_PM25_Value.setText(value);
        return data;
    }
    public String checkO3(String value) {
        String data = "";
        double value_O3 = Double.parseDouble(value);
        if (0 <= value_O3 && value_O3 <= 0.030) {
            data = "좋음";
        } else if (0.030 < value_O3 && value_O3 <= 0.090) {
            data = "보통";
        } else if (0.090 < value_O3 && value_O3 <= 0.150) {
            data = "나쁨";
        } else if (0.150 < value_O3) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        tv_O3_Value.setText(value);
        return data;
    }
    public String checkCO(String value) {
        String data = "";
        double value_CO = Double.parseDouble(value);
        if (0 <= value_CO && value_CO <= 2.000) {
            data = "좋음";
        } else if (2.000 < value_CO && value_CO <= 9.000) {
            data = "보통";
        } else if (9.000 < value_CO && value_CO <= 15.000) {
            data = "나쁨";
        } else if (15.000 < value_CO) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        tv_CO_Value.setText(value);
        return data;
    }
    public String checkNO2(String value) {
        String data = "";
        double value_NO2 = Double.parseDouble(value);
        if (0 <= value_NO2 && value_NO2 <= 0.030) {
            data = "좋음";
        } else if (0.030 < value_NO2 && value_NO2 <= 0.060) {
            data = "보통";
        } else if (0.060 < value_NO2 && value_NO2 <= 0.200) {
            data = "나쁨";
        } else if (0.200 < value_NO2) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        tv_NO2_Value.setText(value);
        return data;
    }
    public String checkSO2(String value) {
        String data = "";
        double value_SO2 = Double.parseDouble(value);
        if (0 <= value_SO2 && value_SO2 <= 0.020) {
            data = "좋음";
        } else if (0.020 < value_SO2 && value_SO2 <= 0.050) {
            data = "보통";
        } else if (0.050 < value_SO2 && value_SO2 <= 0.150) {
            data = "나쁨";
        } else if (0.150 < value_SO2) {
            data = "매우나쁨";
        } else {
            data = "알수없음";
        }
        tv_SO2_Value.setText(value);
        return data;
    }
}