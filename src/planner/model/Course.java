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
	private IndexList indexList = new IndexList();
	
	/** The exam date of the module
	 */
	Calendar examDate;
	
	public Calendar getExamDate() {
		return examDate;
	}
	

	/** Constructor for Course
	 */
	public Course (String courseCode, String courseName, int AU, String school, Calendar examDate) {
		this.courseCode			= courseCode;
		this.courseName			= courseName;
		this.AU					= AU;
		this.school				= school;
		this.examDate			= examDate;
	}
	
	
	

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

	public void setExamDate(Calendar examDate){
		this.examDate = examDate;
	}


	public IndexList getIndexList() {return indexList;
	}


	public void setIndexList(IndexList indexList) {
		this.indexList = indexList;
	}



}