package com.bsoft.anthony.springbootservice.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DateUtil {
	public static String dateFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	public static String dateFormatDay(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
	
	public static String dateFormatMin(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时MM分");
		return dateFormat.format(date);
	}

	public static String dateFormatDT15(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return dateFormat.format(date);
	}
	
	//根据日期取得星期几
	public static String getWeek(Date date){
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
	String week = sdf.format(date);
	return week;
	}
	
	public static Date getDateByZeroTime(Date date,Integer addDay){
		
		
		 Calendar calendar = Calendar.getInstance();
         calendar.setTime(addDateToDay(date,addDay));
         calendar.set(Calendar.HOUR_OF_DAY, 0);
         calendar.set(Calendar.MINUTE, 0);
         calendar.set(Calendar.SECOND, 0);
         Date zero = calendar.getTime();
         
         return zero;
	}
	
	
	/**
	*
	*@return  返回1是星期日、2是星期一、3是星期二、4是星期三、5是星期四、6是星期五、7是星期六
	*/
	 
	public static int getDayofweek(Date date){
	  Calendar cal = Calendar.getInstance();
	  
	  cal.setTime(date);

	   return cal.get(Calendar.DAY_OF_WEEK);
	 }
	 

	
	// public static void main(String[] args) throws Exception {
	// System.out.println(dateFormat(new Date()));
	// System.out.println(stringToDate("20140203T120302"));
	// }

	// 这个函数负责建 各种不规范的时间字符串转换为java的时间类型
	public synchronized static Date stringToDate(String value) throws Exception {// 将

		String df = "";
		if (value.length() == 15) {
			df = "yyyyMMdd'T'HHmmss";
		} else if (value.length() == 8) {
			df = "yyyyMMdd";
		} else {
			boolean isHasT = false;
			// 时间字符串转为时间
			// String valueString = "2014-2-3 12:3:2";
			String[] di = null;
			if (value.contains("T")) {// 有T的用T截断
				di = value.split("T");
				isHasT = true;
			} else
				di = value.split(" ");

			if (di.length >= 1) {
				int c = di[0].split("-").length;
				if (c >= 1)
					df += "yyyy";
				if (c >= 2)
					df += "-MM";
				if (c >= 3)
					df += "-dd";
			}
			if (di.length >= 2) {
				if (isHasT)
					df += "'T'";
				int c = di[1].split(":").length;
				if (c >= 1)
					df += "HH";
				if (c >= 2)
					df += ":mm";
				if (c >= 3)
					df += ":ss";
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		return sdf.parse(value);
	}
	public static Date StrToFormatDate(String str,String FormatStr) {
	    // String string = "2016-10-24 21:59:06";
	    // FormatStr = "yyyy-MM-dd HH:mm:ss"  "yyyy-MM-dd"
        SimpleDateFormat sdf = new SimpleDateFormat(FormatStr);
        try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
}
	public static Date addDateToYear(Date date, int year) {
		Date da = (Date) date.clone();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(da);
		calendar.add(calendar.YEAR, year);
		da = calendar.getTime();
		return da;
	}

	public static Date addDateToMonth(Date date, int month) {
		Date da = (Date) date.clone();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(da);
		calendar.add(calendar.MONTH, month);
		da = calendar.getTime();
		return da;
	}

	public static Date addDateToDay(Date date, int day) {
		Date da = (Date) date.clone();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(da);
		calendar.add(calendar.DATE, day);// 把日期往后增加一天.整数往后推,负数往前移动
		da = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		return da;
	}

	public static Date addDateToHour(Date date, int hour) {
		Date da = (Date) date.clone();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(da);
		calendar.add(calendar.HOUR, hour);
		da = calendar.getTime();
		return da;
	}
	public static Date addDateToMinute(Date date, int minute) {
		Date da = (Date) date.clone();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(da);
		calendar.add(calendar.MINUTE, minute);
		da = calendar.getTime();
		return da;
	}
	
	public static String getFormatDateString(String s) throws ParseException {
		
        //日期输出格式  
		String targetFormat = "yyyy-MM-dd HH:mm:ss";  
		//日期原始格式  
		String origFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSz";  
	//	String s = "1988-11-06T12:14:05.671+08:00";  
		//去掉时区部分的冒号  
		s = s.replaceAll(":[^:]*$", "00");  
		System.out.println(s);  
		DateFormat format = new SimpleDateFormat(origFormat);  
		Date date = format.parse(s);  
		format = new SimpleDateFormat(targetFormat);  
		String dateString = format.format(date);  
		System.out.println(dateString);  
		return dateString;
	} 
	/**
	 * 
	 * @param date 带时区的格式：2015-12-7T16:00:00.000Z
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDateByTimezoneStr(String dateStr) throws ParseException{
		//String date = "2015-12-7T16:00:00.000Z"; 
		dateStr = dateStr.replace("Z", " UTC");//注意是空格+UTC
		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
		//判断格式
		if (dateStr.length() ==20){
			format =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
		}
		else if (dateStr.length() ==23){ //2016-09-01T16:00:00 UTC
			format =new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss Z");
		}
		Date d = format.parse(dateStr );
		return d;
	}
	//Unparseable date: "Sun Jan 1 00:00:00 UTC+0800 2017"
	public static Date getDateChina(String dateStr) throws ParseException{
		if(dateStr.contains("UTC")){ //Tue Jul 12 00:00:00 GMT+08:00 2016
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss 'UTC'Z yyyy",Locale.ENGLISH);
			return format.parse(dateStr);
		}else{// if(dateStr.contains("GMT"))
			dateStr = dateStr.replace("+0800", " +08:00");//GMT   
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss z",Locale.ENGLISH);
			return format.parse(dateStr);
		}
	}
	
	public static  int getAge(Date birthDay) throws Exception {
		 int age = 0;
        Calendar cal = Calendar.getInstance(); 
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
        	return age;
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay); 
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
        age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            }else{
                age--;//当前月份在生日之前，年龄减一

            } 
        } 
        return age; 
    }
	
	/**
	 * 
	 * @param date 带时区的格式：2015-12-7T16:00:00.000Z 转换出来精确到天 去掉秒
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDateByTimezoneStrForDate(String dateStr) throws ParseException{
		//String date = "2015-12-7T16:00:00.000Z"; 
		dateStr = dateStr.replace("Z", " UTC");//注意是空格+UTC
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//注意格式化的表达式
		Date d = format.parse(dateStr );
		return d;
	}
	/**
	 * 获取当前日期经过n秒后的时间 n 正数则 表后后面时间 负数 前面时间
	 * @param 
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getDateAddByTime(Date indate,int ss){
		Calendar c = new GregorianCalendar();
		c.setTime(indate);//设置参数时间
		c.add(Calendar.SECOND,ss);//把日期往后增加SECOND 秒.整数往后推,负数往前移动
		Date d=c.getTime(); //这个时间就是日期结果
		return d;
	}
	
	public static void main(String[] args) throws Exception {
//		getFormatDateString("2016-09-09T16:00:00.000Z");
		
		//Date begin =  getDateByTimezoneStr("2016-09-09T16:00:00.123Z");
	//	Date end = getDateByTimezoneStr("2016-09-10T16:00:00.456Z");
		Date begin =  getDateByTimezoneStrForDate("2016-09-09T16:00:00.123Z");
		Date end = getDateByTimezoneStrForDate("2016-09-10T16:00:00.456Z");
		
		Date sqrq = DateUtil.getDateByTimezoneStr("2015-12-7T16:00:00.000Z");
		
		Date sqchina = DateUtil.getDateChina("Sun Jan 1 00:00:00 UTC+0800 2017");
		
		System.out.println(begin);
		String x = dateFormat(begin);
		String y = dateFormat(end);
		
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss.SSS Z" );

        String str = sdf.format(sqrq);
        System.out.println("------------------"+str);
        str = sdf.format(sqchina);
        System.out.println("------------------sqchina"+str);
		System.out.println(str);
		System.out.println(y);
		System.out.println("-------------");
		Date i= getDateAddByTime(end,-1);
		 x = dateFormat(i);
		System.out.println(x);
		
	}
}
