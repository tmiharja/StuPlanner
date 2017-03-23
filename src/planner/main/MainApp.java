package planner.main;

import java.text.ParseException;

import planner.UI.StaffUI;
import planner.db.PlannerData;

public class MainApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		PlannerData.initStudents();
		StaffUI.showStaffOption();  

	}

}
