package planner.model;

public class Index {
	
	private int indexNumber;
	
	private int vacancy;
	
	private int isLecture;

	private int isTutorial;
	
	private int isLab;
	
	Lesson lessonSchedule;
	
	public Index (int indexNumber, int vacancy, int isLecture, int isTutorial, int isLab){
		this.indexNumber = indexNumber;
		this.vacancy = vacancy;
		this.isLecture = isLecture;
		this.isTutorial = isTutorial;
		this.isLab = isLab;
	}
	
	public int isLecture() {
		return isLecture;
	}

	public void setLecture(int isLecture) {
		this.isLecture = isLecture;
	}

	public int isTutorial() {
		return isTutorial;
	}

	public void setTutorial(int isTutorial) {
		this.isTutorial = isTutorial;
	}

	public Lesson getLessonSchedule() {
		return lessonSchedule;
	}

	public void setLessonSchedule(Lesson lessonSchedule) {
		this.lessonSchedule = lessonSchedule;
	}

	public int getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(int indexNumber) {
		this.indexNumber = indexNumber;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public int isLab() {
		return isLab;
	}

	public void setLab(int isLab) {
		this.isLab = isLab;
	}

}
