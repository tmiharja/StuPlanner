package planner.UI;

import java.io.IOException;
import java.text.*;
import java.util.*;

import planner.db.IndexesData;
import planner.manager.AccountMgr;
import planner.manager.CalendarMgr;
import planner.manager.IndexMgr;
import planner.manager.PrintMgr;
import planner.manager.StaffCourseMgr;
import planner.manager.StudentMgr;
import planner.manager.UserValidationMgr;
import planner.model.Course;
import planner.model.CourseList;
import planner.model.Index;
import planner.model.IndexList;

public class IndexUI {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Show a UI that prompts Staff to add/update courses
	 * @throws ParseException 
	 */
	public static void addUpdateIndexUI() throws ParseException{
		int choice;
		
		CourseWhileLoop:
		while(true){
			System.out.println("***Welcome to Index panel!***");
			System.out.println("Please select an action:");
			System.out.println("(1) Add a new index");
			System.out.println("(2) Update existing index");
			System.out.println("(3) Remove a index");
			System.out.println("(4) Print list of indexes");
			System.out.println("(5) Back");

			System.out.print("> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1: // Add a new index
					addNewIndexUI();
					break;
				case 2: // Update existing Indexes
					break;
				case 3: // Remove an Index
					break;
				case 4: // Print list of indexes

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
	
	private static void addNewIndexUI() throws IOException{
		ArrayList<Course> courseList = CourseList.getCourseList();
		ArrayList<Index> indexList = IndexList.getIndexList() ;
		
		System.out.print("Enter the course's code:"); String courseCode = sc.nextLine();
		System.out.print("Enter the index number:"); String indexNumber = sc.next();
		sc.nextLine();
		System.out.print("Enter the index vacancy:"); int vacancy = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the index waiting list:"); int waitingList = sc.nextInt();
		sc.nextLine();
		
		IndexMgr.addIndex(courseCode, indexNumber , vacancy, waitingList);
	}
	
	private static void Vacancy() throws IOException
	{	
		int indexNumber;
		int choice,t=0;
		Course courseToUpdate;
		Index newIndex;
		ArrayList<Course> courseList = CourseList.getCourseList();
		ArrayList<Index> indexList = IndexList.getIndexList() ;
		
		PrintMgr.printCourseList();
		System.out.println("\nSelect the course:");
		choice = sc.nextInt();
		courseToUpdate = courseList.get(choice-1);
		
		IndexesData.showIndex(courseToUpdate.getCourseCode());
		System.out.print("Please enter the index number to check: ");
		indexNumber = sc.nextInt();
		sc.nextLine();
		newIndex = indexList.get(indexNumber-1);
		//System.out.print(newIndex);
		IndexesData.searchVacancy(courseToUpdate.getCourseCode() , newIndex.getIndexNumber());
		
		return;
	}
}
