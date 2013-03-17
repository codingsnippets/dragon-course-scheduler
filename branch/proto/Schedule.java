import java.util.ArrayList;
import java.util.IdentityHashMap;

/*
    Course schedule Entity class
 */
public class Schedule {
    public static final String DBTABLE= "schedule";
    public Integer CRN;
    public String Subject;
    public Integer Course_no;
    public String Term;
    public Integer Section;
    public String Instruction_type;
    public String Instructor;
    public String Location;
    public String Weekday;
    public String Start_time;
    public String End_time;
    public ArrayList<Integer> Times;

    public Schedule(){

    }
    /*
        @param dbhost
        @param dbuser
        @param dbpass
     */
    public void getRecord(String dbhost, String dbuser, String dbpass){
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

    public String getCoursename() {
        return this.Subject+this.Course_no.toString();
    }
    
    public ArrayList<Integer> getTimes(){
    	return this.Times;
    }
	/**
	 * The <code>toCsv</code> function creates a string of comma separated
	 * values of the schedule.
	 * </br>
	 * @return  csv string
	 */
	public String toCsv()
	{
		String csv = "";
		
		return csv;
	}
}