package course_info;

import java.util.ArrayList;
import java.util.IdentityHashMap;

/*
    Course schedule Entity class
 */
public class Schedule {
    public static final String DBTABLE= "current_schedule";


    //TODO: convert in to array of fields
    public Integer CRN;
    public String Subject;
    public String Term;
    public Integer Section;
    public String Instruction_type;
    public String Instructor;
    public String Location;
    public String Weekday;
    public String Start_time;
    public String End_time;
    public ArrayList<Timeslot> Times;
    public Long Course_no;
    public Integer coursename;

    public Schedule(){

    }
    /*
        @param String dbhost
        @param String dbuser
        @param String dbpass
     */
    public void getRecord(String dbhost, String dbuser, String dbpass){
        String fields = "*" ;
        ArrayList<String > newRecord = course_db_connect.getRecord(dbhost,dbuser,dbpass,DBTABLE,fields);
        for (String field : newRecord){
        }
     }
}