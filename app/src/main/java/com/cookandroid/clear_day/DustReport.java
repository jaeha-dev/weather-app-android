package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DustReport {
    @SerializedName("list") @Expose private java.util.List<List> list = null;
    @SerializedName("parm") @Expose private Parm parm;
    @SerializedName("ArpltnInforInqireSvcVo") @Expose private ArpltnInforInqireSvcVo arpltnInforInqireSvcVo;
    @SerializedName("totalCount") @Expose private int totalCount;

    public java.util.List<List> getList() { return list; }
    public Parm getParm() { return parm; }
    public ArpltnInforInqireSvcVo getArpltnInforInqireSvcVo() { return arpltnInforInqireSvcVo; }
    public int getTotalCount() { return totalCount; }

    public class List {
        @SerializedName("_returnType") @Expose private String returnType;
        @SerializedName("coGrade") @Expose private String coGrade;
        @SerializedName("coValue") @Expose private String coValue;
        @SerializedName("dataTerm") @Expose private String dataTerm;
        @SerializedName("dataTime") @Expose private String dataTime;
        @SerializedName("khaiGrade") @Expose private String khaiGrade;
        @SerializedName("khaiValue") @Expose private String khaiValue;
        @SerializedName("mangName") @Expose private String mangName;
        @SerializedName("no2Grade") @Expose private String no2Grade;
        @SerializedName("no2Value") @Expose private String no2Value;
        @SerializedName("numOfRows") @Expose private String numOfRows;
        @SerializedName("o3Grade") @Expose private String o3Grade;
        @SerializedName("o3Value") @Expose private String o3Value;
        @SerializedName("pageNo") @Expose private String pageNo;
        @SerializedName("pm10Grade") @Expose private String pm10Grade;
        @SerializedName("pm10Grade1h") @Expose private String pm10Grade1h;
        @SerializedName("pm10Value") @Expose private String pm10Value;
        @SerializedName("pm10Value24") @Expose private String pm10Value24;
        @SerializedName("pm25Grade") @Expose private String pm25Grade;
        @SerializedName("pm25Grade1h") @Expose private String pm25Grade1h;
        @SerializedName("pm25Value") @Expose private String pm25Value;
        @SerializedName("pm25Value24") @Expose private String pm25Value24;
        @SerializedName("resultCode") @Expose private String resultCode;
        @SerializedName("resultMsg") @Expose private String resultMsg;
        @SerializedName("rnum") @Expose private int rnum;
        @SerializedName("serviceKey") @Expose private String serviceKey;
        @SerializedName("sidoName") @Expose private String sidoName;
        @SerializedName("so2Grade") @Expose private String so2Grade;
        @SerializedName("so2Value") @Expose private String so2Value;
        @SerializedName("stationCode") @Expose private String stationCode;
        @SerializedName("stationName") @Expose private String stationName;
        @SerializedName("totalCount") @Expose private String totalCount;
        @SerializedName("ver") @Expose private String ver;

        public String getReturnType() { return returnType; }
        public String getCoGrade() { return coGrade; }
        public String getCoValue() { return coValue; }
        public String getDataTerm() { return dataTerm; }
        public String getDataTime() { return dataTime; }
        public String getKhaiGrade() { return khaiGrade; }
        public String getKhaiValue() { return khaiValue; }
        public String getMangName() { return mangName; }
        public String getNo2Grade() { return no2Grade; }
        public String getNo2Value() { return no2Value; }
        public String getNumOfRows() { return numOfRows; }
        public String getO3Grade() { return o3Grade; }
        public String getO3Value() { return o3Value; }
        public String getPageNo() { return pageNo; }
        public String getPm10Grade() { return pm10Grade; }
        public String getPm10Grade1h() { return pm10Grade1h; }
        public String getPm10Value() { return pm10Value; }
        public String getPm10Value24() { return pm10Value24; }
        public String getPm25Grade() { return pm25Grade; }
        public String getPm25Grade1h() { return pm25Grade1h; }
        public String getPm25Value() { return pm25Value; }
        public String getPm25Value24() { return pm25Value24; }
        public String getResultCode() { return resultCode; }
        public String getResultMsg() { return resultMsg; }
        public int getRnum() { return rnum; }
        public String getServiceKey() { return serviceKey; }
        public String getSidoName() { return sidoName; }
        public String getSo2Grade() { return so2Grade; }
        public String getSo2Value() { return so2Value; }
        public String getStationCode() { return stationCode; }
        public String getStationName() { return stationName; }
        public String getTotalCount() { return totalCount; }
        public String getVer() { return ver; }
    }

    public class Parm {
        @SerializedName("_returnType") @Expose private String returnType;
        @SerializedName("coGrade") @Expose private String coGrade;
        @SerializedName("coValue") @Expose private String coValue;
        @SerializedName("dataTerm") @Expose private String dataTerm;
        @SerializedName("dataTime") @Expose private String dataTime;
        @SerializedName("khaiGrade") @Expose private String khaiGrade;
        @SerializedName("khaiValue") @Expose private String khaiValue;
        @SerializedName("mangName") @Expose private String mangName;
        @SerializedName("no2Grade") @Expose private String no2Grade;
        @SerializedName("no2Value") @Expose private String no2Value;
        @SerializedName("numOfRows") @Expose private String numOfRows;
        @SerializedName("o3Grade") @Expose private String o3Grade;
        @SerializedName("o3Value") @Expose private String o3Value;
        @SerializedName("pageNo") @Expose private String pageNo;
        @SerializedName("pm10Grade") @Expose private String pm10Grade;
        @SerializedName("pm10Grade1h") @Expose private String pm10Grade1h;
        @SerializedName("pm10Value") @Expose private String pm10Value;
        @SerializedName("pm10Value24") @Expose private String pm10Value24;
        @SerializedName("pm25Grade") @Expose private String pm25Grade;
        @SerializedName("pm25Grade1h") @Expose private String pm25Grade1h;
        @SerializedName("pm25Value") @Expose private String pm25Value;
        @SerializedName("pm25Value24") @Expose private String pm25Value24;
        @SerializedName("resultCode") @Expose private String resultCode;
        @SerializedName("resultMsg") @Expose private String resultMsg;
        @SerializedName("rnum") @Expose private int rnum;
        @SerializedName("serviceKey") @Expose private String serviceKey;
        @SerializedName("sidoName") @Expose private String sidoName;
        @SerializedName("so2Grade") @Expose private String so2Grade;
        @SerializedName("so2Value") @Expose private String so2Value;
        @SerializedName("stationCode") @Expose private String stationCode;
        @SerializedName("stationName") @Expose private String stationName;
        @SerializedName("totalCount") @Expose private String totalCount;
        @SerializedName("ver") @Expose private String ver;

        public String getReturnType() { return returnType; }
        public String getCoGrade() { return coGrade; }
        public String getCoValue() { return coValue; }
        public String getDataTerm() { return dataTerm; }
        public String getDataTime() { return dataTime; }
        public String getKhaiGrade() { return khaiGrade; }
        public String getKhaiValue() { return khaiValue; }
        public String getMangName() { return mangName; }
        public String getNo2Grade() { return no2Grade; }
        public String getNo2Value() { return no2Value; }
        public String getNumOfRows() { return numOfRows; }
        public String getO3Grade() { return o3Grade; }
        public String getO3Value() { return o3Value; }
        public String getPageNo() { return pageNo; }
        public String getPm10Grade() { return pm10Grade; }
        public String getPm10Grade1h() { return pm10Grade1h; }
        public String getPm10Value() { return pm10Value; }
        public String getPm10Value24() { return pm10Value24; }
        public String getPm25Grade() { return pm25Grade; }
        public String getPm25Grade1h() { return pm25Grade1h; }
        public String getPm25Value() { return pm25Value; }
        public String getPm25Value24() { return pm25Value24; }
        public String getResultCode() { return resultCode; }
        public String getResultMsg() { return resultMsg; }
        public int getRnum() { return rnum; }
        public String getServiceKey() { return serviceKey; }
        public String getSidoName() { return sidoName; }
        public String getSo2Grade() { return so2Grade; }
        public String getSo2Value() { return so2Value; }
        public String getStationCode() { return stationCode; }
        public String getStationName() { return stationName; }
        public String getTotalCount() { return totalCount; }
        public String getVer() { return ver; }
    }
    public class ArpltnInforInqireSvcVo {
        @SerializedName("_returnType") @Expose private String returnType;
        @SerializedName("coGrade") @Expose private String coGrade;
        @SerializedName("coValue") @Expose private String coValue;
        @SerializedName("dataTerm") @Expose private String dataTerm;
        @SerializedName("dataTime") @Expose private String dataTime;
        @SerializedName("khaiGrade") @Expose private String khaiGrade;
        @SerializedName("khaiValue") @Expose private String khaiValue;
        @SerializedName("mangName") @Expose private String mangName;
        @SerializedName("no2Grade") @Expose private String no2Grade;
        @SerializedName("no2Value") @Expose private String no2Value;
        @SerializedName("numOfRows") @Expose private String numOfRows;
        @SerializedName("o3Grade") @Expose private String o3Grade;
        @SerializedName("o3Value") @Expose private String o3Value;
        @SerializedName("pageNo") @Expose private String pageNo;
        @SerializedName("pm10Grade") @Expose private String pm10Grade;
        @SerializedName("pm10Grade1h") @Expose private String pm10Grade1h;
        @SerializedName("pm10Value") @Expose private String pm10Value;
        @SerializedName("pm10Value24") @Expose private String pm10Value24;
        @SerializedName("pm25Grade") @Expose private String pm25Grade;
        @SerializedName("pm25Grade1h") @Expose private String pm25Grade1h;
        @SerializedName("pm25Value") @Expose private String pm25Value;
        @SerializedName("pm25Value24") @Expose private String pm25Value24;
        @SerializedName("resultCode") @Expose private String resultCode;
        @SerializedName("resultMsg") @Expose private String resultMsg;
        @SerializedName("rnum") @Expose private int rnum;
        @SerializedName("serviceKey") @Expose private String serviceKey;
        @SerializedName("sidoName") @Expose private String sidoName;
        @SerializedName("so2Grade") @Expose private String so2Grade;
        @SerializedName("so2Value") @Expose private String so2Value;
        @SerializedName("stationCode") @Expose private String stationCode;
        @SerializedName("stationName") @Expose private String stationName;
        @SerializedName("totalCount") @Expose private String totalCount;
        @SerializedName("ver") @Expose private String ver;

        public String getReturnType() { return returnType; }
        public String getCoGrade() { return coGrade; }
        public String getCoValue() { return coValue; }
        public String getDataTerm() { return dataTerm; }
        public String getDataTime() { return dataTime; }
        public String getKhaiGrade() { return khaiGrade; }
        public String getKhaiValue() { return khaiValue; }
        public String getMangName() { return mangName; }
        public String getNo2Grade() { return no2Grade; }
        public String getNo2Value() { return no2Value; }
        public String getNumOfRows() { return numOfRows; }
        public String getO3Grade() { return o3Grade; }
        public String getO3Value() { return o3Value; }
        public String getPageNo() { return pageNo; }
        public String getPm10Grade() { return pm10Grade; }
        public String getPm10Grade1h() { return pm10Grade1h; }
        public String getPm10Value() { return pm10Value; }
        public String getPm10Value24() { return pm10Value24; }
        public String getPm25Grade() { return pm25Grade; }
        public String getPm25Grade1h() { return pm25Grade1h; }
        public String getPm25Value() { return pm25Value; }
        public String getPm25Value24() { return pm25Value24; }
        public String getResultCode() { return resultCode; }
        public String getResultMsg() { return resultMsg; }
        public int getRnum() { return rnum; }
        public String getServiceKey() { return serviceKey; }
        public String getSidoName() { return sidoName; }
        public String getSo2Grade() { return so2Grade; }
        public String getSo2Value() { return so2Value; }
        public String getStationCode() { return stationCode; }
        public String getStationName() { return stationName; }
        public String getTotalCount() { return totalCount; }
        public String getVer() { return ver; }
    }
}