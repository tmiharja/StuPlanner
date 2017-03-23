package planner.model;

import java.util.Calendar;

public class Lesson {
	/**
	 * The venue of the lesson
	 */
	private String venue;
	
	/**
	 * The time of the lesson
	 */
	private Calendar lessonTime;
	
	/**
	 * Boolean attribute to indicate whether or not
	 * the index has tutorial/ lecture/ lab
	 */
	private boolean hasClass;

	public Calendar getLessonTime() {
		return lessonTime;
	}

	public void setLessonTime(Calendar lessonTime) {
		this.lessonTime = lessonTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

}
