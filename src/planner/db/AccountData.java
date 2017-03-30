package planner.db;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.*;


import planner.model.Account;
import planner.model.Student;

public class AccountData {
	public static final String SEPARATOR = "|";

	//read account data 
	public static ArrayList readAccounts(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList) IO.read(filename);
		ArrayList alr = new ArrayList();// to store account data

		for (int i = 0; i < stringArray.size(); i++) {
			String st = (String) stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			// pass in the string to the string tokenizer using delimiter "|"
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);

			String username = star.nextToken().trim(); // first token
			String password = star.nextToken().trim(); // second token
			String accountType = star.nextToken().trim(); // third token
			String salt = star.nextToken().trim(); // fourth token
			// create Account object from file data
			Account acc = new Account(username, password, accountType, salt);
			// add to Account list
			alr.add(acc);
		}
		return alr;
	}

	// save new entry 
	public static void saveAccounts(String filename, List al) throws IOException {
		List alw = new ArrayList(); 

		for (int i = 0; i < al.size(); i++) {
			Account acc = (Account) al.get(i);
			StringBuilder st = new StringBuilder();
			st.append(acc.getUsername().trim());
			st.append(SEPARATOR);
			st.append(acc.getPassword().trim());
			st.append(SEPARATOR);
			st.append(acc.getAccountType().trim());
			st.append(SEPARATOR);
			st.append(acc.getSalt().trim());
			alw.add(st.toString());
		}
		IO.write(filename, alw);
	}
}