package planner.manager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import planner.model.Student;
import planner.model.StudentList;

/**
 * Student Manager Class manages the creation, removal 
 * of students from the student list
 * @version 1.0
 * @since 2017-03-21
 */

public class StudentMgr {
	
	static ArrayList<Student> students = StudentList.getStudents();
	
	private static Scanner sc = new Scanner(System.in);	
	
	/**
	 * Create a new student having the all necessary information.
	 * @param firstName
	 * @param lastName
	 * @param matricNumber
	 * @param gender
	 * @param nationality
	 */	
	public static void addStudent (String firstName, String lastName, String matricNumber, char gender, String nationality, Calendar accessStart, Calendar accessEnd) {
		Student newStudent = new Student(firstName, lastName, matricNumber, gender, nationality, accessStart, accessEnd);
		students.add((Student) newStudent);
		System.out.println("Student of matric no " + matricNumber + " was added to the food menu.");
	}
	
	/**
	 * Update a student's accesss period
	 * @param student The student
	 * @param foodCourseType New food course type
	 */
	public static void updateAccessPeriod(Student studentToUpdate, Calendar newAccessStart, Calendar newAccessEnd){
		
		Student student = studentToUpdate;
		String studentName = student.getFirstName() + student.getLastName();
		
		student.setAccessStart(newAccessStart);
		student.setAccessEnd(newAccessEnd);
		System.out.println("Student " + studentName + "'s access period has been updated!");
	}
	
	/**
	 * Prompt user to give a valid access period
	 * @return the VALID reservation date time
	 */
	@SuppressWarnings("null")
	public static Calendar getValidDateTime(String mode){

		String date = "";
	    Date parsedDate = null;
	    SimpleDateFormat dateFormat = null;
		boolean validDate = false;		
		Calendar newAccessPeriod = Calendar.getInstance();
		
		do{
		    System.out.print("Enter " + mode + " access time (dd/MM/yyyy HH:mm): ");
		    date  = sc.nextLine();
		    dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		    
		    try {
		    	parsedDate = dateFormat.parse(date);
		    	 
		    } catch (ParseException e) {
		        System.out.println("Entered access time is not in the correct format!");
		        continue;
		    }
		    newAccessPeriod.setTime(parsedDate);
		    validDate = true;

		} while(!validDate);
				
		return newAccessPeriod;
	}

}
