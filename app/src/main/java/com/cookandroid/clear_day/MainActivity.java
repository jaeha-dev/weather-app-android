package com.cookandroid.clear_day;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // 마지막으로 뒤로가기 버튼이 터치된 시간
    private long lastTimeBackPressed;
    // 위도, 경도
    protected static double mLatitude;
    protected static double mLongitude;
    // 사용자 주소(도, 시, 구, 군, 동)
    protected static String mDo;
    protected static String mSi;
    protected static String mGu;
    protected static String mGun;
    protected static String mDong;
    protected static String location_1;
    protected static String location_2;
    // 현재 시각, 4시간, 7시간, 10시간 후 시각 및 낮/밤 플래그
    protected static int mHour_Integer;
    protected static int m4Hours_Integer;
    protected static int m7Hours_Integer;
    protected static int m10Hours_Integer;
    protected static boolean dayOrNight; // T: Day, F: Night
    // 위치정보 사용권한
    protected boolean isPermission = false;
    // 위치정보
    protected GPSInfo gps;
    // 기상정보
    protected static String forecastStation;
    protected static String forecastTime;
    protected static String skyCode_Current;
    protected static String skyCode_4Hours;
    protected static String skyCode_7Hours;
    protected static String skyCode_10Hours;
    protected static String tc_Current;
    protected static String tc_4Hours;
    protected static String tc_7Hours;
    protected static String tc_10Hours;
    protected static String tc_Max;
    protected static String tc_Min;
    protected static String wdir_Current;
    protected static String wspd_Current;
    protected static String humidity_Current;
    protected static String sinceOntime_Rain_Current;
    protected static String prob_4Hours;
    protected static String prob_7Hours;
    protected static String prob_10Hours;
    protected static String skyCode_Yesterday;
    protected static String skyCode_Today;
    protected static String skyCode_Tomorrow;
    protected static String tc_Max_Yesterday;
    protected static String tc_Min_Yesterday;
    protected static String tc_Max_Today;
    protected static String tc_Min_Today;
    protected static String tc_Max_Tomorrow;
    protected static String tc_Min_Tomorrow;
    protected static int tc_Current_Integer;
    protected static int tc_4Hours_Integer;
    protected static int tc_7Hours_Integer;
    protected static int tc_10Hours_Integer;
    protected static int tc_Max_Integer;
    protected static int tc_Min_Integer;
    protected static double wdir_Current_Double;
    protected static int wspd_Current_Integer;
    protected static int humidity_Current_Integer;
    protected static int sinceOntime_Rain_Current_Integer;
    protected static int prob_4Hours_Integer;
    protected static int prob_7Hours_Integer;
    protected static int prob_10Hours_Integer;
    protected static int tc_Max_Yesterday_Integer;
    protected static int tc_Min_Yesterday_Integer;
    protected static int tc_Max_Today_Integer;
    protected static int tc_Min_Today_Integer;
    protected static int tc_Max_Tomorrow_Integer;
    protected static int tc_Min_Tomorrow_Integer;
    // 대기정보
    protected static String dustStation; // 관측소명
    protected static String dustTime; // 관측시간
    protected static String value_Khai; // 통합대기환경지수
    protected static String value_PM10; // 미세먼지 지수(PM10)
    protected static String value_PM25; // 초미세먼지 지수(PM2.5)
    protected static String value_O3; // 오존지수
    protected static String value_CO; // 일산화탄소 지수
    protected static String value_NO2; // 이산화질소 지수
    protected static String value_SO2; // 아황산가스 지수
    protected static String status_Khai; // 통합대기환경지수 상태(좋음, 보통, 나쁨, 매우나쁨)
    protected static String status_PM10; // 미세먼지 상태(좋음, 보통, 나쁨, 매우나쁨)
    protected static String status_PM25; // 초미세먼지 상태(좋음, 보통, 나쁨, 매우나쁨)
    protected static String status_O3; // 오존지수 상태(좋음, 보통, 나쁨, 매우나쁨)
    protected static String status_CO; // 일산화탄소 상태(좋음, 보통, 나쁨, 매우나쁨)
    protected static String status_NO2; // 이산화질소 상태(좋음, 보통, 나쁨, 매우나쁨)
    protected static String status_SO2; // 아황산가스 상태(좋음, 보통, 나쁨, 매우나쁨)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_forecast:
                                selectedFragment = ForecastFragment.newInstance();
                                break;
                            case R.id.navigation_dust:
                                selectedFragment = DustFragment.newInstance();
                                break;
                            case R.id.navigation_report:
                                selectedFragment = ReportFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        // 시간 데이터 받기
        this.getTime();
        // 위치 데이터
        this.gps = new GPSInfo(this);
        this.callPermission();
        this.getAddress();

        // 첫 실행 시, 출력될 프래그먼트 지정.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, ForecastFragment.newInstance());
        transaction.commit();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(this.findViewById(android.R.id.content), permissions[i] + " 권한이 승인됨", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(this.findViewById(android.R.id.content), permissions[i] + " 권한이 승인되지 않음", Snackbar.LENGTH_LONG).show();
                }
            }
        }
    }
    @Override
    public void onBackPressed() {
        // 뒤로가기 버튼 연속 터치 시, 종료
        if(System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한번 더 터치하면 종료됩니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();
    }
    public void getAddress() {
        if(isPermission == false) {
            // 위치정보 사용 권한
            callPermission();
            return;
        }
        if (gps.isGetLocation()) {
            mLatitude = gps.getLatitude();
            mLongitude = gps.getLongitude();
            // 지오코더
            Geocoder gCoder = new Geocoder(this, Locale.KOREA);
            List<Address> addr = null;
            try {
                addr = gCoder.getFromLocation(mLatitude,mLongitude,1);
                // 설정한 데이터로 주소가 반환된 데이터가 있을 경우,
                if (addr != null && addr.size() > 0) {
                    // 영문 주소를 국문 주소로 변환
                    String currentLocationAddress = addr.get(0).getAddressLine(0);
                    Log.d("변환된 전체 주소", currentLocationAddress);
                    String si = addr.get(0).getLocality(); // 시
                    String gu = addr.get(0).getSubLocality(); // 구
                    if (si == null && gu != null) {
                        location_1 = gu;
                    } else if (si != null && gu == null) {
                        location_1 = si;
                    } else if (si != null && gu != null) {
                        location_1 = si + " " + gu;
                    } else {
                        location_1 = "주소 정보 없음";
                    }
                    location_2 = addr.get(0).getThoroughfare();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addr != null) {
                if (addr.size() == 0) {
                    Toast.makeText(this,"주소 정보 없음", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            // GPS 를 사용할수 없으므로
            // gps.showSettingsAlert();
        }
        this.callPermission();
    }
    private void callPermission() {
        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        };
        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            // Snackbar.make(this.findViewById(android.R.id.content), "위치정보 사용 권한 있음", Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(this.findViewById(android.R.id.content), "위치정보 사용 권한 없음", Snackbar.LENGTH_LONG).show();
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Snackbar.make(this.findViewById(android.R.id.content), "위치정보 사용 권한 설명 필요함", Snackbar.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
        isPermission = true;
    }
    public void getTime() {
        // 현재 날짜 및 시간
        // Date dt = new Date();
        // Log.d("DATE", dt.toString());
        // SimpleDateFormat full_sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a");
        // Log.d("DATE", full_sdf.format(dt).toString());
        // SimpleDateFormat sdf = new SimpleDateFormat("HH");
        // Log.d("DATE", sdf.format(dt).toString() + "시");
        Calendar calendar = Calendar.getInstance();
//        Log.d("캘린더 시간: ", String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
        String mHour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        mHour_Integer = Integer.parseInt(mHour);
        Log.d("캘린더 시간: ", mHour + "시");
    }
    public static boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isStringInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
