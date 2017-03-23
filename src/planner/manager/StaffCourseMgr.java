package planner.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import planner.db.CoursesData;
import planner.model.Course;
import planner.model.CourseList;

/** Add new courses to the courseList done by the admin
 * 
 */


public class StaffCourseMgr {
	static ArrayList<Course> courseList = CourseList.getCourseList();
	
	/**
	 * Create a new course with the necessary information
	 * @throws IOException 
	 */	
	public static void addCourse (String courseCode, String courseName, int AU, String school, Calendar examDate) throws IOException {
		Course newCourse = new Course(courseCode, courseName, AU, school, examDate);
		courseList.add((Course) newCourse);
		System.out.println("Course " + courseName + " (" + courseCode + ") has been added!");
		
		
		CoursesData.saveCourses(courseList);
	}
	
	

}
