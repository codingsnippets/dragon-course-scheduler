import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Stan_2
 * Date: 3/21/13
 * Time: 11:17 PM
 * To change this template use File | Settings | File Templates.
 */

//        System.out.println("Testing method " + name.getMethodName().substring(4) + "() by: ");
//        /****   Sample New Test Case *********/
//        System.out.println("\t" + "<what you are doing>... ");
//
//        //initialize your vars
//        Obj si = new Obj();
//        si.testMethod(params);
//        Obj expected =
//        Obj test = si.gettestMethod()
//
//        try
//        {
//          assertTrue( test.equals(expected) );
//          System.out.println("Passed!");
//        }
//        catch(AssertionError e)
//        {
//          System.out.println("Failed!");
//        }
public class testHelper {

    public static final String HISTORY_STR = "CS123,CS171,CS172";

    public static Boolean containsCRNmatch(ArrayList<Schedule> l, Integer crn){

        Boolean contains = false;

        //Schedule schedule = new Schedule();

        //find schedule matching crn in termOfferings, and set
        for (int i = 0; i < l.size(); i++ )
        {
            if ( l.get(i).getCRN().equals(crn) )
            {
                contains = true;
                break;
            }

        }

        return contains;
    }
}
