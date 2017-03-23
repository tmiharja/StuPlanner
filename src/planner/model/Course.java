package planner.model;

import java.util.Calendar;

public class Course {
	private String courseCode;
	private String courseName;
	private int academicUnit;
	private String school;
	private Calendar examDate;

	// constructor
	public Course(String courseCode, String courseName, int academicUnit, String school, Calendar examDate) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.academicUnit = academicUnit;
		this.school = school;
		this.examDate = examDate;
	}

	// getters
	public String getCourseCode() {
		return courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getAcademicUnit() {
		return academicUnit;
	}

	public String getSchool() {
		return school;
	}

	public Calendar getExamDate() {
		return examDate;
	}

	// setters
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setAcademicUnit(int academicUnit) {
		this.academicUnit = academicUnit;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setExamDate(Calendar examDate) {
		this.examDate = examDate;
	}

	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course st = (Course) o;
			return (getCourseCode().equals(st.getCourseCode()));
		}
		return false;
	}

}
