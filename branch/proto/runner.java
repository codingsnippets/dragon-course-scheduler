/**
 * Author: Kevin Huang
 * Date: 3/18/13 , 1:41 AM
 * Copyright Reserved 2013
 */


import java.util.ArrayList;

public class runner {
    public static void main(String [ ] args){

        ArrayList<String> majors = Filter.getMajors();

        SessionInfo newsession = new SessionInfo();

        ArrayList<Schedule> schedLcd=  Filter.getClasses(Term.Spring, newsession);


        ArrayList<String> concentrations  = Filter.getConcentrations("CS") ;
        System.out.println("Done running");


    }
}