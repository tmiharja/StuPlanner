package planner.model;

import java.util.Calendar;

public class Lesson {
	/**
	 * The venue of the lesson
	 */
	protected String venue;
	
	/**
	 * The time of the lesson
	 */
	protected Calendar lessonStart;
	protected Calendar lessonEnd;
	

	public Calendar getLessonStart() {
		return lessonStart;
	}

	public void setLessonStart(Calendar lessonStart) {
		this.lessonStart = lessonStart;
	}

	public Calendar getLessonEnd() {
		return lessonEnd;
	}

	public void setLessonEnd(Calendar lessonEnd) {
		this.lessonEnd = lessonEnd;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

}
