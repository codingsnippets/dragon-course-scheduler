import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
    /*
     * Method Name: getMajors
     * Method Description:  This method will get major information based on the UHO and return classes for the user to select
     * @param
     * @return  A list of classes that available for the student to take
     */

    dbcredential db = new dbcredential();

    public static ArrayList<String> getMajors(){
        ArrayList majors = new ArrayList<String>();


        // table of choice
        String table = "schedule";

        // adding dummy data into this arraylist
        majors.add("CS");




        return majors;

    }
    /*
     * Method Name: getConcentration
     * Method Description:  This method will take in a unique major code and return concentrations available for the user.
     * @param MajorCode the major is converted into unique identifier for db to recognize
     * @return
     */
    public static ArrayList<String> getConcentrations(String MajorCode){
        String table="track";
        String fields="coursename";

        ArrayList<String> concentrations =  new ArrayList<String>();
        concentrations.add("Algor");
        concentrations.add("Software E");
        concentrations.add("OS") ;
        concentrations.add("AI") ;
        concentrations.add("HCI") ;
        concentrations.add("Game Design") ;

        return concentrations;
    };
    /*
    * Method Name: getClasses
    * Method Description:   This method will get classes for user to choose.
    * @param term:     The term table that in current planning
    * @param userHistory:   The User history object that is passed from DCS
    * @return
    */
    public static ArrayList<Schedule> getCourses(Term term, SessionInfo userHistory){

        //based off term

        //based off userHistory

        ArrayList<Schedule> scheduleCollection = new ArrayList<Schedule>();

        Schedule s1 = new Schedule();
        Schedule s2 = new Schedule();
        Schedule s3 = new Schedule();


        s1.Subject = "CS";
        s1.CRN=302141;
        s1.Course_no=171;
        s1.Start_time="5:00 PM"   ;
        s1.End_time="8:00 PM";
        s1.Term="Spring";
        s1.Section=1;
        s1.Instruction_type="Lecture";
        s1.Instructor ="Nowak";
        s1.Location="Korman 137";
        s1.Weekday="M";

        s2.Subject = "CS";
        s2.CRN=360873;
        s2.Course_no=283;
        s2.Start_time="4:00 PM"  ;
        s2.End_time="6:00 PM";
        s2.Term="Spring";
        s2.Section=1;
        s2.Instruction_type="Lecture";
        s2.Instructor ="Mongon";
        s2.Location="UC 153";
        s2.Weekday="W";


        s3.Subject = "CS";
        s3.CRN=302141;
        s3.Course_no= 265;
        s3.Start_time="10:00 AM";
        s3.End_time="12:00 AM";
        s3.Term="Spring";
        s3.Section=1;
        s3.Instruction_type="Lecture";
        s3.Instructor ="Schmidt";
        s3.Location="Korman 153";
        s3.Weekday="T";

        scheduleCollection.add(s1);
        scheduleCollection.add(s2);
        scheduleCollection.add(s3);


        return scheduleCollection;
    };
    /*
    * Method Name: getDescription
    * Method Description:  This method will get the descriptions based on classes
    * @return
    */
    public static String getDescription(Integer CRN){
        return "i am a description";
    };

    /*
    * Method Name: filterhistory
    * Method Description    This method will take responsibility of filtering a result against user history object
    * @param userhistory    The UHO passed from DCS
    * @param recrodSet      The records returned from the database call
    * @return
    */
    private void filterhistory(SessionInfo userhistory, ArrayList<String> recrodSet){


    }
}
