package planner.model;

import java.util.ArrayList;

public class IndexList {
	/**
	 * The list of indexes that student can register to
	 * specific to each course
	 */
	public static ArrayList<Index> indexList = new ArrayList<Index>();
	
	/**
	 * Add index to the index list
	 */
	public void add(Index newIndex){ indexList.add(newIndex); }
	
	/**
	 * Get the array of indexes
	 * @return this index list
	 */
	public ArrayList<Index> getIndexList(){ return indexList; }

}