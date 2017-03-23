package planner.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import planner.model.Staff;
import planner.model.Student;
import java.util.Calendar;
import java.util.Date;

/**
 * Static Star Planner database class keeping track of
 * the user accounts, courses registered, etc
 * @version 1.0
 * @since 2017-03-21
 */

public class PlannerData {
	
	public static ArrayList<Student> students;
	public static ArrayList<Staff> staffs;
	
	/**
	 * Initialise list of students
	 * @throws ParseException 
	 */
	@SuppressWarnings("null")
	public static void initStudents() throws ParseException{
		ArrayList<Student> students = new ArrayList<Student>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date startDate = dateFormat.parse("19/4/2017 19:50");
		Date endDate = dateFormat.parse("21/4/2017 19:50");
		Calendar accessStart = Calendar.getInstance();
		accessStart.setTime(startDate);
		Calendar accessEnd = Calendar.getInstance();
		accessEnd.setTime(endDate);
		
		//students.add(new Student("Michelle", "Tan", "U1521000E", 'M', "Singaporean", accessStart, accessEnd));	
		//PlannerData.students = students;
	}
	
	/**
	 * Initialise list of staffs
	 */
	public static void initStaff(){
		ArrayList<Staff> staffs = new ArrayList<Staff>();
		staffs.add(new Staff("S152101200E"));
		PlannerData.staffs = staffs;
	}

}
