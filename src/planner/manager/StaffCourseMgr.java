package planner.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import planner.db.CourseData;
import planner.model.Course;
import planner.model.CourseList;

/** Add new courses to the courseList done by the admin
 * 
 */

import planner.db.StudentData;
import planner.model.Student;

public class StaffCourseMgr {
	static ArrayList<Course> courseList = CourseList.getCourseList();
	
	/**
	 * Create a new course with the necessary information
	 * @throws IOException 
	 */	
	public static void addCourse (String courseCode, String courseName, int au, String school, Calendar examDate) throws IOException {
		Course newCourse = new Course(courseCode.toUpperCase(), courseName, au, school, examDate);
		courseList.add((Course) newCourse);
		System.out.println("Course " + courseName + " (" + courseCode + ") has been added!");
		
		//Use this before closing!
		CourseData.saveCourses(courseList);
	}
	
	public static void removeCourse(String courseCode) throws IOException{
		for(Course i : courseList){
			if (i.getCourseCode().equals(courseCode.toUpperCase())){
				courseList.remove(i);
				CourseData.saveCourses(courseList);
				System.out.println("Course " + i.getCourseName() + " (" + courseCode + ") has been removed!");
			}
		}
	}
}
