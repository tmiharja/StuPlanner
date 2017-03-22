package planner.manager;

import java.util.ArrayList;

import planner.model.Student;
import planner.model.StudentList;

/**
 * Manages the printing of the student list and staff list
 * @version 1.0
 * @since 2017-03-21
 */

public class PrintMgr {
	
	static ArrayList<Student> students = StudentList.getStudents();
	
	/**
	 * Print out all the student names on the Student List
	 * from index 0 to the end of the array
	 */
	
	public static void printStudentList(){
		if(students.size() <= 0){
			System.out.println("There are no student in the list.");
			return;
		}
		else{
			int index = 0;
			for(Student student : students) {
				System.out.println("(" + index++ + ") " + student.getFirstName() + " " + student.getLastName());
			}
		}
	}
	

}
