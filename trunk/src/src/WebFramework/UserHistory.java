package WebFramework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserHistory {	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void UserHistoryInterface() {
		JPanel UserBackground = new JPanel();
		UserBackground.setLayout(new BoxLayout(UserBackground, BoxLayout.Y_AXIS));
		
		JLabel Header = new JLabel("Dragon Course Scheduler");
		Header.setFont(new Font("Arial", Font.BOLD, 30));
		UserBackground.add(Header);
		Header.setAlignmentX(Component.CENTER_ALIGNMENT);
		Header.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		
		JLabel JL1 = new JLabel("Please enter all classes you have completed with a C- or higher (seperate with commas):");
		JTextField PreviousClassesField = new JTextField(100);
		JL1.setLabelFor(PreviousClassesField);
		UserBackground.add(JL1);
		JL1.setAlignmentX(Component.CENTER_ALIGNMENT);
		UserBackground.add(PreviousClassesField);
		PreviousClassesField.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel JL2 = new JLabel("Please enter your major code (i.e.: CS for computer science):");
		JTextField MajorCodeField = new JTextField(100);
		MajorCodeField.setHorizontalAlignment(JTextField.CENTER);
		JL2.setLabelFor(MajorCodeField);
		UserBackground.add(JL2);
		JL2.setAlignmentX(Component.CENTER_ALIGNMENT);
		UserBackground.add(MajorCodeField);
		MajorCodeField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JL2.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JLabel JL3 = new JLabel("Please select your (2) tracks from the list below");
		JList TrackList = new JList(new Object[]{"Algorithms and Data Structures", "Artificial Intelligence", "Computer and Network Security", "Computer Graphics and Vision", "Game Development and Design", "Human Computer Interaction", "Numerical Analysis", "Numeric and Symbolic Computation", "Programming Languages", "Software Engineering", "Systems"});
		TrackList.setLayoutOrientation(JList.VERTICAL_WRAP);
		JL3.setLabelFor(TrackList);
		UserBackground.add(JL3);
		JL3.setAlignmentX(Component.CENTER_ALIGNMENT);
		UserBackground.add(TrackList);
		TrackList.setAlignmentX(Component.CENTER_ALIGNMENT);
		JL3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JLabel JL4 = new JLabel("Please select the quarter term that you would like to schedule?");
		final JCheckBox Fall = new JCheckBox("Fall");
		final JCheckBox Winter = new JCheckBox("Winter");
		final JCheckBox Spring = new JCheckBox("Spring");
		final JCheckBox Summer = new JCheckBox("Summer");
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
		
		final JFrame frame = new JFrame("User History");
		frame.add(UserBackground);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 550);
		frame.setLocationRelativeTo(null);
		
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
		
		//button to next page (no error handling yet)
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassSelection selectionFrame = new ClassSelection();
				//Set couresbone.Term
				if (Fall.isSelected()) {
					selectionFrame.changeTerm(Term.Fall);
				}
				else if (Winter.isSelected()) {
					selectionFrame.changeTerm(Term.Winter);
				}
				else if (Spring.isSelected()) {
					selectionFrame.changeTerm(Term.Spring);
				}
				else if (Summer.isSelected()) {
					selectionFrame.changeTerm(Term.Summer);
				}
				//Set Tracks
				
				frame.setVisible(false);
				selectionFrame.ClassSelectionInterface();
			}});

	}
	
	public static void main(String[] args) {
		UserHistoryInterface();
	}
	
}
