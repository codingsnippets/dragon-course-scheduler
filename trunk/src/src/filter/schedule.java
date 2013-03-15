package Filter;

import java.util.ArrayList;

/*
    Course schedule Entity class
 */
public class schedule {
    public static final String DBTABLE= "current_schedule";


    //TODO: convert in to array of fields
    private Integer CRN;
    private String Subject;
    private Integer Course_no;
    private String Term;
    private Integer Section;
    private String Instruction_type;
    private String Instructor;
    private String Location;
    private String Weekday;
    private String Start_time;
    private String End_time;
    private Integer Start_block;
    private Integer End_block;
    private Integer coursename;

    public schedule(){

    }

    /*
        @param String dbhost
        @param String dbuser
        @param String dbpass
     */
    private void getRecord(String dbhost, String dbuser, String dbpass){
        String fields = "*" ;
        ArrayList<String > newRecord = course_db_connect.getRecord(dbhost,dbuser,dbpass,DBTABLE,fields);
        for (String field : newRecord){

        }
    }

    public String getSubject() {
        return this.Subject;
    }

    public Integer getCRN() {
        return this.CRN;
    }

    public Integer getCourse_no() {
        return this.Course_no;
    }

    public String getTerm() {
        return this.Term;
    }

    public Integer getSection() {
        return this.Section;
    }

    public String getInstruction_type() {
        return this.Instruction_type;
    }

    public String getLocation() {
        return this.Location;
    }

    public String getInstructor() {
        return this.Instructor;
    }

    public String getWeekday() {
        return this.Weekday;
    }

    public String getStart_time() {
        return this.Start_time;
    }

    public String getEnd_time() {
        return this.End_time;
    }

    public Integer getStart_block() {
        return this.Start_block;
    }

    public Integer getEnd_block() {
        return this.End_block;
    }

    public Integer getCoursename() {
        return this.coursename;
    }







}
