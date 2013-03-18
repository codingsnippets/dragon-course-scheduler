import java.util.*;


class Filter {



    /*
     * Method Name: getMajors
     * Method Description:  This method will get major information based on the UHO and return classes for the user to select
     * @return  A list of majors for student to choose
     */

    //TODO  change the signature back to protected after the prototype
    public static ArrayList<String> getMajors(){

       // mysqlDBExecute sessionMajor = new mysqlDBExecute();


        return mysqlDBExecute.PullMajors();

    }


    /*
     * Method Name: getConcentration
     * Method Description:  This method will take in a unique major code and return concentrations available for the user.
     * @param MajorCode the major is converted into unique identifier for db to recognize
     * @return
     */
    public static ArrayList<String> getConcentrations(String MajorString){

        //mysqlDBExecute sessionConcentrations = new mysqlDBExecute();

        return mysqlDBExecute.PullConcentrations(MajorString);
    }


    /*
    * Method Name: getClasses
    * Method Description :   This method will get classes for user to choose.
    * @param ternName :     The term table that in current planning
    * @param userSession :   The User history object that is passed from DCS
    * @return
    */
    public static ArrayList<Schedule> getClasses(Term termName, SessionInfo userSession){

       // mysqlDBExecute sessionSchedule = new mysqlDBExecute();


        return mysqlDBExecute.PullSchedule(termName, userSession);
    }


    /*
    * Method Name: filterhistory
    * Method Description    This method will take responsibility of filtering a result against user history object
    * @param userhistory    The userhistory will be taken classes which gathered through the webframework
    * @return
    */
//    private void filterhistory(SessionInfo userhistory){
//        // assuming that the userhistory will be a string
//
//        ArrayList<String> takenClasses = new ArrayList<String>();
//
//        for(String className : takenClasses){
//            // convert into code
//
//            // query against db
//
//        }
//
//    }




}
