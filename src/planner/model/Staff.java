package planner.model;
import java.io.Serializable;

/**
 * Represents the Staff who acts as the admin of the 
 * planner and the system.
 * @version 1.0
 * @since 2017-03-21
 */

public class Staff extends UserAcc implements Serializable{
	
	/**
	//The domain which differentiates students and staff
	 */
	private static final String DOMAIN = "STAFF";
	
	/**
	//The unique ID of the staff
	 */
	private String staffID;
	
	/**
	 * Create a new student having the all necessary information.
	 * @param matricNumber, gender, nationality
	 */	
	public Staff (String staffID){
		this.staffID = staffID;
	}

}
