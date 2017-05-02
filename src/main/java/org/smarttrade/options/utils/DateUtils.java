package org.smarttrade.options.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getDateString(String expiryDate){
		String oldstring=expiryDate + " 17:30:00";
		Date date=null;
		try {
		  date = new SimpleDateFormat("ddMMMyyyy HH:mm:ss").parse(oldstring);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//expiry = "2017-05-02 23:59:00",
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss"); //Or whatever format fits best your needs.
		String dateStr = sdf.format(date);

		return dateStr;
	}
	
	public static String getTodayDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		String dateStr = sdf.format(date).toUpperCase();
		//02May2017
		return dateStr;
	}
	

	public static void main(String[] args) {
		String a =APPConstant.getUSDINRFutureURL("28JUN2017");
		System.out.println(a);
		
		
	}
	
}
