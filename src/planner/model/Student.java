package planner.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import planner.db.CourseData;
import planner.db.StudentData;

public class Student {
	
	private String firstName; 
	private String lastName;
	private String matricNumber;
	private char gender;
	private String nationality; 
	private Calendar accessStart;
	private Calendar accessEnd; 
	private ArrayList courselist;
	private ArrayList studentlist; 
	private static final String filename = "student.txt";
	
	//constructor
	public Student (String firstName, String lastName, String matricNumber, char gender, String nationality, Calendar accessStart, Calendar accessEnd) {
		this.firstName 			= firstName;
		this.lastName 			= lastName;
		this.matricNumber		= matricNumber;
		this.gender				= gender;
		this.nationality		= nationality;
		this.accessStart 		= accessStart;
		this.accessEnd 			= accessEnd;
	}
	
	//getters 
	public String getFirstName(){
		return firstName; 
	}
	public String getLastName(){
		return lastName; 
	}
	public String getMatNumber(){
		return matricNumber;
	}	
	public char getGender(){
		return gender; 
	}
	public String getNationality(){
		return nationality;
	}
	
	public Calendar getAccessStart() {
		return accessStart;
	}
	public Calendar getAccessEnd() {
		return accessEnd;
	}
	
	public ArrayList getCourseList() throws IOException, ParseException{ 
		courselist = CourseData.readCourses(filename);
		return courselist;
	}
	
	public ArrayList getStudentList() throws IOException, ParseException{
		studentlist = StudentData.readStudents(filename);
		return studentlist;
	}
	
	//setters
	public void setAccessStart(Calendar accessStart) {
		this.accessStart = accessStart;
	}
	
	public void setAccessEnd(Calendar accessEnd) {
		this.accessEnd = accessEnd;
	}

	public void setFirstName(String nm){
		firstName = nm;
	}
	public void setMatricNumber(String m){
		matricNumber = m; 
	}
	public void setGender(char g){
		gender = g; 
	}
	public void setNationality(String n){
		nationality = n; 
	}
	public void setCourseList(ArrayList al) throws IOException{ 
		CourseData.saveCourses(filename, al);
	}
	public void setStudentList(ArrayList al) throws IOException{
		StudentData.saveStudents(filename, al);
	}

	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student st = (Student) o;
			return (getLastName().equals(st.getLastName()));
		}
		return false;
	}
	
	public void printRegisteredCourses() throws ParseException{
		try {
		
			// read file containing Student records.
			ArrayList al = getCourseList();
			
			for (int i = 0 ; i < al.size() ; i++) {
					Course c =	(Course) al.get(i);
					System.out.println("Course Code " + "	:	" + c.getCourseCode() );
					System.out.println("Course Name " + "	:	" + c.getCourseName());
					System.out.println("Academic AU " + "	:	"  + c.getAcademicUnit());
					System.out.println("School " + "		:	" + c.getSchool());
					System.out.println("Exam Date " +"	:	" + c.getExamDate());
					System.out.println();
			}
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
	  }
	
	
	public void addCourse(String cc, String cn, int au,String s, Calendar e) throws ParseException{
		try {	
			// read file containing Student records.
			ArrayList al = getCourseList();
			Course course = new Course(cc,cn,au,s,e);
			al.add(course);
			setCourseList(al);
		}catch (IOException error) {
			System.out.println("IOException > " + error.getMessage());
		}
	}
	
	public void dropCourse(String cc, String cn, int au, String s, Calendar e) throws ParseException{
		try {	
			// read file containing Student records.
			ArrayList al = getCourseList();
			Course course = new Course(cc,cn,au,s,e);
			al.remove(course);
			setCourseList(al);
			
		}catch (IOException error) {
			System.out.println("IOException > " + error.getMessage());
		}	
	}
	
	public void addStudent(String fn, String ln,String mt, char c, String nt, Calendar std, Calendar ed) throws ParseException{
		try {	
			// read file containing Student records.
			ArrayList al = getStudentList();
			Student st = new Student(fn, ln,mt, c, nt, std, ed);
			al.add(st);
			setStudentList(al);
		}catch (IOException error) {
			System.out.println("IOException > " + error.getMessage());
		}
	}
	
	public void removeStudent(String fn, String ln, String mt, char c, String nt, Calendar std, Calendar ed) throws ParseException{
		try {	
			// read file containing Student records.
			ArrayList al = getStudentList();
			Student st = new Student(fn, ln, mt, c, nt, std, ed);
			al.remove(st);
			setStudentList(al);
			
		}catch (IOException error) {
			System.out.println("IOException > " + error.getMessage());
		}	
	}
	
	/*
	public static void main(String args[]){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date startDate = dateFormat.parse("19/4/2017 19:50");
		Date endDate = dateFormat.parse("21/4/2017 19:50");
		Student st = new Student("Htet Naing","U1620683D", 'M', "Myanmar", );
		st.addCourse("CZ30001", "ACOA", 3, 12345, "April 30,2017");
		st.printRegisteredCourses();
		TextDB txtDB = new TextDB();
		//txtDB.start();
	}
	*/
}
