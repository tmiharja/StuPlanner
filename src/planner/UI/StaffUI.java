package planner.UI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import planner.manager.PrintMgr;
import planner.manager.StudentMgr;
import planner.model.Student;
import planner.model.StudentList;



/**
 * The UI displayed to the staff as the admin.
 * @version 1.0
 * @since 2017-03-22
 */

public class StaffUI {
	
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Display options user can perform on restaurant food menu.
	 * User can Add new food, new promotion package or remove 
	 * menu item from menu
	 */	
	public static void showStaffOption(){
		
		int choice;
		
        do {
        	System.out.println("\nSelect a choice: ");
            System.out.println("(1) Add new student");
            System.out.println("(2) Change student's access time");
            System.out.println("(3) Back");
        	choice = sc.nextInt();
        	sc.nextLine();
        	
        	switch (choice) {
	            case 1: 
	            		addNewStudentUI();
	                    break;
	            case 2:
	            		editAccessTimeUI();
	                    break;
	            case 3:
        	}
        } while (choice < 3);
	}
	
	/**
	 * Show a UI that prompts Staff of the students'
	 * details to add new student
	 */
	private static void addNewStudentUI(){

		System.out.print("Enter the student's first name:"); String firstName = sc.nextLine();
		System.out.print("Enter the student's last name:"); String lastName = sc.nextLine();
		System.out.print("Enter the student's matric number:"); String matricNumber = sc.nextLine();
		System.out.print("Enter the student's gender:"); char gender= sc.next().charAt(0);
		sc.nextLine();
		System.out.print("Enter the student's nationality: "); String nationality = sc.nextLine();
		
		Calendar accessStart = StudentMgr.getValidDateTime("start");
		Calendar accessEnd = StudentMgr.getValidDateTime("end");
		  	
		StudentMgr.addStudent(firstName, lastName, matricNumber, gender, nationality, accessStart, accessEnd);

	}
	
	/**
	 * Show a UI to update the students' access period
	 * done by the Staff
	 */
	private static void editAccessTimeUI(){

		int choice;
		ArrayList<Student> students = StudentList.getStudents();
		Student studentToUpdate;
		PrintMgr.printStudentList();
		
		System.out.println("\nSelect the student whose access period is to be updated:");
		
		choice = sc.nextInt();
		studentToUpdate = students.get(choice);
		
		Calendar newAccessStart = StudentMgr.getValidDateTime("new start");
		Calendar newAccessEnd = StudentMgr.getValidDateTime("new end");
		
		StudentMgr.updateAccessPeriod(studentToUpdate, newAccessStart, newAccessEnd);
	}
}
