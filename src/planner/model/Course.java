package planner.model;

public class Course {
	private String courseCode;
	private String courseName;
	private int academicUnit; 
	private int index;
	private String examDate;
	
	//constructor
	public Course(String cc, String cn, int au,int i, String e){
		courseCode = cc; 
		courseName = cn; 
		academicUnit = au; 
		index = i; 
		examDate = e; 	
	}
	//getters 
	public String getCourseCode(){
		return courseCode;
	}
	public String getCourseName(){
		return courseName;
	}	
	public int getAcademicUnit(){
		return academicUnit;
	}
	public int getIndex(){
		return index;
	}
	public String getExamDate(){
		return examDate;
	}
	
	//setters 
	public void setCourseCode(String cc){
		courseCode = cc; 
	}
	public void setCourseName(String cn){
		courseName = cn; 
	}	
	public void setAcademicUnit(int au){
		academicUnit = au;  
	}
	public void setIndex(int i){ 
		index = i; 
	}
	public void setExamDate(String e){
		examDate = e; 
	}
	
	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course st = (Course)o;
			return (getCourseCode().equals(st.getCourseCode()));
		}
		return false;
	}

}
