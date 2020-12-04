package com.bsoft.anthony.springbootservice.utils;


import java.util.Arrays;
import java.util.List;

/**
 * Created by ThinkPad on 2017/6/13.
 */

public class List2String {
    public static String listToString(List list) {
        if (list.size()==0){
            return null;
        }else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(",");
            }
            return sb.toString().substring(0, sb.toString().length() - 1);
        }
    }
    public static List stringToList(String data){
        if (TextUtils.isEmpty(data)){
            return null;
        }else{
          return   Arrays.asList(data.split(","));
        }
    }
}
