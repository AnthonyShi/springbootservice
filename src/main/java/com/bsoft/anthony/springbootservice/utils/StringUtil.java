package com.bsoft.anthony.springbootservice.utils;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
    public Map<String,Object> parseStringToMap(String[] str){
        Map<String,Object> response = new HashMap<String,Object>();
        if(str.length==0){
            return null;
        }
        for (int i = 0; i < str.length; i++) {
            response.put("kbsh",str[0]);
            response.put("ybh",str[1]);
            response.put("dwbh",str[2]);
            response.put("sfzh",str[3]);
            response.put("xm",str[4]);
            response.put("psw",str[5]);
            response.put("xb",str[6]);
            response.put("zhye",str[7]);
            response.put("jfjs",str[8]);
            response.put("zhzt",str[9]);
            response.put("rylb",str[10]);
            response.put("zycs",str[11]);
            response.put("ndtclj",str[13]);
            response.put("mzzz",str[14]);
            response.put("zzxe",str[15]);
            response.put("zztc",str[18]);
            response.put("bcze",str[19]);
            response.put("qfx",str[20]);
            response.put("bcbl",str[21]);
            response.put("bcxe",str[22]);
            response.put("bctc",str[23]);
//            brxx.kbsh = ls_outpara[1]
//            brxx.ybh  = ls_outpara[2]
//            brxx.dwbh = ls_outpara[3]
//            brxx.sfzh = ls_outpara[4]
//            brxx.xm   = Trim(ls_outpara[5])
//            brxx.psw  = ls_outpara[6]
//            brxx.xb   = ls_outpara[7]
//            brxx.zhye = Dec(ls_outpara[8])
//            brxx.jfjs = Dec(ls_outpara[9])
//            brxx.zhzt = Dec(ls_outpara[10])
//            brxx.rylb = Dec(ls_outpara[11])
//            brxx.zycs = Dec(ls_outpara[12])
//            brxx.ndtclj = Dec(ls_outpara[14])
//            brxx.mzzz = Dec(ls_outpara[15])
//            brxx.zzxe = Dec(ls_outpara[16])
//            brxx.zztc = Dec(ls_outpara[19])
//            brxx.bcze = Dec(ls_outpara[20])
//            brxx.qfx  = Dec(ls_outpara[21])
//            brxx.bcbl = Dec(ls_outpara[22])
//            brxx.bcxe = Dec(ls_outpara[23])
//            brxx.bctc = Dec(ls_outpara[24])
        }
        return response;
    };
}
