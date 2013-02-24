import javax.swing.table.DefaultTableModel;


public class WebFramework {
	protected static Term term;
	protected DefaultTableModel WeeklyTableModel = new DefaultTableModel(new Object[]{"Time", "M", "T", "W", "R", "F"}, 28);
	protected DefaultTableModel PlanningTableModel = new DefaultTableModel(new Object[]{"CRN", "Class", "Title", "Timeslot", "Instructor", "Prereq. For"}, 15);
	
	public void changeTerm(Term t) {
		term = t;
	}
	
	public void addClass(Integer CRN) {

	}
	
	public void removeClass(Integer CRN) {
		
	}
}
