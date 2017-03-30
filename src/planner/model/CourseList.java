package planner.model;

import java.util.ArrayList;

import planner.db.CourseData;

public class CourseList {
	
	public static ArrayList<Course> CourseList = CourseData.CourseList;

	public static ArrayList<Course> getCourseList() {
		return CourseList;
	}

	public static void setCourseList(ArrayList<Course> courseList) {
		CourseList = courseList;
	}
	
}
