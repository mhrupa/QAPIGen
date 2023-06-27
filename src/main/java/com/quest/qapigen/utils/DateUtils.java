package com.quest.qapigen.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Contains date structure
 * 
 * @author GiduguSa
 *
 */
public class DateUtils {
	
	private DateUtils() {
		
	}

    /**
     * Return current datetime in ISO 8601 format
     */

    public static String getCurrentDateTimeInISO8601() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        TimeZone tz = TimeZone.getTimeZone("UTC");
        df.setTimeZone(tz);
        return df.format(new Date());
    }
    
    public static String getCurrentDateTime() {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }
    
    public static String getCurrentDateTimeWithoutSpace() {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
        Calendar calobj = Calendar.getInstance();
        return df.format(calobj.getTime());
    }
    
    public static String getCurrentDate() {
    	DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calobj1 = Calendar.getInstance();
        return df1.format(calobj1.getTime());
    }
    
    public static String getCurrentDateForCancellation() {
    	DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'23:59:59");
        Calendar calobj1 = Calendar.getInstance();
        return df1.format(calobj1.getTime());
    }
    
    
    /**
     * @return currentDate in format e.g. 2023-04-27T23:00:00+00:00 
     */
    public static String getCurrentDateForCancelAt() {
    	DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'23:00:00+00:00");
        Calendar calobj1 = Calendar.getInstance();
        return df1.format(calobj1.getTime());
    }

	/**
	 * This method will return as current date time with time zone.
	 * @return
	 */
	public static String getCurrentDateTimeWithTimeZone() {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		Calendar calObj1 = Calendar.getInstance();
		return df1.format(calObj1.getTime());
	}

    public static LocalDateTime getStringToLocalTimeDateTime(String date) {
		return LocalDateTime.parse(date.substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

    public static LocalDateTime getStringToLocalDateTime(String date) {
		return LocalDateTime.parse(date.substring(0, 25), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss+SS:SS"));
	}


    public static LocalDateTime getLocalTimeDateTime(String date) {
		return LocalDateTime.parse(date.substring(0, 19), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
	}
    
    public static LocalDateTime getLocalDateWithoutTime(String date) {
		return LocalDateTime.of(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.MIN);
	}

	/**
	 * Return current date time in yyyy-MM-dd'T'hh:mm:ss format
	 */
	public static String getCurrentDateTimeWithZone() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		df.setTimeZone(tz);
		return df.format(new Date());
	}
	
	/**
	 * Return  date time in yyyy-MM-dd hh:mm:ss format
	 */
	public static String formatDateAndTimeForNotificationService(LocalDateTime date ) { 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return date.format(format); 
	}
	
	/**
	 * Return date time in yyyy-MM-dd HH:mm:ss format
	 */
	public static String formatDateTimeWithZone(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone tz = TimeZone.getTimeZone("UTC");
		df.setTimeZone(tz);
		return df.format(date);
	}
	
	/**
	 * Return date and time in yyyy-MM-dd HH:mm:ss format in UTC.
	 * 
	 * @return String
	 */
	public static String formatDateAndTimeInUTC(LocalDateTime date) {
		String parseDateInUTC = "";
		if (date != null) {
			parseDateInUTC = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC));
		}
		return parseDateInUTC;
	}
	
	/**
	 * Return LocalDateTime from Date
	 */
	public static LocalDateTime convertToLocalDateTimeViaSqlTimestamp(Date dateToConvert) {
	    return new java.sql.Timestamp(
	      dateToConvert.getTime()).toLocalDateTime();
	}
	
	/**
	 * This method will check is order created before 24 hours ago from current date.
	 * 
	 * @param orderCreatedDate
	 * @return boolean
	 */
	public static boolean isOrderCreateDateBeforeHours(Date orderCreatedDate, int hour) {
		Calendar calendar = Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("UTC");
		calendar.setTime(orderCreatedDate);
		calendar.setTimeZone(tz);
		calendar.add(Calendar.HOUR, +hour);
		return calendar.getTime().before(new Date());
	}
	
	/**
	 * Return date time
	 * @param date
	 * @return String
	 */
	public static String formatDateAndTime(LocalDateTime date ) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		return date.format(format); 
	}
}
