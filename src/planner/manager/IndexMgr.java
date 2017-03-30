package planner.manager;

import java.io.IOException;
import java.util.ArrayList;

import planner.db.CourseData;
import planner.db.IndexesData;
import planner.model.Course;
import planner.model.CourseList;
import planner.model.Index;
import planner.model.IndexList;


public class IndexMgr {
	static ArrayList<Index> indexList = IndexList.getIndexList();
	/**
	 * Create a new index specific to the course
	 * @throws IOException 

	 */	
	public static Index addIndex (String courseCode, String indexNumber, int vacancy, int waitingList) throws IOException  {
		
		Index newIndex = new Index(courseCode.toUpperCase(), indexNumber, vacancy, waitingList);
		indexList.add((Index) newIndex);
			
		IndexesData.saveIndexes(indexList);
		System.out.println("Index " + courseCode + " (" + indexNumber + ") has been successfully added!");
		
		return newIndex;
	}

}