import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Stan_2
 * Date: 3/21/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeslotTest extends Object {
    @Rule public TestName name = new TestName();


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetSlots() throws Exception {
        System.out.println("Testing method " + name.getMethodName().substring(4) + "() by: ");
        /****   Sample New Test Case *********/
        System.out.println("\t" + "comparing with a fixed Array... ");

        //initialize your vars
        int start = 1;
        int num = 3;
        int size = start + num;

        Timeslot ts = new Timeslot(new Integer(start), new Integer(num));
        Integer[] expected = new Integer[size];
        for (int i = 0; i < num; i++){
           Array.set(expected, i, new Integer(i+1));
        }

        ArrayList<Integer> test = ts.getSlots();
        Integer[] testArray = new Integer[size];
        test.toArray(testArray);

        try
        {
            assertArrayEquals( expected, testArray);
            System.out.println("Passed!");
        }
        catch(AssertionError e)
        {
            System.out.println("Failed!");
        }
    }
}
