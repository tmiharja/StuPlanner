package planner.model;

import java.util.ArrayList;

import planner.db.PlannerData;

public class StudentList {
	
	public static ArrayList<Student> studentList = PlannerData.students;
	
	/**
	 * Add student to the student list
	 */
	public void add(Student student){ studentList.add(student); }
	
	/**
	 * Get the studentList 
	 * @return this student list
	 */
	public static ArrayList<Student> getStudents(){ return studentList; }

}
