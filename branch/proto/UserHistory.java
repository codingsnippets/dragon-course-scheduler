import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class UserHistory extends Applet {
	private static final long serialVersionUID = 1L;
	private JTextField PreviousClassesField = new JTextField(5);
	private JTextField MajorCodeField = new JTextField(5);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JList TrackList = new JList(new Object[]{"Algorithms and Data Structures", "Artificial Intelligence", "Computer and Network Security", "Computer Graphics and Vision", "Game Development and Design", "Human Computer Interaction", "Numerical Analysis", "Numeric and Symbolic Computation", "Programming Languages", "Software Engineering", "Systems"});
	private JCheckBox Fall = new JCheckBox("Fall");
	private JCheckBox Winter = new JCheckBox("Winter");
	private JCheckBox Spring = new JCheckBox("Spring");
	private JCheckBox Summer = new JCheckBox("Summer");
	
	private SessionInfo sessioninfo = new SessionInfo();
	
	public UserHistory() {
		super();
	}
	
	public UserHistory(SessionInfo si) {
		super();
		sessioninfo = si;
	}
	
	public void init() {
		JPanel UserBackground = new JPanel();
		UserBackground.setLayout(new BoxLayout(UserBackground, BoxLayout.Y_AXIS));
		
		JLabel Header = new JLabel("Dragon Course Scheduler");
		Header.setFont(new Font("Arial", Font.BOLD, 30));
		UserBackground.add(Header);
		Header.setAlignmentX(Component.CENTER_ALIGNMENT);
		Header.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		
		JLabel JL1 = new JLabel("Please enter all classes you have completed with a C- or higher (seperate with commas):");
		
		JL1.setLabelFor(PreviousClassesField);
		UserBackground.add(JL1);
		JL1.setAlignmentX(Component.CENTER_ALIGNMENT);
		UserBackground.add(PreviousClassesField);
		PreviousClassesField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel JL2 = new JLabel("Please enter your major code (i.e.: CS for computer science):");
		
		MajorCodeField.setHorizontalAlignment(JTextField.CENTER);
		JL2.setLabelFor(MajorCodeField);
		UserBackground.add(JL2);
		JL2.setAlignmentX(Component.CENTER_ALIGNMENT);
		UserBackground.add(MajorCodeField);
		MajorCodeField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JL2.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JLabel JL3 = new JLabel("Please select your (2) tracks from the list below");
		
		TrackList.setLayoutOrientation(JList.VERTICAL_WRAP);
		JL3.setLabelFor(TrackList);
		UserBackground.add(JL3);
		JL3.setAlignmentX(Component.CENTER_ALIGNMENT);
		UserBackground.add(TrackList);
		TrackList.setAlignmentX(Component.CENTER_ALIGNMENT);
		JL3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JLabel JL4 = new JLabel("Please select the quarter term that you would like to schedule?");
		UserBackground.add(JL4);
		JL4.setAlignmentX(Component.CENTER_ALIGNMENT);
		//all for term radio buttons proper alignment
		JPanel termsPanel = new JPanel();
		termsPanel.setLayout(new BoxLayout(termsPanel, BoxLayout.X_AXIS));
		termsPanel.add(Fall);
		termsPanel.add(Winter);
		termsPanel.add(Spring);
		termsPanel.add(Summer);
		UserBackground.add(termsPanel);
		JL4.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		termsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		
		//submit button
		final JButton submit = new JButton("Submit History and Select Classes!");
		submit.setEnabled(false);
		UserBackground.add(submit);
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		UserBackground.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(UserBackground);
		setVisible(true);
		setSize(800, 550);
		repaint();
		
		//action listener that enables button once proper information is entered by user
		ActionListener checkBoxActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!submit.isEnabled()) {
					if (Fall.isSelected() || Winter.isSelected() || Spring.isSelected() || Summer.isSelected()) {
						submit.setEnabled(true);
					}
				}
				if (submit.isEnabled()) {
					if(!Fall.isSelected() && !Winter.isSelected() && !Spring.isSelected() && !Summer.isSelected()) {
						submit.setEnabled(false);
					}
				}
			}
		};
		Fall.addActionListener(checkBoxActionListener);
		Winter.addActionListener(checkBoxActionListener);
		Spring.addActionListener(checkBoxActionListener);
		Summer.addActionListener(checkBoxActionListener);
		
		//button to next page
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				sessioninfo = DragonCourseScheduler.updateMajor(sessioninfo, getMajorCode());//what is the major value?
				sessioninfo = DragonCourseScheduler.setTerms(sessioninfo, getTerms());
				sessioninfo = DragonCourseScheduler.updateHistory(sessioninfo, PreviousClassesField.getText());
				sessioninfo = DragonCourseScheduler.updateConcentrations(sessioninfo, getTrackList());// please fill in concentration info
				
				//ClassSelection selectionFrame = (ClassSelection)getAppletContext().getApplet("ClassSelection.class");
				setVisible(false);
			}
		});

	}
	
	//getters
	public String[] getPreviousClasses() {
		return PreviousClassesField.getText().split(",");
	}
	
	public String getMajorCode() {
		return MajorCodeField.getText();
	}
	
	public ArrayList<String> getTrackList() {
		@SuppressWarnings("unchecked")
		ArrayList<String> selectedValues = (ArrayList<String>) TrackList.getSelectedValuesList();
		
		return selectedValues;
	}
	
	public Term[] getTerms() {
		ArrayList<Term> selectedTerms = new ArrayList<Term>();
		if(Fall.isSelected()) {
			selectedTerms.add(Term.Fall);
		}
		if(Winter.isSelected()) {
			selectedTerms.add(Term.Winter);
		}
		if(Spring.isSelected()) {
			selectedTerms.add(Term.Spring);
		}
		if(Summer.isSelected()) {
			selectedTerms.add(Term.Summer);
		}
		Term[] returnTerms = new Term[selectedTerms.size()];
		for(int i = 0; i < selectedTerms.size(); i++) {
			returnTerms[i] = selectedTerms.get(i);
		}
		return returnTerms;
	}
	
}
