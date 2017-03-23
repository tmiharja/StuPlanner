package planner.db;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import planner.model.Course;

public class CoursesData {
	public static final String SEPARATOR = "|";

    // an example of reading
	@SuppressWarnings("rawtypes")
	public static ArrayList readCourses(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Courses data
		
        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st, SEPARATOR);	// pass in the string to the string tokenizer using delimiter "," 
				
				String  courseCode = star.nextToken().trim();	// first token
				String  courseName = star.nextToken().trim();	// second token
				int academicUnit = Integer.parseInt(star.nextToken().trim());// third token
				int index = Integer.parseInt(star.nextToken().trim()); //fourth token
				String examDate = star.nextToken().trim(); //fifth token
	
				// create Course object from file data
				Course course = new Course(courseCode, courseName, academicUnit, index, examDate);
				// add to Courses list 
				alr.add(course) ;
		}
		return alr ;
	}



// an example of saving
public static void saveCourses(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Courses data

        for (int i = 0 ; i < al.size() ; i++) {
				Course course = (Course)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(course.getCourseCode().trim());
				st.append(SEPARATOR);
				st.append(course.getCourseName().trim());
				st.append(SEPARATOR);
				st.append(course.getAcademicUnit());
				st.append(SEPARATOR);
				st.append(course.getIndex());
				st.append(SEPARATOR);
				st.append(course.getExamDate());
				alw.add(st.toString()) ;
			}
			write(filename,alw);
	}

  /** Write fixed content to the given file. */
  public static void write(String fileName, List data) throws IOException  {
    PrintWriter out = new PrintWriter(new FileWriter(fileName));

    try {
		for (int i =0; i < data.size() ; i++) {
      		out.println((String)data.get(i));
		}
    }
    finally {
      out.close();
    }
  }

  /** Read the contents of the given file. */
  public static List read(String fileName) throws IOException {
	List data = new ArrayList() ;
    Scanner scanner = new Scanner(new FileInputStream(fileName));
    try {
      while (scanner.hasNextLine()){
        data.add(scanner.nextLine());
      }
    }
    finally{
      scanner.close();
    }
    return data;
  }
}
 