package planner.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import planner.db.CourseData;
import planner.db.IndexesData;
import planner.model.Course;
import planner.model.Index;
import planner.model.Student;
import planner.model.StudentList;

/**
 * Manages the printing of the student list and staff list
 * @version 1.0
 * @since 2017-03-21
 */

public class PrintMgr {

	/**
	 * Print out all the student names on the Student List
	 * from index 0 to the end of the array
	 */
	public static void printStudentList(){
		ArrayList<Student> students = StudentList.getStudents();
		if(students.size() <= 0){
			System.out.println("There are no student in the list.");
			return;
		}
		else{
			int index = 0;
			for(Student student : students) {
				System.out.println("(" + index++ + ") " + student.getFirstName() + " " + student.getLastName());
			}
		}
	}
	
	/**
	 * Print out all the courses on the Course List
	 * from index 0 to the end of the array
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static void printCourseList() throws IOException, ParseException{
		ArrayList<Course> courses = CourseData.initCourses();
		if(courses.size() <= 0){
			System.out.println("There are no course in the list.");
			return;
		}
		else{
			int index = 0;
			for(Course course : courses) {
				System.out.println("(" + index++ + ") " + course.getCourseName() + " " + course.getCourseCode());
			}
		}
	}
	
	/**
	 * Print out all the indexes of a course
	 * from index 0 to the end of the array
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public static void printIndexList(Course course) throws IOException, ParseException{
		
		ArrayList<Index> indexList = IndexesData.initIndexes();
		if(indexList.size() <= 0){
			System.out.println("There is no index for this course.");
			return;
		}
		else{
			int counter = 0;
			for(Index index : indexList) {
				System.out.println("(" + counter++ + ") " + index.getIndexNumber() + " " + index.getVacancy());
			}
		}
	}
	

}
