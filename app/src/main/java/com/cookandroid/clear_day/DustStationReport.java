package com.cookandroid.clear_day;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DustStationReport {
    @SerializedName("MsrstnInfoInqireSvrVo") @Expose private MsrstnInfoInqireSvrVo msrstnInfoInqireSvrVo;
    @SerializedName("list") @Expose private java.util.List<List> list = null;
    @SerializedName("parm") @Expose private Parm parm;
    @SerializedName("totalCount") @Expose private int totalCount;

    public MsrstnInfoInqireSvrVo getMsrstnInfoInqireSvrVo() { return msrstnInfoInqireSvrVo; }
    public java.util.List<List> getList() { return list; }
    public Parm getParm() { return parm; }
    public int getTotalCount() { return totalCount; }

    public class List {
        @SerializedName("_returnType") @Expose private String returnType;
        @SerializedName("addr") @Expose private String addr;
        @SerializedName("districtNum") @Expose private String districtNum;
        @SerializedName("dmX") @Expose private String dmX;
        @SerializedName("dmY") @Expose private String dmY;
        @SerializedName("item") @Expose private String item;
        @SerializedName("mangName") @Expose private String mangName;
        @SerializedName("map") @Expose private String map;
        @SerializedName("numOfRows") @Expose private String numOfRows;
        @SerializedName("oper") @Expose private String oper;
        @SerializedName("pageNo") @Expose private String pageNo;
        @SerializedName("photo") @Expose private String photo;
        @SerializedName("resultCode") @Expose private String resultCode;
        @SerializedName("resultMsg") @Expose private String resultMsg;
        @SerializedName("rnum") @Expose private int rnum;
        @SerializedName("serviceKey") @Expose private String serviceKey;
        @SerializedName("sggName") @Expose private String sggName;
        @SerializedName("sidoName") @Expose private String sidoName;
        @SerializedName("stationCode") @Expose private String stationCode;
        @SerializedName("stationName") @Expose private String stationName;
        @SerializedName("tm") @Expose private double tm;
        @SerializedName("tmX") @Expose private String tmX;
        @SerializedName("tmY") @Expose private String tmY;
        @SerializedName("totalCount") @Expose private String totalCount;
        @SerializedName("umdName") @Expose private String umdName;
        @SerializedName("vrml") @Expose private String vrml;
        @SerializedName("year") @Expose private String year;

        public String getReturnType() { return returnType; }
        public String getAddr() { return addr; }
        public String getDistrictNum() { return districtNum; }
        public String getDmX() { return dmX; }
        public String getDmY() { return dmY; }
        public String getItem() { return item; }
        public String getMangName() { return mangName; }
        public String getMap() { return map; }
        public String getNumOfRows() { return numOfRows; }
        public String getOper() { return oper; }
        public String getPageNo() { return pageNo; }
        public String getPhoto() { return photo; }
        public String getResultCode() { return resultCode; }
        public String getResultMsg() { return resultMsg; }
        public int getRnum() { return rnum; }
        public String getServiceKey() { return serviceKey; }
        public String getSggName() { return sggName; }
        public String getSidoName() { return sidoName; }
        public String getStationCode() { return stationCode; }
        public String getStationName() { return stationName; }
        public double getTm() { return tm; }
        public String getTmX() { return tmX; }
        public String getTmY() { return tmY; }
        public String getTotalCount() { return totalCount; }
        public String getUmdName() { return umdName; }
        public String getVrml() { return vrml; }
        public String getYear() { return year; }
    }

    public class Parm {
        @SerializedName("_returnType") @Expose private String returnType;
        @SerializedName("addr") @Expose private String addr;
        @SerializedName("districtNum") @Expose private String districtNum;
        @SerializedName("dmX") @Expose private String dmX;
        @SerializedName("dmY") @Expose private String dmY;
        @SerializedName("item") @Expose private String item;
        @SerializedName("mangName") @Expose private String mangName;
        @SerializedName("map") @Expose private String map;
        @SerializedName("numOfRows") @Expose private String numOfRows;
        @SerializedName("oper") @Expose private String oper;
        @SerializedName("pageNo") @Expose private String pageNo;
        @SerializedName("photo") @Expose private String photo;
        @SerializedName("resultCode") @Expose private String resultCode;
        @SerializedName("resultMsg") @Expose private String resultMsg;
        @SerializedName("rnum") @Expose private int rnum;
        @SerializedName("serviceKey") @Expose private String serviceKey;
        @SerializedName("sggName") @Expose private String sggName;
        @SerializedName("sidoName") @Expose private String sidoName;
        @SerializedName("stationCode") @Expose private String stationCode;
        @SerializedName("stationName") @Expose private String stationName;
        @SerializedName("tm") @Expose private double tm;
        @SerializedName("tmX") @Expose private String tmX;
        @SerializedName("tmY") @Expose private String tmY;
        @SerializedName("totalCount") @Expose private String totalCount;
        @SerializedName("umdName") @Expose private String umdName;
        @SerializedName("vrml") @Expose private String vrml;
        @SerializedName("year") @Expose private String year;

        public String getReturnType() { return returnType; }
        public String getAddr() { return addr; }
        public String getDistrictNum() { return districtNum; }
        public String getDmX() { return dmX; }
        public String getDmY() { return dmY; }
        public String getItem() { return item; }
        public String getMangName() { return mangName; }
        public String getMap() { return map; }
        public String getNumOfRows() { return numOfRows; }
        public String getOper() { return oper; }
        public String getPageNo() { return pageNo; }
        public String getPhoto() { return photo; }
        public String getResultCode() { return resultCode; }
        public String getResultMsg() { return resultMsg; }
        public int getRnum() { return rnum; }
        public String getServiceKey() { return serviceKey; }
        public String getSggName() { return sggName; }
        public String getSidoName() { return sidoName; }
        public String getStationCode() { return stationCode; }
        public String getStationName() { return stationName; }
        public double getTm() { return tm; }
        public String getTmX() { return tmX; }
        public String getTmY() { return tmY; }
        public String getTotalCount() { return totalCount; }
        public String getUmdName() { return umdName; }
        public String getVrml() { return vrml; }
        public String getYear() { return year; }
    }

    public class MsrstnInfoInqireSvrVo {
        @SerializedName("_returnType") @Expose private String returnType;
        @SerializedName("addr") @Expose private String addr;
        @SerializedName("districtNum") @Expose private String districtNum;
        @SerializedName("dmX") @Expose private String dmX;
        @SerializedName("dmY") @Expose private String dmY;
        @SerializedName("item") @Expose private String item;
        @SerializedName("mangName") @Expose private String mangName;
        @SerializedName("map") @Expose private String map;
        @SerializedName("numOfRows") @Expose private String numOfRows;
        @SerializedName("oper") @Expose private String oper;
        @SerializedName("pageNo") @Expose private String pageNo;
        @SerializedName("photo") @Expose private String photo;
        @SerializedName("resultCode") @Expose private String resultCode;
        @SerializedName("resultMsg") @Expose private String resultMsg;
        @SerializedName("rnum") @Expose private int rnum;
        @SerializedName("serviceKey") @Expose private String serviceKey;
        @SerializedName("sggName") @Expose private String sggName;
        @SerializedName("sidoName") @Expose private String sidoName;
        @SerializedName("stationCode") @Expose private String stationCode;
        @SerializedName("stationName") @Expose private String stationName;
        @SerializedName("tm") @Expose private double tm;
        @SerializedName("tmX") @Expose private String tmX;
        @SerializedName("tmY") @Expose private String tmY;
        @SerializedName("totalCount") @Expose private String totalCount;
        @SerializedName("umdName") @Expose private String umdName;
        @SerializedName("vrml") @Expose private String vrml;
        @SerializedName("year") @Expose private String year;

        public String getReturnType() { return returnType; }
        public String getAddr() { return addr; }
        public String getDistrictNum() { return districtNum; }
        public String getDmX() { return dmX; }
        public String getDmY() { return dmY; }
        public String getItem() { return item; }
        public String getMangName() { return mangName; }
        public String getMap() { return map; }
        public String getNumOfRows() { return numOfRows; }
        public String getOper() { return oper; }
        public String getPageNo() { return pageNo; }
        public String getPhoto() { return photo; }
        public String getResultCode() { return resultCode; }
        public String getResultMsg() { return resultMsg; }
        public int getRnum() { return rnum; }
        public String getServiceKey() { return serviceKey; }
        public String getSggName() { return sggName; }
        public String getSidoName() { return sidoName; }
        public String getStationCode() { return stationCode; }
        public String getStationName() { return stationName; }
        public double getTm() { return tm; }
        public String getTmX() { return tmX; }
        public String getTmY() { return tmY; }
        public String getTotalCount() { return totalCount; }
        public String getUmdName() { return umdName; }
        public String getVrml() { return vrml; }
        public String getYear() { return year; }
    }
}
