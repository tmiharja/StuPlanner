package planner.db;

import java.util.ArrayList;
import planner.model.Staff;
import planner.model.Student;

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
	 */
	public static void initStudents(){
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("U1521000E", 'M', "Singaporean"));	
		PlannerData.students = students;
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
