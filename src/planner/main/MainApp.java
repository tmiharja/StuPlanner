package planner.main;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import planner.UI.StaffUI;
import planner.UI.StudentUI;
import planner.db.PlannerData;
import planner.db.TextDB;
import planner.model.Account;

public class MainApp {

	public static void main(String[] args) throws ParseException {
		do {
			String filename = "src/planner/db/accounts.txt";
			String username;
			String password;
			String accountType = "";
			int choice = 0;
			Account loggedInAcc;

			try {
				// read file containing Account records.
				ArrayList list = TextDB.readAccounts(filename);
				Scanner sc = new Scanner(System.in);

				mainLoop: 
				while(true){
						System.out.println("********Select Domain********");
						System.out.println("(1) Student");
						System.out.println("(2) Staff");
						System.out.print("> ");
						try {
							choice = Integer.parseInt(sc.nextLine());
							switch (choice) {
							case 1:
								accountType = "Student";
								break;
							case 2:
								accountType = "Staff";
								break;
							default:
								System.out.println("Invalid Input! Please re-enter!");
								System.out.println();
							}
						} catch (Exception e) {
							System.out.println("Invalid Input! Please re-enter!");
							System.out.println();
						}

					System.out.print("Username: ");
					username = sc.nextLine();
					System.out.print("Password: ");
					password = sc.nextLine();

					for (int i = 0; i < list.size(); i++) {
						Account acc = (Account) list.get(i);

						if (username.equals(acc.getUsername()) && password.equals(acc.getPassword())
								&& accountType.equals(acc.getAccountType())) {
							loggedInAcc = acc;
							break mainLoop;
						}
					}

					System.out.println();
					System.out.println("Incorrect username or password! Please re-enter!");
					System.out.println();
				}

				System.out.println();
				System.out.println("Hello, " + loggedInAcc.getUsername() + "!");

				if (loggedInAcc.getAccountType().equals("Student")) {
					PlannerData.initStudents();
					StudentUI.showStudentOption();
				} else if (loggedInAcc.getAccountType().equals("Staff")) {
					PlannerData.initStudents();
					StaffUI.showStaffOption();
				}

				// SAVE/CREATE ACCOUNT
				// Account acc = new Account("alvin","lee","Student");
				// list is an array list containing Account objs
				// list.add(acc);
				// write Account record/s to file.
				// TextDB.saveAccounts(filename, list);
			} catch (IOException e) {
				System.out.println("IOException > " + e.getMessage());
			}
		} while (true);
	}
}
