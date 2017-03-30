package planner.model;

public class Index {
	
	private String indexNumber;
	private String courseCode;
	private int vacancy;
	private int waitingList;
	
	/**
	 * Boolean attributes to indicate whether or not
	 * the index has tutorial/ lecture/ lab
	 */
	
	Lesson lessonSchedule;
	
	public Index (String courseCode, String indexNumber, int vacancy, int waitingList){
		this.courseCode = courseCode;
		this.indexNumber = indexNumber;
		this.vacancy = vacancy;
		this.waitingList = waitingList;
	}
	//Course Code
	public String getCourseCode()
	{
		return courseCode;
	}
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	//Index Number
	public String getIndexNumber()
	{
		return indexNumber;
	}
	public void setIndexNumber(String indexNumber)
	{
		this.indexNumber = indexNumber;
	}
	//Vacancy
	public int getVacancy()
	{
		return vacancy;
	}
	public void setVacancy(int vacancy)
	{
		this.vacancy = vacancy;
	}
	//Waiting List
	public int getWaitingList()
	{
		return waitingList;
	}
	public void setWaitingList(int waitingList)
	{
		this.waitingList = waitingList;
	}


}