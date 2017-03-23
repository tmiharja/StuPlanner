package planner.model;

import java.util.ArrayList;

import planner.db.PlannerData;

public class StudentList {
	
	public static ArrayList<Student> students = PlannerData.students;
	
	/**
	 * Add student to the student list
	 */
	public void add(Student student){ students.add(student); }
	
	/**
	 * Get the studentList 
	 * @return this student list
	 */
	public static ArrayList<Student> getStudents(){ return students; }

}
