import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;
import static org.junit.Assert.*;
import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * User: Stan Kolakowski
 * Date: 3/21/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 *
 *
 *
 */

public class SessionInfoTest extends Object {
    @Rule public TestName name = new TestName();

    mockFilter fp = new mockFilter();
    Object expected;
    Object test;

    @Before
    public void setUp() throws Exception {
        //si = new SessionInfo();
    }

    @Test
    public void testSetlastAction() throws Exception {

    }

    @Test
    public void testSetConcentration() throws Exception {
        System.out.println("\nTesting method " + name.getMethodName().substring(4) + "() by: ");

        /****   New Test Case *********/
        System.out.println("\t" + "setting a populated concentrations arraylist... ");

        SessionInfo si = new SessionInfo();
        si.setConcentration( fp.getConcentration() );
        expected = new String("Algor");
        test = si.getConcentration().get(0);

        try{
            assertTrue(test.equals(expected));
            System.out.println("Passed!");
        } catch(AssertionError e){
            System.out.println("Failed!");
        }

        /****   New Test Case *********/
        System.out.println("\t" + "passing a null... ");

        si = new SessionInfo();
        si.setConcentration( null );
        expected = null;
        test = si.getConcentration();

        try{
            assertTrue(test == expected);
            System.out.println("Passed!");
        } catch(AssertionError e){
            System.out.println("Failed!");
        }

    }

    @Test
    public void testSetMajor() throws Exception {
        System.out.println("\nTesting method " + name.getMethodName().substring(4) + "() by: ");

        /****   New Test Case *********/
        System.out.println("\t" + "setting a String... ");

        SessionInfo si = new SessionInfo();
        expected = new String("CS");

        si.setMajor("CS");
        String test = si.getMajor();

        try{
            assertTrue(test.equals(expected));
            System.out.println("Passed!\n");
        } catch(AssertionError e){
           System.out.println("Failed!\n");
        }

    }

    @Test
    public void testSetTermOffer() throws Exception {
        System.out.println("\nTesting method " + name.getMethodName().substring(4) + "() by: ");

        /****   New Test Case *********/
        System.out.println("\t" + "setting populated arrayList... ");

        SessionInfo si = new SessionInfo();
        expected = new String("Korman 137");
        si.setTermOffer( fp.getCourses() );

        String test = si.getTermOffer().get(0).getLocation();

        try{
            assertTrue(test.equals(expected));
            System.out.println("Passed!\n");
        } catch(AssertionError e){
            System.out.println("Failed!\n");
        }
    }

    @Test
    public void testAddClass() throws Exception {
        System.out.println("Testing method " + name.getMethodName().substring(4) + "() by: ");
        /****   New Test Case *********/
        System.out.println("\t" + "adding an a course that is offered... ");

        //initialize your vars
        SessionInfo si = new SessionInfo();
        si.setTermOffer( fp.getCourses() );
        si.addClass(new Integer(360873));
        expected = new Integer(360873);
        test = si.getCoursework().get(Term.Fall).get(0).getCRN();

        try
        {
            assertTrue( test.equals(expected) );
            System.out.println("Passed!");
        }
        catch(AssertionError e){
            System.out.println("Failed!");
        }
    }

    @Test
    public void testRemoveClass() throws Exception {
        System.out.println("Testing method " + name.getMethodName().substring(4) + "() by: ");
        /****   New Test Case *********/
        System.out.println("\t" + "adding an a course that is offered... ");

        //initialize your vars
        SessionInfo si = new SessionInfo();
        si.setClasses( Term.Fall, fp.getCourses() );
        si.removeClass(new Integer(360873));
        expected = new Integer(360873);
        //test = si.getCoursework().get(Term.Fall).get(0).getCRN();

        try
        {
            assertFalse( testHelper.containsCRNmatch(si.getCoursework().get(Term.Fall), new Integer(360873)) );
            System.out.println("Passed!");
        }
        catch(AssertionError e){
            System.out.println("Failed!");
        }
    }



}
