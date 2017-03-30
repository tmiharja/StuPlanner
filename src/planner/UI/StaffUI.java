package planner.UI;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import planner.manager.CalendarMgr;
import planner.manager.IndexMgr;
import java.text.*;
import java.util.*;
import planner.manager.AccountMgr;
import planner.manager.PrintMgr;
import planner.manager.StaffCourseMgr;
import planner.manager.StudentMgr;
import planner.model.Course;
import planner.model.CourseList;
import planner.model.Index;
import planner.manager.UserValidationMgr;
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
		
		StaffWhileLoop:
		while(true){
			System.out.println("***Welcome to Staff panel!***");
			System.out.println("Please select an action:");
			System.out.println("(1) Edit student access period");
			System.out.println("(2) Add a student");
			System.out.println("(3) Add/Update a course");
			System.out.println("(4) Add an index to a course");
			System.out.println("(5) Check available (vacancy) slot for an index number");
			System.out.println("(6) Print student list by index number");
			System.out.println("(7) Print student list by course");
			System.out.println("(8) Logout");

			System.out.print("> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1: // Edit student access period
					editAccessTimeUI();
					break;
				case 2: // Add a student
					addNewStudentUI();
					System.out.println("A New Student Added Successfully!");
					System.out.println();
					break;
				case 3: // Add/Update a course
					CourseUI.addUpdateCourseUI();
					break;
					
				case 4: // Add an index to a course
					addIndexUI();
					break;
					
				case 5: // Check available vacancy for an index
					break;

				case 6: // Print student list by index number

					break;
				case 7: // Print student list by course

					break;
				case 8: // Logout
					System.out.println("Successfully Logged Out!");
					System.out.println();
					break StaffWhileLoop;
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
    
    /** Show a UI that prompts Staff of the students'
    * details to add new student
    * @throws ParseException
    */
    private static void addNewStudentUI() throws ParseException{
        System.out.print("Enter the student's username: "); String username = sc.nextLine();
        System.out.print("Enter the student's first name: "); String firstName = sc.nextLine();
        System.out.print("Enter the student's last name: "); String lastName = sc.nextLine();
        System.out.print("Enter the student's matric number: "); String matricNumber = sc.nextLine();
        System.out.print("Enter the student's gender: "); char gender= sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Enter the student's nationality: "); String nationality = sc.nextLine();
        
        Calendar accessStart = CalendarMgr.getValidDateTime("access start");
        Calendar accessEnd = CalendarMgr.getValidDateTime("access end");
        
        String salt = UserValidationMgr.generateSalt();
        
        AccountMgr.addAccount(username, matricNumber, salt);
        StudentMgr.addStudent(firstName, lastName, matricNumber, gender, nationality, accessStart, accessEnd);
    }
	
	 /* Show a UI to update the students' access period
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
		
	    Calendar newAccessStart = CalendarMgr.getValidDateTime("new access start");
	    Calendar newAccessEnd = CalendarMgr.getValidDateTime("new access end");
	        
		StudentMgr.updateAccessPeriod(studentToUpdate, newAccessStart, newAccessEnd);
	}
	
	/**
	 * Show a UI to add a new index to a course
	 * done by the Staff
	 * @throws IOException 
	 */
	private static void addIndexUI(){

		int choice;
		Index newIndex;
		ArrayList<Course> courseList = CourseList.getCourseList();
		Course courseToUpdate;
		PrintMgr.printCourseList();
		
		System.out.println("\nSelect the course:");
		
		choice = sc.nextInt();
		courseToUpdate = courseList.get(choice);
		
		System.out.print("Enter the index number:"); int indexNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the index vacancy:"); int vacancy = sc.nextInt();
		sc.nextLine();
		System.out.print("Does this index has lecture? (1 = yes, 0 = no)"); int isLecture = sc.nextInt();
		sc.nextLine();
		System.out.print("Does this index has tutorial? (1 = yes, 0 = no)"); int isTutorial = sc.nextInt();
		sc.nextLine();
		System.out.print("Does this index has lab? (1 = yes, 0 = no)"); int isLab = sc.nextInt();
		sc.nextLine();
		
		newIndex = IndexMgr.addIndex(courseToUpdate, indexNumber, vacancy, isLecture, isTutorial, isLab);
		
		if (isLecture == 1){
			
		}
		if (isTutorial == 1){
			
		}
		if (isLab == 1){
			
		}	
		PrintMgr.printIndexList(courseToUpdate);
        
	}
}
