package planner.model;

import java.util.Calendar;

public class Lab extends Lesson{
	
	private boolean isEvenOrOdd;
	
	public Lab (String venue, Calendar lessonStart, Calendar lessonEnd, boolean isEvenOrOdd){
		this.venue = venue;
		this.lessonStart = lessonStart;
		this.lessonEnd = lessonEnd;
		
	}

	public boolean isEvenorOdd() {
		return isEvenOrOdd;
	}

	public void setEvenorOdd(boolean isEvenOrOdd) {
		this.isEvenOrOdd = isEvenOrOdd;
	}
	

}
