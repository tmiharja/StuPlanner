package planner.model;

import java.util.ArrayList;

import planner.db.CoursesData;

public class CourseList {
	
	public static ArrayList<Course> CourseList = CoursesData.CourseList;

	public static ArrayList<Course> getCourseList() {
		return CourseList;
	}

	public static void setCourseList(ArrayList<Course> courseList) {
		CourseList = courseList;
	}
	

}
