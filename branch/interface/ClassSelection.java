import java.awt.*;
import javax.swing.*;

public class ClassSelection extends WebFramework{	
	public ClassSelection() {	}

	public ClassSelection(Term t) {
		term = t;
	}
	
	public void ClassSelectionInterface() {	
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
		JLabel CurrentlyPlanning = new JLabel("Currently Planning: " + term.toString() + " Term");
		CurrentlyPlanning.setFont(new Font("Arial", Font.PLAIN, 20));
		CurrentlyPlanning.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		JTable PlanningTable = new JTable(PlanningTableModel);
		JScrollPane PlanningScrollPane = new JScrollPane(PlanningTable);
		SelectClasses.add(CurrentlyPlanning);
		CurrentlyPlanning.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(PlanningScrollPane);
		PlanningTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//weekly schedule
		JLabel WeeklySchedule = new JLabel(term.toString() + " Term Weekly Schedule");
		JTable WeeklyTable = new JTable(WeeklyTableModel);
		SelectClasses.add(WeeklySchedule);
		WeeklySchedule.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(WeeklyTable);
		WeeklyTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//frame
		final JFrame frame = new JFrame("Select Classes");
		frame.add(SelectClasses);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set Size of frame and center
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = (int) ((int) tk.getScreenSize().getHeight()*(0.80));  
		frame.setSize(xSize/2,ySize);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
