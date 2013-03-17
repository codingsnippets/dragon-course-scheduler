import java.util.ArrayList;

public class filterproto {
    /*
     * Method Name: getMajors
     * Method Description:  This method will get major information based on the UHO and return classes for the user to select
     * @param
     * @return  A list of classes that available for the student to take
     */

    dbcredential db = new dbcredential();

    protected ArrayList getMajors(){
        ArrayList majors = new ArrayList();


        String table = "schedule";
        String fields= "CRN";

        // adding dummy data into this arraylist
        majors.add("CS171");
        majors.add("CS132");
        majors.add("CS283");
        majors.add("CS381");
        majors.add("CS303");
        majors.add("MATH121"); majors.add("CS350");
        majors.add("MATH221");



        return majors;

    }
    /*
     * Method Name: getConcentration
     * Method Description:  This method will take in a unique major code and return concentrations available for the user.
     * @param MajorCode the major is converted into unique identifier for db to recognize
     * @return
     */
    protected ArrayList getConcentration(Integer MajorCode){
        String table="track";
        String fields="coursename";

        ArrayList concentrations =  new ArrayList();
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
    * @param termtable:     The term table that in current planning
    * @param userHistory:   The User history object that is passed from DCS
    * @return
    */
    protected ArrayList getClasses(SessionInfo userHistory){

        // return an arraylist of schedule object

        ArrayList<Schedule> scheduleCollection = new ArrayList<Schedule>();



        return null;
    };
    /*
    * Method Name: getDescription
    * Method Description:  This method will get the descriptions based on classes
    * @return
    */
    protected String getDescription(Integer CRN){
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
