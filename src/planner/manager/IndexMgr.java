package planner.manager;

import planner.model.Course;
import planner.model.Index;


public class IndexMgr {
	
	/**
	 * Create a new index specific to the course

	 */	
	public static Index addIndex (Course course, int indexNumber, int vacancy, int isLecture, int isTutorial, int isLab)  {
		
		Index newIndex = new Index(indexNumber, vacancy, isLecture, isTutorial, isLab);
		
		(course.getIndexList()).add((Index) newIndex);
		
		System.out.println("Index Number " + indexNumber + " of course" + course.getCourseName() + " has been added!");
		return newIndex;
	}

}
