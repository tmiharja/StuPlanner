package planner.manager;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import planner.UI.StudentUI;
import planner.db.CourseData;
import planner.db.IndexesData;
import planner.db.LessonData;
import planner.db.StudentData;
import planner.model.Course;
import planner.model.Index;
import planner.model.Lesson;
import planner.model.Student;

public class StudentCourseMgr {
	private static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Course> courseList	= new ArrayList<Course>();
	static ArrayList<Index> indexList	= new ArrayList<Index>();
	static ArrayList<Lesson> lessonList	= new ArrayList<Lesson>();
	/**
	 * Create a new course with the necessary information
	 * @throws ParseException 
	 * @throws IOException 
	 */	
	public static void registerCourse() throws IOException, ParseException {
		System.out.print("Enter the Index Number: ");
		int i = sc.nextInt();
		sc.nextLine();
		
		indexList = IndexesData.initIndexes();
		lessonList = LessonData.initLessons();
		courseList = CourseData.initCourses();
		
		for (Index in : indexList) {
			if (in.equals(i)) {
				System.out.println("Index Number: " + i);
				for (Course c : courseList) {
					if (c.getCourseCode().equals(in.getCourseCode())) {
						System.out.println("Course: " + in.getCourseCode());
						System.out.println("Course Type: " + c.getCourseType());
					}
				}
				
				System.out.println("Type\t Group\t\t Day\t\t Time\t\t Venue");
				System.out.println("-----------------------------------------------------------------");
				for (Lesson le : lessonList)
				{
					if(le.equals(i)){
						System.out.print(le.getLessonType() + "\t ");
						System.out.print(in.getTutorialGroup() + "\t\t ");
						System.out.print(le.getLessonDay() + "\t\t ");
						System.out.print(le.getLessonTime() + "\t ");
						System.out.print(le.getLessonVenue() + "\t ");
						System.out.println();
					}
				}
			}
		}
		System.out.println();
		System.out.print("Confirm to Add Course? (Y/N): ");
		char choice = sc.nextLine().charAt(0);
		if (choice == 'Y'){
			// add course
			
		}
		else if (choice == 'N'){
			StudentUI.showStudentOption();
		}
	}
	
	public static void removeCourse(String courseCode) throws IOException{
		for(Course i : courseList){
			if (i.getCourseCode().equals(courseCode.toUpperCase())){
				courseList.remove(i);
				CourseData.saveCourses(courseList);
				System.out.println("Course " + i.getCourseName() + " (" + courseCode + ") has been removed!");
			}
		}
	}
}