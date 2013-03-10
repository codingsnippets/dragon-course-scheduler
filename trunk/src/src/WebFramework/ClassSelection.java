import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClassSelection extends Applet{
	private static final long serialVersionUID = 1L;
	protected static Term activeTerm;
	protected DefaultTableModel WeeklyTableModel = new DefaultTableModel(new Object[]{"Time", "M", "T", "W", "R", "F"}, 28);
	protected DefaultTableModel PlanningTableModel = new DefaultTableModel(new Object[]{"CRN", "Class", "Title", "Timeslot", "Instructor", "Prereq. For"}, 15);

	
	public void init() {	
		JPanel SelectClasses = new JPanel();
		SelectClasses.setLayout(new BoxLayout(SelectClasses, BoxLayout.Y_AXIS));
		
		JLabel Header = new JLabel("Dragon Course Scheduler");
		Header.setFont(new Font("Arial", Font.BOLD, 30));
		SelectClasses.add(Header);
		Header.setAlignmentX(Component.CENTER_ALIGNMENT);
		Header.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		
		JPanel UserHistory = new JPanel(new BorderLayout());
		JTextArea UserInfo = new JTextArea(10,0);
		JButton GoToMenu = new JButton("Menu (Change Term, Export/View Schedule, etc.)");
		UserHistory.add(UserInfo, BorderLayout.CENTER);
		UserHistory.add(GoToMenu, BorderLayout.EAST);
		SelectClasses.add(UserHistory);
		
		//currently planning
		JLabel CurrentlyPlanning = new JLabel("Currently Planning: " +/* activeTerm.toString() +*/ " Term");
		CurrentlyPlanning.setFont(new Font("Arial", Font.PLAIN, 20));
		CurrentlyPlanning.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		JTable PlanningTable = new JTable(PlanningTableModel);
		JScrollPane PlanningScrollPane = new JScrollPane(PlanningTable);
		SelectClasses.add(CurrentlyPlanning);
		CurrentlyPlanning.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(PlanningScrollPane);
		PlanningTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//weekly schedule
		JLabel WeeklySchedule = new JLabel(/*activeTerm.toString() +*/ " Term Weekly Schedule");
		JTable WeeklyTable = new JTable(WeeklyTableModel);
		SelectClasses.add(WeeklySchedule);
		WeeklySchedule.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(WeeklyTable);
		WeeklyTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(SelectClasses);
		
		//Set Size of frame and center
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = (int) ((int) tk.getScreenSize().getHeight()*(0.80));  
		setSize(xSize/2,ySize);
		setVisible(true);
	}
}
