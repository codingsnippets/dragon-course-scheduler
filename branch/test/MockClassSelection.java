/**
 * Created with IntelliJ IDEA.
 * User: Stan_2
 * Date: 3/22/13
 * Time: 12:14 PM
 * To change this template use File | Settings | File Templates.
 */

import org.mockito.Mockito;
import org.mockito.Mockito.*;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MockClassSelection extends ClassSelection {
    SessionInfo sessioninfo = Mockito.mock(SessionInfo.class);
    ArrayList<Integer> classes = new ArrayList<Integer>();
    Term activeTerm = Term.Fall;
    DefaultTableModel mockTable = Mockito.mock(DefaultTableModel.class);

    public MockClassSelection() {

    }

    public void setActiveTerm(Term t) {
        activeTerm = t;
    }

    public void removeClassFromPlanning(Integer SelectedRow) {
        mockTable.removeRow(SelectedRow);
    }

    public void addClassToUser(Integer CRN) {
        classes.add(CRN);
        //sessioninfo = DragonCourseScheduler.updateAdd(sessioninfo, CRN);
    }

    public void removeClassFromUser(Integer CRN) {
        sessioninfo.removeClass(CRN);
        //sessioninfo = DragonCourseScheduler.updateRemove(sessioninfo, CRN);
    }

    public void clearClassesToWeekly() {
        WeeklyTableModel.setRowCount(0);
        WeeklyTableModel.setRowCount(28);
        populateTimes();
    }

    public void setClassesToWeekly(Term term) {
        HashMap<Term, ArrayList<Schedule>> classes = sessioninfo.getCoursework();
        for(Schedule schedule : classes.get(activeTerm)) {
            for(Integer time : schedule.getTimes()) {
                if (time % 3 == 0) {
                    WeeklyTableModel.setValueAt("X", (time % 84)/3, ((time/84)+1));
                }
            }
        }
    }

    public void addClassToWeekly(Integer CRN) {
        HashMap<Term, ArrayList<Schedule>> classes = sessioninfo.getCoursework();
        for(Schedule schedule : classes.get(activeTerm)) {
            if(schedule.getCRN().equals(CRN)) {
                for(Integer time : schedule.getTimes()) {
                    if (time % 3 == 0) {
                        WeeklyTableModel.setValueAt("X", (time % 84)/3, ((time/84)+1));
                    }
                }
            }
        }
    }

    public void removeClassFromWeekly(Integer CRN) {
        HashMap<Term, ArrayList<Schedule>> classes = sessioninfo.getCoursework();
        for(Schedule schedule : classes.get(activeTerm)) {
            if(schedule.getCRN().equals(CRN)) {
                for(Integer time : schedule.getTimes()) {
                    if (time % 3 == 0) {
                        WeeklyTableModel.setValueAt("", (time % 84)/3, ((time/84)+1));
                    }
                }
            }
        }
    }

    public void populateClasses() {
        if (PlanningTableModel.getRowCount() > 0) {
            for (int i = PlanningTableModel.getRowCount() - 1; i > -1; i--) {
                PlanningTableModel.removeRow(i);
            }
        }
        for(Schedule schedule :  sessioninfo.termOfferings) {
            PlanningTableModel.addRow(new Object[] {schedule.getCRN(), schedule.getCoursename(), schedule.getTitle(), schedule.getTimeSchedule(), schedule.getInstructor(), schedule.getLocation(),schedule.getPrereq()});
        }
    }

    public void populateTimes() {
        long milli = 46800000;
        Date time = new Date(milli);
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm a");
        for (int i = 0; i < 28; i++) {
            WeeklyTableModel.setValueAt(ft.format(time), i, 0);
            milli += 1800000;
            time = new Date(milli);
        }
    }

    public void setUserInfoText() {
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

    public void planningToOverview() {
        if (PlanningTableModel.getRowCount() > 0) {
            for (int i = PlanningTableModel.getRowCount() - 1; i > -1; i--) {
                PlanningTableModel.removeRow(i);
            }
        }
        //isPlanning = false;
        Label1.setText("Currently Viewing Selected Classes for " + activeTerm.toString() + " Term");
        for(Schedule schedule :  sessioninfo.getCoursework().get(activeTerm)) {
            PlanningTableModel.addRow(new Object[] {schedule.getCRN(), schedule.getCoursename(), schedule.getTitle(), schedule.getTimeSchedule(), schedule.getInstructor(), schedule.getLocation(),schedule.getPrereq()});
        }
    }
}
