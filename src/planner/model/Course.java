package planner.model;

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

}