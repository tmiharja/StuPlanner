package planner.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class CalendarMgr {
	
	private static Scanner sc = new Scanner(System.in);	
	
	/**
	 * Prompt user to give a valid access period
	 * @return the VALID reservation date time
	 */
	public static Calendar getValidDateTime(String mode){

		String dateInput = "";
	    Date parsedDate = null;
	    SimpleDateFormat dateFormat = null;
		boolean validDate = false;		
		Calendar date = Calendar.getInstance();
		
		do{
		    System.out.print("Enter " + mode+ " (dd/MM/yyyy HH:mm): ");
		    dateInput  = sc.nextLine();
		    dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		    
		    try {
		    	parsedDate = dateFormat.parse(dateInput);
		    	 
		    } catch (ParseException e) {
		        System.out.println("Input is not in the correct format!");
		        continue;
		    }
		    date.setTime(parsedDate);
		    validDate = true;

		} while(!validDate);
				
		return date;
	}

}
