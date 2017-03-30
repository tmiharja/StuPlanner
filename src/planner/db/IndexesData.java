package planner.db;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import planner.model.Course;
import planner.model.CourseList;
import planner.model.Index;

public class IndexesData {
	public static final String SEPARATOR = "|";
	
	/** Initialise the indexess before application starts
     * @param filename
     * @throws IOException
     * @throws ParseException 
     */
	@SuppressWarnings({ "rawtypes", "unchecked"})
	
	public static ArrayList <Index> IndexList = new ArrayList() ;
	
	public static ArrayList<Index> initIndexes() throws IOException, ParseException {
		
		// read String from text file
		ArrayList<String> stringArray = (ArrayList) IO.read("src/planner/db/indexes.txt");
		
		
        for (int i = 0 ; i < stringArray.size() ; i++) {
        	
				String field = (String) stringArray.get(i);
				
				// get individual 'fields' of the string separated by SEPARATOR
				// pass in the string to the string tokenizer using delimiter "," 
				StringTokenizer tokenizer = new StringTokenizer(field, SEPARATOR);	
				
				//first to fifth tokens
				String  courseCode = tokenizer.nextToken().trim();	
				String  indexNumber = tokenizer.nextToken().trim();	
				int vacancies = Integer.parseInt(tokenizer.nextToken().trim());
				int waitingList = Integer.parseInt(tokenizer.nextToken().trim());
				
				// create Course object from file data
				Index index = new Index(courseCode, indexNumber, vacancies, waitingList);
				// add to Courses list 
				IndexList.add(index) ;
		}
		return IndexList ;
	}

	
	public static void searchVacancy(String CourseCode,String indexNumber)throws IOException
	{
		ArrayList<String> stringArray = (ArrayList) IO.read("src/planner/db/indexes.txt");
		for (int i = 0 ; i < stringArray.size() ; i++) {
        	
			String field = (String) stringArray.get(i);
			
			// get individual 'fields' of the string separated by SEPARATOR
			// pass in the string to the string tokenizer using delimiter "," 
			StringTokenizer tokenizer = new StringTokenizer(field, SEPARATOR);	
			
			//first to fifth tokens
			String  courseCode = tokenizer.nextToken().trim();	
			String  indexNumber1 = tokenizer.nextToken().trim();	
			int vacancies = Integer.parseInt(tokenizer.nextToken().trim());
			int waitingList = Integer.parseInt(tokenizer.nextToken().trim());
			
			if(courseCode.equalsIgnoreCase(CourseCode))
			{
				if(indexNumber.equals( indexNumber1))
				System.out.println("Index Number: "+indexNumber1+" \t Vacancies: "+vacancies);
			}
		}
	}
		public static void showIndex(String CourseCode)throws IOException
		{
			ArrayList<String> stringArray = (ArrayList) IO.read("src/planner/db/indexes.txt");
			int t=0;
			for (int i = 0 ; i < stringArray.size() ; i++) {
	        	
				String field = (String) stringArray.get(i);
				
				// get individual 'fields' of the string separated by SEPARATOR
				// pass in the string to the string tokenizer using delimiter "," 
				StringTokenizer tokenizer = new StringTokenizer(field, SEPARATOR);	
				
				//first to fifth tokens
				String  courseCode = tokenizer.nextToken().trim();	
				String  indexNumber1 = tokenizer.nextToken().trim();	
				int vacancies = Integer.parseInt(tokenizer.nextToken().trim());
				int waitingList = Integer.parseInt(tokenizer.nextToken().trim());
				
				if(courseCode.equalsIgnoreCase(CourseCode))
				{
					
					System.out.println(t+1+") Index Number: "+indexNumber1);
					t++;
				}
			}
	
		}
		
		/** Save the courses that has been added during the session
		 * @param CourseToUpdate
		 * @throws IOException
		 */
		public static void saveIndexes(ArrayList<Index> IndexToUpdate) throws IOException {
			ArrayList <String> cl = new ArrayList<String>() ;// to store Courses data

	        for (int i = 0 ; i < IndexToUpdate.size() ; i++) {
					Index index = (Index) IndexToUpdate.get(i);
					StringBuilder stringBuild =  new StringBuilder() ;
					stringBuild.append(index.getCourseCode().trim());
					stringBuild.append(SEPARATOR);
					stringBuild.append(index.getIndexNumber().trim());
					stringBuild.append(SEPARATOR);
					stringBuild.append(index.getVacancy());
					stringBuild.append(SEPARATOR);
					stringBuild.append(index.getWaitingList());

					cl.add(stringBuild.toString()) ;
				}
				IO.write("src/planner/db/indexes.txt",cl);
		}
}