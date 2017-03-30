package planner.UI;

import java.io.IOException;
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
					updateCourseUI();
					break;
				case 3: // Remove a course
					removeCourseUI();
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
	 * Show a UI to add a new course
	 * done by the Staff
	 * @throws IOException 
	 */
	private static void addNewCourseUI() throws IOException{
		System.out.print("Enter the course's code:"); String courseCode = sc.nextLine();
		System.out.print("Enter the course's name:"); String courseName = sc.nextLine();
		System.out.print("Enter the number of AUs:"); int academicUnit = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the school that offers the course (eg: SCE):"); String school= sc.nextLine();
		
		Calendar examDate = CalendarMgr.getValidDateTime("examDate");
	
		StaffCourseMgr.addCourse(courseCode, courseName, academicUnit, school, examDate);	
	}
	
	private static void removeCourseUI() throws IOException{
		System.out.print("Enter the course's code:"); String courseCode = sc.nextLine();
		StaffCourseMgr.removeCourse(courseCode);	
	}
	
	private static void updateCourseUI() throws IOException{
		System.out.print("Enter the course's code:"); String courseCode = sc.nextLine();
	}
}
