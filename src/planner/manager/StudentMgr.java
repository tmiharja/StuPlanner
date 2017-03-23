package planner.manager;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import planner.db.StudentData;
import planner.model.Student;

/**
 * Student Manager Class manages the creation, removal 
 * of students from the student list
 * @version 1.0
 * @since 2017-03-21
 */

public class StudentMgr {
	
	//static ArrayList<Student> students = StudentList.getStudents();
	static String filename = "src/planner/db/students.txt";
	
	/**
	 * Create a new student having the all necessary information.
	 * @param firstName
	 * @param lastName
	 * @param matricNumber
	 * @param gender
	 * @param nationality
	 * @throws ParseException 
	 */	
	public static void addStudent (String firstName, String lastName, String matricNumber, char gender, String nationality, Calendar accessStart, Calendar accessEnd) throws ParseException {
		Student newStudent = new Student(firstName, lastName, matricNumber, gender, nationality, accessStart, accessEnd);
		//students.add((Student) newStudent);
		//System.out.println("Student of matric no " + matricNumber + " was added to the food menu.");
		
		try{
			ArrayList <Student> studList = StudentData.initStudents();
			studList.add(newStudent);
			StudentData.saveStudents(studList);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
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
}
