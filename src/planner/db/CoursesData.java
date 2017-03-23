package planner.db;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import planner.manager.DataMgr;
import planner.model.Course;

public class CoursesData {
	
	public static final String SEPARATOR = "|";
	
	/**ArrayList to store the course list
	 */
	public static ArrayList <Course> CourseList = new ArrayList() ;

    /** Initialise the courses before application starts
     * @param filename
     * @throws IOException
     * @throws ParseException 
     */
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static ArrayList<Course> initCourses() throws IOException, ParseException {
		
		// read String from text file
		ArrayList<String> stringArray = (ArrayList) DataMgr.read("src/planner/db/courses.txt");
		
		Calendar examDate = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date examDateD;
		
        for (int i = 0 ; i < stringArray.size() ; i++) {
        	
				String field = (String) stringArray.get(i);
				
				// get individual 'fields' of the string separated by SEPARATOR
				// pass in the string to the string tokenizer using delimiter "," 
				StringTokenizer tokenizer = new StringTokenizer(field, SEPARATOR);	
				
				//first to fifth tokens
				String  courseCode = tokenizer.nextToken().trim();	
				String  courseName = tokenizer.nextToken().trim();	
				int AU = Integer.parseInt(tokenizer.nextToken().trim());
				String school = tokenizer.nextToken().trim(); 
				String examDateS = tokenizer.nextToken().trim(); 
				
				examDateD = dateFormat.parse(examDateS);
				examDate.setTime(examDateD);
	
				// create Course object from file data
				Course course = new Course(courseCode, courseName, AU, school, examDate);
				// add to Courses list 
				CourseList.add(course) ;
		}
		return CourseList ;
	}



	/** Save the courses that has been added during the session
	 * @param CourseToUpdate
	 * @throws IOException
	 */
	public static void saveCourses(ArrayList<Course> CourseToUpdate) throws IOException {
		ArrayList <String> courseListRename = new ArrayList<String>() ;// to store Courses data

        for (int i = 0 ; i < CourseToUpdate.size() ; i++) {
				Course course = (Course) CourseToUpdate.get(i);
				StringBuilder stringBuild =  new StringBuilder() ;
				stringBuild.append(course.getCourseCode().trim());
				stringBuild.append(SEPARATOR);
				stringBuild.append(course.getCourseName().trim());
				stringBuild.append(SEPARATOR);
				stringBuild.append(course.getAU());
				stringBuild.append(SEPARATOR);
				stringBuild.append(course.getSchool());
				stringBuild.append(SEPARATOR);
				
				Calendar ExamDate = course.getExamDate();
				int day = ExamDate.get(Calendar.DAY_OF_MONTH);
				int month = ExamDate.get(Calendar.MONTH);
				int year = ExamDate.get(Calendar.YEAR);
				int hour = ExamDate.get(Calendar.HOUR_OF_DAY);
			    int minute = ExamDate.get(Calendar.MINUTE);
			    
			    String ExamDateS = String.format("%02d/%02d/%4d %02d:%02d", year, month+1, day, hour, minute);
				
				stringBuild.append(ExamDateS);

				courseListRename.add(stringBuild.toString()) ;
			}
			DataMgr.write("src/planner/db/courses.txt",courseListRename);
	}

}
 