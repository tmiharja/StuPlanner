package planner.db;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import planner.model.Account;

public class TextDB {
	public static final String SEPARATOR = "|";

	// an example of reading
	public static ArrayList readAccounts(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList) read(filename);
		ArrayList alr = new ArrayList();// to store Professors data

		for (int i = 0; i < stringArray.size(); i++) {
			String st = (String) stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			// pass in the string to the string tokenizer using delimiter ","
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);

			String username = star.nextToken().trim(); // first token
			String password = star.nextToken().trim(); // second token
			String accountType = star.nextToken().trim(); // third token
			// create Account object from file data
			Account acc = new Account(username, password, accountType);
			// add to Account list
			alr.add(acc);
		}
		return alr;
	}

	// an example of saving
	public static void saveAccounts(String filename, List al) throws IOException {
		List alw = new ArrayList();// to store Professors data

		for (int i = 0; i < al.size(); i++) {
			Account acc = (Account) al.get(i);
			StringBuilder st = new StringBuilder();
			st.append(acc.getUsername().trim());
			st.append(SEPARATOR);
			st.append(acc.getPassword().trim());
			st.append(SEPARATOR);
			st.append(acc.getAccountType());
			alw.add(st.toString());
		}
		write(filename, alw);
	}

	/** Write fixed content to the given file. */
	public static void write(String fileName, List data) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(fileName));

		try {
			for (int i = 0; i < data.size(); i++) {
				out.println((String) data.get(i));
			}
		} finally {
			out.close();
		}
	}

	/** Read the contents of the given file. */
	public static List read(String fileName) throws IOException {
		List data = new ArrayList();
		Scanner scanner = new Scanner(new FileInputStream(fileName));
		try {
			while (scanner.hasNextLine()) {
				data.add(scanner.nextLine());
			}
		} finally {
			scanner.close();
		}
		return data;
	}
}