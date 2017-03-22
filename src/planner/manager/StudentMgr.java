package planner.manager;
import java.util.ArrayList;
import java.util.Scanner;
import planner.db.PlannerData;
import planner.model.Student;

/**
 * Student Manager Class manages the creation, removal 
 * of students from the student list
 * @version 1.0
 * @since 2017-03-21
 */

public class StudentMgr {
	
	private static ArrayList<Student> students = PlannerData.students;
	private static Scanner sc = new Scanner(System.in);
	
	public static ArrayList<Student> getStudents(){ return students; }
	
	
	/**
	 * Create a new student having the all necessary information.
	 * @param matricNumber
	 * @param gender
	 * @param nationality
	 */	
	public static void Student (String matricNumber, char gender, String nationality) {
		Student newStudent = new Student(matricNumber, gender, nationality);
		students.add((Student) newStudent);
		System.out.println("Student of matric no " + matricNumber + " was added to the food menu.");
	}

}
