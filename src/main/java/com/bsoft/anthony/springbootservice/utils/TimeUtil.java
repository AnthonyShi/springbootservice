package com.bsoft.anthony.springbootservice.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtil {

	private static String dateString;
	private static String chaTime;
	private static long date;

	/**
	 * 转化为yyyy-mm-dd HH:mm
	 * 
	 * @return
	 */
	public static String timeFormat5(String text) {
		StringBuilder sb = new StringBuilder();
		if (text == null || "".equals(text)) {
			return "00-00 00:00";
		}
		if (text.length() >= 4) {
			sb.append(text.substring(0, 4) + "-");
		}
		if (text.length() >= 6) {
			sb.append(text.substring(4, 6)).append("-");
		}
		if (text.length() >= 8) {
			sb.append(text.substring(6, 8)).append(" ");
		}
		if (text.length() >= 10) {
			sb.append(text.substring(8, 10)).append(":");
		}
		if (text.length() >= 12) {
			sb.append(text.substring(10, 12)).append("");
		}
		return sb.toString();
	}

	/**
	 * 北京时间
	 * @return
     */
	public static String getBj(){
		float timeZoneOffset=8;
			if (timeZoneOffset > 13 || timeZoneOffset < -12) {
				timeZoneOffset = 0;
			}
			int newTime=(int)(timeZoneOffset * 60 * 60 * 1000);
			TimeZone timeZone;
			String[] ids = TimeZone.getAvailableIDs(newTime);
			if (ids.length == 0) {
				timeZone = TimeZone.getDefault();
			} else {
				timeZone = new SimpleTimeZone(newTime, ids[0]);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sdf.setTimeZone(timeZone);
		return sdf.format(new Date());
	}

	/**
	 * 转化为yyyy-mm-dd
	 *
	 * @return
	 */
	public static String timeFormatx(String text) {
		StringBuilder sb = new StringBuilder();
		if (text == null || "".equals(text)) {
			return "00-00";
		}
		if (text.length() >= 4) {
			sb.append(text.substring(0, 4) + "-");
		}
		if (text.length() >= 6) {
			sb.append(text.substring(4, 6)).append("-");
		}
		if (text.length() >= 8) {
			sb.append(text.substring(6, 8)).append(" ");
		}
		return sb.toString();
	}

	/**
	 * 转化为mm-dd HH:mm
	 * 
	 * @return
	 */
	public static String timeFormat6(String text) {
		StringBuilder sb = new StringBuilder();
		if (text == null || "".equals(text)) {
			return "00-00 00:00";
		}

		if (text.length() >= 6) {
			sb.append(text.substring(4, 6)).append("-");
		}
		if (text.length() >= 8) {
			sb.append(text.substring(6, 8)).append(" ");
		}
		if (text.length() >= 10) {
			sb.append(text.substring(8, 10)).append(":");
		}
		if (text.length() >= 12) {
			sb.append(text.substring(10, 12)).append("");
		}
		return sb.toString();
	}
	/**
	 * 转化为 HH:mm
	 *
	 * @return
	 */
	public static String timeFormatX(String text) {
		StringBuilder sb = new StringBuilder();
		if (text == null || "".equals(text)) {
			return "00-00 00:00";
		}
		if (text.length() >= 10) {
			sb.append(text.substring(8, 10)).append(":");
		}
		if (text.length() >= 12) {
			sb.append(text.substring(10, 12)).append("");
		}
		return sb.toString();
	}
	/**
	 * 转化为mm-dd
	 * 
	 * @return
	 */
	public static String timeFormat(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "00-00";
		}
		if (text.length() >= 6) {
			str += text.substring(4, 6) + "-";
		}
		if (text.length() >= 8) {
			str += text.substring(6, 8);
		}
		return str;
	}
	/**
	 * 转化为hh-mm
	 *
	 * @return
	 */
	public static String hhmm(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "00:00";
		}
		if (text.length() >= 6) {
			str += text.substring(2, 4) + ":";
		}
		if (text.length() >= 8) {
			str += text.substring(6, 8);
		}
		return str;
	}
	/**
	 * 转化为mm-dd
	 *
	 * @return
	 */
	public static String timeFormat9(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "";
		}
		if (text.length() >= 6) {
			str += text.substring(4, 6) + "月";
		}
		if (text.length() >= 8) {
			str += text.substring(6, 8)+"日";
		}
		return str;
	}

	/**
	 * 转化为mm:dd
	 *
	 * @return
	 */
	public static String timeFormat7(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "";
		}
		if (text.length() >= 2) {
			str += text.substring(0, 2) + ":";
		}
		if (text.length() >= 4) {
			str += text.substring(2, 4);
		}
		return str;
	}

	/**
	 * 转化为yyyy年mm月dd日
	 * 
	 * @return
	 */
	public static String timeFormat3(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "0000年00月00日";
		}
		if (text.length() >= 4) {
			str += text.substring(0, 4) + "年";
		}
		if (text.length() >= 6) {
			str += text.substring(4, 6) + "月";
		}
		if (text.length() >= 8) {
			str += text.substring(6, 8) + "日";
		}
		return str;
	}

	/**
	 * 转化为yyy-mm-dd
	 * 
	 * @return
	 */
	public static String timeFormat1(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "0000-00-00";
		}
		if (text.length() >= 4) {
			str += text.substring(0, 4) + "-";
		}
		if (text.length() >= 6) {
			str += text.substring(4, 6) + "-";
		}
		if (text.length() >= 8) {
			str += text.substring(6, 8);
		}
		return str;
	}

	/**
	 * 转化为yyy-mm-dd
	 *
	 * @return
	 */
	public static String timeFormat8(String text) {
		String str = "";
		if (text == null || "".equals(text)) {
			return "";
		}
		if (text.length() >= 4) {
			str += text.substring(0, 4) + "-";
		}
		if (text.length() >= 6) {
			str += text.substring(4, 6) + "-";
		}
		if (text.length() >= 8) {
			str += text.substring(6, 8)+" ";
		}
		if (text.length() >= 10) {
			str += text.substring(8, 10) + ":";
		}
		if (text.length() >= 12) {
			str += text.substring(10, 12);
		}
		return str;
	}

	public static String getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * data转string
	 * @param data
	 * @return
	 */
	public static String dateToString(Date data,String pattern) {
		return new SimpleDateFormat(pattern).format(data);
	}
	/**
	 * 获取现在时间
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
//获取当前时间
		Date date = new Date(System.currentTimeMillis());
		return date;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyyMMddHHmmss
	 */
	public static String getStringDate1() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 获取现在时间
	 *
	 * @return返回字符串格式 yyyyMMdd
	 */
	public static String getStringDate2() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	/**
	 * 获取现在时间
	 *
	 */
	public static Long getLongDate() {
		Date currentTime = new Date();
		return currentTime.getTime();
	}
	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}



	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 *
	 * @param dateDate
	 * @return
	 */
	public static String longToStr(long dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	/**
	 * 将短时间格式时间转换为字符串 yyyy/MM/dd
	 *
	 * @param dateDate

	 * @return
	 */
	public static String dateToStr2(Date dateDate) {
		if (dateDate!=null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			dateString = formatter.format(dateDate);
		}
			return dateString;
	}
	/**
	 * 将短时间格式时间转换为字符串 yyyyMMdd
	 *
	 * @return
	 */
	public static String dateToStr1() {
		Date dateDate = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate, String fomat) {
		SimpleDateFormat formatter = new SimpleDateFormat(fomat);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return
	 */
	public static Date getNow() {
		Date currentTime = new Date();
		return currentTime;
	}

	/**
	 * 提取一个月中的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day) {
		Date date = new Date();
		long date_3_hm = date.getTime() - 3600000 * 34 * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return 字符串 yyyyMMdd HHmmss
	 */
	public static String getStringToday() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return
	 */
	public static String getTime() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getUserDate(String sformat) {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static String getTwoHour(String st1, String st2) {
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else {
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1])
					/ 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1])
					/ 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static String getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		long day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e) {
			return "";
		}
		return day + "";
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mydate1 = "";
		try {
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e) {
		}
		return mydate1;
	}



	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate) {

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate, "yyyy-MM-dd");
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}


	/**
	 * 获取一个月的最后一天
	 * 
	 * @param dat
	 * @return
	 */
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8
				|| mon == 10 || mon == 12) {
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
			str += "30";
		} else {
			if (isLeapYear(dat)) {
				str += "29";
			} else {
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 判断二个时间是否在同一个周
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH)) {
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH)) {
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2
					.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * @return
	 */
	public static String getSeqWeek() {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 * 
	 * @param sdate
	 * @param num
	 * @return
	 */
	public static String getWeek(String sdate, String num) {
		// 再转换为时间
		Date dd = strToDate(sdate, "yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate) {
		// 再转换为时间
		Date date = strToDate(sdate, "yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate) {
		String str = "";
		str = getWeek(sdate);
		if ("1".equals(str)) {
			str = "星期日";
		} else if ("2".equals(str)) {
			str = "星期一";
		} else if ("3".equals(str)) {
			str = "星期二";
		} else if ("4".equals(str)) {
			str = "星期三";
		} else if ("5".equals(str)) {
			str = "星期四";
		} else if ("6".equals(str)) {
			str = "星期五";
		} else if ("7".equals(str)) {
			str = "星期六";
		}
		return str;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @return
	 */
	public static int getTimeString(Date startTime, Date endTime){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = simpleFormat.format(endTime);
		String toDate = simpleFormat.format(startTime);
		long from = 0;
		long to = 0;
		try {
			from = simpleFormat.parse(fromDate).getTime();
			to = simpleFormat.parse(toDate).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int days = (int) ((to - from)/(1000 * 60 * 60 * 24));
		return days;
	}
	public static int getDays(Date date1, Date date2)

	{

		Calendar cal = Calendar.getInstance();

		cal.setTime(date1);

		long time1 = cal.getTimeInMillis();

		cal.setTime(date2);

		long time2 = cal.getTimeInMillis();

		long between_days=(time2-time1)/(1000*3600*24);



		return Integer.parseInt(String.valueOf(between_days));

	}


	public static String friendlyTime(String time) {
		DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		try {
			date = format.parse(time).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return friendlyTime(date);
	}

	public static String friendlyTime(long time) {
		//获取time距离当前的秒数
		int ct = (int)((System.currentTimeMillis() - time)/1000);

		if(ct == 0) {
			return "刚刚";
		}

		if(ct > 0 && ct < 60) {
			return ct + "秒前";
		}

		if(ct >= 60 && ct < 3600) {
			return Math.max(ct / 60,1) + "分钟前";
		}
		if(ct >= 3600 && ct < 86400)
			return ct / 3600 + "小时前";
		if(ct >= 86400 && ct < 2592000){ //86400 * 30
			int day = ct / 86400 ;
			return day + "天前";
		}
		if(ct >= 2592000 && ct < 31104000) { //86400 * 30
			return ct / 2592000 + "月前";
		}
		return ct / 31104000 + "年前";
	}
}
