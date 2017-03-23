package planner.db;

import java.io.*;
import java.text.*;
import java.util.*;

import planner.manager.CalendarMgr;
import planner.model.Course;

public class CourseData {

	public static final String SEPARATOR = "|";
	
	// an example of reading
	public static ArrayList readCourses(String filename) throws IOException, ParseException {
		// read String from text file
		ArrayList stringArray = (ArrayList) IO.read(filename);
		ArrayList alr = new ArrayList();// to store Courses data
		
		for (int i = 0; i < stringArray.size(); i++) {
			String st = (String) stringArray.get(i);
			// get individual 'fields' of the string separated by SEPARATOR
			// pass in the string to the string tokenizer using delimiter ","
			StringTokenizer star = new StringTokenizer(st, SEPARATOR);

			String courseCode = star.nextToken().trim(); // first token
			String courseName = star.nextToken().trim(); // second token
			int academicUnit = Integer.parseInt(star.nextToken().trim());// third token
			String school = star.nextToken().trim(); // fourth token
			Calendar examDate = CalendarMgr.stringToCalendar(star.nextToken().trim()); // fifth token

			// create Course object from file data
			Course course = new Course(courseCode, courseName, academicUnit, school, examDate);

			// add to Courses list
			alr.add(course);
		}
		return alr;
	}

	// an example of saving
	public static void saveCourses(String filename, List al) throws IOException {
		List alw = new ArrayList();// to store Courses data

		for (int i = 0; i < al.size(); i++) {
			Course course = (Course) al.get(i);
			StringBuilder st = new StringBuilder();
			st.append(course.getCourseCode().trim());
			st.append(SEPARATOR);
			st.append(course.getCourseName().trim());
			st.append(SEPARATOR);
			st.append(course.getAcademicUnit());
			st.append(SEPARATOR);
			st.append(course.getSchool());
			st.append(SEPARATOR);
			st.append(CalendarMgr.calendarToString(course.getExamDate()));
			
			alw.add(st.toString());
		}
		IO.write(filename, alw);
	}
}
