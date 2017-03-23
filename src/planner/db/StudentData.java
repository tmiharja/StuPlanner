package planner.db;

import java.io.*;
import java.text.*;
import java.util.*;

import planner.manager.CalendarMgr;
import planner.model.Student;

public class StudentData {
	public static final String SEPARATOR = "|";
	
	public static ArrayList<Student> studentList = new ArrayList();// to store Students data

	// an example of reading
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> initStudents() throws IOException, ParseException {
		// read String from text file
		ArrayList<String> stringArray = (ArrayList) IO.read("src/planner/db/students.txt");
		
		for (int i = 0; i < stringArray.size(); i++) {
			String st = (String) stringArray.get(i);
			
			// get individual 'fields' of the string separated by SEPARATOR
			// pass in the string to the string tokenizer using delimiter ","
			StringTokenizer star = new StringTokenizer(st, SEPARATOR); 

			String firstName = star.nextToken().trim(); // first token
			String lastName = star.nextToken().trim(); // second token
			String matricNum = star.nextToken().trim(); // third token
			char gender = (star.nextToken().trim()).charAt(0); // fourth token
			String nationality = star.nextToken().trim(); // fifth token
			Calendar accessStart = CalendarMgr.stringToCalendar(star.nextToken().trim()); // sixth token
			Calendar accessEnd = CalendarMgr.stringToCalendar(star.nextToken().trim()); // seventh token

			Student std = new Student(firstName, lastName, matricNum, gender, nationality, accessStart, accessEnd);
			
			// add to Students list
			studentList.add(std);
		}
		return studentList;
	}

	// an example of saving
	public static void saveStudents(List al) throws IOException {
		List alw = new ArrayList();// to store Studetns data

		for (int i = 0; i < al.size(); i++) {
			Student std = (Student) al.get(i);
			StringBuilder st = new StringBuilder();
			st.append(std.getFirstName().trim());
			st.append(SEPARATOR);
			st.append(std.getLastName().trim());
			st.append(SEPARATOR);
			st.append(std.getMatNumber().trim());
			st.append(SEPARATOR);
			st.append(std.getGender());
			st.append(SEPARATOR);
			st.append(std.getNationality());
			st.append(SEPARATOR);
			st.append(CalendarMgr.calendarToString(std.getAccessStart()));
			st.append(SEPARATOR);
			st.append(CalendarMgr.calendarToString(std.getAccessEnd()));

			alw.add(st.toString());
		}
		IO.write("src/planner/db/students.txt", alw);
	}
}