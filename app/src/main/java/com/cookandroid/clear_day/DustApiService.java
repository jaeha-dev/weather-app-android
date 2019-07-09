package com.cookandroid.clear_day;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DustApiService {
    // ArpltnInforInqireSvc(대기오염정보 조회 서비스): 각 측정소별 대기오염정보를 조회하기 위한 서비스로 기간별, 시도별 대기오염 정보와 통합대기환경지수 나쁨 이상 측정소 내역, 대기질(미세먼지/오존) 예보 통보 내역 등을 조회할 수 있다.
    // getMsrstnAcctoRltmMesureDnsty(측정소별 실시간 측정정보 조회): 측정소명과 측정데이터 기간(일, 한달, 3개월)으로 해당 측정소의 일반항목 측정정보를 제공하는 측정소별 실시간 측정정보 조회
    // MsrstnInfoInqireSvc(측정소 조회): 대기질 측정소 정보를 조회하기 위한 서비스로 TM 좌표 기반의 가까운 측정소 및 측정소 목록과 측정소의 정보를 조회할 수 있다.
    // getNearbyMsrstnList(근접측정소 목록 조회): TM 좌표를 이용하여 좌표 주변 측정소 정보와 측정정소와 좌표 간의 거리 정보를 제공하는 서비스

    public static final String BASEURL = "http://openapi.airkorea.or.kr/";
    public static final String APPKEY = "o%2BH4x4zMdl6wmajfE%2FsOduZ4wyJ9yLabsAS506QwX76BumSYRZoO1lheAY7cOUBVcr0hgIipIYTxdxTMQAAyLg%3D%3D";
    // http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?stationName=%EC%9D%98%EC%A0%95%EB%B6%801%EB%8F%99&dataTerm=month&pageNo=1&numOfRows=10&ServiceKey=o%2BH4x4zMdl6wmajfE%2FsOduZ4wyJ9yLabsAS506QwX76BumSYRZoO1lheAY7cOUBVcr0hgIipIYTxdxTMQAAyLg%3D%3D&ver=1.3&_returnType=json

    // 예보(날짜 입력 필수)
    // http://openapi.airkorea.or.kr/openapi/services/rest/ArpltnInforInqireSvc/getMinuDustFrcstDspth?searchDate=2018-06-01&ServiceKey=o%2BH4x4zMdl6wmajfE%2FsOduZ4wyJ9yLabsAS506QwX76BumSYRZoO1lheAY7cOUBVcr0hgIipIYTxdxTMQAAyLg%3D%3D

    @GET("/openapi/services/rest/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?ServiceKey=" + APPKEY + "&_returnType=json&ver=1.3&dataTerm=month")
    Observable<DustReport> getDustData(
            @Query("stationName") String stationName,
            @Query("pageNo") String pageNo,
            @Query("numOfRows") String numOfRows
    );

    @GET("/openapi/services/rest/MsrstnInfoInqireSvc/getNearbyMsrstnList?ServiceKey=" + APPKEY + "&_returnType=json")
    Observable<DustStationReport> getDustStationData(
            @Query("tmX") double tmX,
            @Query("tmY") double tmY,
            @Query("pageNo") String pageNo,
            @Query("numOfRows") String numOfRows
    );
}