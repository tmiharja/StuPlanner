package planner.model;

import java.util.Calendar;

public class Course {
	/**
	 * The course code unique to each module
	 */
	private String courseCode;
	
	/**
	 * The name of the course
	 */
	private String courseName;
	
	/**
	 * The number of Academic Unit (AU) of the course
	 */
	private int AU;
	
	/**
	 * The school that offers the module
	 */
	private String school;
	
	/**
	 * The list of indexes for the course that the student can register to
	 */
	Index indexList;
	
	/**
	 * The exam date of the course
	 */
	Calendar examDate;
	
	

	public String getCourseCode() {
		return courseCode;
	}
	
	/**
	 * Change the course code
	 * @param courseCode
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getAU() {
		return AU;
	}

	public void setAU(int aU) {
		AU = aU;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	

}