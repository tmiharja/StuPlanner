package planner.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import planner.db.CourseData;
import planner.model.Course;

/** Add new courses to the courseList done by the admin
 * 
 */

import planner.db.StudentData;
import planner.model.Student;

public class StaffCourseMgr {
	static ArrayList<Course> courseList = new ArrayList<Course>();
	
	/**
	 * Create a new course with the necessary information
	 * @throws IOException 
	 * @throws ParseException 
	 */	
	public static void addCourse (String courseCode, String courseName, int au, String school,String courseType, Calendar examDate) throws IOException, ParseException {
		Course newCourse = new Course(courseCode.toUpperCase(), courseName, au, school, courseType, examDate);
		courseList = CourseData.initCourses();
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
