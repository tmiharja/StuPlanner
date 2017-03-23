package planner.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class CalendarMgr {
	
	static Scanner sc = new Scanner(System.in);
	static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public static String calendarToString(Calendar cal) {
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		return String.format("%02d/%02d/%4d %02d:%02d", year, month + 1, day, hour, minute);
	}
	
	public static Calendar stringToCalendar(String s) throws ParseException {
		Date date = dateFormat.parse(s);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	/**
	 * Prompt user to give a valid access period
	 * @return the VALID reservation date time
	 */

	@SuppressWarnings("null")
	public static Calendar getValidDateTime(String date){

	    Date parsedDate = null;
		boolean validDate = false;		
		Calendar newDate = Calendar.getInstance();
		
		do{
		    try {
		    	parsedDate = dateFormat.parse(date);
		    	 
		    } catch (ParseException e) {
		        System.out.println("Input is not in the correct format!");
		        continue;
		    }
		    newDate.setTime(parsedDate);

		    validDate = true;

		} while(!validDate);
				
		return newDate;
	}

}
