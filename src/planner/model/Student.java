package planner.model;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import planner.db.CoursesData;

/**
 * Represents the Student who acts as the user of the 
 * planner to register their courses.
 * @version 1.0
 * @since 2017-03-21
 */

public class Student extends UserAcc implements Serializable{
	
	/**
	//The domain which differentiates students and staff
	 */
	private final static String DOMAIN = "STUDENT";
	
	/**
	//The matriculation number unique to each student
	 */
	private String matricNumber;
	
	/**
	//The gender of the student (either F or M)
	 */
	private char gender;
	
	/**
	//The nationality of the student
	 */
	private String nationality;
	
	/**
	//The start of the access period of the student
	 */
	private Calendar accessStart;
	
	/**
	//The end of the access period of the student
	 */
	private Calendar accessEnd;
	
	/**
	//List of all courses registered by the student
	 */
	// CourseList courseList;
	
	/**
	 * Create a new student having the all necessary information.
	 * @param matricNumber
	 * @param gender
	 * @param nationality
	 */	
	public Student (String firstName, String lastName, String matricNumber, char gender, String nationality, Calendar accessStart, Calendar accessEnd) {
		this.firstName 			= firstName;
		this.lastName 			= lastName;
		this.matricNumber		= matricNumber;
		this.gender				= gender;
		this.nationality		= nationality;
		this.accessStart 		= accessStart;
		this.accessEnd 			= accessEnd;
	}
	
	/**
	 * Change the matric number of the student
	 * @param matricNumber
	 */
	public void setMatricNumber(String matricNumber){ this.matricNumber = matricNumber; }
	
	/**
	 * Change the gender of the student
	 * @param gender
	 */
	public void setGender(char gender){ this.gender = gender; }
	
	/**
	 * Change the nationality of the student
	 * @param nationality
	 */
	public void setNationality(String nationality){ this.nationality = nationality; }
	
	/**
	 * Change the starting access period of the student
	 * @param accessPeriod
	 */
	public void setAccessStart(Calendar accessStart){ this.accessStart = accessStart; }
	
	/**
	 * Change the end access period of the student
	 * @param accessPeriod
	 */
	public void setAccessEnd(Calendar accessEnd){ this.accessEnd = accessEnd; }
	
	/**
	 * Get the matric number of the student
	 * @return this matricNumber
	 */
	public String getMatricNumber(){ return this.matricNumber; }
	
	/**
	 * Get the gender of the student
	 * @return this gender
	 */
	public char getGender(){ return this.gender; }
	
	/**
	 * Get the nationality of the student
	 * @return this nationality
	 */
	public String getNationality(){ return this.nationality; }
	
	/**
	 * Get the starting access period of the student
	 * @return this accessPeriod
	 */
	public Calendar getAccessStart(){ return this.accessStart; }
	
	/**
	 * Get the ending access period of the student
	 * @return this accessPeriod
	 */
	public Calendar getAccessEnd(){ return this.accessEnd; }
	
	public ArrayList getCourseList() throws IOException{ 
		courselist = CoursesTextDB.readCourses(filename);
		return courselist;
	}
	
	public void setCourseList(ArrayList al) throws IOException{ 
		CoursesData.saveCourses(filename, al);
	}
	
	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student st = (Student) o;
			return (getLastName().equals(st.getLastName()));
		}
		return false;
	}
	
	public void printRegisteredCourses(){
		try {
		
			// read file containing Student records.
			ArrayList al = getCourseList();
			
			for (int i = 0 ; i < al.size() ; i++) {
					Course c =	(Course) al.get(i);
					System.out.println("Course Code " + "	:	" + c.getCourseCode() );
					System.out.println("Course Name " + "	:	" + c.getCourseName());
					System.out.println("Academic AU " + "	:	"  + c.getAcademicUnit());
					System.out.println("Index " + "		:	" + c.getIndex());
					System.out.println("Exam Date " +"	:	" + c.getExamDate());
					System.out.println();
			}
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	  }
	
	public void addCourse(String cc, String cn, int au,int i, String e){
		try {	
			// read file containing Student records.
			ArrayList al = getCourseList();
			Course course = new Course(cc,cn,au,i,e);
			al.add(course);
			setCourseList(al);
		}catch (IOException error) {
			System.out.println("IOException > " + error.getMessage());
		}
	}
	
	public void dropCourse(String cc, String cn, int au, int i, String e){
		try {	
			// read file containing Student records.
			ArrayList al = getCourseList();
			Course course = new Course(cc,cn,au,i,e);
			al.remove(course);
			setCourseList(al);
			
		}catch (IOException error) {
			System.out.println("IOException > " + error.getMessage());
		}	
	}
}
