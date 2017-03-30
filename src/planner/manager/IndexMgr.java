package planner.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import planner.db.CourseData;
import planner.db.IndexesData;
import planner.model.Course;
import planner.model.Index;


public class IndexMgr {
	private static ArrayList<Index> newIndexList = new ArrayList<Index>();
	/**
	 * Create a new index specific to the course
	 * @throws IOException 
	 * @throws ParseException 

	 */	
	public static Index addIndex (String courseCode, int indexNumber, String tutorialGroup, int vacancy, int waitingList) throws IOException, ParseException  {
		Index newIndex = new Index(courseCode.toUpperCase(), indexNumber, tutorialGroup, vacancy, waitingList);
		newIndexList = IndexesData.initIndexes();
		newIndexList.add(newIndex);
			
		IndexesData.saveIndexes(newIndexList);
		System.out.println("Index " + courseCode + " (" + indexNumber + ") has been successfully added!");
		
		return newIndex;
	}

}