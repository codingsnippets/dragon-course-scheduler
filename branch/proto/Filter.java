import java.util.ArrayList;

class Filter {
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

        return course_db_connect.getRecord(db.getOst(),db.getDbname(),db.getDbpass(),table,fields);

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
        return course_db_connect.getRecord(db.getOst(),db.getDbname(),db.getDbpass(),table,fields);
    };
    /*
    * Method Name: getClasses
    * Method Description:   This method will get classes for user to choose.
    * @param termtable:     The term table that in current planning
    * @param userHistory:   The User history object that is passed from DCS
    * @return
    */
    protected TermTable getClasses(TermTable termtable, UserHistoryObject userHistory){

        return null;
    };
    /*
    * Method Name: getDescription
    * Method Description:  This method will get the descriptions based on classes
    * @return
    */
    protected String getDescription(){
        return null;
    };

    /*
    * Method Name: filterhistory
    * Method Description    This method will take responsibility of filtering a result against user history object
    * @param userhistory    The UHO passed from DCS
    * @param recrodSet      The records returned from the database call
    * @return
    */
    private void filterhistory(UserHistoryObject userhistory, ArrayList<String> recrodSet){


    }
}
