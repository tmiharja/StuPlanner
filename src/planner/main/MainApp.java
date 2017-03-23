package planner.main;

import java.io.IOException;
import java.text.*;
import java.util.*;

import planner.UI.StaffUI;
import planner.UI.StudentUI;
import planner.db.PlannerData;
import planner.db.CoursesData;
import planner.manager.UserValidationMgr;
import planner.model.Account;

public class MainApp {

	public static void main(String[] args) throws ParseException, IOException {

		// TODO Auto-generated method stub
		PlannerData.initStudents();
		CoursesData.initCourses();
		StaffUI.showStaffOption();  

		do {
			String username;
			String password;
			String accountType = "";
			int choice = 0;
			Account loggedInAcc;

            Scanner sc = new Scanner(System.in);
			
			mainLoop: 
			while (true) {
				domainLoop:
                
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
							break domainLoop;
						case 2:
							accountType = "Staff";
							break domainLoop;
						default:
							System.out.println("Invalid Input! Please re-enter!");
							System.out.println();
						}
					} catch (Exception e) {
						System.out.println("Invalid Input! Please re-enter!");
						System.out.println();
					}
				}

				System.out.print("Username: ");
				username = sc.nextLine();
				System.out.print("Password: ");
				password = sc.nextLine();

				loggedInAcc = UserValidationMgr.compareUserPass(username, password, accountType);
				if (!(loggedInAcc == null)) {
					break mainLoop;
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
		} while (true);
		
	}
}
