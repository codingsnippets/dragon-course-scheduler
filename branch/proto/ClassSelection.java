import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClassSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	protected static Term activeTerm = Term.Fall;
	protected DefaultTableModel PlanningTableModel = new DefaultTableModel(new Object[]{"CRN", "Class", "Title", "Timeslot", "Instructor", "Prereq. For"}, 15) {
		private static final long serialVersionUID = 2098240965623242350L;
		public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
	protected DefaultTableModel WeeklyTableModel = new DefaultTableModel(new Object[]{"Time", "M", "T", "W", "R", "F"}, 28){
		private static final long serialVersionUID = -8681527977153100661L;
		public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
	JTextArea UserInfo = new JTextArea(10,0);
	JLabel Label1 = new JLabel("Currently Planning: " + activeTerm.toString() + " Term");

	private SessionInfo sessioninfo = new SessionInfo();
	
	public ClassSelection() {
		super();
		init();
	}
	
	public ClassSelection(SessionInfo si) {
		super();
		sessioninfo = si;
		init();
	}

	public void init() {	
		final JPanel SelectClasses = new JPanel();
		SelectClasses.setLayout(new BoxLayout(SelectClasses, BoxLayout.Y_AXIS));
		
		JLabel Header = new JLabel("Dragon Course Scheduler");
		Header.setFont(new Font("Arial", Font.BOLD, 30));
		SelectClasses.add(Header);
		Header.setAlignmentX(Component.CENTER_ALIGNMENT);
		Header.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		
		JPanel UserHistory = new JPanel(new BorderLayout());
		JButton GoToMenu = new JButton("Menu (Change Term, Export/View Schedule, etc.)");
		UserHistory.add(UserInfo, BorderLayout.CENTER);
		UserHistory.add(GoToMenu, BorderLayout.EAST);
		SelectClasses.add(UserHistory);
		
		//currently planning
		Label1.setFont(new Font("Arial", Font.PLAIN, 20));
		Label1.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		final JTable PlanningTable = new JTable(PlanningTableModel);
		PlanningTableModel.addRow(new Object[] {"12345", "Class", "Title", "Timeslot", "Instructor", "Prereq. For"});
		JScrollPane PlanningScrollPane = new JScrollPane(PlanningTable);
		SelectClasses.add(Label1);
		Label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(PlanningScrollPane);
		PlanningScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//weekly schedule
		JLabel Label2 = new JLabel(activeTerm.toString() + " Term Weekly Schedule");
		JTable WeeklyTable = new JTable(WeeklyTableModel);
		JScrollPane WeeklyScrollPane = new JScrollPane(WeeklyTable);
		SelectClasses.add(Label2);
		Label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(WeeklyScrollPane);
		PlanningScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		SelectClasses.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(SelectClasses);
		
		//Set Size of frame and center
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = (int) ((int) tk.getScreenSize().getHeight()*(0.80));  
		setSize(xSize/2,ySize);
		setVisible(true);
		
		//listener for going back to menu
		//TODO make work
		GoToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
		
		//lisenter for adding a double clicked class in the planning table
		PlanningTable.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (PlanningTable.getSelectedRow() != -1) {
					if (e.getClickCount() == 2) {
						if (e.getSource() == PlanningTable) {
							Integer CRN = Integer.parseInt((String) PlanningTableModel.getValueAt(PlanningTable.getSelectedRow(), 0));
							addClassToUser(CRN);
							removeClassFromPlanning(CRN);
							addClassToWeekly(CRN);
						}
					}
				}				
			}

			public void mouseEntered(MouseEvent e) {}

			public void mouseExited(MouseEvent e) {}

			public void mousePressed(MouseEvent e) {}

			public void mouseReleased(MouseEvent e) {}			
		});
		
		//lisenter for deleting a row in the planning table when selected and delete button is clicked
		//listener for adding a class when selected and enter is clicked
		PlanningTable.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (PlanningTable.getSelectedRow() != -1) {
					if(e.getKeyCode() == KeyEvent.VK_DELETE) {
						if (e.getSource() == PlanningTable) {
							if (PlanningTableModel.getValueAt(PlanningTable.getSelectedRow(), 0) != null) {
								int n = JOptionPane.showConfirmDialog(SelectClasses, "Are you sure you would like to remove this row?", "Remove Class", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (n == 0) {
									Integer CRN = Integer.parseInt((String) PlanningTableModel.getValueAt(PlanningTable.getSelectedRow(), 0));
									removeClassFromPlanning(CRN);
									removeClassFromWeekly(CRN);
								}
								
							}
						}
					}
					else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (e.getSource() == PlanningTable) {
							if (PlanningTableModel.getValueAt(PlanningTable.getSelectedRow(), 0) != null) {
								Integer CRN = Integer.parseInt((String) PlanningTableModel.getValueAt(PlanningTable.getSelectedRow(), 0));
								addClassToUser(CRN);
								removeClassFromPlanning(CRN);
								addClassToWeekly(CRN);
							}
						}
					}
				}			
			}
			public void keyReleased(KeyEvent arg0) {}
			public void keyTyped(KeyEvent arg0) {}
		});
		
	}
	
	//getters
	public DefaultTableModel getPlanningTableModel() {
		return PlanningTableModel;
	}
	
	public DefaultTableModel getWeeklyTableModel() {
		return WeeklyTableModel;
	}
	
	//setters/adders/removes
	public void setActiveTerm(Term t) {
		activeTerm = t;
	}
	
	public void setUserInfoBox(String userInfo) {
		UserInfo.setText(userInfo);
	}
	
	//TODO actually get class info based on crn
	public void addClassToPlanning(Integer CRN) {
		PlanningTableModel.addRow(new Object[] {CRN, "Class", "Title", "Timeslot", "Instructor", "Prereq. For"});
	}
	
	public void removeClassFromPlanning(Integer CRN) {
		for (int i = 0; i < PlanningTableModel.getRowCount(); i++) {
			if (PlanningTableModel.getValueAt(i, 0) != null) {
				if (Integer.parseInt((String) PlanningTableModel.getValueAt(i, 0)) == CRN) {
					PlanningTableModel.removeRow(i);
				}
			}
		}
		removeClassFromWeekly(CRN);
	}
	
	public void addClassToUser(Integer CRN) {
		
	}
	
	private void addClassToWeekly(Integer CRN) {
		
	}
	
	private void removeClassFromWeekly(Integer CRN) {
		
	}
	
	public SessionInfo passSession() {
		return sessioninfo;
	}
}
