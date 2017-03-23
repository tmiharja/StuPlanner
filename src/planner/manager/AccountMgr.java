package planner.manager;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import planner.db.AccountData;
import planner.model.Account;
import planner.model.Student;
import planner.model.StudentList;

/**
 * Student Manager Class manages the creation, removal 
 * of students from the student list
 * @version 1.0
 * @since 2017-03-21
 */

public class AccountMgr {
	
	static String filename = "src/planner/db/accounts.txt";
	
	private static Scanner sc = new Scanner(System.in);	
	
	/**
	 * Create a new student having the all necessary information.
	 * @param firstName
	 * @param lastName
	 * @param matricNumber
	 * @param gender
	 * @param nationality
	 */	
	public static void addAccount (String username, String password, String salt) {
		password = UserValidationMgr.hashing(password,salt);
		
		Account newAccount = new Account(username, password, "Student", salt);
		try{
			ArrayList accList = AccountData.readAccounts(filename);
			accList.add(newAccount);
			AccountData.saveAccounts(filename, accList);
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	}
}
