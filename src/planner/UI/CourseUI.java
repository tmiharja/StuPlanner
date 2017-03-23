package planner.UI;

import java.text.*;
import java.util.*;

import planner.manager.AccountMgr;
import planner.manager.CalendarMgr;
import planner.manager.StaffCourseMgr;
import planner.manager.StudentMgr;
import planner.manager.UserValidationMgr;

public class CourseUI {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Show a UI that prompts Staff to add/update courses
	 * @throws ParseException 
	 */
	public static void addUpdateCourseUI() throws ParseException{
		int choice;
		
		CourseWhileLoop:
		while(true){
			System.out.println("***Welcome to Course panel!***");
			System.out.println("Please select an action:");
			System.out.println("(1) Add a new course");
			System.out.println("(2) Update existing course");
			System.out.println("(3) Remove a course");
			System.out.println("(4) Print list of courses");
			System.out.println("(5) Back");

			System.out.print("> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1: // Add a new course
					addNewCourseUI();
					break;
				case 2: // Update existing course
					
					break;
				case 3: // Remove a course
					
					break;
				case 4: // Print list of courses

					break;
				case 5: // Back
					break CourseWhileLoop;
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
	
	/**
	 * Show a UI that prompts Staff to add new courses
	 * @throws ParseException 
	 */
	private static void addNewCourseUI(){
		System.out.print("Enter a Course Code: "); String courseCode = sc.nextLine();
		System.out.print("Enter a Course Name: "); String courseName = sc.nextLine();
		System.out.print("Enter no. of Academic Unit: "); int academicUnit = Integer.parseInt(sc.nextLine());
		System.out.print("Enter the Course's School: "); String school = sc.nextLine();
		System.out.print("Enter the student's gender: "); char gender= sc.next().charAt(0);
		sc.nextLine();
		System.out.print("Enter the student's nationality: "); String nationality = sc.nextLine();
		
		System.out.print("Enter start access time (dd/MM/yyyy HH:mm): "); 
		Calendar examDate = CalendarMgr.getValidDateTime(sc.nextLine());
		
		//StaffCourseMgr.addCourse(courseCode, courseName, academicUnit, school, examDate);
	}
}
