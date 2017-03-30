package planner.UI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import planner.manager.PrintMgr;
import planner.manager.StudentCourseMgr;
import planner.manager.StudentMgr;
import planner.model.Student;
import planner.model.StudentList;



/**
 * The UI displayed to the staff as the admin.
 * @version 1.0
 * @since 2017-03-22
 */

public class StudentUI {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Display options user can perform on restaurant food menu.
	 * User can Add new food, new promotion package or remove 
	 * menu item from menu
	 */	
	public static void showStudentOption(){

		int choice;
	
		StudentWhileLoop:
		while (true){
			System.out.println("***Welcome to Student panel!***");
			System.out.println("Please select an action:");
			System.out.println("(1) Register Course");
			System.out.println("(2) Drop Course");
			System.out.println("(3) Check/Print Courses Registered");
			System.out.println("(4) Check Vacancies Available");
			System.out.println("(5) Change Index Number of Course");
			System.out.println("(6) Swop Index Number with Another Student");
			System.out.println("(7) Logout");

			System.out.print("> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1: // Register Course
					StudentCourseMgr.registerCourse();
					break;
				case 2: // Drop Course

					break;
				case 3: // Check/Print Courses Registered

					break;
				case 4: // Check Vacancies Available

					break;
				case 5: // Change Index Number of Course

					break;
				case 6: // Swop Index Number with Another Student

					break;
				case 7: // Logout
					System.out.println("Successfully Logged Out!");
					System.out.println();
					break StudentWhileLoop;
				default:
					System.out.println("Invalid Input! Please re-enter!");
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println("Invalid Input! Please re-enter!");
				System.out.println();
			}
		}
	}
}
