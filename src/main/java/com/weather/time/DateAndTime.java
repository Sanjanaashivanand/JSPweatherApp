package com.weather.time;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class DateAndTime {
	
	public static String getTime() {
		DateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
		String timeString = timeFormat.format(new Date()).toString();
		return timeString;
		
	}
	
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		String dateString = dateFormat.format(new Date()).toString();
		return dateString;
	}
	
	public static String getDay() {
		DateFormat dayFormat = new SimpleDateFormat("EEEE");
		String dayString = dayFormat.format(new Date()).toString();
		return dayString;
	}
	
	

}
