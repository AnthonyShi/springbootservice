package com.bsoft.anthony.springbootservice.utils;

import java.math.BigDecimal;

/**
 * 合计价格
 */

public class SumPriceUtil {
    //加
    public static String getAddPrice(String p1, String p2){
        if (TextUtils.isEmpty(p1)){
            p1="0.00";
        }
        if (TextUtils.isEmpty(p2)){
            p2="0.00";
        }
        BigDecimal b1 = new BigDecimal(p1);
        BigDecimal b2 = new BigDecimal(p2);
        String ss=String.valueOf(b1.add(b2).doubleValue());
        return ss;
    }
    //减
    public static String getMinusPrice(String p1, String p2){
        if (TextUtils.isEmpty(p1)){
            p1="0.00";
        }
        if (TextUtils.isEmpty(p2)){
            p2="0.00";
        }
        BigDecimal b1 = new BigDecimal(p1);
        BigDecimal b2 = new BigDecimal(p2);
        String ss=String.valueOf(b1.subtract(b2).doubleValue());
        return ss;
    }
    //乘
    public static String getRidePrice(String p1, String p2) {
        if (TextUtils.isEmpty(p1)){
            p1="0";
        }
        if (TextUtils.isEmpty(p2)){
            p2="0";
        }
        BigDecimal b1 = new BigDecimal(p1);
        BigDecimal b2 = new BigDecimal(p2);
        String ss = String.valueOf(b1.multiply(b2));
        return ss;
    }
    //除
    public static double divisionMethod(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    public static Double getAddPriceDouble(Double p1, Double p2){
        if (p1==null){
            p1=0.00;
        }
        if (p2==null){
            p2=0.00;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(p1));
        BigDecimal b2 = new BigDecimal(Double.toString(p2));
        return b1.add(b2).doubleValue();
    }
    public static Double getMinusPriceDouble(Double p1, Double p2){
        if (p1==null){
            p1=0.00;
        }
        if (p2==null){
            p2=0.00;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(p1));
        BigDecimal b2 = new BigDecimal(Double.toString(p2));
        return b1.subtract(b2).doubleValue();
    }
    //乘
    public static Double getRidePriceDouble(Double p1, Double p2) {
        BigDecimal b1 = new BigDecimal(Double.toString(p1));
        BigDecimal b2 = new BigDecimal(Double.toString(p2));
        return b1.multiply(b2).doubleValue();
    }
}
