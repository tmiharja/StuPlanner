package planner.manager;
import java.util.ArrayList;
import java.util.Calendar;
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
	

}
