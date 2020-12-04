package com.bsoft.anthony.springbootservice.utils;

/**
 * 创建日期 : 2019/8/12
 * 创建人 : 赵太行
 */
public class TextUtils {
    public static boolean isEmpty( CharSequence str) {
        return str == null || str.length() == 0 || str.equals("null");
    }
    public static String filtration( String str) {
        if (str!=null){
            if (str.length() == 0 || str.equals("null")){
                return null;
            }else{
                return str;
            }
        }else{
            return null;
        }
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                // 判断字符是否为空格、制表符、tab
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
