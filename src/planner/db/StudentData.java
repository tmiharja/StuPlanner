import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

import planner.model.Student;

public class StudentData {
	public static final String SEPARATOR = "|";

    // an example of reading
	public static ArrayList readStudents(String filename) throws IOException {
		// read String from text file
		ArrayList stringArray = (ArrayList)read(filename);
		ArrayList alr = new ArrayList() ;// to store Students data

        for (int i = 0 ; i < stringArray.size() ; i++) {
				String st = (String)stringArray.get(i);
				// get individual 'fields' of the string separated by SEPARATOR
				StringTokenizer star = new StringTokenizer(st , SEPARATOR);	// pass in the string to the string tokenizer using delimiter "," 
				String  name = star.nextToken().trim();	// first token
				String  matricNum = star.nextToken().trim();	// second token
				char gender = (star.nextToken().trim()).charAt(0); // third token
				String nationality = star.nextToken().trim();
				//CourseList courseList = star.nextToken().trim());
				// create Professor object from file data
				Student std = new Student(name, matricNum, gender, nationality); 
				// add to Professors list
				alr.add(std) ;
			}
			return alr ;
	}



// an example of saving
public static void saveStudents(String filename, List al) throws IOException {
		List alw = new ArrayList() ;// to store Studetns data

        for (int i = 0 ; i < al.size() ; i++) {
				Student std = (Student)al.get(i);
				StringBuilder st =  new StringBuilder() ;
				st.append(std.getName().trim());
				st.append(SEPARATOR);
				st.append(std.getMatNum().trim());
				st.append(SEPARATOR);
				st.append(std.getGender());
				st.append(SEPARATOR);
				st.append(std.getNationality());
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

public static void start(){
    	TextDB txtDB = new TextDB();
    	String filename = "student.txt" ;
		try {
		
			// read file containing Student records.
			ArrayList al = TextDB.readStudents(filename) ;
			for (int i = 0 ; i < al.size() ; i++) {
					Student stud = (Student)al.get(i);
					System.out.println("Name " + "			:	" + stud.getName() );
					System.out.println("Matric Number " + "		:	" + stud.getMatNum());
					System.out.println("Gender " + "			:	"  + stud.getGender() );
					System.out.println("Nationality " +"		:	" + stud.getNationality() );
					System.out.println();
			}
			Student s1 = new Student("Alvin Lee", "J13345345X", 'M', "Singapore");
			// al is an array list containing Student objs
			//al.add(s1);
			al.remove(s1);
			// write Student record/s to file.
			TextDB.saveStudents(filename, al);
		}catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}
  }
}