package planner.model;

import java.io.Serializable;

/**
 * Represents the account data used by all users to access the
 * planner and the system.
 * @version 1.0
 * @since 2017-03-21
 */

public class UserAcc implements Serializable{
	
	/**
	//The username of the user for logging in
	 */
	private String username;
	
	/**
	//The password used for logging in
	 */
	private String password;
	
	/**
	//The first and last name of the user 
	 */
	protected String firstName;
	protected String lastName;
	
	/**
	 * Change the username of the user
	 * @param username
	 */
	public void setUsername(String username){ this.username = username; }
	
	/**
	 * Change the password of the user
	 * @param password
	 */
	public void setPassword(String password){ this.password = password; }
	
	/**
	 * Change the first and last names of the user
	 * @param firstname, lastName
	 */
	public void setFirstName(String firstName){ this.firstName = firstName; }
	public void setLastName(String lastName){ this.lastName = lastName; }
	
	/**
	 * Get the username of the user
	 * @return this username
	 */
	public String getUsername(){ return this.username; }
	
	/**
	 * Get the password of the user
	 * @return this password
	 */
	public String getPassword(){ return this.password; }

	/**
	 * Get the first and last name of the user
	 * @return this firstName, this lastName
	 */
	public String getFirstName(){ return this.firstName; }
	public String getLastName(){ return this.lastName; }
	
	
}
