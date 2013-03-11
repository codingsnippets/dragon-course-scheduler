package filter;


import couresbone.TermTable;
import couresbone.UHO;

import java.util.ArrayList;

class Filter {
    /*
     * Method Name: getMajors
     * Method Description:  This method will get major information based on the UHO and return classes for the user to select
     * @param
     * @return  A list of classes that available for the student to take
     */
    protected ArrayList getMajors(){
        ArrayList majors = new ArrayList();

        dbcredential db = new dbcredential();

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
        String fields="";
        return null;
    };
    protected TermTable getClasses(TermTable t, UHO userHistory){
        return null;
    };
    protected String getDescription(){
        return null;
    };
}
