package planner.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import planner.db.LessonData;
import planner.model.Lesson;

public class LessonMgr {
	static ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
	/**
	 * Create a new index specific to the course
	 * @throws IOException 
	 * @throws ParseException 
	 */	
	public static void addLesson (int indexNumber, String lessonType, String lessonDay, String lessonTime, String lessonVenue) throws IOException, ParseException  {
		
		Lesson newLesson = new Lesson(indexNumber, lessonType, lessonDay, lessonTime, lessonVenue);
		lessonList = LessonData.initLessons();
		lessonList.add(newLesson);
		
		LessonData.saveLessons(lessonList);
	}
}
