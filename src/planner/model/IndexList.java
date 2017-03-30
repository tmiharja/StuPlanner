package planner.model;

import java.util.ArrayList;

import planner.db.IndexesData;

public class IndexList {
	/**
	 * The list of indexes that student can register to
	 * specific to each course
	 */
	
    public static ArrayList<Index> IndexList = IndexesData.IndexList;
	/**
	 * Add index to the index list
	 */
	public void add(Index newIndex){ IndexList.add(newIndex); }
	
	/**
	 * Get the array of indexes
	 * @return this index list
	 */
	public static ArrayList<Index> getIndexList(){ return IndexList; }

}