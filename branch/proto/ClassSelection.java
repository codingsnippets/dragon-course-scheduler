import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClassSelection extends JPanel {
	private static final long serialVersionUID = 1L;
	protected Term activeTerm = Term.Fall;
	protected DefaultTableModel PlanningTableModel = new DefaultTableModel(new Object[]{"CRN", "Class", "Title", "Timeslot", "Instructor", "Prereq."}, 0) {
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
	JTextArea UserInfo = new JTextArea(8,20);
	protected JLabel Label1 = new JLabel();
	protected JLabel Label2 = new JLabel();

	private SessionInfo sessioninfo = new SessionInfo();
	
	public ClassSelection() {
		super();
		init();
	}
	
	public ClassSelection(SessionInfo si) {
		super();
		sessioninfo = si;
		setActiveTerm(sessioninfo.getTerm());
		Label1 = new JLabel("Currently Planning: " + activeTerm.toString() + " Term");
		Label2 = new JLabel(activeTerm.toString() + " Term Weekly Schedule");
		populateTimes();
		init();
	}

	public void init() {	
		final JPanel SelectClasses = new JPanel();
		SelectClasses.setLayout(new BoxLayout(SelectClasses, BoxLayout.Y_AXIS));
		//Set Size of panel
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = (int) ((int) tk.getScreenSize().getHeight()*(0.70));
		setSize((int) (xSize/2.5),ySize);
		setVisible(true);
		
		JLabel Header = new JLabel("Dragon Course Scheduler");
		Header.setFont(new Font("Arial", Font.BOLD, 30));
		SelectClasses.add(Header);
		Header.setAlignmentX(Component.CENTER_ALIGNMENT);
		Header.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		
		JPanel UserHistory = new JPanel(new BorderLayout());
		setUserInfoText();
		JButton GoToMenu = new JButton("Menu (Change Term)");
		UserHistory.add(UserInfo, BorderLayout.CENTER);
		UserHistory.add(GoToMenu, BorderLayout.EAST);
		SelectClasses.add(UserHistory);
		
		//currently planning
		Label1.setFont(new Font("Arial", Font.PLAIN, 20));
		Label1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		final JTable PlanningTable = new JTable(PlanningTableModel);
		JScrollPane PlanningScrollPane = new JScrollPane(PlanningTable);
		PlanningTable.setPreferredScrollableViewportSize(new Dimension((int) (xSize/2.5), 6 * PlanningTable.getRowHeight()));
		PlanningScrollPane.setSize(PlanningTable.getPreferredScrollableViewportSize());
		SelectClasses.add(Label1);
		Label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(PlanningScrollPane);
		PlanningScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		//populate classes
		populateClasses();
		
		//weekly schedule
		JTable WeeklyTable = new JTable(WeeklyTableModel);
		JScrollPane WeeklyScrollPane = new JScrollPane(WeeklyTable);
		WeeklyTable.setPreferredScrollableViewportSize(new Dimension((int) (xSize/2.5), WeeklyTable.getRowCount() * WeeklyTable.getRowHeight()));
		WeeklyScrollPane.setSize(WeeklyTable.getPreferredScrollableViewportSize());
		SelectClasses.add(Label2);
		Label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.add(WeeklyScrollPane);
		PlanningScrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		SelectClasses.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(SelectClasses);
		
		//listener for going back to menu
		//TODO make work
		GoToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JRadioButton Fall = new JRadioButton("Fall", true);
				JRadioButton Winter = new JRadioButton("Winter");
				JRadioButton Spring = new JRadioButton("Spring");
				JRadioButton Summer = new JRadioButton("Summer");
				ButtonGroup group = new ButtonGroup();
				group.add(Fall);
				group.add(Winter);
				group.add(Spring);
				group.add(Summer);
				JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		        radioPanel.add(Fall);
		        radioPanel.add(Winter);
		        radioPanel.add(Spring);
		        radioPanel.add(Summer);
		        int n = JOptionPane.showConfirmDialog(SelectClasses, radioPanel, "Menu", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE);
		        if (n == 0) {
		        	if (Fall.isSelected()) {
		        		sessioninfo = DragonCourseScheduler.updateTerm(sessioninfo, Term.Fall);
			        	setActiveTerm(Term.Fall);
			        }
			        else if (Winter.isSelected()) {
			        	sessioninfo = DragonCourseScheduler.updateTerm(sessioninfo, Term.Winter);
			        	setActiveTerm(Term.Winter);
			        }
			        else if (Spring.isSelected()) {
			        	sessioninfo = DragonCourseScheduler.updateTerm(sessioninfo, Term.Spring);
			        	setActiveTerm(Term.Spring);
			        }
			        else if (Summer.isSelected()) {
			        	sessioninfo = DragonCourseScheduler.updateTerm(sessioninfo, Term.Summer);
			        	setActiveTerm(Term.Summer);
			        }
			        Label1.setText("Currently Planning: " + activeTerm.toString() + " Term");
			        Label2.setText(activeTerm.toString() + " Term Weekly Schedule");
			        populateClasses();
			        SelectClasses.repaint();
		        }
			}
		});
		
		//lisenter for adding a double clicked class in the planning table
		PlanningTable.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if (PlanningTable.getSelectedRow() != -1) {
					if (e.getClickCount() == 2) {
						if (e.getSource() == PlanningTable) {
							int x = PlanningTable.getSelectedRow();
							String classnumber = (String) PlanningTable.getValueAt(x, 1);
							int n = JOptionPane.showConfirmDialog(SelectClasses, "Add " + classnumber +" to " + activeTerm.toString() + " schedule?", "Add Class", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (n == 0) {
								Integer CRN = (Integer) PlanningTableModel.getValueAt(x, 0);
								addClassToUser(CRN);
								removeClassFromPlanning(x);
								addClassToWeekly(CRN);
								setUserInfoText();
							}
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
							int x = PlanningTable.getSelectedRow();
							if (PlanningTableModel.getValueAt(x, 0) != null) {
								String classnumber = (String) PlanningTable.getValueAt(x, 1);
								int n = JOptionPane.showConfirmDialog(SelectClasses, "Are you sure you would like to remove " + classnumber +"?", "Remove Class", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (n == 0) {
									removeClassFromPlanning(x);
								}
								
							}
						}
					}
					else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (e.getSource() == PlanningTable) {
							int x = PlanningTable.getSelectedRow();
							if (PlanningTableModel.getValueAt(x, 0) != null) {
								
								String classnumber = (String) PlanningTable.getValueAt(x, 1);
								int n = JOptionPane.showConfirmDialog(SelectClasses, "Add " + classnumber +" to " + activeTerm.toString() + " schedule?", "Add Class", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
								if (n == 0) {
									Integer CRN = (Integer) PlanningTableModel.getValueAt(x, 0);
									addClassToUser(CRN);
									removeClassFromPlanning(x);
									addClassToWeekly(CRN);
									setUserInfoText();
								}
								
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
	private void setActiveTerm(Term t) {
		activeTerm = t;
	}
	
	private void removeClassFromPlanning(int SelectedRow) {
		PlanningTableModel.removeRow(SelectedRow);
	}
	
	private void addClassToUser(Integer CRN) {
		sessioninfo.addClass(CRN);
	}
	
	private void addClassToWeekly(Integer CRN) {
		
	}
	
	private void populateClasses() {
		if (PlanningTableModel.getRowCount() > 0) {
			for (int i = PlanningTableModel.getRowCount() - 1; i > -1; i--) {
		        PlanningTableModel.removeRow(i);
		    }
		}
		for(Schedule schedule :  sessioninfo.termOfferings) {
			PlanningTableModel.addRow(new Object[] {schedule.getCRN(), schedule.getCoursename(), schedule.getTitle(), schedule.getTimeSchedule(), schedule.getInstructor(), schedule.getPrereq()});
		}
	}
	
	private void populateTimes() {
		long milli = 46800000;
		Date time = new Date(milli);
		SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
		for (int i = 0; i < 28; i++) {
			WeeklyTableModel.setValueAt(ft.format(time), i, 0);
			milli += 1800000;
			time = new Date(milli);
		}
	}
	
	private void setUserInfoText() {
		String s = "Concentrations/Tracks:\n";
		for (String x:sessioninfo.getConcentration()){
			s+=x+"\n";
		}
			s+="\n\n";
		if (!sessioninfo.getCoursework().get(Term.Fall).isEmpty()) {
			String returnString = "";
	    	for (Schedule schedule : sessioninfo.getCoursework().get(Term.Fall)) {
	    		returnString += schedule.getCoursename() +", ";
	    	}
	    	s += "Fall Term Courses: " + returnString.substring(0, returnString.length()-2) + "\n";
		}
		if (!sessioninfo.getCoursework().get(Term.Winter).isEmpty()) {
			String returnString = "";
	    	for (Schedule schedule : sessioninfo.getCoursework().get(Term.Winter)) {
	    		returnString += schedule.getCoursename() +", ";
	    	}
	    	s += "Winter Term Courses: " + returnString.substring(0, returnString.length()-2) + "\n";
		}
		if (!sessioninfo.getCoursework().get(Term.Spring).isEmpty()) {
			String returnString = "";
	    	for (Schedule schedule : sessioninfo.getCoursework().get(Term.Spring)) {
	    		returnString += schedule.getCoursename() +", ";
	    	}
	    	s += "Spring Term Courses: " + returnString.substring(0, returnString.length()-2) + "\n";
		}
		if (!sessioninfo.getCoursework().get(Term.Summer).isEmpty()) {
			String returnString = "";
	    	for (Schedule schedule : sessioninfo.getCoursework().get(Term.Summer)) {
	    		returnString += schedule.getCoursename() +", ";
	    	}
	    	s += "Summer Term Courses: " + returnString.substring(0, returnString.length()-2) + "\n";
		}
		UserInfo.setText(s);
	}
	
	public SessionInfo passSession() {
		return sessioninfo;
	}
}
