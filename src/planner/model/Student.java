package planner.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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
	//The specific access period of the student
	 */
	private Date accessPeriod;
	
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
	public Student (String matricNumber, char gender, String nationality) {
		this.matricNumber	= matricNumber;
		this.gender			= gender;
		this.nationality	= nationality;
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
	 * Change the access period of the student
	 * @param accessPeriod
	 */
	public void setAccessPeriod(Date accessPeriod){ this.accessPeriod = accessPeriod; }
	
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
	 * Get the access period of the student
	 * @return this accessPeriod
	 */
	public Date getAccessPeriod(){ return this.accessPeriod; }
	
	
	
	
	

}
