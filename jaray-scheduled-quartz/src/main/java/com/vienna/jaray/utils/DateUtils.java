package com.vienna.jaray.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	
	public static String getDateStr(String format){
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat(format); 
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8")); 
		String BeijingTime = dateFormat.format(date); 
		return BeijingTime;
	}

}
